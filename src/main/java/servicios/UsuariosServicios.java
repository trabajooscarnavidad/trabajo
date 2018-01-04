package servicios;

import config.Configuration;
import dao.UsuariosDAO;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.Duration;
import java.time.Instant;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import java.util.Date;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import utils.PasswordHash;

public class UsuariosServicios {

    UsuariosDAO dao = new UsuariosDAO();

    public boolean loginUsuario(String nombre, String password) {

        boolean exito = false;
        try {
            Usuario obj_user = new Usuario();
            obj_user.setUsuario(nombre);
            Usuario obj_user_db = dao.comprobarDatosUsuarioDB(obj_user);
            if (obj_user_db != null) {
                exito = PasswordHash.getInstance().validatePassword(password, obj_user_db.getPass());
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordHash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(PasswordHash.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
    }

    public boolean comprobarActivado(String nombre) {
        boolean exito = false;
        Usuario obj_user = new Usuario();
        obj_user.setUsuario(nombre);
        Usuario obj_user_db = dao.comprobarDatosUsuarioDB(obj_user);
        if (obj_user_db != null) {
            exito = obj_user_db.isActivo();
        }

        return exito;
    }

    public boolean crearUsuario(String nombre, String password, String email) {
        boolean exito = false;
        Usuario obj_user = new Usuario();
        obj_user.setUsuario(nombre);
        obj_user.setPass(password);
        obj_user.setEmail(email);
        preparacionUser(obj_user); //añadir fecha, hashear contraseña...
        boolean existe = dao.comprobarUser(obj_user); //comprobar si usuario ya existe
        if (existe == false) {
            exito = dao.insertarRegistro(obj_user);
            mandarMail(obj_user);
        }

        return exito;

    }

    public boolean activarUsuario(String nombre, String codigo) {
        boolean exito = false;
        Usuario obj_user = new Usuario();
        obj_user.setUsuario(nombre);
        obj_user.setCodigo(codigo);
        long minutosyml = Configuration.getInstance().getMinutos();
        Usuario obj_user_db = dao.comprobarDatosUsuarioDB(obj_user);
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldt2 = obj_user_db.getFecha();
        long minutospasados = Duration.between(ldt, ldt2).toMinutes();
        if (minutosyml < minutospasados) {
            exito = dao.activarRegistro(obj_user);
        }

        return exito;
    }

    public void mandarMail(Usuario registro) {
        MandarMail mail = new MandarMail();
        mail.mandarMail(registro.getEmail(), "tu codigo de activacion es "+ registro.getCodigo()+ " activalo en  http://127.0.0.1:8080/login?op=activar&usuario=" + registro.getUsuario() + "&codigo=" + registro.getCodigo(), "Codigo de activacion");

    }

    public Usuario preparacionUser(Usuario registro) {
        try {
            LocalDateTime ldt = LocalDateTime.now();
            registro.setFecha(ldt);
            String hash = PasswordHash.getInstance().createHash(registro.getPass());
            registro.setPass(hash);
            generarcodigoActivacion(registro);

        } catch (Exception ex) {
            Logger.getLogger(UsuariosServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;
    }

    public Usuario generarcodigoActivacion(Usuario registro) {

        String codigo = UUID.randomUUID().toString();
        registro.setCodigo(codigo);

        return registro;
    }
}
