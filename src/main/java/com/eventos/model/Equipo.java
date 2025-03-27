package com.eventos.model;

import java.util.ArrayList;

public class Equipo {
    private int id;
    private String nombre;
    private String deporte;
    private String ciudad;
    private String fechaFundacion;
    private String logo;
    private ArrayList<Integer> jugadores;

    public Equipo(int id, String nombre, String deporte, String ciudad, String fechaFundacion, String logo) {
        this.id = id;
        this.nombre = nombre;
        this.deporte = deporte;
        this.ciudad = ciudad;
        this.fechaFundacion = fechaFundacion;
        this.logo = logo;
        this.jugadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDeporte() {
        return deporte;
    }
}
