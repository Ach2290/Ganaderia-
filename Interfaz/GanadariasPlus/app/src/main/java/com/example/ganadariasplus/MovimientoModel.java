package com.example.ganadariasplus;

public class MovimientoModel {

    private int id;
    private String tipo;
    private String fecha;
    private int id_matadero;

    private int id_explotacion;

    public MovimientoModel(int id, String tipo, String fecha) {
        this.id = id;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public MovimientoModel() {

    }

    public int getId_matadero() {
        return id_matadero;
    }

    public void setId_matadero(int id_matadero) {
        this.id_matadero = id_matadero;
    }

    public int getId_explotacion() {
        return id_explotacion;
    }

    public void setId_explotacion(int id_explotacion) {
        this.id_explotacion = id_explotacion;
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
