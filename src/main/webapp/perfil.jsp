<!-- Aquí va el formulario de edición -->
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Usuario</title>
    <link rel="stylesheet" type="text/css" href="Styles/style1.css">
</head>
<form id="formEditarPerfil">
    <input type="hidden" id="idUsuario" value="${usuario.idUsuario}">

    <label for="nombre">Nombre</label>
    <input type="text" id="nombre" name="nombre" value="${usuario.nombre}" required><br>

    <label for="apellido">Apellido</label>
    <input type="text" id="apellido" name="apellido" value="${usuario.apellido}" required><br>

    <label for="sexo">Sexo</label>
    <select id="sexo" name="sexo" required>
        <option value="Masculino" ${usuario.sexo == 'Masculino' ? 'selected' : ''}>Masculino</option>
        <option value="Femenino" ${usuario.sexo == 'Femenino' ? 'selected' : ''}>Femenino</option>
    </select><br>

    <label for="tipoSangre">Tipo de Sangre</label>
    <input type="text" id="tipoSangre" name="tipoSangre" value="${usuario.tipoDeSangre}" required><br>

    <input type="hidden" name="idUsuario" value="${usuario.idUsuario}">

    <button type="submit">Actualizar Perfil</button>
</form>

<!-- Agregar la librería de jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
$(document).ready(function() {
    // Evento para enviar el formulario sin recargar la página
    $('#formEditarPerfil').submit(function(e) {
        e.preventDefault(); // Prevenir el envío normal del formulario

        var formData = $(this).serialize(); // Obtener los datos del formulario

        // Realizar la solicitud AJAX
        $.ajax({
            url: 'UsuarioControlador?action=update',  // Ruta al controlador que actualiza el perfil
            type: 'POST',
            data: formData, // Datos que enviamos al servidor
            success: function(response) {
                // Si la actualización fue exitosa, mostramos un mensaje o redirigimos
                alert('Perfil actualizado correctamente');
                window.location.href = 'UsuarioControlador?action=viewProfile&idUsuario=' + $('#idUsuario').val();
            },
            error: function(xhr, status, error) {
                // En caso de error, mostramos un mensaje
                alert('Error al actualizar el perfil');
            }
        });
    });
});
</script>
