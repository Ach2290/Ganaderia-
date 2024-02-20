package com.example.ganadariasplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ganadariasplus.retrofit.ApiAdapter;
import com.example.ganadariasplus.retrofit.model.Ganadero;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Button btn_regsitrarse = findViewById(R.id.button_registrarse);
        TextInputEditText correo = findViewById(R.id.ETcorreo);
        TextInputEditText nombre = findViewById(R.id.nombre_usuario);
        TextInputEditText password = findViewById(R.id.contrasena);
        TextInputEditText passwordrepetir = findViewById(R.id.repetir_contrasena);

        btn_regsitrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String correoIntroducido = correo.getText().toString();
                String nombreIntroducido = nombre.getText().toString();
                String contraIntroducido = password.getText().toString();
                String contrarepetirIntroducido = passwordrepetir.getText().toString();

                Ganadero newGanadero = new Ganadero();

                newGanadero.setNombre(nombreIntroducido);
                newGanadero.setCorreo(correoIntroducido);
                newGanadero.setPassword(contraIntroducido);
                Call<Ganadero> call = ApiAdapter.getApiService().registro(newGanadero);
                call.enqueue(new Callback<Ganadero>() {
                    @Override
                    public void onResponse(Call<Ganadero> call, Response<Ganadero> response) {

                        if (contraIntroducido.equals(contrarepetirIntroducido)){
                            if(!response.body().toString().isEmpty()){
                                Toast.makeText(RegistroActivity.this, "USUARIO REGISTRADO", Toast.LENGTH_SHORT).show();
                                Toast.makeText(RegistroActivity.this, response.body().getNombre(), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegistroActivity.this, Principal.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(RegistroActivity.this, "USUARIO NO REGISTRADO", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            password.setText("");
                            passwordrepetir.setText("");
                            Toast.makeText(RegistroActivity.this, "LAS CONTRASEÑAS NO COINCIDEN", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<Ganadero> call, Throwable t) {
                        Toast.makeText(RegistroActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}