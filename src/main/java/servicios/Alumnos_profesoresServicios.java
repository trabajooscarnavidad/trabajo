/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.Alumnos_profesoresDAO;
import java.util.List;
import model.Alumno;
import model.Profesor;
import model.User;

/**
 *
 * @author DAW
 */
public class Alumnos_profesoresServicios
{
    public List<Alumno> listarAlumnos() {
        Alumnos_profesoresDAO dao = new Alumnos_profesoresDAO();
        return dao.listarAlumnos();
    }
    public List<Profesor> listarProfesores() {
        Alumnos_profesoresDAO dao = new Alumnos_profesoresDAO();
        return dao.listarProfesores();
    }
    
    public long getIdUsuario(String usuario)
    {
        Alumnos_profesoresDAO dao = new Alumnos_profesoresDAO();
        List<User> lista = dao.getIdUsuario(usuario);
        long id = lista.get(0).getIdUsuarios();
        
        return id;
    }
    
    public int introducir_alumno(Alumno alumno)
    {
        Alumnos_profesoresDAO dao = new Alumnos_profesoresDAO();
        return dao.introducir_alumno(alumno);
    }
    public int introducir_profesor(Profesor profe)
    {
        Alumnos_profesoresDAO dao = new Alumnos_profesoresDAO();
        return dao.introducir_profesor(profe);
    }
    
        public long getIdAlumno(int idusuario)
    {
        Alumnos_profesoresDAO dao = new Alumnos_profesoresDAO();
        List<Alumno> lista = dao.getIdAlumno(idusuario);
        long id = lista.get(0).getIdAlumnos();
        
        return id;
    }
}
