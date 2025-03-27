package com.eventos.dao;

import com.eventos.model.Equipo;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
    private static List<Equipo> equipos = new ArrayList<>();

    public void agregarEquipo(Equipo equipo) {
        for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(equipo.getNombre()) &&
                    e.getDeporte().equalsIgnoreCase(equipo.getDeporte())) {
                throw new RuntimeException("Ya existe un equipo con el mismo nombre y deporte.");
            }
        }
        equipos.add(equipo);
    }

    public List<Equipo> obtenerEquipos() {
        return equipos;
    }
}
