package com.example.ganadariasplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ganadariasplus.retrofit.ApiAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Explotacion extends AppCompatActivity {

    // Botones y vistas de la interfaz
    FloatingActionButton btn_movimiento;
    ImageView btn_atras;

    SearchView busqueda;

    // Lista de modelos de animales
    ArrayList<AnimalModel> animalModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explotacion);

        // Inicialización de botones y vistas
        btn_movimiento = findViewById(R.id.boton_movimiento);
        btn_atras = findViewById(R.id.backIcon);
        busqueda = findViewById(R.id.searchView);

        TextView nombreExplotacion = findViewById(R.id.tv_nombreExplotacion);
        TextView textViewIdExplotacion = findViewById(R.id.tv_idExplotacion);
        TextView ubicacionExplotacion = findViewById(R.id.tv_ubicaExplotacion);

        // Obtención del ID de explotación desde SharedPreferences
        SharedPreferences sharedPref = this.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        int idExplotacion = Integer.parseInt(sharedPref.getString("idExplotacion", "1"));

        // Llamada a la API para obtener detalles de la explotación por su ID
        Call<ExplotacionModel> call = ApiAdapter.getApiService().byIdExplotacion(idExplotacion);
        call.enqueue(new Callback<ExplotacionModel>() {

            @Override
            public void onResponse(Call<ExplotacionModel> call, Response<ExplotacionModel> response) {
                // Actualización de las vistas con los detalles de la explotación
                nombreExplotacion.setText(response.body().getNombre());
                textViewIdExplotacion.setText(String.valueOf(response.body().getId()));
                ubicacionExplotacion.setText(response.body().getUbicacion());
                setAnimalModel();

            }

            @Override
            public void onFailure(Call<ExplotacionModel> call, Throwable t) {
            }
        });

        // Configuración del botón para regresar a la actividad Principal
        btn_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Explotacion.this, Principal.class);
                startActivity(intent);
            }
        });

        // Configuración del botón para ir a la actividad Movimiento
        btn_movimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Explotacion.this, Movimiento.class);
                startActivity(intent);
            }
        });

        busqueda.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                if(s.isEmpty()){
                    setAnimalModel();
                }else {

                    SharedPreferences sharedPref = Explotacion.this.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
                    int idExplotacion = Integer.parseInt(sharedPref.getString("idExplotacion", "1"));

                    Call<List<AnimalModel>> call = ApiAdapter.getApiService().busquedaAnimal(idExplotacion, Integer.parseInt(s));
                    call.enqueue(new Callback<List<AnimalModel>>() {
                        @Override
                        public void onResponse(Call<List<AnimalModel>> call, Response<List<AnimalModel>> response) {
                            animalModels = (ArrayList<AnimalModel>) response.body();
                            RecyclerView recyclerView = findViewById(R.id.recyclerAnimales);
                            AnimalAdapter adapter = new AnimalAdapter(Explotacion.this, animalModels);
                            recyclerView.setAdapter(adapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(Explotacion.this));
                            // Llenar la lista de modelos de animales con la respuesta de la API
                            animalModels = (ArrayList<AnimalModel>) response.body();
                        }
                        @Override
                        public void onFailure(Call<List<AnimalModel>> call, Throwable t) {

                        }
                    });

                }

                return false;
            }
        });
    }



    // Método para llenar la lista de modelos de animales mediante una llamada a la API
    private void setAnimalModel() {

        // Obtención del ID de explotación desde SharedPreferences
        SharedPreferences sharedPref = this.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        int idExplotacion = Integer.parseInt(sharedPref.getString("idExplotacion", "1"));

        // Llamada a la API para obtener la lista de animales por ID de explotación
        Call<List<AnimalModel>> call = ApiAdapter.getApiService().animalByIdExplotacion(idExplotacion);
        call.enqueue(new Callback<List<AnimalModel>>() {

            @Override
            public void onResponse(Call<List<AnimalModel>> call, Response<List<AnimalModel>> response) {

                animalModels = (ArrayList<AnimalModel>) response.body();
                RecyclerView recyclerView = findViewById(R.id.recyclerAnimales);
                AnimalAdapter adapter = new AnimalAdapter(Explotacion.this, animalModels);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(Explotacion.this));
                // Llenar la lista de modelos de animales con la respuesta de la API
                animalModels = (ArrayList<AnimalModel>) response.body();
            }

            @Override
            public void onFailure(Call<List<AnimalModel>> call, Throwable t) {
                // Manejo de la falla en la llamada a la API si es necesario
            }
        });

    }


}