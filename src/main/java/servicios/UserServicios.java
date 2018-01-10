/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import config.Configuration;
import dao.UsersDAO;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import utils.Constantes;
import utils.PasswordHash;
import utils.Utils;

/**
 *
 * @author Miguel Angel Diaz
 */
public class UserServicios {

    public int registrar(User user) {
        UsersDAO dao = new UsersDAO();

        boolean existe = this.comprobarNombres(user.getUsuario());

        int alta = -1;
        if (!existe) {
            try {
                user.setPass(PasswordHash.getInstance().createHash(user.getPass()));
                user.setCodigo(Utils.randomAlphaNumeric(Configuration.getInstance().getLongitudCodigo()));
                LocalDateTime fechaActual = LocalDateTime.now();
                user.setFecha(fechaActual);
                user = dao.registrar(user);
                if (user != null) {
                    MailServicios mail = new MailServicios();
                    mail.mandarMail(user.getEmail(), "Activa tu cuenta aquí: <a href='"+Constantes.LINK_EMAIL + user.getCodigo()+"'>Activar</a>", Constantes.ASUNTO_EMAIL);
                    alta = 1;
                }

            } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
                Logger.getLogger(UserServicios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            alta = 2;
        }
        return alta;
    }
    public int registrar_alumno(User user) {
        UsersDAO dao = new UsersDAO();

        boolean existe = this.comprobarNombres(user.getUsuario());

        int alta = -1;
        if (!existe) {
            try {
                String pass = user.getPass();
                user.setPass(PasswordHash.getInstance().createHash(pass));
                user.setCodigo(Utils.randomAlphaNumeric(Configuration.getInstance().getLongitudCodigo()));
                LocalDateTime fechaActual = LocalDateTime.now();
                user.setFecha(fechaActual);
                user = dao.registrar(user);
                if (user != null) {
                    MailServicios mail = new MailServicios();
                    mail.mandarMail(user.getEmail(), "Tu usuario es: "+user.getUsuario()+" y tu contraseña es: "+pass+". Activa tu cuenta aquí: <a href='"+Constantes.LINK_EMAIL + user.getCodigo()+"'>Activar</a>", Constantes.ASUNTO_EMAIL);
                    alta = 1;
                }

            } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
                Logger.getLogger(UserServicios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            alta = 2;
        }
        return alta;
    }
    
    

    public boolean comprobarNombres(String nombreUser) {
        UsersDAO dao = new UsersDAO();
        return dao.comprobarNombres(nombreUser);
    }

    public int login(User user) {
        int valido = -1;
        try {

            UsersDAO dao = new UsersDAO();
            User userDB = dao.getUserByNombre(user.getUsuario());
            boolean passCorrecta = PasswordHash.getInstance().validatePassword(user.getPass(), userDB.getPass());
            if (passCorrecta == true) {
                if(userDB.getActivo() == true){
                    valido = 1;
                }else{
                    valido = 2;
                }
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(UserServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valido;
    }

    public int activar(String codigo) {
        UsersDAO dao = new UsersDAO();
        User userDB = dao.getUserByCodigoActivacion(codigo);

        int activar;
        
        if(userDB==null){
            activar = -1;
        }else if (!userDB.getActivo()) {
            LocalDateTime fechaActivacion = userDB.getFecha();
            LocalDateTime fechaActual = LocalDateTime.now().minusMinutes(Configuration.getInstance().getMinutosParaValidar());
            if (fechaActivacion.isAfter(fechaActual)) {
                activar = dao.updateValido(userDB);
            } else {
                activar = dao.borrarUserByCodigoActivacion(userDB);
            }
        } else {
            activar = 2;
        }
        return activar;
    }

                public List<User> getAllUsuarios()
    {
        UsersDAO dao = new UsersDAO();
        
        return dao.getAllUsuariosJDBCTemplate();
    }
    
       public List<User> getAllUsuariosSinAlta()
    {
        UsersDAO dao = new UsersDAO();
        
        return dao.getAllUsuariosSinAltaJDBCTemplate();
    }
           public boolean recuperarPass(String nombre, String email)
    { UsersDAO dao = new UsersDAO();
        boolean exito = false;
        User obj_user = new User();
        obj_user.setUsuario(nombre);
        obj_user.setEmail(email);
      
         User obj_user_db = dao.getUserByNombre(obj_user.getUsuario()); //comprueba si existe el usuario en la db

         if (obj_user_db != null) //aqui podrias ser mas severo y comprobar nombre y correo aportado por el usuario con el de la db
            {
            String  pass =  Utils.randomAlphaNumeric(6); //genera nueva contraseña
 
            cambiarPass(obj_user_db.getUsuario(), pass); // 
        MailServicios mail = new MailServicios();
                    mail.mandarMailPassword(obj_user_db.getEmail(), pass, "Password"); // le envia la nueva contraseña por correo
                    //otra forma tambien podria ser que le envie un correo antes confirmando si quiere cambiar la contraseña y luego cambiarla
                    //en la pantalla de cambiar contraseña pero para no complicarme lo hice asi, lo puedes rehacer o cambiar
            exito = true;
        } else
        {
            exito = false;
        }
        return exito;

    }

    public boolean cambiarPass(String usuario, String passNueva) //esta funcion se utiliza desde /user en recuperar contraseña
    {
      
        boolean exito = false;
        try
        {
             UsersDAO dao = new UsersDAO();
            User obj_user = new User();
            obj_user.setUsuario(usuario);
            String hash = PasswordHash.getInstance().createHash(passNueva);
            obj_user.setPass(hash);
            boolean igual = false;
           User obj_user_db = dao.getUserByNombre(usuario);   //esta funcion la he cambiado para que coja los datos verificando el usuario
            if (obj_user_db != null) 
            {
                int update = 0;
                update = dao.updatePass(obj_user);
                if(update>0)
                {
                   exito = true; 
                }else
                {
                exito = false;
                }
            }

        } catch (Exception ex)
        {
            Logger.getLogger(UsuariosServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
    }        
    
        public boolean cambiarPass(String usuario, String passActual, String passNueva) //no se si permite sobrecarga si no cambiarle el nombre a la funcion
//esta funcion se utiliza en una nueva pagina que deberia ser /cambiarpassword o algo asi yo haria un nuevo servlet pero usando el servicio y dao de users
                //el usuario se podria cojer de la session o formulario
    {
      
        boolean exito = false;
        try
        {
             UsersDAO dao = new UsersDAO();
            User obj_user = new User();
            obj_user.setUsuario(usuario);
            String hash = PasswordHash.getInstance().createHash(passNueva);
            obj_user.setPass(hash);
            boolean igual = false;
           User obj_user_db = dao.getUserByNombre(usuario); 
            if (obj_user_db != null) //comprueba que existe el usuario
            {
                if (PasswordHash.getInstance().validatePassword(passActual, obj_user_db.getPass())){ //comprueba la pwd actual en la db con la que introducio el usuario si es la misma continua
                int update = 0;
                update = dao.updatePass(obj_user);
                if(update>0)
                {
                   exito = true; 
                }else
                {
                exito = false;
                }
                }
            }

        } catch (Exception ex)
        {
            Logger.getLogger(UsuariosServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
    }        
                
                
}