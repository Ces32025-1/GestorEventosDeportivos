package com.eventos.servlets;

import com.eventos.dao.JugadorDAO;
import com.eventos.model.Jugador;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="jugador", value="/jugadores")
public class JugadorServlet extends HttpServlet {
    private JugadorDAO jugadorDAO = new JugadorDAO();
    private Gson gson = new Gson();

    @Override
    public void init() throws ServletException {

        List<Jugador> jugadores = jugadorDAO.obtenerJugadores();

        if (jugadores.isEmpty()) {
            Jugador jugador1 = new Jugador(1,"Lionel","Messi","24/06/1987","Argentina","Delantero",10,1,true);

            jugadorDAO.agregarJugador(jugador1);

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Jugador nuevoJugador = gson.fromJson(reader, Jugador.class);

        try {
            jugadorDAO.agregarJugador(nuevoJugador);
            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.getWriter().write("Jugador agregado correctamente.");
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Jugador> jugadores = jugadorDAO.obtenerJugadores();
        String jsonResponse = gson.toJson(jugadores);

        resp.setContentType("application/json");
        resp.getWriter().write(jsonResponse);
    }
}
