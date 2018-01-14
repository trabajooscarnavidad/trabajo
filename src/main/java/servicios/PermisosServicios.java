
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
                    exito = 1;
                } else {
                    exito = 2; 
                }
            }catch(Exception e){ System.out.println("error inesperado"); }
            return exito;
           
        
        }


        public List<Asociaciones> getAllPermisosbyID(String usuario)
    {
        PermisosDAO dao = new PermisosDAO();
        UsersDAO dao2 = new UsersDAO();
      int id = (int) dao2.getUserByNombre(usuario).getIdUsuarios();
        return dao.getAllPermisosJDBCTemplate(id);
    }
           
         public int addpermisos(String newpermiso) {
        PermisosDAO dao = new PermisosDAO();

        int result = -1;
        
            try {
                Permiso obj_permiso = new Permiso();
                obj_permiso.setValor(newpermiso);
                result = dao.addpermiso(obj_permiso);
                   }catch(Exception e){ System.out.println("error inesperado"); }
        return result;
    }
        
}

