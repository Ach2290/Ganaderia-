package com.example.ganadariasplus.retrofit;

import android.content.Intent;

import retrofit2.Call;

import com.example.ganadariasplus.AnimalModel;
import com.example.ganadariasplus.Explotacion;
import com.example.ganadariasplus.ExplotacionModel;
import com.example.ganadariasplus.MataderoModel;
import com.example.ganadariasplus.Movimiento;
import com.example.ganadariasplus.MovimientoModel;
import com.example.ganadariasplus.retrofit.model.Ganadero;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @GET("ganadero/all")
    Call <List<Ganadero>> getGanaderos();

    @GET("ganadero/byId/{id}")
    Call <Ganadero> loadPerfil(@Path("id")Integer id);

    @POST("ganadero/login/{correo}")
    Call <List<Ganadero>> loginCorreo(@Path("correo") String correo);

    @POST("ganadero/loginNombre/{nombre}")
    Call <String> loginNombre(@Path("nombre") String nombre);

    @POST("ganadero/registro")
    Call <Ganadero> registro(@Body Ganadero ganadero);

    @POST("ganadero/updateGanadero")
    Call <Ganadero> update(@Body Ganadero ganadero);

    @GET("explotacion/by_id_ganadero/{id_ganadero}")
    Call <List<ExplotacionModel>> byIdGanadero(@Path("id_ganadero") Integer idGanadero);

    @GET("explotacion/by_id/{id}")
    Call<ExplotacionModel> byIdExplotacion(@Path("id") Integer id);

    @GET("movimiento/by_id_ganadero/{id_ganadero}")
    Call<List<MovimientoModel>> movimientoByIdGanadero(@Path("id_ganadero") Integer id_ganadero);

    @GET("animal/by_id_explotacion/{id_explotacion}")
    Call<List<AnimalModel>> animalByIdExplotacion(@Path("id_explotacion") Integer id_explotacion);

    @GET("matadero/byId/{id}")
    Call <MataderoModel> mataderoById(@Path("id") Integer id);
}
