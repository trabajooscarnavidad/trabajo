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
        <script src="js/jquery-3.2.1.js"></script>
        <script>
            function registrar_alumno()
            {
                var alumno_nombre = document.getElementById("alumno_nombre").value;
                var alumno_pass = document.getElementById("alumno_pass").value;
                var alumno_email = document.getElementById("alumno_email").value;
                var alumno_fecha = document.getElementById("alumno_date").value;
                var alumno_mayor;
                
                if (document.getElementById("alumno_mayor").checked == true)
                {
                    alumno_mayor = 1;
                }
                else
                {
                    alumno_mayor = 0;
                }
                
                var datos = "alumno_nombre="+alumno_nombre+"&alumno_pass="+alumno_pass+"&alumno_email="+alumno_email+"&alumno_mayor="+alumno_mayor+"&alumno_date="+alumno_fecha+"&op=registrar_alumno";
                alert(datos);
                
                $.ajax({
                        type:'get',
                        url:'alumnos_profesores',
                        data:datos,
                        success:function(resp)
                        {
                           document.getElementById("espacio").innerHTML=resp;
                        }
                });
            }
        </script>
    </head>
    <body>
        <h2>Alumnos</h2>
        Nombre: <input type="text" id="alumno_nombre"><br>
        Contraseña <input type="password" id="alumno_pass"><br>
        Email: <input type="text" id="alumno_email"><br>
        Fecha nacimiento: <input type="date" id="alumno_date"><br>
        Mayor: <input type="checkbox" id="alumno_mayor"><br>
        <button onclick="registrar_alumno()" >Registrar</button>
        
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
        <br>
        <div id="espacio"></div>
    </body>
</html>
