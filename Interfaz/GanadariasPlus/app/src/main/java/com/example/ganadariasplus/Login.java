package com.example.ganadariasplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.ganadariasplus.retrofit.model.Ganadero;
import com.example.ganadariasplus.retrofit.ApiAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements Callback<List<Ganadero>> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView btn_entrar = findViewById(R.id.btn_entrar);

        TextView btn_regsitro = findViewById(R.id.btn_registro);

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Principal.class);
                startActivity(intent);
            }
        });

        btn_regsitro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        Call <List<Ganadero>> call = ApiAdapter.getApiService().getGanaderos();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Ganadero>> call, Response<List<Ganadero>> response) {
        Log.d("APICALL: GANADEROS", String.valueOf(response));
    }

    @Override
    public void onFailure(Call<List<Ganadero>> call, Throwable t) {
        Log.d("Fallo", t.getMessage());
    }
}