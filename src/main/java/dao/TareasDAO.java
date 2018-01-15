package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alumno;
import model.Asociaciones;
import model.Mostrar_tarea;
import model.Nota;
import model.Tarea;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Samu
 */
public class TareasDAO
{

    public int asignarTarea(Tarea tarea)
    {   int filas = 0;
        try {
     
        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        filas = jtm.update("INSERT INTO Tareas (Asignaturas_idAsignaturas,Nombre,Fecha) VALUES (?,?,?)", tarea.getAsignaturas_idAsignaturas(), tarea.getNombre(), tarea.getFecha());
       
        }catch (Exception ex) {
             Logger.getLogger(TareasDAO.class.getName()).log(Level.SEVERE, null, ex);
 
         }
        return filas;
    }

    public List<Mostrar_tarea> getAllTareas(String alumno) {
        List<Mostrar_tarea> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Mostrar_tarea>> h = new BeanListHandler<>(Mostrar_tarea.class);
            lista = qr.query(con, "select m.Tareas_idTareas, m.Alumnos_idAlumnos,  t.Nombre as tarea, t.Fecha as fecha, b.Nombre as asignatura, m.Realizada as realizada from Alumnos a \n" +
                                    "join Alumnos_has_Tareas m on a.idAlumnos = m.Alumnos_idAlumnos\n" +
                                    "join Tareas t on m.Tareas_idTareas = t.idTareas\n" +
                                    "join Asignaturas b on b.idAsignaturas = t.Asignaturas_idAsignaturas\n" +
                                    "where a.Nombre = ?", alumno, h);
               
        } catch (Exception ex) {
            Logger.getLogger(TareasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    
    public int marcarHecha(int id_tarea, int id_alumno, int realizada)
    {
        Connection con = null;
        long resultado = 0;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            QueryRunner qr = new QueryRunner();
            resultado = qr.update(con,
                    "update Alumnos_has_Tareas set Realizada = ? where Tareas_idTareas = ? and Alumnos_idAlumnos = ?", realizada,  id_tarea, id_alumno);
           con.commit();
        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return (int) resultado;
    }

      public int modificarTarea(Tarea tarea)
    
           {   int filas = 0;
        try {
     
        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        filas = jtm.update("UPDATE Tareas SET Nombre = ?,Fecha = ? WHERE IdTareas = ? AND Asignaturas_idAsignaturas = ?", tarea.getNombre(), tarea.getFecha(),tarea.getIdTareas(), tarea.getAsignaturas_idAsignaturas());
       
        }catch (Exception ex) {
             Logger.getLogger(TareasDAO.class.getName()).log(Level.SEVERE, null, ex);
 
         }
        return filas;
    }
      
    public int borrarTarea(Tarea tarea)
       
           {   int filas = 0;
        try {
     
        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        filas = jtm.update("DELETE FROM Tareas WHERE idTareas = ?", tarea.getIdTareas());
       
        }catch (Exception ex) {
             Logger.getLogger(TareasDAO.class.getName()).log(Level.SEVERE, null, ex);
 
         }
        return filas;
    }
    public List<Tarea> getAllAlumnosTareas()
    {
        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        List<Tarea> lista = jtm.query("SELECT * FROM Alumnos_has_Tareas", new BeanPropertyRowMapper(Tarea.class));
        return lista;
    }
    
       public List<Tarea> getAllTareas2()
    {

        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        List<Tarea> lista = jtm.query("SELECT * FROM Tareas", new BeanPropertyRowMapper(Tarea.class));

        return lista;
    }
       
              public List<Nota> getAllAlumnosByAsignatura(int id)
    {

        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        List<Nota> lista = jtm.query("SELECT * FROM Notas where Asignaturas_idAsignaturas=?",  new BeanPropertyRowMapper(Nota.class), id);

        return lista;
    }

              public void asignarTareaAlumnosJDBCTemplate(final List<Nota> records, final int id ) {
   
    
try {
    
 JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());

    jtm.batchUpdate("INSERT INTO Alumnos_has_Tareas (Alumnos_idAlumnos,Tareas_idTareas, Realizada ) VALUES (?, ?, ?)", new BatchPreparedStatementSetter() {


        @Override
        public void setValues(PreparedStatement ps, int i) throws SQLException {
              Nota record = records.get(i);

              ps.setLong(1, record.getAlumnos_idAlumnos());
              ps.setInt(2, id);
              ps.setInt(3, 0);
        }

        @Override
        public int getBatchSize() {
            return records.size();
        }
    });
}
catch (DataAccessException e){

       System.out.println("el usuario ya tenia asignada esa tarea");
    }

         // return filas ;

}
              
}
