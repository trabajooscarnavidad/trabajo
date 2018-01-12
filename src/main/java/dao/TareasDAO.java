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
    public boolean asignarTarea(Tarea tarea)
    {
        boolean exito = false; 
        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
       // exito = jtm.query("INSERT INTO Tareas (Asignaturas_idAsignaturas,Nombre,Fecha) VALUES = (?,?,?)",tarea.get, new BeanPropertyRowMapper(Tarea.class));
            return exito;
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
       filas = jtm.update("UPDATE TAREAS SET AND Nombre = ?,FechA = ? WHERE Asignaturas_idAsignaturas = ?", tarea.getNombre(), tarea.getFecha(),tarea.getAsignaturas_idAsignaturas(),new BeanPropertyRowMapper(Tarea.class));
       return filas;
    }
    public boolean borrarTarea(Tarea tarea)
    {
       boolean exito = false; 
       JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
       //exito = jtm.query("DELETE FROM TAREAS WHERE Asignaturas_idAsignaturas = ?,Nombre = ?,FechA = ?", ,new BeanPropertyRowMapper(Tarea.class));
       return exito;
    }
}
