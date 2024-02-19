package com.example.ganadariasplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Explotacion extends AppCompatActivity {

    FloatingActionButton btn_movimiento;
    ImageView btn_atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explotacion);

        btn_movimiento = findViewById(R.id.boton_movimiento);
        btn_atras = findViewById(R.id.backIcon);

        btn_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Explotacion.this, Principal.class);
                startActivity(intent);
            }
        });

        btn_movimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Explotacion.this, Movimiento.class);
                startActivity(intent);
            }
        });
    }
}