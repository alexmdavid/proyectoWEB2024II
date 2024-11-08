<%-- 
    Document   : perfil
    Created on : 8/11/2024, 12:24:10 a. m.
    Author     : ALEX DAVID RUIDIAZ C
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Perfil de Usuario</title>
</head>
<body>
    <h2>Perfil de Usuario</h2>
    <form action="UsuarioControlador?action=update" method="post">
        <input type="hidden" name="idUsuario" value="${usuario.idUsuario}" />
        <label>Nombre:</label>
        <input type="text" name="nombre" value="${usuario.nombre}" /><br/>
        <label>Apellido:</label>
        <input type="text" name="apellido" value="${usuario.apellido}" /><br/>
        <label>Sexo:</label>
        <input type="text" name="sexo" value="${usuario.sexo}" /><br/>
        <label>Tipo de Sangre:</label>
        <input type="text" name="tipoDeSangre" value="${usuario.tipoDeSangre}" /><br/>
        <button type="submit">Guardar Cambios</button>
    </form>
</body>
</html>
