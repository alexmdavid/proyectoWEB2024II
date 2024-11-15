/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclovia.bicicaribe_v2.DAOs;

import com.ciclovia.bicicaribe_v2.modelos.Grupo;
import com.ciclovia.bicicaribe_v2.repositorios.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */
public class GrupoDAO {



    

    public boolean insertarGrupo(Grupo grupo) throws SQLException {
        boolean res = false;
        String sql = "INSERT INTO grupos (nombre, descripcion, modalidad) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, grupo.getNombre());
            stmt.setString(2, grupo.getDescripcion());
            stmt.setString(3, grupo.getModalidad());
            res = stmt.executeUpdate() > 0;
        }
        return res;
    }

    public void actualizarGrupo(Grupo grupo) throws SQLException {
        String sql = "UPDATE grupos SET nombre = ?, descripcion = ?, modalidad = ? WHERE id_grupo = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, grupo.getNombre());
            stmt.setString(2, grupo.getDescripcion());
            stmt.setString(3, grupo.getModalidad());
            stmt.setInt(4, grupo.getIdGrupo());
            stmt.executeUpdate();
        }
    }

    public void eliminarGrupo(int idGrupo) throws SQLException {
        String sql = "DELETE FROM grupos WHERE id_grupo = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idGrupo);
            stmt.executeUpdate();
        }
    }

    public Grupo obtenerGrupoPorId(int idGrupo) throws SQLException {
        String sql = "SELECT * FROM grupos WHERE id_grupo = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idGrupo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Grupo(rs.getInt("id_grupo"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("modalidad"));
            }
        }
        return null;
    }

    public List<Grupo> obtenerTodosLosGrupos() throws SQLException {
        List<Grupo> grupos = new ArrayList<>();
        String sql = "SELECT * FROM grupos";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                grupos.add(new Grupo(rs.getInt("idgrupo"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("modalidad")));
            }
        }
        return grupos;
    }

    public List<Grupo> obtenerGruposPorUsuario(int idUsuario) throws SQLException {
        List<Grupo> grupos = new ArrayList<>();
        String sql = "SELECT g.* FROM grupos g INNER JOIN usuarios_grupos ug ON g.id_grupo = ug.id_grupo WHERE ug.id_usuario = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                grupos.add(new Grupo(rs.getInt("id_grupo"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("modalidad")));
            }
        }
        return grupos;
    }

 public boolean unirseAGrupo(int idUsuario, int idGrupo) throws SQLException {
    String sqlInsertRelacion = "INSERT INTO inscripciones_grupo (idusuario, idgrupo, fecha_inscripcion) VALUES (?, ?, ?)";
    String sqlActualizarUsuario = "UPDATE usuarios SET idGrupo = ? WHERE idusuario = ?";
    LocalDate currentDate = LocalDate.now(); // Fecha actual

    try (Connection conn = Conexion.getConnection()) {
        // Desactivar auto-commit para manejar la transacción manualmente
        conn.setAutoCommit(false);

        try (PreparedStatement stmtRelacion = conn.prepareStatement(sqlInsertRelacion);
             PreparedStatement stmtActualizar = conn.prepareStatement(sqlActualizarUsuario)) {

            // Configurar el statement para el INSERT
            stmtRelacion.setInt(1, idUsuario);
            stmtRelacion.setInt(2, idGrupo);
            stmtRelacion.setDate(3, java.sql.Date.valueOf(currentDate)); // Convertir LocalDate a java.sql.Date
            stmtRelacion.executeUpdate();

            // Configurar el statement para el UPDATE
            stmtActualizar.setInt(1, idGrupo);
            stmtActualizar.setInt(2, idUsuario);
            stmtActualizar.executeUpdate();

            // Confirma la transacción si ambas operaciones son exitosas
            conn.commit();
            return true;

        } catch (SQLException ex) {
            // En caso de error, deshace la transacción
            conn.rollback();
            throw ex;
        } finally {
            // Restaurar auto-commit
            conn.setAutoCommit(true);
        }
    }
}



}

    
