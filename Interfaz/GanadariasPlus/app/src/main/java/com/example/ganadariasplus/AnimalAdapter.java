package com.example.ganadariasplus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.MyViewHolder> {

    Context context;
    ArrayList<AnimalModel> animalModels;

    public AnimalAdapter(Context context, ArrayList<AnimalModel> animalModels){
        this.context = context;
        this.animalModels = animalModels;
    }
    @NonNull
    @Override
    public AnimalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_animal, parent, false);
        return new AnimalAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalAdapter.MyViewHolder holder, int position) {

        holder.id.setText(animalModels.get(position).getId());
        holder.tipo.setText(animalModels.get(position).getEspecie());

    }

    @Override
    public int getItemCount() {
        return animalModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id, tipo, edad, sexo;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            id = itemView.findViewById(R.id.idAnimal);
            tipo = itemView.findViewById(R.id.tipoAnimal);
        }
    }
}
