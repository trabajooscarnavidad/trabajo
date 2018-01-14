<%-- 
    Document   : informe_alumnos
    Created on : 13-ene-2018, 21:31:27
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
        <title>Informe de alumnos</title>
    </head>
    <body>
        <h1>Informe de alumnos</h1>
        <hr/>
        <h3>Todas las notas del alumno: <font color="red"><c:out value="${alumno}" /></font> iniciado en sesión.</h3>
        (Si la tabla está vacia es que aun no hay notas puestas)
        <br><br>
        <table  border=1 cellspacing=0 cellpadding=2 bordercolor="666633">
            <tr><th>Asignatura</th><th>Nota</th></tr>
            <c:forEach items="${informe3}" var="informe3">
                <tr><td>${informe3.asignatura}</td><td>${informe3.nota}</td></tr>
            </c:forEach>
        </table>
    </body>
</html>
