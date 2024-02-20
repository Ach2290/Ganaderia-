package com.example.ganadariasplus.retrofit;

import retrofit2.Call;

import com.example.ganadariasplus.retrofit.model.Ganadero;

import java.util.ArrayList;
import java.util.List;


import retrofit2.http.GET;

public interface ApiService {

    @GET("ganadero/all")
    Call <List<Ganadero>> getGanaderos();


}
