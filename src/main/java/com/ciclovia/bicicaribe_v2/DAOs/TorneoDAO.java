/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclovia.bicicaribe_v2.DAOs;



import com.ciclovia.bicicaribe_v2.modelos.Torneo;
import com.ciclovia.bicicaribe_v2.repositorios.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;

/**
 *
 * @author ALEX DAVID
 */
public class TorneoDAO {

    public void insertarTorneo(Torneo torneo) throws SQLException {
        String sql = "INSERT INTO torneos (nombre, descripcion, idpatrocinador) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, torneo.getNombre());
            stmt.setString(2, torneo.getDescripcion());
            stmt.setInt(3, torneo.getIdPatrocinador());
            stmt.executeUpdate();
        }
    }

    public void actualizarTorneo(Torneo torneo) throws SQLException {
        String sql = "UPDATE torneos SET nombre = ?, descripcion = ?, idpatrocinador = ? WHERE idtorneo = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, torneo.getNombre());
            stmt.setString(2, torneo.getDescripcion());
            stmt.setInt(3, torneo.getIdPatrocinador());
            stmt.setInt(4, torneo.getIdTorneo());
            stmt.executeUpdate();
        }
    }

    public void eliminarTorneo(int idTorneo) throws SQLException {
        String sql = "DELETE FROM torneos WHERE idtorneo = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTorneo);
            stmt.executeUpdate();
        }
    }

    public Torneo obtenerTorneoPorId(int idTorneo) throws SQLException {
        String sql = "SELECT * FROM torneos WHERE idtorneo = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTorneo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Torneo(rs.getInt("idtorneo"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("idpatrocinador"));
            }
        }
        return null;
    }

    public List<Torneo> obtenerTodosLosTorneos() throws SQLException {
        List<Torneo> torneos = new ArrayList<>();
        String sql = "SELECT * FROM torneos";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                torneos.add(new Torneo(rs.getInt("idtorneo"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("idpatrocinador")));
            }
        }
        return torneos;
    }

    public List<Torneo> obtenerTorneosPorPatrocinador(int idPatrocinador) throws SQLException {
        List<Torneo> torneos = new ArrayList<>();
        String sql = "SELECT * FROM torneos WHERE idpatrocinador = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPatrocinador);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                torneos.add(new Torneo(rs.getInt("idtorneo"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("idpatrocinador")));
            }
        }
        return torneos;
    }
}
