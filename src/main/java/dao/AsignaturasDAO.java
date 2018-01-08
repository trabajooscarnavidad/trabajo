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
import model.Curso;
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
}
