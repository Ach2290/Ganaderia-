package com.example.ganadariasplus;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FirstFragmenExplotaciones extends Fragment {

    public FirstFragmenExplotaciones(){

    }

    ArrayList<ExplotacionModel> explotacionModels = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragmen_explotaciones, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerExplotaciones);
        setExplotacionModel();
        ExplotacionAdapter adapter = new ExplotacionAdapter(getActivity(), explotacionModels);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }
    private void setExplotacionModel(){
        String[] id = getResources().getStringArray(R.array.explotacion_id);
        String[] nombre = getResources().getStringArray(R.array.explotacion_nombre);

        for (int i = 0; i < id.length;i++){
            explotacionModels.add(new ExplotacionModel(
                    id[i],
                    nombre[i]
            ));
        }
    }
}