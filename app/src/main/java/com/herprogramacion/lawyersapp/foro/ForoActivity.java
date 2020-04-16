package com.herprogramacion.lawyersapp.foro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.herprogramacion.lawyersapp.Login;
import com.herprogramacion.lawyersapp.MenuPrincipal;
import com.herprogramacion.lawyersapp.R;


public class ForoActivity extends AppCompatActivity {



    public static final String EXTRA_FORO_ID = "extra_foro_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foro);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ForoFragment fragment = (ForoFragment)
                getSupportFragmentManager().findFragmentById(R.id.foro_container);

        if (fragment == null) {
            fragment = ForoFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.foro_container, fragment)
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

    //public void Salir(View view) {

      //  Intent Salir = new Intent(this, Login.class);
        //startActivity(Salir);




}
