package com.example.ganadariasplus;

public class MovimientoModel {

    private int id;
    private String tipo;
    private String fecha;

    public MovimientoModel(int id, String tipo, String fecha) {
        this.id = id;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
