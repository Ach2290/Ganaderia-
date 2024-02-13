package com.example.ganadariasplus;

public class ExplotacionModel {

    public String id;
    public String nombre;
    public boolean clicked;

    public ExplotacionModel(String id, String nombre) {

        this.id = id;
        this.nombre = nombre;
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

