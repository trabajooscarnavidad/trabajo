package dao;

import java.util.Date;
import java.util.List;
import model.Tarea;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Samu
 */
public class TareasDAO
{

    public int asignarTarea(Tarea tarea)
    {
        int filas = 0;
        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        filas = jtm.update("INSERT INTO Tareas (Asignaturas_idAsignaturas,Nombre,Fecha) VALUES = (?,?,?)",tarea.getAsignaturas_idAsignaturas(),tarea.getNombre(),tarea.getFecha(), new BeanPropertyRowMapper(Tarea.class));
        return filas;
    }

    public List<Tarea> getAllTareas()
    {

        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        List<Tarea> lista = jtm.query("SELECT * FROM Tareas", new BeanPropertyRowMapper(Tarea.class));

        return lista;
    }

    public int modificarTarea(Tarea tarea)
    {
        int filas = 0;
        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        filas = jtm.update("UPDATE TAREAS SET AND Nombre = ?,FechA = ? WHERE Asignaturas_idAsignaturas = ?", tarea.getNombre(), tarea.getFecha(), tarea.getAsignaturas_idAsignaturas(), new BeanPropertyRowMapper(Tarea.class));
        return filas;
    }

    public int borrarTarea(Tarea tarea)
    {
        int filas = 0;
        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        filas = jtm.update("DELETE FROM TAREAS WHERE Asignaturas_idAsignaturas = ?,Nombre = ?,FechA = ?",tarea.getAsignaturas_idAsignaturas(),tarea.getNombre(),tarea.getFecha(), new BeanPropertyRowMapper(Tarea.class));
        return filas;
    }

    public int actualizarRealizada(Tarea tarea)
    {
        int filas = 0;
        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        filas = jtm.update("UPDATE Alumnos_has_Tareas WHERE Alumnos_idAlumnos = ?, Tareas_idTareas = ? SET Realizada",tarea.getAlumnos_idAlumnos(),tarea.getTareas_idTareas(),tarea.isRealizada(), new BeanPropertyRowMapper(Tarea.class));
        return filas;
    }
}
