package com.eventos.model;

import java.util.ArrayList;

public class Evento {
    private int id;
    private String nombre;
    private String fecha;
    private String lugar;
    private String deporte;
    private ArrayList<Integer> equiposParticipantes;
    private int capacidad;
    private int entradasVendidas;
    private String estado;

    public Evento(int id, String nombre, String fecha, String lugar, String deporte, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.deporte = deporte;
        this.capacidad = capacidad;
        this.entradasVendidas = 0;
        this.equiposParticipantes = new ArrayList<>(); //  Inicialización correcta
        this.estado = "Programado";
    }

    // Metodo para obtener los equipos participantes, evitando errores con null
    public ArrayList<Integer> getEquiposParticipantes() {
        if (equiposParticipantes == null) {
            equiposParticipantes = new ArrayList<>();
        }
        return equiposParticipantes;
    }

    // Getters y Setters
}
