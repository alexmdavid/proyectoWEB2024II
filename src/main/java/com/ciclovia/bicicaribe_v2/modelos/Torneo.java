/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclovia.bicicaribe.entities;

/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */public class Torneo {
    private int idTorneo;
    private String nombre;
    private String descripcion;
    private int idPatrocinador;

    public Torneo() {}

    public Torneo(int idTorneo, String nombre, String descripcion, int idPatrocinador) {
        this.idTorneo = idTorneo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idPatrocinador = idPatrocinador;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }
}
