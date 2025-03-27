package com.eventos.servlets;

import com.eventos.dao.EventoDAO;
import com.eventos.model.Evento;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="evento", value= "/eventos")
public class EventoServlet extends HttpServlet {
    private EventoDAO eventoDAO = new EventoDAO();
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Evento nuevoEvento = gson.fromJson(reader, Evento.class);

        try {
            eventoDAO.agregarEvento(nuevoEvento);
            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.getWriter().write("Evento agregado correctamente.");
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Evento> eventos = eventoDAO.obtenerEventos();
        String jsonResponse = gson.toJson(eventos);

        resp.setContentType("application/json");
        resp.getWriter().write(jsonResponse);
    }
}
