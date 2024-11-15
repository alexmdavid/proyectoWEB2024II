<%-- 
    Document   : grupos
    Created on : 13/11/2024, 12:19:48 a. m.
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
    <form action="GrupoControlador?action=create" method="POST">

        <label for="nombreGrupo">Nombre del grupo:</label>
        <input type="text" id="nombreGrupo" name="nombreGrupo" required>

        <label for="descripcion">Descripción:</label>
        <textarea id="descripcion" name="descripcion" required></textarea>
        
        <label for="modalidad">Modalidad:</label>
        <textarea id="descripcion" name="modalidad" required></textarea>


        <button type="submit">Agregar agregar grupo</button>
    </form>
</body>
</html>
