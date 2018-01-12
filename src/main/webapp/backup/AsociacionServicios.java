package servicios;

import dao.AsociacionAlumAsigDAO;
import java.util.List;
import model.Alumno;
import model.Asignatura;

/**
 *
 * @author Samu
 */
public class AsociacionServicios
{
     public List<Alumno> getAllAlumnos() {
        AsociacionAlumAsigDAO dao = new AsociacionAlumAsigDAO();
        return dao.getAllAlumnos();
    }
     public List<Asignatura> getAllAsignaturas() {
        AsociacionAlumAsigDAO dao = new AsociacionAlumAsigDAO();
        return dao.getAllAsignaturas();
    }
    public Alumno getAlumno(Long idAlumno)
    {
        AsociacionAlumAsigDAO dao = new AsociacionAlumAsigDAO();
        return dao.getAlumnoById(idAlumno);
    }
    public Asignatura getAsignatura(Long idAsignatura)
    {
        AsociacionAlumAsigDAO dao = new AsociacionAlumAsigDAO();
        return dao.getAsignaturaById(idAsignatura);
    }
    public int asociarAluAsig (String[] idAlumno, String[] idAsignatura)
    {
        AsociacionAlumAsigDAO dao = new AsociacionAlumAsigDAO();
        return dao.asociarAluAsig(idAlumno,idAsignatura);
    }
    public int desAsociarAluAsig (String[] idAlumno, String[] idAsignatura)
    {
        AsociacionAlumAsigDAO dao = new AsociacionAlumAsigDAO();
        return dao.desAsociarAluAsig(idAlumno,idAsignatura);
    }

    
}
