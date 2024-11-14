<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ciclovia.bicicaribe_v2.modelos.Torneo" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Torneos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
    <h1>Listado de Torneos</h1>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Patrocinador</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Obtener la lista de torneos desde el request
                List<Torneo> torneos = (List<Torneo>) request.getAttribute("torneos");

                if (torneos != null && !torneos.isEmpty()) {
                    for (Torneo torneo : torneos) {
            %>
                        <tr>
                            <td><%= torneo.getIdTorneo() %></td>
                            <td><%= torneo.getNombre() %></td>
                            <td><%= torneo.getDescripcion() %></td>
                            <td>niguno por ahora</td>
                        </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="4" style="text-align: center;">No hay torneos registrados.</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
