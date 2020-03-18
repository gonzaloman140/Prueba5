package com.herprogramacion.lawyersapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.herprogramacion.lawyersapp.lawyers.LawyersActivity;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void Publicar(View view) {

        Intent Publicar = new Intent(this, PublicarForo.class);
        startActivity(Publicar);


    }


    public void Ver(View view) {

        Intent Ver = new Intent(this, LawyersActivity.class);
        startActivity(Ver);


    }

}
