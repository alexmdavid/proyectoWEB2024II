/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclovia.bicicaribe.entities;

/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */
import java.util.Date;

public class InscripcionGrupo {
    private int idUsuario;
    private int idInscripcion;
    private int idGrupo;
    private Date fechaInscripcion;

    public InscripcionGrupo() {}

    public InscripcionGrupo(int idUsuario, int idInscripcion, int idGrupo, Date fechaInscripcion) {
        this.idUsuario = idUsuario;
        this.idInscripcion = idInscripcion;
        this.idGrupo = idGrupo;
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
