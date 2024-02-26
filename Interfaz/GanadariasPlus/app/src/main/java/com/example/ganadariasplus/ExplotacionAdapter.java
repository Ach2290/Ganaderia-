package com.example.ganadariasplus;

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


public class ExplotacionAdapter extends RecyclerView.Adapter<ExplotacionAdapter.MyViewHolder> {

    Context context;
    ArrayList<ExplotacionModel> explotacionModels;

    // Constructor del adaptador
    public ExplotacionAdapter(FragmentActivity context, ArrayList<ExplotacionModel> explotacionModels) {
        this.context = context;
        this.explotacionModels = explotacionModels;
    }

    // Método para crear y devolver una nueva instancia del ViewHolder
    @NonNull
    @Override
    public ExplotacionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_explotacion, parent, false);
        return new ExplotacionAdapter.MyViewHolder(view);
    }

    // Método para asociar los datos a las vistas del ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ExplotacionAdapter.MyViewHolder holder, int position) {
        // Asignar datos a las vistas del ViewHolder
        holder.id.setText(explotacionModels.get(position).getId());
        holder.nombre.setText(explotacionModels.get(position).getNombre());
    }

    // Método para obtener la cantidad de elementos en el conjunto de datos
    @Override
    public int getItemCount() {
        return explotacionModels.size();
    }

    // Clase interna que representa el ViewHolder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, nombre;
        CardView cardView;

        // Constructor del ViewHolder
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idExplotacion);
            nombre = itemView.findViewById(R.id.nombreExplotacion);

            // Configuración de un ClickListener en el elemento de la lista
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Al hacer clic en un elemento, se guarda el ID de la explotación en SharedPreferences
                    SharedPreferences sharedPref = itemView.getContext().getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("idExplotacion", id.getText().toString());
                    editor.apply();

                    // Se lanza la actividad Explotacion
                    Intent intent = new Intent(v.getContext(), Explotacion.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}