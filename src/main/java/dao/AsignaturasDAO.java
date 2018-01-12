/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Asignatura;
import model.Asignatura_curso;
import model.Curso;
import model.Profesor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 *
 * @author Miguel Angel Diaz
 */
public class AsignaturasDAO {

    public List<Asignatura> getAllAsignaturas() {
        List<Asignatura> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Asignatura>> h = new BeanListHandler<Asignatura>(Asignatura.class);
            lista = qr.query(con, "select * FROM Asignaturas", h);
               
        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    
    public List<Profesor> getAllprofesores() {
        List<Profesor> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Profesor>> h = new BeanListHandler<>(Profesor.class);
            lista = qr.query(con, "select * FROM Profesores", h);
               
        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    
    public List<Asignatura> ver_asignaturas(int curso) {
        List<Asignatura> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Asignatura>> h = new BeanListHandler<>(Asignatura.class);
            lista = qr.query(con, "select a.Nombre from Asignaturas a join Asignaturas_has_Cursos m on a.idAsignaturas = m.Asignaturas_idAsignaturas join Cursos c on m.Cursos_idCursos = c.idCursos where c.idCursos = ?",curso , h);
               
        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    
    public List<Curso> ver_cursos(int asignatura) {
        List<Curso> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Curso>> h = new BeanListHandler<>(Curso.class);
            lista = qr.query(con, "select c.Nombre from Asignaturas a join Asignaturas_has_Cursos m on a.idAsignaturas = m.Asignaturas_idAsignaturas join Cursos c on m.Cursos_idCursos = c.idCursos where a.idAsignaturas = ?",asignatura , h);
               
        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    
    public List<Profesor> ver_profesores(int asignatura) {
        List<Profesor> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Profesor>> h = new BeanListHandler<>(Profesor.class);
            lista = qr.query(con, "select p.Nombre from Asignaturas a join Asignaturas_has_Profesores m on a.idAsignaturas = m.Asignaturas_idAsignaturas join Profesores p on m.Profesores_idProfesores = p.idProfesores where a.idAsignaturas = ?",asignatura , h);
               
        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    
    
    public List<Curso> getAllCursos() {
        List<Curso> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Curso>> h = new BeanListHandler<>(Curso.class);
            lista = qr.query(con, "select * FROM Cursos", h);

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }

    public Asignatura addAsignatura(Asignatura a) {
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            QueryRunner qr = new QueryRunner();
            long id = qr.insert(con,
                    "INSERT INTO Asignaturas (Nombre) VALUES(?)",
                    new ScalarHandler<Long>(), a.getNombre());
           
            a.setidAsignaturas(id);
            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
            a = null;
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return a;
    }
    
    public Curso addCurso(Curso c) {
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            QueryRunner qr = new QueryRunner();
            long id = qr.insert(con,
                    "INSERT INTO Cursos (Nombre) VALUES(?)",
                    new ScalarHandler<Long>(), c.getNombre());
           
            c.setIdCursos(id);
            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
            c = null;
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return c;
    }
    
    
    public int relacionar(Asignatura_curso s) {
        Connection con = null;
        long resultado = 0;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            QueryRunner qr = new QueryRunner();
            resultado = qr.update(con,
                    "insert into Asignaturas_has_Cursos values (?, ?)", s.getAsignaturas_idAsignaturas(), s.getCursos_idCursos());
           con.commit();
        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return (int) resultado;
    }
    
    public int quitar_relacion(Asignatura_curso y) {
        Connection con = null;
        long resultado = 0;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            QueryRunner qr = new QueryRunner();
            resultado = qr.update(con,
                    "delete from Asignaturas_has_Cursos where Asignaturas_idAsignaturas=? and Cursos_idCursos=?", y.getAsignaturas_idAsignaturas(), y.getCursos_idCursos());
           con.commit();
        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return (int) resultado;
    }
    
    public int comprobar_union(Asignatura_curso r)
    {
        long resultado = 0;
        
        List<Asignatura_curso> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Asignatura_curso>> h = new BeanListHandler<>(Asignatura_curso.class);
            lista = qr.query(con, "select * from Asignaturas_has_Cursos where Asignaturas_idAsignaturas=? and Cursos_idCursos=?", h, r.getAsignaturas_idAsignaturas(), r.getCursos_idCursos());
            
            if (lista.size() > 0)
                {
                    resultado = 1;
                }
            
            
        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        
        return (int) resultado;
    }
}
