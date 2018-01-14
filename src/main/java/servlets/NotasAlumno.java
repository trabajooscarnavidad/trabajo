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
import model.Asignatura;
import servicios.Alumnos_profesoresServicios;
import servicios.AsignaturasServicios;
import servicios.NotasServicios;
import utils.Constantes;

@WebServlet(name = "NotasAlumno", urlPatterns = {"/notasalumno"})
public class NotasAlumno extends HttpServlet {

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
        NotasServicios ns = new NotasServicios();
        Alumnos_profesoresServicios alums = new Alumnos_profesoresServicios();
        AsignaturasServicios asigs = new AsignaturasServicios();
        String op = request.getParameter("accion");
        String idAlu = request.getParameter("idAlumno");
        String idAsig = request.getParameter("idAsignatura");
        String nomAlu = request.getParameter("nombreAlumno");
        String nomAsig = request.getParameter("nombreAsignatura");
        String nota = request.getParameter("nota");

        HashMap root = new HashMap();
        Asignatura obj_temporal = new Asignatura();

        Long id = (Long) request.getSession().getAttribute("id");

        root.put("notas", ns.getNotas(id));

        // getAll siempre se hace
        root.put("asignaturas", asigs.getAllAsignaturas());
        root.put("alumnos", alums.listarAlumnos());
        root.put("cursos", asigs.getAllcursos());
        root.put("nomAlu", nomAlu);
        root.put("idAlu", idAlu);
        root.put("nomAsig", nomAsig);
        root.put("idAsig", idAsig);

        response.setContentType("text/html;charset=UTF-8");
        try {
            Template temp = Configuration.getInstance().getFreeMarker().getTemplate("notasalumno.ftl");
            temp.process(root, response.getWriter());
        } catch (TemplateException ex) {
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
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
