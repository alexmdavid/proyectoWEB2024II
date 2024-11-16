<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Grupos</title>
    <link rel="stylesheet" type="text/css" href="statics/styles/ver_Grupos.css">
</head>
<body>

    <div class="container">
        <h1>Todos los grupos</h1>

        <!-- Si no hay grupos, mostrar mensaje -->
        <c:if test="${empty listargrupos}">
            <p class="no-grupos">No se encontraron grupos.</p>
        </c:if>

        <!-- Si existen grupos, mostrar la tabla -->
        <c:if test="${not empty listargrupos}">
            <table class="grupo-table">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Modalidad</th>
                        <th>Acción</th>  <!-- Nueva columna para el botón -->
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="grupo" items="${listargrupos}">
                        <tr>
                            <td>${grupo.nombre}</td>
                            <td>${grupo.descripcion}</td>
                            <td>${grupo.modalidad}</td>
                            <td>
                                <!-- Formulario con botón para unirse al grupo -->
                                <form action="GrupoControlador" method="post">
                                    <input type="hidden" name="action" value="unirse">
                                    <input type="hidden" name="idGrupo" value="${grupo.idGrupo}">
                                    <button type="submit" class="btn-unirse">Unirme</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>

</body>
</html>
