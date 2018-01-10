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
}
