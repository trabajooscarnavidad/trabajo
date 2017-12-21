/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AlumnosDAO;
import java.util.List;
import model.Alumno;

/**
 *
 * @author Miguel Angel Diaz
 */
public class AlumnosServicios {

    public List<Alumno> getAllAlumnos() {
        AlumnosDAO dao = new AlumnosDAO();
        return dao.getAllAlumnosJDBC();
    }

    public Alumno addAlumno(Alumno alumnoNuevo) {
        AlumnosDAO dao = new AlumnosDAO();
        return dao.insertAlumnoJDBC(alumnoNuevo);
    }

    public int updateAlumno(Alumno alumnoNuevo) {
        AlumnosDAO dao = new AlumnosDAO();
        return dao.updateUser(alumnoNuevo);
    }
    
    public int delAlumno(Alumno alumnoNuevo){
        AlumnosDAO dao = new AlumnosDAO();
        return dao.delUser(alumnoNuevo);
    }
    
    public int delAlumno2(Alumno alumnoNuevo){
        AlumnosDAO dao = new AlumnosDAO();
        return dao.delUser2(alumnoNuevo);
    }
}
