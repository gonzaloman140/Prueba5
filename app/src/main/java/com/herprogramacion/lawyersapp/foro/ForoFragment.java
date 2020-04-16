package com.herprogramacion.lawyersapp.foro;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.herprogramacion.lawyersapp.R;
import com.herprogramacion.lawyersapp.addeditforo.AddEditForoActivity;
import com.herprogramacion.lawyersapp.data.ForoDbHelper;
import com.herprogramacion.lawyersapp.forodetail.ForoDetailActivity;

import static com.herprogramacion.lawyersapp.data.ForoContract.ForoEntry;


/**
 * Vista para la lista de publicaciones en el foro
 */
public class ForoFragment extends Fragment {
    public static final int REQUEST_UPDATE_DELETE_FORO = 2;



    private ForoDbHelper mForoDbHelper;

    private ListView mForoList;
    private ForoCursorAdapter mForoAdapter;
    private FloatingActionButton mAddButton;


    public ForoFragment() {
        // Required empty public constructor
    }

    public static ForoFragment newInstance() {
        return new ForoFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_foro, container, false);

        // Referencias UI
        mForoList = (ListView) root.findViewById(R.id.foro_list);
        mForoAdapter = new ForoCursorAdapter(getActivity(), null);
        mAddButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        // Setup
        mForoList.setAdapter(mForoAdapter);

        // Eventos
        mForoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor currentItem = (Cursor) mForoAdapter.getItem(i);
                String currentForoId = currentItem.getString(
                        currentItem.getColumnIndex(ForoEntry.ID));

                showDetailScreen(currentForoId);
            }
        });
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddScreen();
            }
        });


       //getActivity().deleteDatabase(ForoDbHelper.DATABASE_NAME);

        // Instancia de helper
        mForoDbHelper = new ForoDbHelper(getActivity());

        // Carga de datos
        loadForo();

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Activity.RESULT_OK == resultCode) {
            switch (requestCode) {
                case AddEditForoActivity.REQUEST_ADD_FORO:
                    showSuccessfullSavedMessage();
                    loadForo();
                    break;
                case REQUEST_UPDATE_DELETE_FORO:
                    loadForo();
                    break;
            }
        }
    }

    public void loadForo() {
        new ForoLoadTask().execute();
    }

    private void showSuccessfullSavedMessage() {
        Toast.makeText(getActivity(),
                "Se ha publicado correctamente", Toast.LENGTH_SHORT).show();
    }

    private void showAddScreen() {
        Intent intent = new Intent(getActivity(), AddEditForoActivity.class);
        startActivityForResult(intent, AddEditForoActivity.REQUEST_ADD_FORO);
    }

    private void showDetailScreen(String foroId) {
        Intent intent = new Intent(getActivity(), ForoDetailActivity.class);
        intent.putExtra(ForoActivity.EXTRA_FORO_ID, foroId);
        startActivityForResult(intent, REQUEST_UPDATE_DELETE_FORO);
    }

    private class ForoLoadTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mForoDbHelper.getAllForo();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                mForoAdapter.swapCursor(cursor);
            } else {
                // Mostrar empty state
            }
        }
    }

}
