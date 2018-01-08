/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Miguel Angel Diaz
 */
public class UsersDAO {

    private final String queryRegistrar = "INSERT INTO Usuarios (usuario,pass,codigo,activo,fecha,email) VALUES(?,?,?,0,?,?)";
    private final String queryComprobarNombres = "SELECT Usuario FROM Usuarios WHERE Usuario = ?";
    private final String queryUserByCodigoActivacion = "SELECT * FROM Usuarios WHERE Codigo = ?";
    private final String queryActivar = "UPDATE Usuarios SET Activo = TRUE WHERE Codigo = ?";
    private final String queryBorrar = "DELETE FROM Usuarios WHERE Codigo = ?";
    private final String queryUserByNombre = "SELECT * FROM Usuarios WHERE Usuario = ?";

    public User registrar(User u) {
        try {
            JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            int filas = jtm.update(queryRegistrar, u.getUsuario(), u.getPass(), u.getCodigo(), u.getFecha(), u.getEmail());
            if (filas == 0) {
                u = null;
            }
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            u = null;
        }
        return u;
    }

    public boolean comprobarNombres(String nombreUser) {
        boolean existe = false;
        try {
            JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            String resultado = jtm.queryForObject(queryComprobarNombres, String.class, nombreUser);

            if (resultado != null) {
                existe = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }

    public int updateValido(User user)
    {
        int valido = -1;
        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        if(jtm.update(queryActivar, user.getCodigo())>0){
             valido = 1;
        }
        
        return valido;
    }
    
    public int borrarUserByCodigoActivacion(User user)
    {
        int valido = -1;
        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        if(jtm.update(queryBorrar, user.getCodigo())>0){
             valido = 0;
        }
        
        return valido;
    }
    
    public User getUserByCodigoActivacion(String codigoActivacion) {
        User u;
        try {
            JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            u =(User) jtm.queryForObject(queryUserByCodigoActivacion, new Object[]{codigoActivacion}, new BeanPropertyRowMapper(User.class));
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            u = null;
        }
        return u;
    }
    
    public User getUserByNombre(String nombre) {
        User u;
        try {
            JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            u =(User) jtm.queryForObject(queryUserByNombre, new Object[]{nombre}, new BeanPropertyRowMapper(User.class));
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            u = null;
        }
        return u;
    }
}