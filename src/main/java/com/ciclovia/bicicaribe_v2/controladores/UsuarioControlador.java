package com.ciclovia.bicicaribe_v2.controladores;

import com.ciclovia.bicicaribe_v2.DAOs.UsuarioDAO;
import com.ciclovia.bicicaribe_v2.modelos.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/UsuarioControlador")
public class UsuarioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list".equals(action)) {
            listarUsuarios(request, response);
        } else if ("viewProfile".equals(action)) {
            verPerfil(request, response);
        }
        else if("viewMyProfile".equals(action)){
            vermiPerfil(request, response);
            
        } else {
            response.sendRedirect("home.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("update".equals(action)) {
            actualizar(request, response);
        } else if ("create".equals(action)) {

            registrar(request, response);

        } else if ("login".equals(action)) {
            iniciarSesion(request, response);
        }
        

    }

    @Override
    public String getServletInfo() {
        return "UsuarioControlador Servlet";
    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> listaUsuarios = usuarioDAO.obtenerTodosLosUsuarios();
        Usuario usu = obtenerUsuarioDeSesion(request);
        if (usu.getIdRol() == 1) {
            request.setAttribute("listaUsuarios", listaUsuarios);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listaUsuarios.jsp");
            dispatcher.forward(request, response);
        }else{
             request.setAttribute("listaUsuarios", listaUsuarios);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listarUsuariosN.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void verPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.obtenerUsuarioPorId(idUsuario);
        request.setAttribute("usuario", usuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("perfil.jsp");
        dispatcher.forward(request, response);
    }

    private Usuario obtenerUsuarioDeSesion(HttpServletRequest request) {
    HttpSession session = request.getSession();
    Usuario usuario = (Usuario) session.getAttribute("usuario");

    if (usuario == null) {
        throw new IllegalStateException("No hay usuario en sesión");
    }

    return usuario;
}


    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

        String nombre = request.getParameter("nombre");

        String apellido = request.getParameter("apellido");
        String sexo = request.getParameter("sexo");

        String tipoDeSangre = request.getParameter("tipoSangre");

        Usuario usuario = new Usuario(idUsuario, nombre, apellido, sexo, tipoDeSangre);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.actualizarUsuario(usuario);

        response.setContentType(
                "text/html");
        response.getWriter().write("success");
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Entrando al método registrar");

        String nombre = request.getParameter("nombre");
        String ape = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String contrasna = request.getParameter("contrasena");
        int idrol = 2;

        System.out.println("Datos recibidos: " + nombre + ", " + ape + ", " + correo);

        try {
            Usuario usu = new Usuario(nombre, ape, correo, contrasna, idrol);
            UsuarioDAO usuDAO = new UsuarioDAO();
            boolean resultado = usuDAO.insertarUsuario(usu);
            if (resultado) {
                System.out.println("Usuario insertado con éxito");
                response.sendRedirect("login.jsp");
            } else {
                System.out.println("Error al insertar usuario");
                response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            System.err.println("Error en registrar: " + e.getMessage());
            response.sendRedirect("error.jsp");
        }
    }

    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String username = request.getParameter("correo");
        String password = request.getParameter("contrasena");

        // Verificar las credenciales
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.obtenerUsuarioPorCorreo(username);

        if (usuario != null && password.equals(usuario.getContrasena())) {
            // Las credenciales son correctas, iniciar sesión
            HttpSession session = request.getSession(true); // Crear o recuperar sesión
            session.setAttribute("usuario", usuario);       // Guardar el usuario en la sesión

            // Redirigir a la página principal (o la que corresponda)
            response.sendRedirect("home.jsp");
        } else {
            // Las credenciales son incorrectas, mostrar mensaje de error
            response.sendRedirect("login.jsp?error=true");
        }
    }
    
    private void vermiPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuarioFalso = obtenerUsuarioDeSesion(request);
        UsuarioDAO uDao = new UsuarioDAO();
        Usuario usuario = uDao.obtenerUsuarioPorId(usuarioFalso.getIdUsuario());
        System.out.println(""+usuario.getNombre()+" "+usuario.getApellido()+" "+usuario.getSexo()+" "+usuario.getIdUsuario());
        request.setAttribute("nombre", usuario.getNombre());
        request.setAttribute("apellido", usuario.getApellido());
        request.setAttribute("sexo", usuario.getSexo());
        request.setAttribute("tipoSangre", usuario.getTipoDeSangre());
        RequestDispatcher dispatcher = request.getRequestDispatcher("verPerfil.jsp");
        dispatcher.forward(request, response);
    }

}
