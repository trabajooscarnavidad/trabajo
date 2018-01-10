/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Miguel Angel Diaz
 */
public class Alumno {
    
    private long idAlumnos;
    private long Usuarios_idUsuarios;
    private String Nombre;
    private String Fecha_nac;
    private int Mayor;

    public long getIdAlumnos()
    {
        return idAlumnos;
    }

    public void setIdAlumnos(long idAlumnos)
    {
        this.idAlumnos = idAlumnos;
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

    public String getFecha_nac() {
        return Fecha_nac;
    }

    public void setFecha_nac(String Fecha_nac) {
        this.Fecha_nac = Fecha_nac;
    }

    public int getMayor() {
        return Mayor;
    }

    public void setMayor(int Mayor) {
        this.Mayor = Mayor;
    }
}
