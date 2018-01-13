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
import model.Informe1;
import model.Informe2;
import model.Informe3;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author Juan
 */
public class InformesDAO {
    public List<Informe1> informe1(String profesor) {
        List<Informe1> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Informe1>> h = new BeanListHandler<>(Informe1.class);
            lista = qr.query(con, "select b.Nombre as asignatura, a.Nombre as alumno, n.Nota as nota from Alumnos a\n" +
            "join Notas n on a.idAlumnos = n.Alumnos_idAlumnos \n" +
            "join Asignaturas b on b.idAsignaturas = n.Asignaturas_idAsignaturas \n" +
            "join Asignaturas_has_Profesores m on b.idAsignaturas = m.Asignaturas_idAsignaturas\n" +
            "join Profesores p on m.Profesores_idProfesores = p.idProfesores\n" +
            "where p.Nombre = ?", profesor,  h);

        } catch (Exception ex) {
            Logger.getLogger(InformesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    
    public List<Informe2> informe2(String curso) {
        List<Informe2> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Informe2>> h = new BeanListHandler<>(Informe2.class);
            lista = qr.query(con, "select b.Nombre as asignatura, p.Nombre as profesor, a.Nombre as alumno, n.Nota as nota from Asignaturas b \n" +
                                "join Notas n on n.Asignaturas_idAsignaturas = b.idAsignaturas \n" +
                                "join Alumnos a on n.Alumnos_idAlumnos = a.idAlumnos\n" +
                                "join Asignaturas_has_Profesores m on b.idAsignaturas = m.Asignaturas_idAsignaturas \n" +
                                "join Profesores p on m.Profesores_idProfesores = p.idProfesores\n" +
                                "where b.idAsignaturas in\n" +
                                "(select b.idAsignaturas from Asignaturas b \n" +
                                "join Asignaturas_has_Cursos h on b.idAsignaturas = h.Asignaturas_idAsignaturas\n" +
                                "join Cursos c on h.Cursos_idCursos = c.idCursos \n" +
                                "where c.Nombre = ?)", curso,  h);

        } catch (Exception ex) {
            Logger.getLogger(InformesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    
    public List<Informe3> informe3(String alumno) {
        List<Informe3> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Informe3>> h = new BeanListHandler<>(Informe3.class);
            lista = qr.query(con, "select b.Nombre as asignatura, n.Nota as nota from Alumnos a \n" +
                                "join Notas n on a.idAlumnos = n.Alumnos_idAlumnos \n" +
                                "join Asignaturas b on n.Asignaturas_idAsignaturas = b.idAsignaturas \n" +
                                "where a.Nombre = ?", alumno,  h);

        } catch (Exception ex) {
            Logger.getLogger(InformesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
}
