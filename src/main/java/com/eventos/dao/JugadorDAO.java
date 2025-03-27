package com.eventos.dao;

import com.eventos.model.Jugador;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAO {
    private static List<Jugador> jugadores = new ArrayList<>();

    public void agregarJugador(Jugador jugador) {
        for (Jugador j : jugadores) {
            if (j.getEquipoId() == jugador.getEquipoId() && j.getEquipoId() == jugador.getEquipoId()) {
                throw new RuntimeException("El número de camiseta ya está en uso en este equipo.");
            }
        }
        jugadores.add(jugador);
    }

    public List<Jugador> obtenerJugadores() {
        return jugadores;
    }
}
