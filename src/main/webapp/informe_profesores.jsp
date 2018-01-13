<%-- 
    Document   : informe_profesores
    Created on : 13-ene-2018, 17:41:36
    Author     : Juan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informe de profesores</title>
    </head>
    <body>
        <h1>Informe de profesores</h1>
        <hr/>
        
        <form action="informes_profesores" method="get">
            
        <h3>Todas las notas de los alumnos del profesor: <font color="red"><c:out value="${profesor_seleccionado}" /></font> en todas las asignaturas.</h3>
        (Si la tabla está vacia es que este profesor aun no tiene datos)
        <br><br>
        Selecciona profesor:
            <select name="profesor">
                <c:forEach items="${profesores}" var="profesor">
                    <option value="${profesor.nombre}">${profesor.nombre}</option>
                </c:forEach>
            </select>
        <br><br>
        
        <table  border=1 cellspacing=0 cellpadding=2 bordercolor="666633">
            <tr><th>Asignatura</th><th>Alumno</th><th>Nota</th></tr>
            <c:forEach items="${informe1}" var="informe1">
                <tr><td>${informe1.asignatura}</td><td>${informe1.alumno}</td><td>${informe1.nota}</td></tr>
            </c:forEach>
        </table>
        
        <hr/>
        <h3>Todas las notas de las asignaturas del curso: <font color="red"><c:out value="${curso_seleccionado}" /></font> con sus profesores.</h3>
        (Si la tabla está vacia es que este curso aun no tiene datos)
        <br><br>
        Selecciona curso:
            <select name="curso">
                <c:forEach items="${cursos}" var="curso">
                   <option value="${curso.nombre}">${curso.nombre}</option>
                </c:forEach>
            </select>
        <br><br>
        
        <table border=1 cellspacing=0 cellpadding=2 bordercolor="666633">
            <tr><th>Asignatura</th><th>Profesor</th><th>Alumno</th><th>Nota</th></tr>
            <c:forEach items="${informe2}" var="informe2">
                <tr><td>${informe2.asignatura}</td><td>${informe2.profesor}</td><td>${informe2.alumno}</td><td>${informe2.nota}</td></tr>
            </c:forEach>
        </table>
        <br>
        <input type="submit" value="Consultar">
        </form>
    </body>
</html>
