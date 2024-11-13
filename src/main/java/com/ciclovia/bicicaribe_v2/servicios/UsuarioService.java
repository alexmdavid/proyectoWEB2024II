/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclovia.bicicaribe_v2.servicios;

import com.ciclovia.bicicaribe_v2.DAOs.UsuarioDAO;
import com.ciclovia.bicicaribe_v2.modelos.Usuario;
import java.util.List;

/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */
public class UsuarioService {
    private UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioDAO.obtenerTodosLosUsuarios();
    }

    public Usuario obtenerUsuarioPorId(int id) {
        return usuarioDAO.obtenerUsuarioPorId(id);
    }

    // Otros métodos CRUD...
}
