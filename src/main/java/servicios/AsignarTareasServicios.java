/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.DBConnection;
import dao.TareasDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import model.Alumno;
import model.Tarea;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Samu
 */
public class AsignarTareasServicios
{

    public boolean asignarTarea(int idAsignatura, String nombre, String fecha)
    {

        TareasDAO dao = new TareasDAO();
        boolean exito = false;
        Tarea tarea = new Tarea();
        LocalDateTime fechaFormat = tratarFechas(fecha);
        tarea.setFecha(fechaFormat);
        tarea.setAsignaturas_idAsignaturas(idAsignatura);
        tarea.setNombre(nombre);
        exito = dao.asignarTarea(tarea);
        return exito;
    }

    public List<Tarea> getAllTareas()
    {
        TareasDAO dao = new TareasDAO();
        return dao.getAllTareas();
    }

    public int modificarTarea(String idTarea, String idAsignatura, String nombre, String fecha)
    {
        int filas = 0;
        TareasDAO dao = new TareasDAO();
        Tarea tarea = new Tarea();
        tarea.setTareas_idTareas(Integer.parseInt(idTarea));
        tarea.setAsignaturas_idAsignaturas(Integer.parseInt(idAsignatura));
        tarea.setNombre(nombre);
        LocalDateTime fechaFormat = tratarFechas(fecha);
        tarea.setFecha(fechaFormat);
        filas = dao.modificarTarea(tarea);
        return filas;
    }

    public int borrarTarea(String idTarea, String idAsignatura, String nombre, String fecha)
    {
        int filas = 0;
        TareasDAO dao = new TareasDAO();
        Tarea tarea = new Tarea();
        tarea.setTareas_idTareas(Integer.parseInt(idTarea));
        tarea.setAsignaturas_idAsignaturas(Integer.parseInt(idAsignatura));
        tarea.setNombre(nombre);
        LocalDateTime fechaFormat = tratarFechas(fecha);
        tarea.setFecha(fechaFormat);
        filas = dao.borrarTarea(tarea);
        return filas;
    }

    public LocalDateTime tratarFechas(String fechaFormat)
    {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.parse(fechaFormat, formatter);
        return dateTime;
    }
}
