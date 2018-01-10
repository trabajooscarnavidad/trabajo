<%-- 
    Document   : registrarAlumnos_profesores
    Created on : 10-ene-2018, 10:53:33
    Author     : DAW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro alumnos profesores</title>
    </head>
    <body>
        <form action="alumnos_profesores" method="get">
            <h2>Alumnos</h2>
            Nombre: <input type="text" name="nombre"><br>
            Email: <input type="text" name="email"><br>
            Fecha nacimiento: <input type="date" name="fecha"><br>
            Mayor: <input type="select" name="mayor"><br>
            <input type="submit" value="enviar">
            <input type="hidden" name="op" value="registrar_alumno">
        </form>
        
        <form action="alumnos_profesores" method="get">
            <h2>Profesores</h2>
            Nombre: <input type="text" name="nombre"><br>
            Email: <input type="text" name="email"><br>
            <input type="hidden" name="op" value="registrar_profesor">
            <input type="submit" value="enviar">
        </form>
        
        <br>
        
        <table border="1">
            <c:forEach items="${alumnos}" var="alumno">
                <tr>
                    <td>${alumno.idAlumnos}</td>
                    <td>${alumno.usuarios_idUsuarios}</td>
                    <td>${alumno.nombre}</td>
                    <td>${alumno.fecha_nac}</td>
                    <td>${alumno.mayor}</td>
                </tr>
            </c:forEach>
        </table>
        
        <table border="1">   
            <c:forEach items="${profesores}" var="profesor">
                <tr>
                    <td>${profesor.idProfesores}</td>
                    <td>${profesor.usuarios_idUsuarios}</td>
                    <td>${profesor.nombre}</td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
