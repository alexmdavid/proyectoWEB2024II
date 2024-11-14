<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Torneo</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        form {
            max-width: 500px;
            margin: auto;
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }
        input, textarea, select, button {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Registrar Nuevo Torneo</h2>
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
