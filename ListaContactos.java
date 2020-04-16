package com.herprogramacion.lawyersapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ListaContactos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contactos);



    }

    public void peteco(View view) {

        Intent peteco = new Intent(this, PublicarForo.class);
        startActivity(peteco);


    }

    public void Chat(View view) {

        Intent Chat = new Intent(this, PublicarForo.class);
        startActivity(Chat);


    }

    public void Chat1(View view) {

        Intent Chat1 = new Intent(this, PublicarForo.class);
        startActivity(Chat1);


    }

    public void Chat2(View view) {

        Intent Chat2 = new Intent(this, PublicarForo.class);
        startActivity(Chat2);


    }

    public void Chat3(View view) {

        Intent Chat3 = new Intent(this, PublicarForo.class);
        startActivity(Chat3);


    }

    public void Chat4(View view) {

        Intent Chat4 = new Intent(this, PublicarForo.class);
        startActivity(Chat4);


    }

    public void Chat5(View view) {

        Intent Chat5 = new Intent(this, PublicarForo.class);
        startActivity(Chat5);


    }

}
