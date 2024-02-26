package com.example.ganadariasplus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
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
    // lista de modelos de animales
    Context context;
    ArrayList<AnimalModel> animalModels;
    // Constructor del adaptador para el RecyclerView que muestra la lista de animales en la aplicación.

    // El adaptador se encarga de gestionar la interfaz entre los datos de la lista de animales y la vista que los muestra en el RecyclerView.
    // Recibe el contexto de la actividad o fragmento que lo utiliza y la lista de modelos de animales que se mostrarán en la vista.

    public AnimalAdapter(Context context, ArrayList<AnimalModel> animalModels){
        this.context = context;
        this.animalModels = animalModels;

        Log.d("AnimalAdapter", "Constructor llamado con contexto: " + context.toString());

    }
    // Método llamado cuando se necesita crear un nuevo ViewHolder
    @NonNull
    @Override
    public AnimalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_animal, parent, false);


        Log.d("AnimalAdapter", "onCreateViewHolder llamado");

        return new AnimalAdapter.MyViewHolder(view);
    }
    // Método llamado para asociar los datos a un ViewHolder específico
    @Override
    public void onBindViewHolder(@NonNull AnimalAdapter.MyViewHolder holder, int position) {

        holder.id.setText("ID: " + animalModels.get(position).getId());
        holder.tipo.setText(animalModels.get(position).getEspecie()+"");
        holder.sexo.setText(animalModels.get(position).getSexo()+"");
        holder.edad.setText(animalModels.get(position).getEdad()+"");

        Log.d("AnimalAdapter", "onBindViewHolder llamado para la posición: " + position);


    }
    // Método que devuelve la cantidad de elementos en la lista
    @Override
    public int getItemCount() {
        return animalModels.size();
    }
    // Clase interna que representa el ViewHolder para cada elemento en el RecyclerView
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id, tipo, edad, sexo;

        // Constructor del ViewHolder
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            id = itemView.findViewById(R.id.idAnimal);
            tipo = itemView.findViewById(R.id.tipoAnimal);
            edad = itemView.findViewById(R.id.edadAnimal);
            sexo = itemView.findViewById(R.id.sexoAnimal);

            Log.d("AnimalAdapter", "MyViewHolder constructor llamado");

        }
    }
}

