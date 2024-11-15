document.getElementById('buscarRuta').addEventListener('input', function () {
    const query = this.value.trim(); // Obtiene el valor del input
    const resultadoRutas = document.getElementById('resultadoRutas');
    
    // Limpia resultados si no hay texto
    if (query === "") {
        resultadoRutas.innerHTML = "";
        return;
    }

    console.log("Buscando rutas para:", query); // Muestra el valor de búsqueda

    // Construye la URL correctamente
    const url = `RutaControlador?action=buscar&query=${encodeURIComponent(query)}`;
    console.log("URL solicitada:", url); // Asegúrate de que la URL sea correcta

    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error("Error en la respuesta del servidor: " + response.status);
            }
            return response.json();
        })
        .then(data => {
            console.log("Datos recibidos:", data);

            resultadoRutas.innerHTML = ""; // Limpia resultados previos

            if (data.length > 0) {
                data.forEach(ruta => {
                    const rutaDiv = document.createElement('div');
                    rutaDiv.classList.add('route-card');
                    rutaDiv.innerHTML = `
                        <h3>${ruta.nombreRuta}</h3>
                        <p>${ruta.descripcion}</p>
                    `;
                    resultadoRutas.appendChild(rutaDiv);
                });
            } else {
                resultadoRutas.innerHTML = '<p>No se encontraron rutas.</p>';
            }
        })
        .catch(err => {
            console.error("Error en la búsqueda:", err);
        });
});
