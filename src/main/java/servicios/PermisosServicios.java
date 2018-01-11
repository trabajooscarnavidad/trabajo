/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 //añadir permisos
                PermisosServicios ps = new PermisosServicios();
                ps.asociarPermisosSinInterfaz(idUsuario, 3); //3 = alumnos, 2 = profesores
 */
package servicios;

import dao.PermisosDAO;
import dao.UsersDAO;
import dao.UsuariosDAO;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import model.Asociaciones;
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
        
    
                

      public int [] asociarPermisos(String usuarios[], String permisos[])
    {
        PermisosDAO dao = new PermisosDAO();
        List listA = new ArrayList();
      
        for (int i = 0; i < usuarios.length; i++) {       
            for (int j = 0; j < permisos.length; j++) {
            
 Asociaciones obj_asociaciones = new Asociaciones(); 
                 obj_asociaciones.setId1(parseInt(usuarios[i]));
                 obj_asociaciones.setId2(parseInt(permisos[j]));
                 listA.add(obj_asociaciones);

            }
        }
return dao.asociarPermisosJDBCTemplate(listA);
       // return dao.asociarPermisosJDBCTemplate(listA);
    }
      
                      
      public int [] quitarPermisos(String usuarios[], String permisos[])
    {
        PermisosDAO dao = new PermisosDAO();
        List listA = new ArrayList();

        for (int i = 0; i < usuarios.length; i++) {
            for (int j = 0; j < permisos.length; j++) {
 Asociaciones obj_asociaciones = new Asociaciones(); 
                 obj_asociaciones.setId1(parseInt(usuarios[i]));
                 obj_asociaciones.setId2(parseInt(permisos[j]));
                 listA.add(obj_asociaciones);

            }
        }
return dao.quitarPermisosJDBCTemplate(listA);
       // return dao.asociarPermisosJDBCTemplate(listA);
    }
      
     public int asociarPermisosSinInterfaz(int idUser, int idPermiso) {
        PermisosDAO dao = new PermisosDAO();
Asociaciones obj_asociaciones = new Asociaciones(); 
                 obj_asociaciones.setId1(idUser);
                 obj_asociaciones.setId2(idPermiso);

        int exito = -1;
      
            try {
                
              obj_asociaciones = dao.asociarPermisosSinInterfaz(obj_asociaciones);
                if (obj_asociaciones != null) {
                    exito = 1; //añadido correctamente
                } else {
                    exito = 2; //algo fallo (el unico fallo que puede ocurrir es que ya este asignado el permiso, ya que alumnos o profesores siempre tendran la misma id) y al cojer la id automaticamente del usuario no puede fallar.
                }
            }catch(Exception e){ }
            return exito;
           
        
        }

    

//      
//         public void darDeAlta(String usuarios[], String permisos[]) //sin terminar seguramente para borrar
//    {
//        PermisosDAO dao = new PermisosDAO();
//        List listA = new ArrayList();
//        List listB = new ArrayList();
//
//        Permiso obj_permiso = new Permiso(); 
//          User obj_user = new User();
//        for (int i = 0; i < usuarios.length; i++) {
//             obj_permiso.setIdPermisos(Long.parseLong(usuarios[i]));
//             obj_user.setIdUsuarios(Long.parseLong(usuarios[i]));
//             UsersDAO dao2 = new UsersDAO();
//              User obj_user_db = dao2.comprobarDatosUsuarioDB(obj_user);
//             listB.add(obj_user_db);
//            for (int j = 0; j < permisos.length; j++) {
//                 obj_permiso.setValor(permisos[j]);
//                 listA.add(obj_permiso);
//            }
//        }
//dao.asociarPermisosJDBCTemplate(listA);
// MandarMail mail = new MandarMail();
//for (int i = 0; i < listB.size(); i++) {
//      
//obj_user = (User) listB.get(i);
//String pass = null; //generar contraseña aleatoria
////funcion para asignar nueva contraseña en la db
//mail.mandarMail(obj_user.getEmail(), "tu contraseña es " + pass + " codigo activacion "+ obj_user.getCodigo()+ " activalo en  http://127.0.0.1:8080/login?op=activar&usuario=" + obj_user.getUsuario() + "&codigo=" + obj_user.getCodigo(), "Codigo de activacion");
//
//}
// 
//          
//       // mail.mandarMail(registro.getEmail(), "tu contraseña es "+ registro.getCodigo()+ " activalo en  http://127.0.0.1:8080/login?op=activar&usuario=" + registro.getUsuario() + "&codigo=" + registro.getCodigo(), "Codigo de activacion");
//
//       // return dao.asociarPermisosJDBCTemplate(listA);
//    }
//                
//                
}

