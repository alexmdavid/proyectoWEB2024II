<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <!-- Cambiar la referencia del archivo CSS -->
    <link rel="stylesheet" href="./statics/styles/style.css">
    <script src="statics/js/index.js"></script>
</head>

<body>
    <div class="container">
        <h2>Crear Cuenta</h2>
        <form action="UsuarioControlador?action=create" method="POST" >
            <div class="input-group">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" required>
            </div>
            <div class="input-group">
                <label for="apellido">Apellido:</label>
                <input type="text" id="apellido" name="apellido" required>
            </div>
            <div class="input-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="correo" required>
                <small id="emailError"></small>
            </div>
            <div class="input-group">
                <label for="password">Password:</label>
                <div style="position: relative;">
                    <input type="password" id="password" name="contrasena" required>
                    <!-- Ícono de ojo -->
                    <span id="togglePassword"
                        style="position: absolute; right: 10px; top: 50%; transform: translateY(-50%); cursor: pointer;">
                        ??
                    </span>
                </div>
                <small id="passwordError"></small>
            </div>
            <button type="submit">Regístrate</button>
        </form>
    </div>
</body>

</html>
