/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclovia.bicicaribe_v2.DAOs;

import com.ciclovia.bicicaribe_v2.modelos.Usuario;
import com.ciclovia.bicicaribe_v2.repositorios.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */
public class UsuarioDAO {
    
    public boolean insertarUsuario(Usuario usu) {
        String sql = "INSERT INTO usuarios (idusuario, nombre, apellido, sexo, tipo_de_sangre) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usu.getIdUsuario());
            stmt.setString(2, usu.getNombre());
            stmt.setString(3, usu.getApellido());
            stmt.setString(4, usu.getSexo());
            stmt.setString(5, usu.getTipoDeSangre());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar el usuario: " + e.getMessage());
            return false;
        }
    }
    
}
