package com.example.ismael.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubmenuEstructuras extends AppCompatActivity {

    Button prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu_estructuras);

        prueba = (Button)findViewById(R.id.btnEjercicio);
        prueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(SubmenuEstructuras.this, Prueba.class);
                startActivity(i2);
            }
        });

    }
}
