/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.PermisosDAO;
import java.util.ArrayList;
import java.util.List;
import model.Permiso;
import model.Usuario;

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
        
                public List<Usuario> getAllUsuarios()
    {
        PermisosDAO dao = new PermisosDAO();
        
        return dao.getAllUsuariosJDBCTemplate();
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
                
}

