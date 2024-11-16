<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Usuarios</title>
    <link rel="stylesheet" type="text/css" href="statics/styles/ver_Usuarios.css">
</head>
<body>
    <div class="container">
        <h1>Lista de Usuarios</h1>

        <table>
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
                            <a href="UsuarioControlador?action=viewProfile&idUsuario=${usuario.idUsuario}" class="view-link">Ver Perfil</a>
                            <a href="UsuarioControlador?action=update&idUsuario=${usuario.idUsuario}" class="edit-link">Editar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
