package com.herprogramacion.lawyersapp.lawyers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.herprogramacion.lawyersapp.Login;
import com.herprogramacion.lawyersapp.MenuPrincipal;
import com.herprogramacion.lawyersapp.R;
import com.herprogramacion.lawyersapp.lawyerdetail.LawyerDetailFragment;

public class LawyersActivity extends AppCompatActivity {



    public static final String EXTRA_LAWYER_ID = "extra_lawyer_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyers);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LawyersFragment fragment = (LawyersFragment)
                getSupportFragmentManager().findFragmentById(R.id.lawyers_container);

        if (fragment == null) {
            fragment = LawyersFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.lawyers_container, fragment)
                    .commit();
        }
    }


    public void Registrarse(View view) {

        Intent Registrarse = new Intent(this, Login.class);
        startActivity(Registrarse);

    }

    public void Atras(View view) {

        Intent Atras = new Intent(this, MenuPrincipal.class);
        startActivity(Atras);

    }

    public void Salir(View view) {

        Intent Salir = new Intent(this, Login.class);
        startActivity(Salir);

    }


}
