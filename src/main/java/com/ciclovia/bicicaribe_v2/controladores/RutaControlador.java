/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ciclovia.bicicaribe_v2.controladores;

import com.ciclovia.bicicaribe_v2.DAOs.RutaDAO;
import com.ciclovia.bicicaribe_v2.modelos.Ruta;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */
public class RutaControlador extends HttpServlet {

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
    // Obtener los valores de los parámetros
    String id_ = request.getParameter("idRuta");
    String nombreRuta = request.getParameter("nombreRuta");
    String des = request.getParameter("descripcion");

    try {
        // Convertir el id a entero
        int idRuta = Integer.parseInt(id_);

        // Crear una nueva instancia de Ruta con los datos recibidos
        Ruta ruta = new Ruta(idRuta, nombreRuta, des);

        // Usar el DAO para insertar la ruta en la base de datos
        RutaDAO rutaDAO = new RutaDAO();
        boolean resultado = rutaDAO.insertarRuta(ruta);

        if (resultado) {
            response.getWriter().println("Ruta insertada correctamente.");
        } else {
            response.getWriter().println("Error al insertar la ruta.");
        }
    } catch (NumberFormatException e) {
        // Manejo de error en caso de que el id no sea un número válido
        response.getWriter().println("ID de la ruta inválido.");
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
