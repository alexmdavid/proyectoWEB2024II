<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Ver Perfil</title>
    <link rel="stylesheet" type="text/css" href="Styles/style1.css">
</head>
<body>
    <h1>Perfil del Usuario</h1>
    <form id="formEditarPerfil" action="UsuarioControlador?action=updateProfile" method="GET">
        

        <label for="nombre">Nombre</label>
        <input type="text" id="nombre" name="nombre" value="${nombre}"><br>

        <label for="apellido">Apellido</label>
        <input type="text" id="apellido" name="apellido" value="${apellido}"><br>

        <label for="sexo">Sexo</label>
        <input type="text" id="sexo" name="sexo" value="${sexo}"><br>

        <label for="tipoSangre">Tipo de Sangre</label>
        <input type="text" id="tipoSangre" name="tipoSangre" value="${tipoSangre}"><br>

        <button type="submit">Actualizar Perfil</button>
    </form>
</body>
</html>
