package com.herprogramacion.lawyersapp.forodetail;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.herprogramacion.lawyersapp.foro.AddEditForoActivity;
import com.herprogramacion.lawyersapp.foro.ForoActivity;
import com.herprogramacion.lawyersapp.foro.ForoFragment;
import com.herprogramacion.lawyersapp.R;
import com.herprogramacion.lawyersapp.data.Foro;
import com.herprogramacion.lawyersapp.data.ForoDbHelper;

/**
 * Vista para el detalle del abogado
 */


@SuppressLint("ValidFragment")
public class ForoDetailFragment extends Fragment {
    private static final String ARG_FORO_ID = "foroId";

    private String mForoId;

    private CollapsingToolbarLayout mCollapsingView;
    private ImageView mAvatar;
    private TextView mNumeroTelefono;
    private TextView mDetalle;
    private TextView mConversacion;

    private ForoDbHelper mForoDbHelper;


    public ForoDetailFragment() {
    }

    public static ForoDetailFragment newInstance(String foroId) {
        ForoDetailFragment fragment = new ForoDetailFragment();
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

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_foro_detail, container, false);
        mCollapsingView = (CollapsingToolbarLayout) getActivity().findViewById(R.id.toolbar_layout);
        mAvatar = (ImageView) getActivity().findViewById(R.id.iv_avatar);
        mNumeroTelefono = (TextView) root.findViewById(R.id.tv_numero_telefono);
        mDetalle = (TextView) root.findViewById(R.id.tv_detalle);
        mConversacion = (TextView) root.findViewById(R.id.tv_conversacion);

        mForoDbHelper = new ForoDbHelper(getActivity());

        loadForo();

        return root;
    }

    private void loadForo() {
        new GetForoByIdTask().execute();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                showEditScreen();
                break;
            case R.id.action_delete:
                new DeleteForoTask().execute();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ForoFragment.REQUEST_UPDATE_DELETE_FORO) {
            if (resultCode == Activity.RESULT_OK) {
                getActivity().setResult(Activity.RESULT_OK);
                getActivity().finish();
            }
        }
    }

    private void showForo(Foro foro) {
        mCollapsingView.setTitle(foro.getTituloPublicacion());
        Glide.with(this)
                .load(Uri.parse("file:///android_asset/" + foro.getAvatarUri()))
                .centerCrop()
                .into(mAvatar);
        mNumeroTelefono.setText(foro.getNumeroTelefono());
        mDetalle.setText(foro.getDetalle());
        mConversacion.setText(foro.getConversacion());
    }

    private void showEditScreen() {
        Intent intent = new Intent(getActivity(), AddEditForoActivity.class);
        intent.putExtra(ForoActivity.EXTRA_FORO_ID, mForoId);
        startActivityForResult(intent, ForoFragment.REQUEST_UPDATE_DELETE_FORO);

    }
    private void showForoScreen(boolean requery) {
        if (!requery) {
            showDeleteError();
        }
        getActivity().setResult(requery ? Activity.RESULT_OK : Activity.RESULT_CANCELED);
        getActivity().finish();
    }

    private void showLoadError() {
        Toast.makeText(getActivity(),
                "Error al cargar información", Toast.LENGTH_SHORT).show();
    }

    private void showDeleteError() {
        Toast.makeText(getActivity(),
                "Error al eliminar publicación", Toast.LENGTH_SHORT).show();
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
            }
        }

    }

    private class DeleteForoTask extends AsyncTask<Void, Void, Integer> {

        @Override
        protected Integer doInBackground(Void... voids) {
            return mForoDbHelper.deleteForo(mForoId);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            showForoScreen(integer > 0);
        }

    }

}

