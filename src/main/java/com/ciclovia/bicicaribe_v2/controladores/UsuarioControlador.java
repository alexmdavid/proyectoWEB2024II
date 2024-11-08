package com.ciclovia.bicicaribe_v2.controladores;

import com.ciclovia.bicicaribe_v2.DAOs.UsuarioDAO;
import com.ciclovia.bicicaribe_v2.modelos.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/UsuarioControlador")
public class UsuarioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list".equals(action)) {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            List<Usuario> listaUsuarios = usuarioDAO.obtenerTodosLosUsuarios();
            request.setAttribute("listaUsuarios", listaUsuarios);
            System.out.println(""+listaUsuarios);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listaUsuarios.jsp");
            dispatcher.forward(request, response);
        } else if ("viewProfile".equals(action)) {
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = usuarioDAO.obtenerUsuarioPorId(idUsuario);
            request.setAttribute("usuario", usuario);
            RequestDispatcher dispatcher = request.getRequestDispatcher("perfil.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("home.jsp");
        }

    }

   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getParameter("action");

    if ("update".equals(action)) {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String sexo = request.getParameter("sexo");
        String tipoDeSangre = request.getParameter("tipoDeSangre");

        Usuario usuario = new Usuario(idUsuario, nombre, apellido, sexo, tipoDeSangre);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.actualizarUsuario(usuario);

        response.sendRedirect("UsuarioControlador?action=list"); // Redirigir a la lista de usuarios
    } else {
        // El resto de la lógica POST (como la creación de usuarios)
        String id_ = request.getParameter("idUsuario");
        String nombre = request.getParameter("nombre");
        String ape = request.getParameter("apellido");
        String sexo = request.getParameter("sexo");
        String tipoSan = request.getParameter("tipoSangre");

        try {
            // Validar y convertir el id a entero
            int idUsu = Integer.parseInt(id_);

            // Crear una nueva instancia de Usuario con los datos recibidos
            Usuario usu = new Usuario(idUsu, nombre, ape, sexo, tipoSan);

            // Usar el DAO para insertar el usuario en la base de datos
            UsuarioDAO usuDAO = new UsuarioDAO();
            boolean resultado = usuDAO.insertarUsuario(usu);

            if (resultado) {
                // Redirigir a la página de inicio si la inserción fue exitosa
                response.sendRedirect("home.jsp");
            } else {
                // Redirigir a una página de error si la inserción falla
                response.sendRedirect("error.jsp");
            }
        } catch (NumberFormatException e) {
            // Redirigir a una página de error si el ID no es válido
            response.sendRedirect("error.jsp");
        }
    }
}


    @Override
    public String getServletInfo() {
        return "UsuarioControlador Servlet";
    }
}
