/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Nota;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 *
 * @author Miguel Angel Diaz
 */
public class NotasDAO {

    public Nota guardarNota(Nota n) {
        Connection con = null;
        int filas = 0;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            filas = qr.update(con, "UPDATE Notas SET Nota = ? WHERE Alumnos_idAlumnos = ? AND Asignaturas_idAsignaturas = ?", n.getNota(), n.getAlumnos_idAlumnos(), n.getAsignaturas_idAsignaturas());

            if (filas == 0) {
                con.setAutoCommit(false);
                Long id = qr.insert(con,
                        "INSERT INTO Notas (Alumnos_idAlumnos,Asignaturas_idAsignaturas,Nota) VALUES(?,?,?)",
                        new ScalarHandler<Long>(), n.getAlumnos_idAlumnos(), n.getAsignaturas_idAsignaturas(), n.getNota());
                con.commit();
            }
        } catch (Exception ex) {
            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);
            n = null;
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return n;
    }

    public int delNota(Nota n) {
        Connection con = null;
        int filas = 0;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            filas = qr.update(con, "DELETE FROM Notas WHERE Alumnos_idAlumnos = ? AND Asignaturas_idAsignaturas = ?", n.getAlumnos_idAlumnos(), n.getAsignaturas_idAsignaturas());

        } catch (Exception ex) {
            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return filas;
    }

    public Nota getNota(Long idAlu, Long idAsig) {
        Connection con = null;
        Nota n = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<Nota> h = new BeanHandler<>(Nota.class);
            n = qr.query(con, "SELECT * FROM Notas WHERE Alumnos_idAlumnos = ? AND Asignaturas_idAsignaturas = ?", h, idAlu, idAsig);

        } catch (Exception ex) {
            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return n;
    }
}
