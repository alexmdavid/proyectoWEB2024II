<%-- 
    Document   : index
    Created on : 8/11/2024, 3:22:23 p. m.
    Author     : ALEX DAVID RUIDIAZ C
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bicicleta Rutas</title>
        <link rel="stylesheet" href="./styles.css/style.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" rel="stylesheet">
        <script src="./statics/js/buscarRutas.js"></script>



    </head>
    <body>
        <header>
            <div class="logo">
                <img src="./img/logo-bicicaribe.jpg" alt="Logo Bicicleta" class="zoom">
            </div>
            <div class="social-media">
                <a class="fa-brands fa-facebook fa-xl"></a>
                <a class="fa-brands fa-instagram fa-xl"></a>
                <a class="fa-brands fa-twitter fa-xl"></a>
            </div>
            <div class="auth-buttons">
                <button class="login-btn" onclick="location.href = '<%= request.getContextPath() %>/UsuarioControlador?action=viewMyProfile'">Mi perfil</button>
            </div>

        </header>

        <nav class="barra">
            <ul>
                <li><a href="#">INICIO</a></li>
                <li><a href="RutaControlador?action=listarRutas">RUTAS</a></li>
                <li><a href="GrupoControlador?action=list">GRUPOS DE SALIDA</a></li>
                <li><a href="TorneoControlador?action=list">TORNEOS</a></li>
                <li><a href="UsuarioControlador?action=list">VER USUARIOS</a></li>
                <li><a href="#">CONTACTANOS</a></li>
            </ul>
        </nav>

        <main>
            <div class="search-bar">
                <input type="text" id="buscarRuta" placeholder="Buscar ruta">
            </div>
            <div id="resultadoRutas"></div>


            <div class="routes">
                <div class="route-card">
                    <img src="./img/minca.jpg" alt="Minca - Cerro Kennedy - Arimaca" class="zoom">
                    <h3>Minca - Cerro Kennedy - Arimaca</h3>
                    <button>Ver más</button>
                </div>
                <div class="route-card">
                    <img src="./img/cerro-kennedy.jpg" alt="Minca - Cerro Kennedy - Arimaca" class="zoom">
                    <h3>Minca - Cerro Kennedy</h3>
                    <button>Ver más</button>
                </div>
                <div class="route-card">
                    <img src="./img/rio.jpg" alt="Minca - Cerro Kennedy - Arimaca" class="zoom">
                    <h3>Rio Frio</h3>
                    <button>Ver más</button>
                </div>
            </div>
        </main>

        <footer>
            <h2>BiciCaribe</h2>

            <p>
                <small>&copy; 2024 BiciCaribe. Todos los derechos reservados.</small>
            </p>
        </footer>
    </body>
    <!-- Enlace para listar las rutas -->


    <!-- Enlace para registrar una nueva ruta -->


</html>
