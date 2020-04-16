package com.herprogramacion.lawyersapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.herprogramacion.lawyersapp.foro.ForoActivity;

public class MenuPrincipal extends AppCompatActivity {
    private TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        tv1 =(TextView)findViewById(R.id.textView2);

        String dato =getIntent().getStringExtra("dato");
        tv1.setText(dato);
    }

    public void Publicar(View view) {

        Intent Publicar = new Intent(this, PublicarForo.class);
        startActivity(Publicar);


    }

    public void emergencia(View view) {

        Intent emergencia = new Intent(this, LlamadasActivity.class);
        startActivity(emergencia);


    }


    public void Ver(View view) {

        Intent Ver = new Intent(this, ForoActivity.class);
        startActivity(Ver);


    }

    public void Tips(View view) {

        Intent Tips = new Intent(this, Tips.class);
        startActivity(Tips);


    }






    public void ListaContactos(View view) {

        Intent ListaContactos = new Intent(this, ListaContactos.class);
        startActivity(ListaContactos);


    }




}
