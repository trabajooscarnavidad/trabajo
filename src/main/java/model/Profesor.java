/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DAW
 */
public class Profesor
{
    private long idProfesores;
    private long Usuarios_idUsuarios;
    private String Nombre;

    public long getIdProfesores()
    {
        return idProfesores;
    }

    public void setIdProfesores(long idProfesores)
    {
        this.idProfesores = idProfesores;
    }

    public long getUsuarios_idUsuarios()
    {
        return Usuarios_idUsuarios;
    }

    public void setUsuarios_idUsuarios(long Usuarios_idUsuarios)
    {
        this.Usuarios_idUsuarios = Usuarios_idUsuarios;
    }

    public String getNombre()
    {
        return Nombre;
    }

    public void setNombre(String Nombre)
    {
        this.Nombre = Nombre;
    }
    
    
}
