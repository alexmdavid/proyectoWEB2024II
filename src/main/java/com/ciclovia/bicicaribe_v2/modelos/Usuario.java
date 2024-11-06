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

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String sexo;
    private String tipoDeSangre;
    private String correo;
    private String contrasena;
    private int idRuta;
    private int idTorneo;
    private int idGrupo;
    private int idRol;

    public Usuario() {}

    public Usuario(int idUsuario, String nombre, String apellido, Date fechaNacimiento, String sexo, String tipoDeSangre, String correo, String contrasena, int idRuta, int idTorneo, int idGrupo, int idRol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.tipoDeSangre = tipoDeSangre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.idRuta = idRuta;
        this.idTorneo = idTorneo;
        this.idGrupo = idGrupo;
        this.idRol = idRol;
    }

    // Getters y Setters...
}
