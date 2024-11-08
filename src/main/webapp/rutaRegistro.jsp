<%-- 
    Document   : index
    Created on : 5/11/2024, 1:50:13 p. m.
    Author     : ALEX DAVID RUIDIAZ C
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Agregar Ruta</title>
    <link rel="stylesheet" type="text/css" href="Styles/style1.css">
</head>
<body>
    <h2>Formulario para Agregar una Nueva Ruta</h2>
    <form action="RutaControlador" method="POST">
        <label for="idRuta">ID de la Ruta:</label>
        <input type="number" id="idRuta" name="idRuta" required>

        <label for="nombreRuta">Nombre de la Ruta:</label>
        <input type="text" id="nombreRuta" name="nombreRuta" required>

        <label for="descripcion">Descripción:</label>
        <textarea id="descripcion" name="descripcion" required></textarea>

        <button type="submit">Agregar Ruta</button>
    </form>
</body>
</html>
