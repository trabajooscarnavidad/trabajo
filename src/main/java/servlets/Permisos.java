
package servlets;

import config.Configuration;
import java.util.logging.Logger;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.PermisosServicios;
import servicios.UserServicios;
import utils.Constantes;


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
        String msg = "";
        String[] usuarios = request.getParameterValues("tablausuarios");
        String[] permisos = request.getParameterValues("tablapermisos");
        String nuevopermiso = request.getParameter("nuevopermiso");
        String op = request.getParameter(Constantes.OPCION_SWITCH);
        HashMap root = new HashMap();
        PermisosServicios ps = new PermisosServicios();
        UserServicios us = new UserServicios();
        if (op == null) {
            op = "salir";
        }
        switch (op) {
            case "asociarpermisos":
                int[] result = ps.asociarPermisos(usuarios, permisos);
                if (result.length > 0) {
                    root.put("resultado", "asociado correctamente los permisos");
                } else {
                    root.put("resultado", "hubo un error");
                }

                break;
            case "quitarpermisos":
                result = ps.quitarPermisos(usuarios, permisos);
                if (result.length > 0) {
                    root.put("resultado", "quitado los permisos correctamente");
                } else {
                    root.put("resultado", "hubo un error");
                }

                break;
            case "addpermiso":
                if (!"".equals(nuevopermiso)){
               int exito = ps.addpermisos(nuevopermiso);
                if (exito > 0) {
                     root.put("resultado", "asociado correctamente los permisos");
                } else {
                    root.put("resultado", "hubo un error");
                }
                } else {
                     root.put("resultado", "el permiso esta vacio");
                }
               
                break;
            case "eliminarpermiso":
                //demasiadas dependencias se deja para el futuro
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

                root.put("content", "Pagina asignacion de Permisos");

                root.put("permisos", ps.getAllPermisos());
                root.put("usuarios", us.getAllUsuarios());
                root.put("usuariosalt", us.getAllUsuariosSinAlta());
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
