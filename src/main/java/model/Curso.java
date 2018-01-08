/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Juan
 */
public class Curso {
    
    private long idCursos;
    private String nombre;

    public Curso() {
    }

    public Curso(long idCursos, String nombre)
    {
        this.idCursos = idCursos;
        this.nombre = nombre;
    }

    public long getIdCursos()
    {
        return idCursos;
    }

    public void setIdCursos(long idCursos)
    {
        this.idCursos = idCursos;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    
}
