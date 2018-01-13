/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.NotasDAO;
import java.util.List;
import model.Asociaciones2;
import model.Nota;

/**
 *
 * @author Miguel Angel Diaz
 */
public class NotasServicios {
    public Nota guardarNota(Nota n){
        NotasDAO dao = new NotasDAO();
        return dao.guardarNota(n);
    }
    
    public Nota getNota(Long idalu, Long idasig){
        NotasDAO dao = new NotasDAO();
        return dao.getNota(idalu, idasig);
    }
    
    public int delNota(Nota n){
        NotasDAO dao = new NotasDAO();
        return dao.delNota(n);
    }
    
        public  List<Asociaciones2> getNotas(Long idusuario){
        Alumnos_profesoresServicios ap = new Alumnos_profesoresServicios();
         NotasDAO dao = new NotasDAO();
        return dao.getNotas( ap.getIdAlumno((int)(long)idusuario));
    }
}
