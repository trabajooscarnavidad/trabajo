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
import servicios.AsignarTareasServicios;

/**
 *
 * @author Samu
 */
@WebServlet(name = "Tareas", urlPatterns =
{
    "/tareas"
})
public class Tareas extends HttpServlet
{

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
            throws ServletException, IOException
    {
        
        AsignarTareasServicios ats = new AsignarTareasServicios();;
        String op = request.getParameter("op");
//        String alumno = (String) request.getSession().getAttribute("nombreLogin");
        String alumno = "Juan";
        
        if (op == null)
        {
            op = "inicio";
        }
        
        switch(op)
        {
            case "inicio":
                request.setAttribute("tareas", ats.getAllTareas(alumno));
                request.setAttribute("alumno", alumno);
                request.getRequestDispatcher("/ver_tareas.jsp").forward(request, response);
                break;
                
            case "actualizar":
                int id_tarea = Integer.parseInt(request.getParameter("id_tarea"));
                int id_alumno = Integer.parseInt(request.getParameter("id_alumno"));
                int realizada = Integer.parseInt(request.getParameter("realizada"));
                
                response.getWriter().print(ats.marcarHecha(id_tarea, id_alumno, realizada));
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
