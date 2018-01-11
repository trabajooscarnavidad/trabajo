/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Asociaciones;
import model.Permiso;
import model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ivan
 */
public class PermisosDAO {
      public List<Permiso> getAllPermisosJDBCTemplate() {
     
        JdbcTemplate jtm = new JdbcTemplate(
          DBConnection.getInstance().getDataSource());
        List<Permiso> permisos = jtm.query("Select * from Permisos",
          new BeanPropertyRowMapper(Permiso.class));
        
        
        return permisos;
    }
      

                        
                
                
public int[] asociarPermisosJDBCTemplate(final List<Asociaciones> records ) {
    int []filas = new int[0];
    
try {
    
 JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());

filas = jtm.batchUpdate("INSERT INTO Usuarios_has_Permisos (Usuarios_idUsuarios,Permisos_idPermisos ) VALUES (?, ?)", new BatchPreparedStatementSetter() {


        @Override
        public void setValues(PreparedStatement ps, int i) throws SQLException {
              Asociaciones record = records.get(i);

              ps.setInt(1, record.getId1());
              ps.setInt(2, record.getId2());
        }

        @Override
        public int getBatchSize() {
            return records.size();
        }
    });
}
catch (DataAccessException e){
//catch (DataIntegrityViolationException e) {
       //System.out.println("repe");
    }

          return filas ;

}

public int [] quitarPermisosJDBCTemplate(final List<Asociaciones> records ) {
      int []filas = new int[0];
try {

 JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());

    filas = jtm.batchUpdate("DELETE FROM Usuarios_has_Permisos WHERE Usuarios_idUsuarios = ? AND Permisos_idPermisos = ?", new BatchPreparedStatementSetter() {
        

        @Override
        public void setValues(PreparedStatement ps, int i) throws SQLException {
              Asociaciones record = records.get(i);

                 ps.setInt(1, record.getId1());
              ps.setInt(2, record.getId2());
        }

        @Override
        public int getBatchSize() {
            return records.size();
        }
    });
}
catch (DataAccessException e){
//catch (DataIntegrityViolationException e) {
        //System.out.println("history already exist");
    }
          return filas;
}

    public Asociaciones asociarPermisosSinInterfaz(Asociaciones u) {
        try {
            JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            int filas = jtm.update("INSERT INTO Usuarios_has_Permisos (Usuarios_idUsuarios,Permisos_idPermisos ) VALUES (?, ?)", u.getId1(), u.getId2());
            if (filas == 0) {
                u = null;
            }
        } catch (Exception ex) {
            Logger.getLogger(PermisosDAO.class.getName()).log(Level.SEVERE, null, ex);
            u = null;
        }
        return u;
    }

}
