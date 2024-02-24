package com.example.ganadariasplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ganadariasplus.retrofit.ApiAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Explotacion extends AppCompatActivity {

    FloatingActionButton btn_movimiento;
    ImageView btn_atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explotacion);

        btn_movimiento = findViewById(R.id.boton_movimiento);
        btn_atras = findViewById(R.id.backIcon);

        TextView nombreExplotacion = findViewById(R.id.tv_nombreExplotacion);
        TextView textViewIdExplotacion = findViewById(R.id.tv_idExplotacion);
        TextView ubicacionExplotacion = findViewById(R.id.tv_ubicaExplotacion);

        SharedPreferences sharedPref = this.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        int idExplotacion = Integer.parseInt(sharedPref.getString("idExplotacion", "1"));

        Call<ExplotacionModel> call = ApiAdapter.getApiService().byIdExplotacion(idExplotacion);
        call.enqueue(new Callback<ExplotacionModel>() {

            @Override
            public void onResponse(Call<ExplotacionModel> call, Response<ExplotacionModel> response) {
                nombreExplotacion.setText(response.body().getNombre());
                textViewIdExplotacion.setText(response.body().getId());
                ubicacionExplotacion.setText(response.body().getUbicacion());
            }

            @Override
            public void onFailure(Call<ExplotacionModel> call, Throwable t) {

            }
        });


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