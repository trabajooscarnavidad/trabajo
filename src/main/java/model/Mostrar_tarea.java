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
public class Mostrar_tarea {
    
    private int Tareas_idTareas;
    private int Alumnos_idAlumnos;
    private String tarea;
    private String fecha;
    private String asignatura;
    private boolean realizada;

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public int getTareas_idTareas() {
        return Tareas_idTareas;
    }

    public void setTareas_idTareas(int Tareas_idTareas) {
        this.Tareas_idTareas = Tareas_idTareas;
    }

    public int getAlumnos_idAlumnos() {
        return Alumnos_idAlumnos;
    }

    public void setAlumnos_idAlumnos(int Alumnos_idAlumnos) {
        this.Alumnos_idAlumnos = Alumnos_idAlumnos;
    }

    
    
    
    
}
