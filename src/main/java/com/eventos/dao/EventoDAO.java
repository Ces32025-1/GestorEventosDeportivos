package com.eventos.dao;

import com.eventos.model.Evento;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {
    private static List<Evento> eventos = new ArrayList<>();

    public void agregarEvento(Evento evento) {
        // Verificación para evitar errores con null
        if (evento.getEquiposParticipantes() == null || evento.getEquiposParticipantes().size() < 2) {
            throw new RuntimeException("Un evento debe tener al menos dos equipos participantes.");
        }
        eventos.add(evento);
    }

    public static List<Evento> obtenerEventos() {
        return eventos;
    }
}
