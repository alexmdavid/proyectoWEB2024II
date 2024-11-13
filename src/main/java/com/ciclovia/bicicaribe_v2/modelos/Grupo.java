/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclovia.bicicaribe_v2.modelos;

/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */
public class Grupo {
    private int idGrupo;
    private String nombre;
    private String descripcion;
    private String modalidad;

    public Grupo() {}

    public Grupo( String nombre, String descripcion, String modalidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modalidad = modalidad;
    }

    public Grupo(int idGrupo, String nombre, String descripcion, String modalidad) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modalidad = modalidad;
    }

   

   

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
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

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }
}
