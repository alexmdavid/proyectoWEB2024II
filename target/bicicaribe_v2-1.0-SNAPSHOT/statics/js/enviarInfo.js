/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


document.addEventListener("DOMContentLoaded", function () {
    const inputBusqueda = document.getElementById("buscarRutas");
    const resultadoDiv = document.getElementById("resultadoRutas");

    // Verificar si los elementos existen
    if (!inputBusqueda || !resultadoDiv) {
        console.error("No se encontraron los elementos necesarios en el DOM");
        return;
    }

    inputBusqueda.addEventListener("input", function () {
        const texto = this.value.trim(); // Remover espacios en blanco

        if (texto.length > 0) {
            fetch(`UsuarioControlador?action=buscar&texto=${encodeURIComponent(texto)}`)
                .then(response => {
                    if (!response.ok) {
                        throw new Error(`Error en la respuesta del servidor: ${response.status}`);
                    }
                    return response.json();
                })
                .then(data => {
                    resultadoDiv.innerHTML = ""; // Limpiar resultados previos

                    if (Array.isArray(data) && data.length > 0) {
                        data.forEach(ruta => {
                            const rutaDiv = document.createElement("div");
                            rutaDiv.textContent = `${ruta.nombreRuta} - ${ruta.descripcion}`;
                            resultadoDiv.appendChild(rutaDiv);
                        });
                    } else {
                        resultadoDiv.textContent = "No se encontraron resultados.";
                    }
                })
                .catch(error => {
                    console.error("Error al buscar rutas:", error);
                    resultadoDiv.textContent = "Hubo un error al realizar la búsqueda.";
                });
        } else {
            resultadoDiv.innerHTML = ""; // Limpiar resultados si no hay texto
        }
    });
});
