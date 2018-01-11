/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alumno;
import model.Asignatura;
import model.Profesor;
import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author DAW
 */
public class Alumnos_profesoresDAO
{
    public List<Alumno> listarAlumnos() {
        List<Alumno> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Alumno>> h = new BeanListHandler<>(Alumno.class);
            lista = qr.query(con, "select * FROM Alumnos", h);
               
        } catch (Exception ex) {
            Logger.getLogger(Alumnos_profesoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    public List<User> getIdUsuario(String usuario) {
        List<User> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<User>> h = new BeanListHandler<>(User.class);
            lista = qr.query(con, "select idUsuarios from Usuarios where Usuario = ?",usuario , h);
               
        } catch (Exception ex) {
            Logger.getLogger(Alumnos_profesoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    
    public List<Profesor> listarProfesores() {
        List<Profesor> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Profesor>> h = new BeanListHandler<>(Profesor.class);
            lista = qr.query(con, "select * FROM Profesores", h);
               
        } catch (Exception ex) {
            Logger.getLogger(Alumnos_profesoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    
    public int introducir_alumno(Alumno alumno) {
        Connection con = null;
        long resultado = 0;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            QueryRunner qr = new QueryRunner();
            resultado = qr.update(con,
                    "insert into Alumnos (Usuarios_idUsuarios, Nombre, Fecha_nac, Mayor) values (?, ?, ?, ?)", alumno.getUsuarios_idUsuarios(), alumno.getNombre(), alumno.getFecha_nac(), alumno.getMayor());
           con.commit();
        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return (int) resultado;
    }
    public int introducir_profesor(Profesor profe) {
        Connection con = null;
        long resultado = 0;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            QueryRunner qr = new QueryRunner();
            resultado = qr.update(con,
                    "insert into Profesores (Usuarios_idUsuarios, Nombre) values (?, ?)", profe.getUsuarios_idUsuarios(), profe.getNombre());
           con.commit();
        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return (int) resultado;
    }
}
