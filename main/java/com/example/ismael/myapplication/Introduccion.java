package com.example.ismael.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Introduccion extends AppCompatActivity {

    Button practica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduccion);

        practica =(Button)findViewById(R.id.btnEjercioIn);
        practica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Introduccion.this, EjerciciosIntroduccion.class);
                startActivity(i);
            }
        });

    }
}
