<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Torneo</title>
    <link rel="stylesheet" href="./statics/styles/formularios.css">
</head>
<body>
    
    <form action="TorneoControlador?action=create" method="post">
        <label for="nombre">Nombre del Torneo:</label>
        <input type="text" id="nombre" name="nombre" required placeholder="Ingrese el nombre del torneo">

        <label for="descripcion">Descripción:</label>
        <textarea id="descripcion" name="descripcion" rows="4" required placeholder="Describa el torneo"></textarea>

        <label for="idPatrocinador">Patrocinador:</label>
        <select id="idPatrocinador" name="idPatrocinador" required>
            <option value="">-- Seleccione un patrocinador --</option>
            <option value="1">Patrocinador 1</option>
            <option value="2">Patrocinador 2</option>
            <option value="3">Patrocinador 3</option>
            <!-- Agrega más opciones dinámicamente desde la base de datos -->
        </select>

        <button type="submit">Registrar Torneo</button>
    </form>
</body>
</html>
