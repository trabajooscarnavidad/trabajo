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
import model.Permiso;
import model.User;
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
      

                        
                
                
public void asociarPermisosJDBCTemplate(final List<Permiso> records ) {
try {

 JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());

    jtm.batchUpdate("INSERT INTO Usuarios_has_Permisos (Usuarios_idUsuarios,Permisos_idPermisos ) VALUES (?, ?)", new BatchPreparedStatementSetter() {
        

        @Override
        public void setValues(PreparedStatement ps, int i) throws SQLException {
              Permiso record = records.get(i);

              ps.setInt(1, Math.toIntExact(record.getIdPermisos()));
              ps.setInt(2, Integer.parseInt(record.getValor()));
        }

        @Override
        public int getBatchSize() {
            return records.size();
        }
    });
}catch (DataIntegrityViolationException e) {
        System.out.println("history already exist");
    }
}

public void quitarPermisosJDBCTemplate(final List<Permiso> records ) {
try {

 JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());

    jtm.batchUpdate("DELETE FROM Usuarios_has_Permisos WHERE Usuarios_idUsuarios = ? AND Permisos_idPermisos ?", new BatchPreparedStatementSetter() {
        

        @Override
        public void setValues(PreparedStatement ps, int i) throws SQLException {
              Permiso record = records.get(i);

              ps.setInt(1, Math.toIntExact(record.getIdPermisos()));
              ps.setInt(2, Integer.parseInt(record.getValor()));
        }

        @Override
        public int getBatchSize() {
            return records.size();
        }
    });
}catch (DataIntegrityViolationException e) {
        System.out.println("history already exist");
    }
}

}
