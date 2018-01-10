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
}
