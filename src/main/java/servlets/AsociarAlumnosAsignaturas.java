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
import servicios.AsociacionServicios;

/**
 *
 * @author Samu
 */
@WebServlet(name = "AsociarAlumnosAsignaturas", urlPatterns =
{
    "/asociarAA"
})
public class AsociarAlumnosAsignaturas extends HttpServlet
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
        String msg = "";
        String[] alu = request.getParameterValues("selectedAlu");
        String[] asig = request.getParameterValues("selectedAsig");
        String op = request.getParameter("op");
        AsociacionServicios as = new AsociacionServicios();
        switch (op)
        {

            case "asociar":
                as.asociarAluAsig(alu, asig);
                request.setAttribute("alumno y asignatura asociados", msg);
                break;
            case "desAsociar":
                as.desAsociarAluAsig(alu, asig);
                request.setAttribute("alumno y asignatura desasociados", msg);
                break;
        }
        if (msg != null)
        {
            request.setAttribute("mensaje", msg);

        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            try
            {
                HashMap root = new HashMap();

                root.put("alumnos", as.getAllAlumnos());
                root.put("asignaturas", as.getAllAsignaturas());

                Template temp = Configuration.getInstance().getFreeMarker().getTemplate("asociacion.ftl");
                temp.process(root, response.getWriter());
            } catch (TemplateException ex)
            {
                Logger.getLogger(AsociarAlumnosAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
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
