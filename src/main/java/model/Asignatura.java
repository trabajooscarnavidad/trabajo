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
public class Asignatura {
    
    private Long idAsignaturas;
    private String nombre;
    
    public Asignatura(){
    }

    public Asignatura(Long id, String nombre) {
        this.idAsignaturas = id;
        this.nombre = nombre;
    }

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    public void setidAsignaturas(Long id){
        this.idAsignaturas=id;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public Long getidAsignaturas(){
        return idAsignaturas;
    }
    public String getNombre(){
        return nombre;
    }
}
