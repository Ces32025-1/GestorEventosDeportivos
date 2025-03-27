package com.eventos.servlets;

import com.eventos.dao.EquipoDAO;
import com.eventos.model.Equipo;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "equipo", value="/equipos")

public class EquipoServlet extends HttpServlet {
    private EquipoDAO equipoDAO = new EquipoDAO();
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Equipo nuevoEquipo = gson.fromJson(reader, Equipo.class);

        try {
            equipoDAO.agregarEquipo(nuevoEquipo);
            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.getWriter().write("Equipo agregado correctamente.");
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Equipo> equipos = equipoDAO.obtenerEquipos();
        String jsonResponse = gson.toJson(equipos);

        resp.setContentType("application/json");
        resp.getWriter().write(jsonResponse);
    }
}
