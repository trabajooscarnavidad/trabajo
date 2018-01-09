/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AsignaturasDAO;
import model.Asignatura;
import java.util.List;
import model.Asignatura_curso;
import model.Curso;

/**
 *
 * @author Miguel Angel Diaz
 */
public class AsignaturasServicios {

    public List<Asignatura> getAllAsignaturas() {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.getAllAsignaturas();
    }
    
    public List<Curso> getAllcursos() {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.getAllCursos();
    }

    public Asignatura addAsignatura(Asignatura a) {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.addAsignatura(a);
    }
    
    public Curso addCurso(Curso c) {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.addCurso(c);
    }
    
    public int comprobar_union(Asignatura_curso r)
    {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.comprobar_union(r);
    }
    public int relacionar(Asignatura_curso s)
    {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.relacionar(s);
    }
    
    public int quitar_relacion(Asignatura_curso y)
    {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.quitar_relacion(y);
    }
    
    public String ver_asignaturas(int curso)
    {
        AsignaturasDAO dao = new AsignaturasDAO();
        String asignaturas = "";
        List<Asignatura> lista = dao.ver_asignaturas(curso);
        
        for(int x=0; x<lista.size(); x++) 
        {
            asignaturas += lista.get(x).getNombre()+", ";
        }
        return asignaturas;
    }
    
    
}
