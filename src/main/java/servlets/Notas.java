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
import model.Nota;
import servicios.AlumnosServicios;
import servicios.AsignaturasServicios;
import servicios.NotasServicios;
import utils.Constantes;

/**
 *
 * @author Miguel Angel Diaz
 */
@WebServlet(name = "Notas", urlPatterns = {"/notas"})
public class Notas extends HttpServlet {

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
        AlumnosServicios alums = new AlumnosServicios();
        AsignaturasServicios asigs = new AsignaturasServicios();
        String op = request.getParameter("accion");
        String idAlu = request.getParameter("idAlumno");
        String idAsig = request.getParameter("idAsignatura");
        String nomAlu = request.getParameter("nombreAlumno");
        String nomAsig = request.getParameter("nombreAsignatura");
        String nota = request.getParameter("nota");
        boolean cargar = false;
        HashMap root = new HashMap();

        if (op != null) {
            Nota n = new Nota();
            n.setAlumnos_idAlumnos(Long.parseLong(idAlu));
            n.setAsignaturas_idAsignaturas(Long.parseLong(idAsig));
            int filas = 0;

            switch (op) {
                case "guardar":
                    n.setNota(Integer.parseInt(nota));
                    n = ns.guardarNota(n);
                    if (n != null) {
                        filas = 1;
                    }
                      root.put("nota",n);
                    //request.setAttribute("nota", n);
                    break;
                case "borrar":
                    filas = ns.delNota(n);
                    break;
                case "cargar":
                    n = ns.getNota(n.getAlumnos_idAlumnos(), n.getAsignaturas_idAsignaturas());
                    cargar = true;
                    if (n == null) {
                         root.put("mensaje","No hay notas");
                       // request.setAttribute("mensaje", "No hay notas");
                    }else{
                         root.put("nota",n);
                        //request.setAttribute("nota", n);
                    }
                    break;
            }
            if (filas != 0 && cargar == false) {
                 root.put("mensaje",filas + " filas modificadas correctamente");
              //  request.setAttribute("mensaje", filas + " filas modificadas correctamente");
            } else if (filas == 0 && cargar == false) {
                root.put("mensaje",filas + "No se han hecho modificaciones");
                //request.setAttribute("mensaje", "No se han hecho modificaciones");
            }
        }
        // getAll siempre se hace
         root.put("asignaturas", asigs.getAllAsignaturas());
          root.put("alumnos",alums.getAllAlumnos());
          root.put("cursos",asigs.getAllcursos());
           root.put("nomAlu",nomAlu);
            root.put("idAlu",idAlu);
             root.put("nomAsig",nomAsig);
              root.put("idAsig",idAsig);
  
                 response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        try {
      
             Template temp = Configuration.getInstance().getFreeMarker().getTemplate("notas.ftl");
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
