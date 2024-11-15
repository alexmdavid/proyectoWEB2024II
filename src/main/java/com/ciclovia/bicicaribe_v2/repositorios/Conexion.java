/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclovia.bicicaribe_v2.repositorios;

/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private static final String URL = "jdbc:postgresql://localhost:5432/bicicaribe_v2"; 
    private static final String USER = "user_node"; 
    private static final String PASSWORD = "123456"; 
    public static Connection getConnection() {
    Connection conn = null;
    try {
        Class.forName("org.postgresql.Driver"); 
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Conexión exitosa a la base de datos.");
    } catch (ClassNotFoundException e) {
        System.err.println("Error: Controlador PostgreSQL no encontrado. " + e.getMessage());
    } catch (SQLException e) {
        System.err.println("Error al conectar a la base de datos: " + e.getMessage());
    }
    return conn;
}


    public static void main(String[] args) {
        Connection conn = getConnection();
        
        if (conn != null) {
            System.out.println("Conexión verificada, se cerrará ahora.");
            try {
                conn.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }
}
