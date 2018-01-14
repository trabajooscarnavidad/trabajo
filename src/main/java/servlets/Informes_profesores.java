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
import servicios.AsignaturasServicios;
import servicios.InformesServicios;

/**
 *
 * @author Juan
 */
@WebServlet(name = "Informes_profesores", urlPatterns = {"/informes_profesores"})
public class Informes_profesores extends HttpServlet {

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
        String profesor = request.getParameter("profesor");
        String curso = request.getParameter("curso");
        String op = request.getParameter("op");
        AsignaturasServicios as = new AsignaturasServicios();
        InformesServicios b = new InformesServicios();
        HashMap root = new HashMap();
        if (request.getParameter("profesor") == null)
        {
            profesor = "Marta";
            
        }
        
        if (request.getParameter("curso") == null)
        {
            curso = "Primero";
        }
        
        if (request.getParameter("op") == null)
        {
            op = "inicio";
        }
        
        switch (op)
        {
            case "inicio":
                  root.put("profesores", as.getAllprofesores());
                   root.put("informe1", b.informe1(profesor));
                    root.put("cursos", as.getAllcursos());
                     root.put("informe2", b.informe2(curso));
                      root.put("profesor_seleccionado", profesor);
                       root.put("curso_seleccionado", curso);
                try {
              response.setContentType("text/html;charset=UTF-8");
             Template temp = Configuration.getInstance().getFreeMarker().getTemplate("informes_profesores.ftl");
            temp.process(root, response.getWriter());
        } catch (TemplateException ex) {
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                break;
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
