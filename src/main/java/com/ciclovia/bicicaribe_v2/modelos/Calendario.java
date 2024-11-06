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

public class Calendario {
    private int idCalendario;
    private int idGrupo;
    private int idRuta;
    private Date fecha;
    private String hora;

    public Calendario() {}

    public Calendario(int idCalendario, int idGrupo, int idRuta, Date fecha, String hora) {
        this.idCalendario = idCalendario;
        this.idGrupo = idGrupo;
        this.idRuta = idRuta;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(int idCalendario) {
        this.idCalendario = idCalendario;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
