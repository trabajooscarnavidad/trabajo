/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import config.Configuration;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.UsuariosServicios;
import utils.Constantes;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Usuarios extends HttpServlet {

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
        String nombre = request.getParameter(Constantes.NOMBRE_LOGIN);
        String password = request.getParameter(Constantes.PASSWORD_LOGIN);
        String email = request.getParameter(Constantes.EMAIL_LOGIN);
        String op = request.getParameter(Constantes.OPCION_SWITCH);
/*
                try {
            HashMap root = new HashMap();
              root.put("title","login");
            root.put("content","hola");
           
             Template temp = Configuration.getInstance().getFreeMarker().getTemplate("login.ftl");
            temp.process(root, response.getWriter());
        } catch (TemplateException ex) {
            Logger.getLogger(TemplateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
  */      
        
        if (op == null) {
            op = "salir";
        }

        UsuariosServicios ls = new UsuariosServicios();
        switch (op) {
            case "login":
                if (ls.loginUsuario(nombre, password)) {
                    request.getSession().setAttribute("LOGIN", "SI");
                    msg = "Login correcto";
                } else {
                    msg = "Login incorrecto";
                }

                break;
            case "registro":
                msg = ls.crearUsuario(nombre, password, email) ? "Usuario registrado" : "No se pudo registrar";

                break;
            case "activar":
                String codigo = request.getParameter(Constantes.CODIGO_LOGIN);
                msg = ls.activarUsuario(nombre, codigo) ? "usuario activado correctamente" : "no se pudo activar el usuario";
                break;
            case "desloguear":
                request.getSession().setAttribute("LOGIN", null);
                break;
            default:
                break;
        }
        if (msg != null) {
            request.setAttribute("mensaje", msg);

        }
        request.getRequestDispatcher(Constantes.VISTA_LOGIN).forward(request, response);

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
