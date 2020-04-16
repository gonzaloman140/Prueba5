package com.herprogramacion.lawyersapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Login<et1> extends AppCompatActivity {

    private EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et1=(EditText)findViewById(R.id.editText10);
        et2=(EditText)findViewById(R.id.editText9);

    }



    //metodo para el boton enviar
    public void enviar(View view) {
        Intent i = new Intent(this,MenuPrincipal.class);
        i.putExtra("dato",et1.getText().toString());
        i.putExtra("dato2",et2.getText().toString());
        startActivity(i);



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
