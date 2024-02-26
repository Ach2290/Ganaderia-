package com.example.ganadariasplus;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ganadariasplus.retrofit.ApiAdapter;
import com.example.ganadariasplus.retrofit.model.Ganadero;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragmenExplotaciones extends Fragment {

    public FirstFragmenExplotaciones(){

    }

    ArrayList<ExplotacionModel> explotacionModels = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragmen_explotaciones, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerExplotaciones);
        // Verifica si la lista de explotaciones está vacía antes de configurar el adaptador
        if (explotacionModels.size() == 0) {
            setExplotacionModel();
        }

        ExplotacionAdapter adapter = new ExplotacionAdapter(getActivity(), explotacionModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }

    // Método para obtener y establecer los datos de las explotaciones asociadas al ganadero
    private void setExplotacionModel() {
        // Obtiene el ID del ganadero desde SharedPreferences
        SharedPreferences sharedPref = requireActivity().getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        int idGanadero = sharedPref.getInt("idGanadero", 1);

        // Realiza la llamada a la API para obtener las explotaciones del ganadero
        Call<List<ExplotacionModel>> call = ApiAdapter.getApiService().byIdGanadero(idGanadero);
        call.enqueue(new Callback<List<ExplotacionModel>>() {

            @Override
            public void onResponse(Call<List<ExplotacionModel>> call, Response<List<ExplotacionModel>> response) {
                // Llena la lista de explotaciones con los datos obtenidos de la API
                for (int i = 0; i < response.body().size(); i++) {
                    explotacionModels.add(new ExplotacionModel(
                            response.body().get(i).getId(),
                            response.body().get(i).getNombre()
                    ));
                }
            }

            @Override
            public void onFailure(Call<List<ExplotacionModel>> call, Throwable t) {
                // Maneja la falla en la obtención de datos de la API (puede implementarse según la lógica de la aplicación)
            }
        });
    }
}