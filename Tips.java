package com.herprogramacion.lawyersapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Tips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
    }

    public void Higiene(View view) {

        Intent Higiene = new Intent(this, Higiene.class);
        startActivity(Higiene);


    }

    public void Mochila(View view) {

        Intent Mochila = new Intent(this, Mochila.class);
        startActivity(Mochila);


    }

    public void ContactosImportantes(View view) {

        Intent ContactosImportantes = new Intent(this, ContactosImportantes.class);
        startActivity(ContactosImportantes);


    }


    public void PrecaucionesHogar(View view) {

        Intent PrecaucionesHogar = new Intent(this, PrecaucionesHogar.class);
        startActivity(PrecaucionesHogar);


    }


}


