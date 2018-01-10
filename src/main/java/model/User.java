/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Miguel Angel Diaz
 */
public class User {
    private long idUsuarios;
    private String Usuario;
    private String Pass;
    private boolean activo;
    private String Codigo;
    private LocalDateTime Fecha;
    private String email;

    public User(long idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    
    
    public User() {
    }

    public long getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(long idUsuarios) {
        this.idUsuarios = idUsuarios;
    }


    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public LocalDateTime getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDateTime Fecha) {
        this.Fecha = Fecha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
