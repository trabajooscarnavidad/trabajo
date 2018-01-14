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
import java.text.ParseException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tarea;
import servicios.AsignarTareasServicios;
import servicios.AsignaturasServicios;

/**
 *
 * @author Samu
 */
@WebServlet(name = "AsignarTareas", urlPatterns =
{
    "/asignarTareas"
})
public class AsignarTareas extends HttpServlet
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
        AsignaturasServicios as = new AsignaturasServicios();
        AsignarTareasServicios ats = new AsignarTareasServicios();
        String idAsignatura = request.getParameter("idAsignatura");
        String idTarea = request.getParameter("idTarea");
        String fecha = request.getParameter("fecha");
        String nombre = request.getParameter("nombre");
        String op = request.getParameter("accion");
        String realizada = request.getParameter("realizada");
        HashMap root = new HashMap();
        boolean exito;
        int filas;
        switch (op)
        {
            case "asignar":
                exito = ats.asignarTarea(Integer.parseInt(idAsignatura), nombre, fecha);
                if (exito == true)
                {
                    root.put("mensaje", "La tarea ha sido añadida");

                } else
                {
                    root.put("mensaje", "Hubo un fallo al añadir la tarea");
                }
                break;
            case "modificar":
                filas = ats.modificarTarea(idTarea,idAsignatura,nombre,fecha);
                if (filas>0)
                {
                    root.put("mensaje", "La tarea ha sido modificada");

                } else
                {
                    root.put("mensaje", "Hubo un fallo al modificar la tarea");
                }
                break;
            case "borrar":
                filas = ats.borrarTarea(idTarea, idAsignatura, nombre, fecha);
                if (filas>0)
                {
                    root.put("mensaje", "La tarea ha sido modificada");

                } else
                {
                    root.put("mensaje", "Hubo un fallo al modificar la tarea");
                }
                break;
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            try
            {
                root.put("asignaturas", as.getAllAsignaturas());
                root.put("tareas", ats.getAllTareas());
                //  root.put("usuariosalt",ps.getAllUsuariosSinAlta());
                Template temp = Configuration.getInstance().getFreeMarker().getTemplate("asignarTareas.ftl");
                temp.process(root, response.getWriter());
            } catch (TemplateException ex)
            {
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
