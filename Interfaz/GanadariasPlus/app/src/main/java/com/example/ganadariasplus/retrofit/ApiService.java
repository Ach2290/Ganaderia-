package com.example.ganadariasplus.retrofit;

import retrofit2.Call;

import com.example.ganadariasplus.retrofit.model.Ganadero;

import java.util.ArrayList;
import java.util.List;


import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @GET("ganadero/all")
    Call <List<Ganadero>> getGanaderos();

    @POST("ganadero/login/{correo}")
    Call <List<Ganadero>> login(@Path("correo") String correo);
}
