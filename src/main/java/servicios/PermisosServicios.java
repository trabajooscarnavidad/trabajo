/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.PermisosDAO;
import dao.UsersDAO;
import dao.UsuariosDAO;
import java.util.ArrayList;
import java.util.List;
import model.Permiso;
import model.User;


/**
 *
 * @author ivan
 */
public class PermisosServicios {
        public List<Permiso> getAllPermisos()
    {
        PermisosDAO dao = new PermisosDAO();
        
        return dao.getAllPermisosJDBCTemplate();
    }
        
    
                

      public void asociarPermisos(String usuarios[], String permisos[])
    {
        PermisosDAO dao = new PermisosDAO();
        List listA = new ArrayList();


        Permiso obj_permiso = new Permiso(); 
        for (int i = 0; i < usuarios.length; i++) {
             obj_permiso.setIdPermisos(Long.parseLong(usuarios[i]));
            for (int j = 0; j < permisos.length; j++) {
                 obj_permiso.setValor(permisos[j]);
                 listA.add(obj_permiso);
            }
        }
dao.asociarPermisosJDBCTemplate(listA);
       // return dao.asociarPermisosJDBCTemplate(listA);
    }
      
                      
      public void quitarPermisos(String usuarios[], String permisos[])
    {
        PermisosDAO dao = new PermisosDAO();
        List listA = new ArrayList();


        Permiso obj_permiso = new Permiso(); 
        for (int i = 0; i < usuarios.length; i++) {
             obj_permiso.setIdPermisos(Long.parseLong(usuarios[i]));
            for (int j = 0; j < permisos.length; j++) {
                 obj_permiso.setValor(permisos[j]);
                 listA.add(obj_permiso);
            }
        }
dao.quitarPermisosJDBCTemplate(listA);
       // return dao.asociarPermisosJDBCTemplate(listA);
    }
      
         public void darDeAlta(String usuarios[], String permisos[])
    {
        PermisosDAO dao = new PermisosDAO();
        List listA = new ArrayList();
        List listB = new ArrayList();

        Permiso obj_permiso = new Permiso(); 
          User obj_user = new User();
        for (int i = 0; i < usuarios.length; i++) {
             obj_permiso.setIdPermisos(Long.parseLong(usuarios[i]));
             obj_user.setIdUsuarios(Long.parseLong(usuarios[i]));
             UsersDAO dao2 = new UsersDAO();
              User obj_user_db = dao2.comprobarDatosUsuarioDB(obj_user);
             listB.add(obj_user_db);
            for (int j = 0; j < permisos.length; j++) {
                 obj_permiso.setValor(permisos[j]);
                 listA.add(obj_permiso);
            }
        }
dao.asociarPermisosJDBCTemplate(listA);
 MandarMail mail = new MandarMail();
for (int i = 0; i < listB.size(); i++) {
      
obj_user = (User) listB.get(i);
String pass = null; //generar contraseña aleatoria
//funcion para asignar nueva contraseña en la db
mail.mandarMail(obj_user.getEmail(), "tu contraseña es " + pass + " codigo activacion "+ obj_user.getCodigo()+ " activalo en  http://127.0.0.1:8080/login?op=activar&usuario=" + obj_user.getUsuario() + "&codigo=" + obj_user.getCodigo(), "Codigo de activacion");

}
 
          
       // mail.mandarMail(registro.getEmail(), "tu contraseña es "+ registro.getCodigo()+ " activalo en  http://127.0.0.1:8080/login?op=activar&usuario=" + registro.getUsuario() + "&codigo=" + registro.getCodigo(), "Codigo de activacion");

       // return dao.asociarPermisosJDBCTemplate(listA);
    }
                
                
}

