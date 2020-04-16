package com.herprogramacion.lawyersapp.addeditforo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.herprogramacion.lawyersapp.foro.ForoActivity;
import com.herprogramacion.lawyersapp.R;
import com.herprogramacion.lawyersapp.forodetail.ForoDetailFragment;


public class AddEditForoActivity extends AppCompatActivity {


    public static final int REQUEST_ADD_FORO = 1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String foroId = getIntent().getStringExtra(ForoActivity.EXTRA_FORO_ID);

        setTitle(foroId == null ? "Añadir publicaciôn" : "Editar publicaciôn");

        AddEditForoFragment addEditForoFragment = (AddEditForoFragment) getSupportFragmentManager().findFragmentById(R.id.add_edit_foro_container);
        if (addEditForoFragment == null) {
            addEditForoFragment = AddEditForoFragment.newInstance(foroId);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.add_edit_foro_container, addEditForoFragment)
                    .commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    public void Registrarse(View view) {

        Intent Registrarse = new Intent(this, ForoDetailFragment.class);
        startActivity(Registrarse);

    }




}





