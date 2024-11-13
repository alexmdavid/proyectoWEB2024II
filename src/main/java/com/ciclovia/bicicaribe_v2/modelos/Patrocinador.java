/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclovia.bicicaribe_v2.modelos;

/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */
public class Patrocinador {
    private int idPatrocinador;
    private String nombre;
    private String descripcion;

    public Patrocinador() {}

    public Patrocinador(int idPatrocinador, String nombre, String descripcion) {
        this.idPatrocinador = idPatrocinador;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
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
}
