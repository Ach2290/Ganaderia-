package com.example.ganadariasplus;

public class ExplotacionModel {

    public String id;
    public String nombre;
    public String idganadero;

    public String ubicacion;
    public boolean clicked;

    public String getIdganadero() {
        return idganadero;
    }

    public void setIdganadero(String idganadero) {
        this.idganadero = idganadero;
    }

    public ExplotacionModel(String id, String nombre) {

        this.id = id;
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}

