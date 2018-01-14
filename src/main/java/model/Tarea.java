package model;

import java.time.LocalDateTime;

/**
 *
 * @author Samu
 */
public class Tarea
{

    private int idTareas;
    private int asignaturas_idAsignaturas;
    private String nombre;
    private LocalDateTime fecha;

    public int getIdTareas()
    {
        return idTareas;
    }

    public void setIdTareas(int idTareas)
    {
        this.idTareas = idTareas;
    }

    public int getAsignaturas_idAsignaturas()
    {
        return asignaturas_idAsignaturas;
    }

    public void setAsignaturas_idAsignaturas(int asignaturas_idAsignaturas)
    {
        this.asignaturas_idAsignaturas = asignaturas_idAsignaturas;
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


}