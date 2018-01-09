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
public class Asignatura_curso
{
    private long Asignaturas_idAsignaturas;
    private long Cursos_idCursos;

    
    
    public long getAsignaturas_idAsignaturas()
    {
        return Asignaturas_idAsignaturas;
    }

    public void setAsignaturas_idAsignaturas(long Asignaturas_idAsignaturas)
    {
        this.Asignaturas_idAsignaturas = Asignaturas_idAsignaturas;
    }

    public long getCursos_idCursos()
    {
        return Cursos_idCursos;
    }

    public void setCursos_idCursos(long Cursos_idCursos)
    {
        this.Cursos_idCursos = Cursos_idCursos;
    }
    
    
}
