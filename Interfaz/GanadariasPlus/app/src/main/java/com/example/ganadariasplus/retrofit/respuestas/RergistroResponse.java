package com.example.ganadariasplus.retrofit.respuestas;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.SerializedIr;

public class RergistroResponse {

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("correo")
    private String correo;
}
