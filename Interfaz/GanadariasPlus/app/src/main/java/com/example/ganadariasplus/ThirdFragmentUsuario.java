package com.example.ganadariasplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ganadariasplus.retrofit.ApiAdapter;
import com.example.ganadariasplus.retrofit.model.Ganadero;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThirdFragmentUsuario extends Fragment {

    public ThirdFragmentUsuario(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.activity_usuario, container, false);

        TextInputEditText nombre = rootView.findViewById(R.id.titulo);
        TextInputEditText correo = rootView.findViewById(R.id.correo);
        TextInputEditText telefono = rootView.findViewById(R.id.telefono);
        TextInputEditText direccion = rootView.findViewById(R.id.direccion);
        TextInputEditText password = rootView.findViewById(R.id.contraseña);
//
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        int idGanadero = sharedPref.getInt("idGanadero", 0);
//
        //Call<Ganadero> call = ApiAdapter.getApiService().loadPerfil(idGanadero);
        //call.enqueue(new Callback<Ganadero>() {
//
        //    @Override
        //    public void onResponse(Call<Ganadero> call, Response<Ganadero> response) {
        //        Toast.makeText(getContext(), "EXITO", Toast.LENGTH_SHORT).show();
        //        nombre.setText(response.body().getNombre());
        //        correo.setText(response.body().getCorreo());
        //        telefono.setText(response.body().getTelefono());
        //        direccion.setText(response.body().getDirecion());
        //        password.setText(response.body().getPassword());
        //    }
//
        //    @Override
        //    public void onFailure(Call<Ganadero> call, Throwable t) {
        //        Toast.makeText(getContext(), "ERROR", Toast.LENGTH_SHORT).show();
//
        //    }
        //});

        return rootView;
    }
}