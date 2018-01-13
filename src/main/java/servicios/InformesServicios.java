/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.InformesDAO;
import java.util.List;
import model.Informe1;
import model.Informe2;
import model.Informe3;

/**
 *
 * @author Juan
 */
public class InformesServicios {
    
    public List<Informe1> informe1(String profesor) {
        InformesDAO dao = new InformesDAO();
        return dao.informe1(profesor);
    }
    
    public List<Informe2> informe2(String curso) {
        InformesDAO dao = new InformesDAO();
        return dao.informe2(curso);
    }
    
    public List<Informe3> informe3(String alumno) {
        InformesDAO dao = new InformesDAO();
        return dao.informe3(alumno);
    }
    
}
