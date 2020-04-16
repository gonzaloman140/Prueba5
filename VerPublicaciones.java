package com.herprogramacion.lawyersapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.herprogramacion.lawyersapp.foro.ForoActivity;

public class VerPublicaciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_publicaciones);
    }

    public void Login(View view) {

        Intent Login = new Intent(this, ForoActivity.class);
        startActivity(Login);

    }

}
