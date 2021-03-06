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
import model.Alumno;
import model.Profesor;
import model.User;
import servicios.Alumnos_profesoresServicios;
import servicios.PermisosServicios;
import servicios.UserServicios;

/**
 *
 * @author DAW
 */
@WebServlet(name = "Alumnos_profesores", urlPatterns =
{
    "/alumnos_profesores"
})
public class Alumnos_profesores extends HttpServlet
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
        Alumnos_profesoresServicios s = new Alumnos_profesoresServicios();
        String op = request.getParameter("op");
        HashMap root = new HashMap();
        if (op == null)
        {
            op = "inicio";
        }
        
        
        switch (op)
        {
            case "inicio":
                 root.put("alumnos", s.listarAlumnos());
                 root.put("profesores", s.listarProfesores());
                         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        try {
             Template temp = Configuration.getInstance().getFreeMarker().getTemplate("alumnos_profesores.ftl");
            temp.process(root, response.getWriter());
        } catch (TemplateException ex) {
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }}
                //request.setAttribute("alumnos", s.listarAlumnos());
              //  request.setAttribute("profesores", s.listarProfesores());
               // request.getRequestDispatcher("/registrarAlumnos_profesores.jsp").forward(request, response);
                
                break;
                
            case "registrar_alumno":
                User u = new User();
                UserServicios us = new UserServicios();
                Alumnos_profesoresServicios a = new Alumnos_profesoresServicios();
                
                u.setUsuario(request.getParameter("alumno_nombre"));
                u.setPass(request.getParameter("alumno_pass"));
                u.setEmail(request.getParameter("alumno_email"));
                int mayor =  Integer.parseInt(request.getParameter("alumno_mayor"));
                us.registrar_alumno(u);
                
                //Una vez creado el Usuario, se obtiene el idUsuario geerado por el autoincremental para
                //Poder meterlo en la tabla 'Alumnos'.
                int idUsuario = (int) a.getIdUsuario(request.getParameter("alumno_nombre"));
                
                Alumno alumno = new Alumno();
                alumno.setUsuarios_idUsuarios(idUsuario);
                alumno.setNombre(request.getParameter("alumno_nombre"));
                alumno.setFecha_nac(request.getParameter("alumno_date"));
                alumno.setMayor(mayor);
                
                int introducir_alumno = a.introducir_alumno(alumno);
                //añadir permisos
                PermisosServicios ps = new PermisosServicios();
                ps.asociarPermisosSinInterfaz(idUsuario, 3); //3 = alumnos, 2 = profesores
                break;
                
            case "registrar_profesor":
                User u2 = new User();
                UserServicios us2 = new UserServicios();
                Alumnos_profesoresServicios a2 = new Alumnos_profesoresServicios();
                
                u2.setUsuario(request.getParameter("profesor_nombre"));
                u2.setPass(request.getParameter("profesor_pass"));
                u2.setEmail(request.getParameter("profesor_email"));
                us2.registrar_alumno(u2);
                
                //Una vez creado el Usuario, se obtiene el idUsuario geerado por el autoincremental para
                //Poder meterlo en la tabla 'Alumnos'.
                int idProfesor = (int) a2.getIdUsuario(request.getParameter("profesor_nombre"));
                
                Profesor profe = new Profesor();
                profe.setUsuarios_idUsuarios(idProfesor);
                profe.setNombre(request.getParameter("profesor_nombre"));
                
                int introducir_profesor = a2.introducir_profesor(profe);
                //añadir permisos
                PermisosServicios ps2 = new PermisosServicios();
                ps2.asociarPermisosSinInterfaz(idProfesor, 2); //3 = alumnos, 2 = profesores
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
