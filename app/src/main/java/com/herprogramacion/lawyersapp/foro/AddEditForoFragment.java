package com.herprogramacion.lawyersapp.foro;


import android.app.Activity;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.herprogramacion.lawyersapp.R;
import com.herprogramacion.lawyersapp.data.Foro;
import com.herprogramacion.lawyersapp.data.ForoDbHelper;

/**
 * Vista para creación/edición de una publicacion
 */

public class AddEditForoFragment extends Fragment {
    private static final String ARG_FORO_ID = "arg_foro_id";

    private String mForoId;

    private ForoDbHelper mForoDbHelper;

    private FloatingActionButton mSaveButton;
    private TextInputEditText mTituloPublicacionField;
    private TextInputEditText mNumeroTelefonoField;
    private TextInputEditText mDetalleField;
    private TextInputEditText mConversacionField;
    private TextInputLayout mTituloPublicacionLabel;
    private TextInputLayout mNumeroTelefonoLabel;
    private TextInputLayout mDetalleLabel;
    private TextInputLayout mConversacionLabel;
    private String mAvatarUri;


    public AddEditForoFragment() {
        // Required empty public constructor
    }

    public static AddEditForoFragment newInstance(String foroId) {
        AddEditForoFragment fragment = new AddEditForoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_FORO_ID, foroId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mForoId = getArguments().getString(ARG_FORO_ID);
        }
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_edit_foro, container, false);

        // Referencias UI
        mSaveButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        mTituloPublicacionField = (TextInputEditText) root.findViewById(R.id.et_titulo_publicacion);
        mNumeroTelefonoField = (TextInputEditText) root.findViewById(R.id.et_numero_telefono);
        mDetalleField = (TextInputEditText) root.findViewById(R.id.et_detalle);
        mConversacionField = (TextInputEditText) root.findViewById(R.id.et_conversacion);
        mTituloPublicacionLabel = (TextInputLayout) root.findViewById(R.id.til_titulo_publicacion);
        mNumeroTelefonoLabel = (TextInputLayout) root.findViewById(R.id.til_numero_telefono);
        mDetalleLabel = (TextInputLayout) root.findViewById(R.id.til_detalle);
        mConversacionLabel = (TextInputLayout) root.findViewById(R.id.til_conversacion);

        // Eventos
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEditForo();
            }
        });

        mForoDbHelper = new ForoDbHelper(getActivity());

        // Carga de datos
        if (mForoId != null) {
            loadForo();
        }

        return root;
    }

    private void loadForo() {
        new GetForoByIdTask().execute();
    }

    private void addEditForo() {
        boolean error = false;


        String tituloPublicacion = mTituloPublicacionField.getText().toString();
        String numeroTelefono = mNumeroTelefonoField.getText().toString();
        String detalle = mDetalleField.getText().toString();
        String conversacion = mConversacionField.getText().toString();

        if (TextUtils.isEmpty(tituloPublicacion)) {
            mTituloPublicacionLabel.setError(getString(R.string.field_error));
            error = true;
        }

        if (TextUtils.isEmpty(numeroTelefono)) {
            mNumeroTelefonoLabel.setError(getString(R.string.field_error));
            error = true;
        }

        if (TextUtils.isEmpty(detalle)) {
            mDetalleLabel.setError(getString(R.string.field_error));
            error = true;
        }


        if (TextUtils.isEmpty(conversacion)) {
            mConversacionLabel.setError(getString(R.string.field_error));
            error = true;
        }

        if (error) {
            return;
        }

        Foro foro = new Foro(tituloPublicacion, detalle, numeroTelefono, conversacion,mAvatarUri);

        new AddEditForoTask().execute(foro);

    }

    private void showForoScreen(Boolean requery) {
        if (!requery) {
            showAddEditError();
            getActivity().setResult(Activity.RESULT_CANCELED);
        } else {
            getActivity().setResult(Activity.RESULT_OK);
        }

        getActivity().finish();
    }

    private void showAddEditError() {
        Toast.makeText(getActivity(),
                "Error al agregar nueva información", Toast.LENGTH_SHORT).show();
    }

    private void showForo(Foro foro) {
        mTituloPublicacionField.setText(foro.getTituloPublicacion());
        mNumeroTelefonoField.setText(foro.getNumeroTelefono());
        mDetalleField.setText(foro.getDetalle());
        mConversacionField.setText(foro.getConversacion());
        mAvatarUri = foro.getAvatarUri();
    }

    private void showLoadError() {
        Toast.makeText(getActivity(),
                "Error al editar publicaciòn", Toast.LENGTH_SHORT).show();
    }

    private class GetForoByIdTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mForoDbHelper.getForoById(mForoId);
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.moveToLast()) {
                showForo(new Foro(cursor));
            } else {
                showLoadError();
                getActivity().setResult(Activity.RESULT_CANCELED);
                getActivity().finish();
            }
        }

    }

    private class AddEditForoTask extends AsyncTask<Foro, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Foro... foros) {
            if (mForoId != null) {
                return mForoDbHelper.updateForo(foros[0], mForoId) > 0;

            } else {
                return mForoDbHelper.saveForo(foros[0]) > 0;
            }

        }

        @Override
        protected void onPostExecute(Boolean result) {
            showForoScreen(result);
        }

    }

}
