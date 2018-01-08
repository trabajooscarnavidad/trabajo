/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AsignaturasDAO;
import model.Asignatura;
import java.util.List;
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

    
}
