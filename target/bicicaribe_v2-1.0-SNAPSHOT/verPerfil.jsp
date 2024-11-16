<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Ver Perfil</title>
    <link rel="stylesheet" type="text/css" href="statics/styles/ver_perfil.css">
</head>
<body>
    <form id="formEditarPerfil" action="UsuarioControlador?action=updateProfile" method="GET">
        

        <label for="nombre">Nombre</label>
        <input type="text" id="nombre" name="nombre" value="${nombre}"><br>
        <br>
        <label for="apellido">Apellido</label>
        <input type="text" id="apellido" name="apellido" value="${apellido}"><br>
        <br>
        <label for="sexo">Sexo</label>
        <input type="text" id="sexo" name="sexo" value="${sexo}"><br>
        <br>
        <label for="tipoSangre">Tipo de Sangre</label>
        <input type="text" id="tipoSangre" name="tipoSangre" value="${tipoSangre}"><br>
        <br><br>
        <button type="submit">Actualizar Perfil</button>
    </form>
</body>
</html>
