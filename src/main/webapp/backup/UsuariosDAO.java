package dao;

import java.io.Console;
import model.Usuario;
import java.sql.Connection;
import java.util.HashMap;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class UsuariosDAO
{

    public boolean comprobarUser(Usuario obj_user)
    {
        Boolean existe = false;

        Usuario obj_db_user = null;

        try
        {
            JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            obj_db_user = (Usuario) jtm.queryForObject("SELECT * FROM Usuarios WHERE Usuario = ?", new Object[]
            {
                obj_user.getUsuario()
            }, new BeanPropertyRowMapper(Usuario.class));
        } catch (Exception ex)
        {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            obj_db_user = null;
        }

        if (obj_db_user != null)
        {
            existe = true;
        }

        return existe;
    }

    public boolean insertarRegistro(Usuario u)
    {
        boolean exito = true;
        try
        {

            JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            //  int filas = jtm.update("INSERT INTO Usuarios (Usuario,Email,Pass,Codigo,Activo,Fecha) VALUES(?,?,?,?,?,?)", u.getUsuario(), u.getEmail(), u.getPass(), u.getCodigo(), 0, u.getFecha(), u.getEmail());
            int filas = jtm.update("INSERT INTO Usuarios (usuario,pass,codigo,activo,fecha,email) VALUES(?,?,?,0,?,?)", u.getUsuario(), u.getPass(), u.getCodigo(), u.getFecha(), u.getEmail());
            if (filas == 0)
            {
                exito = false;
            }
        } catch (Exception ex)
        {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            u = null;
        }
        return exito;

    }

    public Usuario comprobarDatosUsuarioDB(Usuario obj_user)
    {
        Usuario obj_db_user;
        try
        {
            JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            obj_db_user = (Usuario) jtm.queryForObject("SELECT * FROM Usuarios WHERE Usuario = ?", new Object[]
            {
                obj_user.getUsuario()
            }, new BeanPropertyRowMapper(Usuario.class));
        } catch (Exception ex)
        {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            obj_db_user = null;
        }
        System.out.println("test");
        return obj_db_user;

    }

    public boolean activarRegistro(Usuario u)
    {
        boolean exito = false;
        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        if (jtm.update("UPDATE Usuarios SET Activo = ? WHERE Codigo = ?", 1, u.getCodigo()) > 0)
        {
            exito = true;
        }
        return exito;
    }

    public Boolean comprobarDatosUsuarioByPassDB(Usuario obj_user)
    {
        Usuario obj_db_user;
        Boolean checkpass = false;
        try
        {
            JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            obj_db_user = (Usuario) jtm.queryForObject("SELECT * FROM USUARIOS WHERE PASS = ?", new Object[]
            {
                obj_user.getPass()
            }, new BeanPropertyRowMapper(Usuario.class));
            if (obj_user.getPass().equals(obj_db_user.getPass()))
            {
                checkpass = true;

            } else
            {
                checkpass = false;
            }
        } catch (Exception ex)
        {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            obj_db_user = null;
        }
        return checkpass;
    }

    public int updatePass(Usuario obj_user, String passNueva)
    {
        int filas = 0;
        try
        {

            JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            filas = (jtm.update("UPDATE USUARIOS SET PASS = ? WHERE PASS = ?", passNueva, obj_user.getPass()));

        } catch (Exception ex1)
        {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex1);

        }
        return filas;
    }

}
