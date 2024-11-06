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

public class InscripcionTorneo {
    private int idInscripcion;
    private int idTorneo;
    private Date fechaInscripcion;
    private int idUsuario;

    public InscripcionTorneo() {}

    public InscripcionTorneo(int idInscripcion, int idTorneo, Date fechaInscripcion, int idUsuario) {
        this.idInscripcion = idInscripcion;
        this.idTorneo = idTorneo;
        this.fechaInscripcion = fechaInscripcion;
        this.idUsuario = idUsuario;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
