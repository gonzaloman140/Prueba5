package com.herprogramacion.lawyersapp.addeditlawyer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.herprogramacion.lawyersapp.R;

public class prueba extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);
    }


    public void Registrarse(View view) {

        Intent Registrarse = new Intent(this, prueba.class);
        startActivity(Registrarse);

    }

}
