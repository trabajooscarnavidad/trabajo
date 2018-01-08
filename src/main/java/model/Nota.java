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
public class Nota {
    
    private Long Alumnos_idAlumnos;
    private Long Asignaturas_idAsignaturas;
    private int nota;
    
    public Nota(){
    }
    
    public void setAlumnos_idAlumnos(Long Alumnos_idAlumnos){
        this.Alumnos_idAlumnos=Alumnos_idAlumnos;
    }
    public void setAsignaturas_idAsignaturas(Long Asignaturas_idAsignaturas){
        this.Asignaturas_idAsignaturas=Asignaturas_idAsignaturas;
    }
    public void setNota(int nota){
        this.nota=nota;
    }
    
    public Long getAlumnos_idAlumnos(){
        return Alumnos_idAlumnos;
    }
    public Long getAsignaturas_idAsignaturas(){
        return Asignaturas_idAsignaturas;
    }
    public int getNota(){
        return nota;
    }
}
