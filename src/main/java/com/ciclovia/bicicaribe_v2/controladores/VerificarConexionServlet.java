/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ciclovia.bicicaribe_v2.controladores;

import com.ciclovia.bicicaribe_v2.repositorios.Conexion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */
@WebServlet("/verificarConexion")
public class VerificarConexionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            Connection conn = Conexion.getConnection();
            if (conn != null) {
                out.println("<h1>Conexión exitosa a la base de datos</h1>");
                conn.close();
                out.println("<h2>Conexión cerrada correctamente</h2>");
            } else {
                out.println("<h1>No se pudo establecer la conexión</h1>");
            }
        } catch (Exception e) {
            String mes = e.getMessage();
            System.out.println(""+mes);
        }
    }
}