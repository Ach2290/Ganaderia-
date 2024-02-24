package com.example.ganadariasplus;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ganadariasplus.retrofit.ApiAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondFragmentHistorial extends Fragment {

    public SecondFragmentHistorial() {

    }

    ArrayList<MovimientoModel> movimientoModels = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_historial, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerHistorial);
        if (movimientoModels.size() == 0) {
            setMovimientoModel();
        }

        MovimientoAdapter adapter = new MovimientoAdapter(getActivity(), movimientoModels);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }

    private void setMovimientoModel() {

        SharedPreferences sharedPref = this.getActivity().getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        int idGanadero = sharedPref.getInt("idGanadero", 1);

        Call<List<MovimientoModel>> call = ApiAdapter.getApiService().movimientoByIdGanadero(idGanadero);
        call.enqueue(new Callback<List<MovimientoModel>>() {
            @Override
            public void onResponse(Call<List<MovimientoModel>> call, Response<List<MovimientoModel>> response) {

                for (int i = 0; i < response.body().size();i++){
                    movimientoModels.add(new MovimientoModel(
                            response.body().get(i).getId(),
                            response.body().get(i).getTipo(),
                            response.body().get(i).getFecha()
                    ));
                }

            }

            @Override
            public void onFailure(Call<List<MovimientoModel>> call, Throwable t) {

            }
        });
    }
}
