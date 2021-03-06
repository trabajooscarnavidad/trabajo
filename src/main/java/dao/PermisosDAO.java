
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Asociaciones;
import model.Permiso;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

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

              ps.setInt(1, record.getUsuarios_idUsuarios());
              ps.setInt(2, record.getPermisos_idPermisos());
        }

        @Override
        public int getBatchSize() {
            return records.size();
        }
    });
}
catch (DataAccessException e){

       System.out.println("el usuario ya tenia asignado ese permiso");
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

                 ps.setInt(1, record.getUsuarios_idUsuarios());
              ps.setInt(2, record.getPermisos_idPermisos());
        }

        @Override
        public int getBatchSize() {
            return records.size();
        }
    });
}
catch (DataAccessException e){

        System.out.println("el usuario no tiene ese permiso");
    }
          return filas;
}

    public Asociaciones asociarPermisosSinInterfaz(Asociaciones u) {
        try {
            JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            int filas = jtm.update("INSERT INTO Usuarios_has_Permisos (Usuarios_idUsuarios,Permisos_idPermisos ) VALUES (?, ?)", u.getUsuarios_idUsuarios(), u.getPermisos_idPermisos());
            if (filas == 0) {
                u = null;
            }
        } catch (Exception ex) {
            Logger.getLogger(PermisosDAO.class.getName()).log(Level.SEVERE, null, ex);
            u = null;
        }
        return u;
    }
      public List<Asociaciones> getAllPermisosJDBCTemplate(int id) {
     
        JdbcTemplate jtm = new JdbcTemplate(
          DBConnection.getInstance().getDataSource());
        List <Asociaciones>permisos = jtm.query("Select * from Usuarios_has_Permisos where Usuarios_idUsuarios=?", new Object[]{id}, 
          new BeanPropertyRowMapper(Asociaciones.class));
        
        
        return permisos;
    }
      
          public int addpermiso(Permiso p) {
              int filas=0;
        try {
            
            JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            filas = jtm.update("INSERT INTO Permisos(Valor) VALUES(?)", p.getValor());

        } catch (Exception ex) {
            Logger.getLogger(PermisosDAO.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return filas;
    }

}
