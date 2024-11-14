/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ciclovia.bicicaribe_v2.controladores;

import com.ciclovia.bicicaribe_v2.DAOs.TorneoDAO;
import com.ciclovia.bicicaribe_v2.modelos.Torneo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */
public class TorneoControlador extends HttpServlet {

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
        String action = request.getParameter("action");
        if("list".equals(action)){
            try {
                listarTorneos(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(TorneoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
        String action = request.getParameter("action");
        if("create".equals(action)){
            try {
                insertarTorneo(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(TorneoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    private void insertarTorneo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        Torneo torneo = new Torneo( nombre, descripcion);
        TorneoDAO tor = new TorneoDAO();
        if(tor.insertarTorneo(torneo)){
            response.sendRedirect("home.jsp");
        }else{
            response.sendRedirect("error.jsp");
        }
    }
    
    private void listarTorneos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
         List<Torneo> torneos = new ArrayList<>();
         TorneoDAO torDao = new TorneoDAO();
         torneos = torDao.obtenerTodosLosTorneos();
        // Agregar la lista de torneos al request
        request.setAttribute("torneos", torneos);
        // Redirigir al JSP
        request.getRequestDispatcher("listarTorneos.jsp").forward(request, response);
    }

    
}





  