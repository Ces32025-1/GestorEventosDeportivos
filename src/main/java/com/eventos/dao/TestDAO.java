package com.eventos.dao;

import com.eventos.dao.EquipoDAO;
import com.eventos.dao.JugadorDAO;
import com.eventos.dao.EventoDAO;
import com.eventos.model.Equipo;
import com.eventos.model.Jugador;
import com.eventos.model.Evento;

public class TestDAO {
    public static void main(String[] args) {
        // Instanciar los DAO
        EquipoDAO equipoDAO = new EquipoDAO();
        JugadorDAO jugadorDAO = new JugadorDAO();
        EventoDAO eventoDAO = new EventoDAO();

        // Crear equipos
        Equipo equipo1 = new Equipo(1, "Real Madrid", "Fútbol", "Madrid", "1902", "https://logo.com/rm.png");
        Equipo equipo2 = new Equipo(2, "Barcelona", "Fútbol", "Barcelona", "1899", "https://logo.com/barca.png");

        equipoDAO.agregarEquipo(equipo1);
        equipoDAO.agregarEquipo(equipo2);

        // Crear jugadores
        Jugador jugador1 = new Jugador(1, "Cristiano", "Ronaldo", "1985-02-05", "Portugal", "Delantero", 7, 1, true);
        Jugador jugador2 = new Jugador(2, "Lionel", "Messi", "1987-06-24", "Argentina", "Delantero", 10, 2, true);

        jugadorDAO.agregarJugador(jugador1);
        jugadorDAO.agregarJugador(jugador2);

        // Crear evento
        Evento evento1 = new Evento(1, "Final Champions League", "2025-06-01", "Estadio Wembley", "Fútbol", 80000);
        evento1.getEquiposParticipantes().add(1);  // Agregar equipo 1
        evento1.getEquiposParticipantes().add(2);  // Agregar equipo 2

        eventoDAO.agregarEvento(evento1);

        // Imprimir resultados
        System.out.println("Equipos registrados:");
        for (Equipo e : equipoDAO.obtenerEquipos()) {
            System.out.println(e.getNombre() + " - " + e.getDeporte());
        }

        System.out.println("\nJugadores registrados:");
        for (Jugador j : jugadorDAO.obtenerJugadores()) {
            System.out.println(j.getNombre() + " " + j.getApellido() + " - " + j.getPosicion());
        }

        System.out.println("\nEventos registrados:");
        for (Evento ev : eventoDAO.obtenerEventos()) {
            System.out.println(ev.getClass() + " - " + ev.getClass());
        }
    }
}
