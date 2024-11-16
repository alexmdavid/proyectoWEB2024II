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
    <title>Agregar Grupo</title>
    <link rel="stylesheet" type="text/css" href="./statics/styles/formularios.css">
</head>
<body>
    <form action="GrupoControlador?action=create" method="POST">

        <label for="nombreGrupo">Nombre del grupo:</label>
        <input type="text" id="nombreGrupo" name="nombreGrupo" required>

        <label for="descripcion">Descripción:</label>
        <textarea id="descripcion" name="descripcion" required></textarea>
        
        <label for="modalidad">Modalidad:</label>
        <textarea id="descripcion" name="modalidad" required></textarea>


        <button type="submit">Agregar grupo</button>
    </form>
</body>
</html>
