package com.ciclovia.bicicaribe_v2.controladores;

import com.ciclovia.bicicaribe_v2.DAOs.GrupoDAO;
import com.ciclovia.bicicaribe_v2.modelos.Grupo;
import com.ciclovia.bicicaribe_v2.modelos.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrupoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("list".equals(action)) {
            try {
                listarGrupos(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(GrupoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getParameter("action");

    if ("unirse".equals(action)) {
        try {
            unirseAGrupo(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(GrupoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    else if("create".equals(action)){
        try {
            crearGrupo(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(GrupoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

private void unirseAGrupo(HttpServletRequest request, HttpServletResponse response)
        throws IOException, SQLException {
    try {
        int idGrupo = Integer.parseInt(request.getParameter("idGrupo"));
        
        int idUsuario = obtenerIdUsuarioDeSesion(request);  
        System.out.println(""+idUsuario);
       
        GrupoDAO grupoDAO = new GrupoDAO();
        boolean exito = grupoDAO.unirseAGrupo(idUsuario, idGrupo);

        if (exito) {
            response.sendRedirect("listarGrupos.jsp");  
        } else {
            response.sendRedirect("error.jsp");  
        }
    } catch (NumberFormatException e) {
        response.sendRedirect("error.jsp");  
    }
}


    private void listarGrupos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        GrupoDAO gDAO = new GrupoDAO();
        List<Grupo> listarGrupos = gDAO.obtenerTodosLosGrupos();
        
      
        System.out.println("Grupos recuperados: " + listarGrupos.size());

       
        if (listarGrupos != null && !listarGrupos.isEmpty()) {
            request.setAttribute("listargrupos", listarGrupos);
        } else {
            System.out.println("No se encontraron grupos.");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("listarGrupos.jsp");
        dispatcher.forward(request, response);
    }

    private int obtenerIdUsuarioDeSesion(HttpServletRequest request) {
    Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
    
    if (usuario != null) {
        return usuario.getIdUsuario();  
    } else {
        throw new IllegalStateException("No hay usuario en sesión");
    }
}
    private void crearGrupo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        String nombre = request.getParameter("nombreGrupo");
        String modalidad = request.getParameter("modalidad");
        String descripcion = request.getParameter("descripcion");
        Grupo grupo = new Grupo(nombre, descripcion, modalidad);
        GrupoDAO gruDao = new GrupoDAO();
        if(gruDao.insertarGrupo(grupo)){
            response.sendRedirect("home.jsp"); 
        }else{
            response.sendRedirect("error.jsp");
        }
        
    }


}
