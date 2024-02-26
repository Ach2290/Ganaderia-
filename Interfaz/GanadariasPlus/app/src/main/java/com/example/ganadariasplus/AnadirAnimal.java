package com.example.ganadariasplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ganadariasplus.retrofit.ApiAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnadirAnimal extends AppCompatActivity {

    // Botón para añadir un animal
    Button btn_anadir;

    // Lista de modelos de animales
    ArrayList<AnimalModel> animalModels = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_animal);
        // Inicialización del botón
        btn_anadir = findViewById(R.id.btn_anadirAnimal);

        // Configuración del evento de clic para el botón
        btn_anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar a la actividad Movimiento al hacer clic en el botón
                Intent intent = new Intent(AnadirAnimal.this, Movimiento.class);
                startActivity(intent);
            }
        });



        // Configuración del modelo de animales
        setAnimalModel();
    }

    // Método para configurar el modelo de animales
    private void setAnimalModel() {

        // Obtener el ID de explotación almacenado en SharedPreferences
        SharedPreferences sharedPref = this.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        int idExplotacion = Integer.parseInt(sharedPref.getString("idExplotacion", "1"));

        // Llamada a la API para obtener la lista de animales por ID de explotación
        Call<List<AnimalModel>> call = ApiAdapter.getApiService().animalByIdExplotacion(idExplotacion);
        call.enqueue(new Callback<List<AnimalModel>>() {

            @Override
            public void onResponse(Call<List<AnimalModel>> call, Response<List<AnimalModel>> response) {

                // Obtener la lista de modelos de animales desde la respuesta de la API
                animalModels = (ArrayList<AnimalModel>) response.body();

                // Configurar el RecyclerView y el adaptador
                RecyclerView recyclerView = findViewById(R.id.recyclreAnadirAnimales);
                AnimalAdapter adapter = new AnimalAdapter(AnadirAnimal.this, animalModels);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(AnadirAnimal.this));
            }

            @Override
            public void onFailure(Call<List<AnimalModel>> call, Throwable t) {
                // Manejar la falla en la llamada a la API si es necesario
            }
        });
    }
}