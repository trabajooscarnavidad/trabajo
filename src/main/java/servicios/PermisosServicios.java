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
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import model.Asociaciones;
import model.Permiso;



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
                 obj_asociaciones.setUsuarios_idUsuarios(parseInt(usuarios[i]));
                 obj_asociaciones.setPermisos_idPermisos(parseInt(permisos[j]));
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
                 obj_asociaciones.setUsuarios_idUsuarios(parseInt(usuarios[i]));
                 obj_asociaciones.setPermisos_idPermisos(parseInt(permisos[j]));
                 listA.add(obj_asociaciones);

            }
        }
return dao.quitarPermisosJDBCTemplate(listA);
       // return dao.asociarPermisosJDBCTemplate(listA);
    }
      
     public int asociarPermisosSinInterfaz(int idUser, int idPermiso) {
        PermisosDAO dao = new PermisosDAO();
Asociaciones obj_asociaciones = new Asociaciones(); 
                 obj_asociaciones.setUsuarios_idUsuarios(idUser);
                 obj_asociaciones.setPermisos_idPermisos(idPermiso);

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


        public List<Asociaciones> getAllPermisosbyID(String usuario)
    {
        PermisosDAO dao = new PermisosDAO();
        UsersDAO dao2 = new UsersDAO();
      int id = (int) dao2.getUserByNombre(usuario).getIdUsuarios();
        return dao.getAllPermisosJDBCTemplate(id);
    }
           
}

