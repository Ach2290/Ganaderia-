package com.example.ganadariasplus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Movimiento extends AppCompatActivity {

    ImageView btn_atras;
    Button anadir_animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimiento);

        // Configuración del botón para añadir un animal
        anadir_animal = findViewById(R.id.button_anadirAnimal);
        anadir_animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Movimiento.this, AnadirAnimal.class);
                startActivity(intent);
            }
        });

        // Configuración del botón para regresar a la pantalla de explotación
        btn_atras = findViewById(R.id.backIcon);
        btn_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Movimiento.this, Explotacion.class);
                startActivity(intent);
            }
        });
    }
}