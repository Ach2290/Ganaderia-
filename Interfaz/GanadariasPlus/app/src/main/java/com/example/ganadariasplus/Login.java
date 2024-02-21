package com.example.ganadariasplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ganadariasplus.retrofit.model.Ganadero;
import com.example.ganadariasplus.retrofit.ApiAdapter;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView btn_entrar = findViewById(R.id.btn_entrar);

        TextView btn_regsitro = findViewById(R.id.btn_registro);

        TextInputEditText correo = findViewById(R.id.ETcorreo);
        TextInputEditText password = findViewById(R.id.ETcontrasena);

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correoIntroducido = correo.getText().toString();
                String contraIntroducido = password.getText().toString();

                Call <List<Ganadero>> call = ApiAdapter.getApiService().loginCorreo(correoIntroducido);
                call.enqueue(new Callback<List<Ganadero>>() {
                    @Override
                    public void onResponse(Call<List<Ganadero>> call, Response<List<Ganadero>> response) {

                        List<Ganadero> ganaderos = response.body();


                        if (ganaderos.size() > 0) {
                            if (ganaderos.get(0).getCorreo().equals(correoIntroducido) && ganaderos.get(0).getPassword().equals(contraIntroducido)) {
                                SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPref.edit();
                                editor.putInt("idGanadero", ganaderos.get(0).getId());
                                Intent intent = new Intent(Login.this, Principal.class);
                                startActivity(intent);
                            } else if (!ganaderos.get(0).getCorreo().equals(correoIntroducido)) {
                                Toast.makeText(Login.this, "USUARIO NO ENCONTRADO", Toast.LENGTH_SHORT).show();

                            } else if (!ganaderos.get(0).getPassword().equals(contraIntroducido)) {
                                Toast.makeText(Login.this, "CONTRASEÑA INCORRECTA", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Login.this, "USUARIO O CONTRASEÑA INCORRECTOS", Toast.LENGTH_SHORT).show();
                            }

                        }else {
                            Toast.makeText(Login.this, "USUARIO NO ENCONTRADO", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Ganadero>> call, Throwable t) {
                        Toast.makeText(Login.this, "ERROR AL CONECTAR CON EL SERVIDOR", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        btn_regsitro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
    }

}