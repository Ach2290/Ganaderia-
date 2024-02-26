package com.example.ganadariasplus;

import android.content.Context;
import android.content.Intent;
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

public class MovimientoAdapter extends RecyclerView.Adapter<MovimientoAdapter.MyViewHolder> {

    Context context;
    ArrayList<MovimientoModel> movimientoModels;

    // Constructor del adaptador
    public MovimientoAdapter(FragmentActivity context, ArrayList<MovimientoModel> movimientoModels){
        this.context = context;
        this.movimientoModels = movimientoModels;
    }

    @NonNull
    @Override
    public MovimientoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el diseño del elemento de RecyclerView
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_historial, parent, false);
        return new MovimientoAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovimientoAdapter.MyViewHolder holder, int position) {
        // Establecer datos en los elementos de la interfaz de usuario
        holder.id.setText("ID: " + movimientoModels.get(position).getId());
        holder.tipo.setText("TIPO: " + movimientoModels.get(position).getTipo());
        holder.fecha.setText("FECHA: " + movimientoModels.get(position).getFecha());
    }

    @Override
    public int getItemCount() {
        return movimientoModels.size();
    }

    // Clase interna para contener los elementos de la interfaz de usuario
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id, tipo, fecha;

        // Constructor de la clase interna
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            // Inicialización de las vistas
            id = itemView.findViewById(R.id.idMovimiento);
            tipo = itemView.findViewById(R.id.tipoMovimiento);
            fecha = itemView.findViewById(R.id.fechaMovimiento);
        }
    }
}
