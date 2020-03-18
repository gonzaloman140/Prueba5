package com.herprogramacion.lawyersapp.addeditlawyer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.herprogramacion.lawyersapp.R;
import com.herprogramacion.lawyersapp.lawyerdetail.LawyerDetailFragment;
import com.herprogramacion.lawyersapp.lawyers.LawyersActivity;

public class AddEditLawyerActivity extends AppCompatActivity {

    public static final int REQUEST_ADD_LAWYER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String lawyerId = getIntent().getStringExtra(LawyersActivity.EXTRA_LAWYER_ID);

        setTitle(lawyerId == null ? "Añadir publicaciôn" : "Editar publicaciôn");

        AddEditLawyerFragment addEditLawyerFragment = (AddEditLawyerFragment)
                getSupportFragmentManager().findFragmentById(R.id.add_edit_lawyer_container);
        if (addEditLawyerFragment == null) {
            addEditLawyerFragment = AddEditLawyerFragment.newInstance(lawyerId);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.add_edit_lawyer_container, addEditLawyerFragment)
                    .commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    public void Registrarse(View view) {

        Intent Registrarse = new Intent(this, LawyerDetailFragment.class);
        startActivity(Registrarse);

    }




}
