/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclovia.bicicaribe_v2.DAOs;

/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */


import com.ciclovia.bicicaribe_v2.modelos.Ruta;
import com.ciclovia.bicicaribe_v2.repositorios.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RutaDAO {

    // Método para insertar una nueva ruta en la base de datos
    public boolean insertarRuta(Ruta ruta) {
        String sql = "INSERT INTO ruta (id_ruta, nombre_ruta, descripcion) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ruta.getIdRuta());
            stmt.setString(2, ruta.getNombreRuta());
            stmt.setString(3, ruta.getDescripcion());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar la ruta: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener una ruta por su ID
    public Ruta obtenerRutaPorId(int idRuta) {
        String sql = "SELECT * FROM ruta WHERE id_ruta = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idRuta);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Ruta(
                        rs.getInt("id_ruta"),
                        rs.getString("nombre_ruta"),
                        rs.getString("descripcion")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la ruta: " + e.getMessage());
        }
        return null;
    }

    // Método para obtener todas las rutas de la base de datos
    public List<Ruta> obtenerTodasLasRutas() {
        List<Ruta> rutas = new ArrayList<>();
        String sql = "SELECT * FROM rutas";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Ruta ruta = new Ruta(
                        rs.getInt("idruta"),
                        rs.getString("nombreruta"),
                        rs.getString("descripcion")
                );
                rutas.add(ruta);
                System.out.println(""+rutas);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener las rutas: " + e.getMessage());
        }
        return rutas;
    }

    // Método para actualizar una ruta existente
    public boolean actualizarRuta(Ruta ruta) {
        String sql = "UPDATE ruta SET nombre_ruta = ?, descripcion = ? WHERE id_ruta = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ruta.getNombreRuta());
            stmt.setString(2, ruta.getDescripcion());
            stmt.setInt(3, ruta.getIdRuta());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar la ruta: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar una ruta por su ID
    public boolean eliminarRuta(int idRuta) {
        String sql = "DELETE FROM ruta WHERE id_ruta = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idRuta);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar la ruta: " + e.getMessage());
            return false;
        }
    }
    
    public static void main(String[] args) {
        RutaDAO r = new RutaDAO();
        r.obtenerTodasLasRutas();
    }
    
    
    public List<Ruta> buscarRutas(String texto) throws SQLException {
    List<Ruta> rutas = new ArrayList<>();
    String sql = "SELECT * FROM rutas WHERE nombreruta ILIKE ? OR descripcion ILIKE ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        String query = "%" + texto + "%";
        stmt.setString(1, query);
        stmt.setString(2, query);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            rutas.add(new Ruta(rs.getInt("idruta"), rs.getString("nombreruta"), rs.getString("descripcion")));
        }
    }
    return rutas;
}

}
