package com.example.ganadariasplus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ganadariasplus.retrofit.ApiAdapter;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Movimiento extends AppCompatActivity {

    ImageView btn_atras;
    Button anadir_animal;
    TextView id, nombre, ubicacion;
    TextInputEditText id_destino, nombre_destino, dire_destino, telefono_destino;

    Boolean seguir;

    Integer eleccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimiento);

        anadir_animal = findViewById(R.id.button_anadirAnimal);

        id = findViewById(R.id.textViewIdExplotacion);
        nombre = findViewById(R.id.textViewNombreExplotacion);
        ubicacion = findViewById(R.id.textViewUbicacionExplotacion);

        id_destino = findViewById(R.id.id_exp);
        dire_destino = findViewById(R.id.dire);
        nombre_destino = findViewById(R.id.N_exp);
        telefono_destino = findViewById(R.id.tel);

        Spinner spinnerLanguages=findViewById(R.id.spinner_languages);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.tipoMovimiento, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerLanguages.setAdapter(adapter);

        eleccion = spinnerLanguages.getSelectedItemPosition();

        spinnerLanguages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(eleccion != i){
                    if(eleccion == 0){

                        id_destino.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void afterTextChanged(Editable editable) {

                                if(!id_destino.getText().toString().isEmpty()){

                                    int idExplotacion = Integer.parseInt(id_destino.getText().toString());

                                    Call<ExplotacionModel> call = ApiAdapter.getApiService().byIdExplotacion(idExplotacion);
                                    call.enqueue(new Callback<ExplotacionModel>() {

                                        @Override
                                        public void onResponse(Call<ExplotacionModel> call, Response<ExplotacionModel> response) {
                                            nombre_destino.setText(response.body().getNombre());
                                            dire_destino.setText(response.body().getUbicacion());
                                        }

                                        @Override
                                        public void onFailure(Call<ExplotacionModel> call, Throwable t) {

                                        }
                                    });
                                }

                            }
                        });

                    }else{

                        if(!id_destino.getText().toString().isEmpty()){

                            int idMatadero = Integer.parseInt(id_destino.getText().toString());

                            Call<MataderoModel> call = ApiAdapter.getApiService().mataderoById(idMatadero);
                            call.enqueue(new Callback<MataderoModel>() {

                                @Override
                                public void onResponse(Call<MataderoModel> call, Response<MataderoModel> response) {
                                    nombre_destino.setText(response.body().getNombre());
                                    dire_destino.setText(response.body().getDireccion());
                                    telefono_destino.setText(response.body().getTelefono());
                                }

                                @Override
                                public void onFailure(Call<MataderoModel> call, Throwable t) {

                                }
                            });
                        }


                    }
                }

                eleccion = i;
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        SharedPreferences sharedPref = this.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        int idExplotacion = Integer.parseInt(sharedPref.getString("idExplotacion", "1"));

        Call<ExplotacionModel> call = ApiAdapter.getApiService().byIdExplotacion(idExplotacion);
        call.enqueue(new Callback<ExplotacionModel>() {

                         @Override
                         public void onResponse(Call<ExplotacionModel> call, Response<ExplotacionModel> response) {
                             id.setText(response.body().getId());
                             nombre.setText(response.body().getNombre());
                             ubicacion.setText(response.body().getUbicacion());
                         }

                         @Override
                         public void onFailure(Call<ExplotacionModel> call, Throwable t) {

                         }
                     });

        anadir_animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Movimiento.this, AnadirAnimal.class);
                startActivity(intent);
            }
        });

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