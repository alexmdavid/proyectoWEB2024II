<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuarios</title>
    <link rel="stylesheet" href="path_to_your_css.css"> <!-- Ruta a tu archivo CSS, si tienes -->
</head>
<body>

<h1>Lista de Usuarios</h1>

<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Sexo</th>
            <th>Tipo de Sangre</th>
            <th>Acciones</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="usuario" items="${listaUsuarios}">
            <tr>
                <td>${usuario.idUsuario}</td>
                <td>${usuario.nombre}</td>
                <td>${usuario.apellido}</td>
                <td>${usuario.sexo}</td>
                <td>${usuario.tipoDeSangre}</td>
                <td>
                    <!-- Enlace para ver el perfil del usuario -->
                    <a href="UsuarioControlador?action=viewProfile&idUsuario=${usuario.idUsuario}">Ver Perfil</a>
                    
                    <!-- Enlace para editar el usuario -->
                    <a href="UsuarioControlador?action=update&idUsuario=${usuario.idUsuario}">Editar</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
