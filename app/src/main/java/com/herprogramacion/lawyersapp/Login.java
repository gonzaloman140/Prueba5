package com.herprogramacion.lawyersapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.herprogramacion.lawyersapp.lawyers.LawyersActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Registrarse(View view) {

        Intent Registrarse = new Intent(this, Registrarse.class);
        startActivity(Registrarse);
    }

    public void Ingresar(View view) {

        Intent Ingresar = new Intent(this, MenuPrincipal.class);
        startActivity(Ingresar);
    }




}
