<%--
  Created by IntelliJ IDEA.
  User: PAULINA
  Date: 24/03/2025
  Time: 12:07 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.eventos.dao.EventoDAO" %>
<%@ page import="com.eventos.model.Evento" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Eventos Deportivos</title>
</head>
<body>
<h2>Eventos Deportivos</h2>
<table border="1">
    <tr>
        <th>Nombre</th>
        <th>Fecha</th>
        <th>Lugar</th>
        <th>Deporte</th>
        <th>Capacidad</th>
        <th>Entradas Vendidas</th>
        <th>Estado</th>
    </tr>
    <%
        List<Evento> eventos = EventoDAO.obtenerEventos();
        for (Evento evento : eventos) {
    %>
    <tr>
        <td><%= evento.getNombre() %></td>
        <td><%= evento.getFecha() %></td>
        <td><%= evento.getLugar() %></td>
        <td><%= evento.getDeporte() %></td>
        <td><%= evento.getCapacidad() %></td>
        <td><%= evento.getEntradasVendidas() %></td>
        <td><%= evento.getEstado() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>

