<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Rutas</title>
    <link rel="stylesheet" type="text/css" href="Styles/style1.css">
</head>
<body action="RutaControlador?action=listarRutas" method="POST">

<h1>Lista de Rutas</h1>

<c:if test="${not empty listaRutas}">
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Descripcion</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="ruta" items="${listaRutas}">
                <tr>
                    <td>${ruta.idRuta}</td>
                    <td>${ruta.nombreRuta}</td>
                    <td>${ruta.descripcion}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
<c:if test="${empty listaRutas}">
    <p>No se encontraron rutas.</p>
</c:if>


</body>
</html>
