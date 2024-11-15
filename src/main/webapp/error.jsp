<%-- 
    Document   : error
    Created on : 8/11/2024, 12:32:15 a. m.
    Author     : ALEX DAVID RUIDIAZ C
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="/addUser" method="post">
            <label for="username">Nombre de Usuario:</label>
            <input type="text" id="username" name="username" required><br><br>

            <label for="role">Rol:</label>
            <input list="roles" id="role" name="role" placeholder="Selecciona o escribe un rol" required>
            <datalist id="roles">
                <option value="usuario_normal">
                <option value="admin">
            </datalist><br><br>

            <button type="submit">Agregar Usuario</button>
        </form>


    </body>
</html>
