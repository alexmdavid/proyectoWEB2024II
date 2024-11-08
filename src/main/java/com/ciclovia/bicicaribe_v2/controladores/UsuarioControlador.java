/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ciclovia.bicicaribe_v2.controladores;

import com.ciclovia.bicicaribe_v2.DAOs.UsuarioDAO;
import com.ciclovia.bicicaribe_v2.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */
@WebServlet("/UsuarioControlador")
public class UsuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_ = request.getParameter("idUsuario");
        String nombre = request.getParameter("nombre");
        String ape = request.getParameter("apellido");
        String sexo = request.getParameter("sexo");
        String tipoSan = request.getParameter("tipoSangre");

        try {
            // Convertir el id a entero
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
                // Redirigir a una página de error o la misma página si la inserción falla
                response.sendRedirect("home.jsp");
            }
        } catch (NumberFormatException e) {
            // Redirigir a una página de error si el ID no es válido
            response.sendRedirect("home.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
