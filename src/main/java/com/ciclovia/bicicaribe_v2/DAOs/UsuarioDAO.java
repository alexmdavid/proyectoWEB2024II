/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclovia.bicicaribe_v2.DAOs;

import com.ciclovia.bicicaribe_v2.modelos.Usuario;
import com.ciclovia.bicicaribe_v2.repositorios.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */
public class UsuarioDAO {

    public boolean insertarUsuario(Usuario usu) {
        String sql = "INSERT INTO usuarios (nombre, apellido, correo, contrasena, idRol) VALUES (?, ?, ?, ?, ?)";
        try ( Connection conn = Conexion.getConnection();  PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usu.getNombre());
            stmt.setString(2, usu.getApellido());
            stmt.setString(3, usu.getCorreo());
            stmt.setString(4, usu.getContrasena());
            stmt.setInt(5, usu.getIdRol());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar el usuario: " + e.getMessage());
            return false;
        }
    }

    // UsuarioDAO.java
    public Usuario obtenerUsuarioPorId(int idUsuario) {
        String sql = "SELECT idusuario, nombre, apellido, fecha_nacimiento, sexo, tipo_de_sangre, correo FROM usuarios WHERE idusuario = ?";
        try ( Connection conn = Conexion.getConnection();  PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getInt("idusuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("sexo"),
                        rs.getString("tipo_de_sangre"),
                        rs.getString("correo"),
                        null, // Contraseña no se incluye por seguridad
                        0, 0, 0, 0 // Rellenar los otros IDs según necesidad
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el usuario: " + e.getMessage());
        }
        return null; // Devuelve null si no se encuentra el usuario
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String query = "SELECT * FROM usuarios"; // o el nombre correcto de tu tabla
        try ( Connection con = Conexion.getConnection();  PreparedStatement stmt = con.prepareStatement(query);  ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("idUsuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String sexo = rs.getString("sexo");
                String tipoSangre = rs.getString("tipo_de_sangre");

                Usuario usuario = new Usuario(id, nombre, apellido, sexo, tipoSangre);
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }

    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, sexo = ?, tipo_de_sangre = ? WHERE idusuario = ?";
        try ( Connection conn = Conexion.getConnection();  PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getSexo());
            stmt.setString(4, usuario.getTipoDeSangre());
            stmt.setInt(5, usuario.getIdUsuario());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }

   public Usuario obtenerUsuarioPorCorreo(String correo) {
    Usuario usuario = null;
    String sql = "SELECT * FROM usuarios WHERE correo = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, correo);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            usuario = new Usuario(
                rs.getInt("idusuario"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("correo"),
                rs.getString("contrasena"),
                rs.getInt("idrol")
            );
        }
    } catch (Exception e) {
        System.err.println("Error al obtener usuario por correo: " + e.getMessage());
    }
    return usuario;
}


}
