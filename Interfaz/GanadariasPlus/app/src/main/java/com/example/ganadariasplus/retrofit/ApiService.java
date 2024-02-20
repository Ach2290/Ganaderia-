package com.example.ganadariasplus.retrofit;

import android.content.Intent;

import retrofit2.Call;

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
}
