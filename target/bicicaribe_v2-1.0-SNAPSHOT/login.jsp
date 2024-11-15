<%-- 
    Document   : login
    Created on : 5/11/2024, 1:50:25 p. m.
    Author     : ALEX DAVID RUIDIAZ C
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="./statics/styles/style.css">
    <script src="statics/js/index.js"></script>
</head>
<body>
    <div class="container">
        <h1>Iniciar Sesión</h1>
        <form method="POST" action="UsuarioControlador?action=login">
            <label for="username">Nombre de Usuario:</label>
            <input type="text" id="username" name="correo" required><br><br>
        
            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="contrasena" required><br><br>
        
            <button type="submit" >Iniciar Sesión</button>
        </form>

        <li><a href = "registro.jsp"> Registrarse</a></li>
        <li><a href="index.jsp">principal</a></li>
    </div>
</body>
</html>
