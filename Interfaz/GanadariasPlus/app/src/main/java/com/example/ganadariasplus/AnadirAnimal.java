package com.example.ganadariasplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnadirAnimal extends AppCompatActivity {

    Button btn_anadir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_animal);
        btn_anadir = findViewById(R.id.btn_anadirAnimal);

        btn_anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnadirAnimal.this, Movimiento.class);
                startActivity(intent);
            }
        });
    }
}