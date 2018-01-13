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
import model.Asignatura_curso;
import model.Asignatura_profesor;
import model.Curso;
import servicios.AsignaturasServicios;

/**
 *
 * @author Miguel Angel Diaz
 */
@WebServlet(name = "Asignaturas", urlPatterns = {"/asignaturas"})
public class Asignaturas extends HttpServlet {

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
HashMap root = new HashMap();
response.setContentType("text/html;charset=UTF-8");
        AsignaturasServicios as = new AsignaturasServicios();
        String op = request.getParameter("accion");
        Asignatura a = new Asignatura();
        Curso c = new Curso();
            a.setNombre(request.getParameter("nombre"));
            c.setNombre(request.getParameter("nombre1"));
        int filas = 0;
        
        if (op == null) 
        {
            op = "inicio";
        }
            switch (op) {
                case "inicio":
                       root.put("asignaturas", as.getAllAsignaturas());
                          root.put("cursos", as.getAllcursos());
                             root.put("profesores", as.getAllprofesores());
                             
                                         
       
        try {
      
             Template temp = Configuration.getInstance().getFreeMarker().getTemplate("asignaturas.ftl");
            temp.process(root, response.getWriter());
        } catch (TemplateException ex) {
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                    break;
                case "insertar":
                    a = as.addAsignatura(a);
                    if (a != null) {
                        filas = 1;
                    }
                      root.put("asignaturas", as.getAllAsignaturas());
                          root.put("cursos", as.getAllcursos());
                             root.put("profesores", as.getAllprofesores());
                      try {
      
             Template temp = Configuration.getInstance().getFreeMarker().getTemplate("asignaturas.ftl");
            temp.process(root, response.getWriter());
        } catch (TemplateException ex) {
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                    break;
                case "insertar1":
                    c = as.addCurso(c);
                    if (c != null) {
                        filas = 1;
                    }
                      root.put("asignaturas", as.getAllAsignaturas());
                          root.put("cursos", as.getAllcursos());
                             root.put("profesores", as.getAllprofesores());
                             
                     try {
      
             Template temp = Configuration.getInstance().getFreeMarker().getTemplate("asignaturas.ftl");
            temp.process(root, response.getWriter());
        } catch (TemplateException ex) {
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                    break;
                case "comprobar_union":
                    Asignatura_curso r = new Asignatura_curso();
                    r.setAsignaturas_idAsignaturas(Integer.parseInt(request.getParameter("asignatura")));
                    r.setCursos_idCursos(Integer.parseInt(request.getParameter("curso")));
                    
                    response.getWriter().print(as.comprobar_union(r));
                    break;
                    
                case "comprobar_union2":
                    Asignatura_profesor m = new Asignatura_profesor();
                    m.setAsignaturas_idAsignaturas(Integer.parseInt(request.getParameter("asignatura2")));
                    m.setProfesores_idProfesores(Integer.parseInt(request.getParameter("profesor")));
                    
                    response.getWriter().print(as.comprobar_union2(m));
                    break;
                    
                    
                case "relacionar":
                    Asignatura_curso s = new Asignatura_curso();
                    s.setAsignaturas_idAsignaturas(Integer.parseInt(request.getParameter("asignatura")));
                    s.setCursos_idCursos(Integer.parseInt(request.getParameter("curso")));
                    
                    response.getWriter().print(as.relacionar(s));
                    break;
                    
                case "quitar_relacion":
                    Asignatura_curso y = new Asignatura_curso();
                    y.setAsignaturas_idAsignaturas(Integer.parseInt(request.getParameter("asignatura")));
                    y.setCursos_idCursos(Integer.parseInt(request.getParameter("curso")));
                    
                    response.getWriter().print(as.quitar_relacion(y));
                    break;
                    
                case "relacionar2":
                    Asignatura_profesor w = new Asignatura_profesor();
                    w.setAsignaturas_idAsignaturas(Integer.parseInt(request.getParameter("asignatura")));
                    w.setProfesores_idProfesores(Integer.parseInt(request.getParameter("profesor")));
                    
                    response.getWriter().print(as.relacionar2(w));
                    break;
                    
                case "quitar_relacion2":
                    Asignatura_profesor t = new Asignatura_profesor();
                    t.setAsignaturas_idAsignaturas(Integer.parseInt(request.getParameter("asignatura")));
                    t.setProfesores_idProfesores(Integer.parseInt(request.getParameter("profesor")));
                    
                    response.getWriter().print(as.quitar_relacion2(t));
                    break;
                    
                case "ver_asignaturas":
                    int curso = Integer.parseInt(request.getParameter("id"));
                    response.getWriter().print(as.ver_asignaturas(curso));
                    break;
                case "ver_cursos":
                    int asignatura = Integer.parseInt(request.getParameter("id"));
                    response.getWriter().print(as.ver_cursos(asignatura));
                    break;
                case "ver_profesores":
                    int asignatura1 = Integer.parseInt(request.getParameter("id"));
                    response.getWriter().print(as.ver_profesores(asignatura1));
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
