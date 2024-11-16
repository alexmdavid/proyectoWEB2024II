/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclovia.bicicaribe_v2.modelos;

/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */
public class Ruta {
    private int idRuta;
    private String nombreRuta;
    private String descripcion;

    public Ruta() {}

    public Ruta(int idRuta, String nombreRuta, String descripcion) {
        this.idRuta = idRuta;
        this.nombreRuta = nombreRuta;
        this.descripcion = descripcion;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
