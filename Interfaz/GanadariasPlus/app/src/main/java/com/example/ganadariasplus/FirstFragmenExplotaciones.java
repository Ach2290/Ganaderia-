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
        if(explotacionModels.size() == 0){
            setExplotacionModel();
        }

        ExplotacionAdapter adapter = new ExplotacionAdapter(getActivity(), explotacionModels);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }


    private void setExplotacionModel(){

        SharedPreferences sharedPref = this.getActivity().getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        int idGanadero = sharedPref.getInt("idGanadero", 1);

        Call<List<ExplotacionModel>> call = ApiAdapter.getApiService().byIdGanadero(idGanadero);
        call.enqueue(new Callback<List<ExplotacionModel>>() {

            @Override
            public void onResponse(Call<List<ExplotacionModel>> call, Response<List<ExplotacionModel>> response) {

                for (int i = 0; i < response.body().size();i++){
                    explotacionModels.add(new ExplotacionModel(
                            response.body().get(i).getId(),
                            response.body().get(i).getNombre()
                    ));
                }
            }

            @Override
            public void onFailure(Call<List<ExplotacionModel>> call, Throwable t) {

            }
        });

    }
}