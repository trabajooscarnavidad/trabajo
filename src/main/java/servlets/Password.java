/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import config.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import servicios.PermisosServicios;
import servicios.UserServicios;
import utils.Constantes;

/**
 *
 * @author Miguel Angel Diaz
 */
@WebServlet(name = "Password", urlPatterns = {"/password"})
public class Password extends HttpServlet {

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

        String accion = request.getParameter("accion");
        UserServicios us = new UserServicios();
HashMap root = new HashMap();
        if (accion != null) {

            switch (accion) {

                case "logout": {
                    request.getSession().invalidate();
                   
                } break;

            case"updatePass":
                String nombre = (String) request.getSession().getAttribute("LOGIN");
                String password = request.getParameter("passLogin");
                String newPassword = request.getParameter("passNueva");
                
                boolean updated;
                updated = us.cambiarPass(nombre, password, newPassword);
                if(updated==true)
                { root.put("mensaje","Se ha cambiado tu contraseña");

                }else
                {root.put("mensaje","La contraseña introducida no es correcta");
                }
                break;
            default:
                break;
        }
            }
        
        
        
        //request.getRequestDispatcher(Constantes.PINTAR_LOGIN).forward(request, response);
         
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        try {
      
            
            // List<Permisos> permisos = new ArrayList();
            // permisos.add(ps.getAlumnoById(1));
           //  root.put("permisos",ps.getAllPermisos());
            //  root.put("usuarios",ps.getAllUsuarios());
            //  root.put("usuariosalt",ps.getAllUsuariosSinAlta());
             Template temp = Configuration.getInstance().getFreeMarker().getTemplate("password.ftl");
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