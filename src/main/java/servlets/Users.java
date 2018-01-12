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
import model.User;
import servicios.PermisosServicios;
import servicios.UserServicios;
import utils.Constantes;

/**
 *
 * @author Miguel Angel Diaz
 */
@WebServlet(name = "Users", urlPatterns = {"/users"})
public class Users extends HttpServlet {

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

        String accion = request.getParameter("accion");
        UserServicios us = new UserServicios();
HashMap root = new HashMap();
        if (accion != null) {

            switch (accion) {
                case "registro":
                    User u = new User();
                    u.setUsuario(request.getParameter("nombreRegistro"));
                    u.setPass(request.getParameter("passRegistro"));
                    u.setEmail(request.getParameter("emailRegistro"));
                    
                    int alta = us.registrar(u);
                    
                    switch (alta) {
                        case 1:
                             root.put("mensaje",Constantes.REGISTRO_CORRECTO);
                              root.put("mensaje2",Constantes.REGISTRO_CORRECTO_2);
                         //   request.setAttribute("mensaje", Constantes.REGISTRO_CORRECTO);
                         //   request.setAttribute("mensaje2", Constantes.REGISTRO_CORRECTO_2);
                            break;
                        case 2:
                             root.put("errorNombre",Constantes.ERROR_NOMBRE);
                           // request.setAttribute("errorNombre", Constantes.ERROR_NOMBRE);
                            break;
                        case -1:
                               root.put("mensaje",Constantes.ERROR_REGISTRO);
                        //    request.setAttribute("mensaje", Constantes.ERROR_REGISTRO);
                            break;
                    }
                    
                    break;
                    
                case "activarUsuario":
                    String codigo = request.getParameter("codigo");
                    int valido = us.activar(codigo);
                    switch (valido) {
                        case 0:
                               root.put("mensaje",Constantes.ERROR_TIEMPO);
                                  root.put("mensaje2",Constantes.ERROR_TIEMPO_2);
                           // request.setAttribute("mensaje", Constantes.ERROR_TIEMPO);
                           // request.setAttribute("mensaje2", Constantes.ERROR_TIEMPO_2);
                            break;
                        case 1:
                               root.put("mensaje",Constantes.CUENTA_ACTIVADA);
                                  root.put("mensaje2",Constantes.CUENTA_ACTIVADA_2);
                          //  request.setAttribute("mensaje", Constantes.CUENTA_ACTIVADA);
                          //  request.setAttribute("mensaje2", Constantes.CUENTA_ACTIVADA_2);
                            break;
                        case 2:
                               root.put("mensaje",Constantes.YA_ACTIVADA);
                                  root.put("mensaje2",Constantes.CUENTA_ACTIVADA_2);
                           // request.setAttribute("mensaje", Constantes.YA_ACTIVADA);
                           // request.setAttribute("mensaje2", Constantes.CUENTA_ACTIVADA_2);
                            break;
                        case -1:
                               root.put("mensaje",Constantes.ERROR_ACTIVAR);
                                  root.put("mensaje2",Constantes.ERROR_ACTIVAR_2);
                       //     request.setAttribute("mensaje", Constantes.ERROR_ACTIVAR);
                        //    request.setAttribute("mensaje2", Constantes.ERROR_ACTIVAR_2);
                            break;
                    }
                    break;

                case "login":
                    String nombreLogin = request.getParameter("nombreLogin");
                    
                    u = new User();
                    u.setUsuario(nombreLogin);
                    u.setPass(request.getParameter("passLogin"));
                    int login = us.login(u);
                    
                    switch (login) {
                        case 1:
                               root.put("nombreUsuario", nombreLogin);
                            
                                PermisosServicios ps = new PermisosServicios();
                                  root.put("permisos",  ps.getAllPermisosbyID(nombreLogin));
                            request.getSession().setAttribute("nombreUsuario", nombreLogin);
                            request.getSession().setAttribute("permisos",  ps.getAllPermisosbyID(nombreLogin));

                            
                            break;
                        case 2:
                               root.put("mensaje",Constantes.ERROR_LOGIN);
                                  root.put("mensaje2",Constantes.ERROR_LOGIN_2);
                            //request.setAttribute("mensaje", Constantes.ERROR_LOGIN);
                            //request.setAttribute("mensaje2", Constantes.ERROR_LOGIN_2);
                            break;
                        default:
                               root.put("errorLogin",Constantes.ERROR_LOGIN_3);
                         //   request.setAttribute("errorLogin", Constantes.ERROR_LOGIN_3);
                            break;
                    }
                    
                    break;

                case "logout": {
                    request.getSession().invalidate();
                   
                } break;
                case "recuperarPass":
                    String nombre = request.getParameter("nombreLogin");
                     String email =request.getParameter("emailRegistro");
                     
                boolean exito;
               exito = us.recuperarPass(nombre,email);
                if(exito==true)
                {
                 request.setAttribute("mensaje", "Se ha enviado un correo para recuperar tu contraseña");
                }else
                {
                    request.setAttribute("mensaje", "El usuario no existe!");
                }
                break;
            case"updatePass":
                 nombre = request.getParameter("nombreLogin");
                String password = request.getParameter("passLogin");
                String newPassword = request.getParameter("passNueva");
                
                boolean updated;
                updated = us.cambiarPass(nombre, password, newPassword);
                if(updated==true)
                {
                 request.setAttribute("mensaje", "Se ha cambiado tu contraseña");
                }else
                {
                    request.setAttribute("mensaje", "La contraseña introducida no es correcta");
                }
                break;
            default:
                break;
        }
            }
        
        
        
        //request.getRequestDispatcher(Constantes.PINTAR_LOGIN).forward(request, response);
         
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        try {
      
            
            // List<Permisos> permisos = new ArrayList();
            // permisos.add(ps.getAlumnoById(1));
           //  root.put("permisos",ps.getAllPermisos());
            //  root.put("usuarios",ps.getAllUsuarios());
            //  root.put("usuariosalt",ps.getAllUsuariosSinAlta());
             Template temp = Configuration.getInstance().getFreeMarker().getTemplate("login.ftl");
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