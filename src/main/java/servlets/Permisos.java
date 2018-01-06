/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import config.Configuration;
import java.util.logging.Level;
import java.util.logging.Logger;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.PermisosServicios;
import utils.Constantes;

/**
 *
 * @author ivan
 */
@WebServlet(name = "Permisos", urlPatterns = {"/permisos"})
public class Permisos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg="";
                String[] usuarios = request.getParameterValues("tablausuarios");
        String[] permisos = request.getParameterValues("tablapermisos");
       String op = request.getParameter(Constantes.OPCION_SWITCH);
        PermisosServicios ps = new PermisosServicios();
                if (op == null) {
            op = "salir";
        }
        switch (op) {
            case "asociarpermisos":
                
                //ArrayList<String> aList = new ArrayList<String>(Arrays.asList(usuarios));
//aList.addAll(Arrays.asList(permisos));
                ps.asociarPermisos(usuarios,permisos);
             //   if (ls.loginUsuario(nombre, password)) {
             //       request.getSession().setAttribute("LOGIN", "SI");
             //       msg = "Login correcto";
             //   } else {
             //       msg = "Login incorrecto";
             //   }

                break;
            case "quitarpermisos":
               // msg = ls.crearUsuario(nombre, password, email) ? "Usuario registrado" : "No se pudo registrar";

                break;
            case "addpermiso":
                //String codigo = request.getParameter(Constantes.CODIGO_LOGIN);
               // msg = ls.activarUsuario(nombre, codigo) ? "usuario activado correctamente" : "no se pudo activar el usuario";
                break;
            case "eliminarpermiso":
                //request.getSession().setAttribute("LOGIN", null);
                break;
            default:
                break;
        }
        if (msg != null) {
            request.setAttribute("mensaje", msg);

        }
     
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        try {
            HashMap root = new HashMap();
            
            root.put("content","hola");
            
            // List<Permisos> permisos = new ArrayList();
            // permisos.add(ps.getAlumnoById(1));
             root.put("permisos",ps.getAllPermisos());
              root.put("usuarios",ps.getAllUsuarios());
             Template temp = Configuration.getInstance().getFreeMarker().getTemplate("permisos.ftl");
            temp.process(root, response.getWriter());
        } catch (TemplateException ex) {
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        
        


        
    }
        
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
