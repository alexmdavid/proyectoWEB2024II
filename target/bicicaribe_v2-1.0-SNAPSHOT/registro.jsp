<%-- 
    Document   : registro
    Created on : 5/11/2024, 1:50:35 p. m.
    Author     : ALEX DAVID RUIDIAZ C
--%>
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
    <title>Registrar Usuario</title>
    <link rel="stylesheet" type="text/css" href="Styles/style1.css">
</head>
<body>
    <h2>Formulario para Refistrar Usuario</h2>
    <form action="UsuarioControlador" method="POST">
        <label for="idUsuario">ID del usuario:</label>
        <input type="number" id="idUsuario" name="idUsuario" required>

        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>

        <label for="apellido">Apellido:</label>
        <textarea id="apellido" name="apellido" required></textarea>
        
        <label for="fechaNacimiento">fecha de Nacimiento:</label>
        <textarea id="fechaNacimiento" name="fechaNacimiento" required></textarea><!--  -->
        
        <label for="sexo">Sexo:</label>
        <textarea id="sexo" name="sexo" required></textarea>
        
        <label for="tipoSangre">Tipo de Sangre:</label>
        <textarea id="tipoSangre" name="tipoSangre" required></textarea>

        <button type="submit">Registrar Usuario</button>
    </form>
</body>
</html>
