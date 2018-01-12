package model;

import java.time.LocalDateTime;

/**
 *
 * @author Samu
 */
public class Tarea
{

    private int tareas_idTareas;
    private int asignaturas_idAsignaturas;
    private int Alumnos_idAlumnos;
    private String nombre;
    private LocalDateTime fecha;
    private boolean realizada;

    public int getTareas_idTareas()
    {
        return tareas_idTareas;
    }

    public void setTareas_idTareas(int tareas_idTareas)
    {
        this.tareas_idTareas = tareas_idTareas;
    }

    public int getAsignaturas_idAsignaturas()
    {
        return asignaturas_idAsignaturas;
    }

    public void setAsignaturas_idAsignaturas(int asignaturas_idAsignaturas)
    {
        this.asignaturas_idAsignaturas = asignaturas_idAsignaturas;
    }

    public int getAlumnos_idAlumnos()
    {
        return Alumnos_idAlumnos;
    }

    public void setAlumnos_idAlumnos(int Alumnos_idAlumnos)
    {
        this.Alumnos_idAlumnos = Alumnos_idAlumnos;
    }

   

    

   

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public LocalDateTime getFecha()
    {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha)
    {
        this.fecha = fecha;
    }
    public boolean isRealizada()
    {
        return realizada;
    }

    public void setRealizada(boolean realizada)
    {
        this.realizada = realizada;
    }

}
