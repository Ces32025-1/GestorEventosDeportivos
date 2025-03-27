package com.eventos.model;

public class Jugador {
    private int id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String nacionalidad;
    private String posicion;
    private int numero;
    private int equipoId;
    private boolean estadoActivo;

    public Jugador(int id, String nombre, String apellido, String fechaNacimiento, String nacionalidad,
                   String posicion, int numero, int equipoId, boolean estadoActivo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.posicion = posicion;
        this.numero = numero;
        this.equipoId = equipoId;
        this.estadoActivo = estadoActivo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPosicion() {
        return posicion;
    }

    public int getEquipoId() {
        return equipoId;
    }


}
