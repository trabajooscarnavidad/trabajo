/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alumno;
import model.Asignatura;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Samu
 */
public class AsociacionAlumAsigDAO
{

    public List<Alumno> getAllAlumnos()
    {

        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        List<Alumno> lista = jtm.query("SELECT * FROM ALUMNOS", new BeanPropertyRowMapper(Alumno.class));

        return lista;
    }

    public List<Asignatura> getAllAsignaturas()
    {
        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        List<Asignatura> lista = jtm.query("SELECT * FROM ASIGNATURAS", new BeanPropertyRowMapper(Alumno.class));
        return lista;
    }

    public Alumno getAlumnoById(Long idAlumno) {
        Alumno a;
        try {
            JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            a =(Alumno) jtm.queryForObject("SELECT * FROM ALUMNOS WHERE ID = ?", new Object[]{idAlumno}, new BeanPropertyRowMapper(Alumno.class));
        } catch (Exception ex) {
            Logger.getLogger(AsociacionAlumAsigDAO.class.getName()).log(Level.SEVERE, null, ex);
            a = null;
        }
        return a;
    }
    public Asignatura getAsignaturaById(Long idAsignatura) {
        Asignatura as;
        try {
            JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            as =(Asignatura) jtm.queryForObject("SELECT * FROM ASIGNATURA WHERE ID = ?", new Object[]{idAsignatura}, new BeanPropertyRowMapper(Asignatura.class));
        } catch (Exception ex) {
            Logger.getLogger(AsociacionAlumAsigDAO.class.getName()).log(Level.SEVERE, null, ex);
            as = null;
        }
        return as;
    }
    public int asociarAluAsig (String[]  idAlumno, String[]  idAsignatura)
    {
        int filas = 0 ;
        
        return filas ; 
    }
     public int desAsociarAluAsig (String[]  idAlumno, String[]  idAsignatura)
    {
        int filas = 0 ;
        
        return filas ; 
    }
}
