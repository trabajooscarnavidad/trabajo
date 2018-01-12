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
        <style>
            td{
                padding : 3px;
            }
        </style>
        <title>Registro alumnos profesores</title>
        <script src="assets/js/jquery-3.2.1.js"></script>
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
            
            function registrar_profesor()
            {
                var profesor_nombre = document.getElementById("profesor_nombre").value;
                var profesor_pass = document.getElementById("profesor_pass").value;
                var profesor_email = document.getElementById("profesor_email").value;
                
                var datos = "profesor_nombre="+profesor_nombre+"&profesor_pass="+profesor_pass+"&profesor_email="+profesor_email+"&op=registrar_profesor";
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
        
        <h2>REGISTRAR ALUMNOS/PROFESORES</h2>
        <hr/>
        <h2>Alumnos</h2>
        Nombre: <input type="text" id="alumno_nombre"><br>
        Contraseña <input type="password" id="alumno_pass"><br>
        Email: <input type="text" id="alumno_email"><br>
        Fecha nacimiento: <input type="date" id="alumno_date"><br>
        Mayor: <input type="checkbox" id="alumno_mayor"><br>
        <button onclick="registrar_alumno()" >Registrar</button><br><br>
        
        <table border=1 cellspacing=0 cellpadding=2 bordercolor="666633">
                <tr>
                    <th>Id</th>
                    <th>Id usuario</th>
                    <th>Nombre</th>
                    <th>Fecha</th>
                    <th>Mayor</th>
                </tr>
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
        
        <br>
        <hr/>
        
        <h2>Profesores</h2>
        Nombre: <input type="text" id="profesor_nombre"><br>
        Contraseña <input type="password" id="profesor_pass"><br>
        Email: <input type="text" id="profesor_email"><br>
        <button onclick="registrar_profesor()" >Registrar</button><br>
        
        <br>
        
        <table border=1 cellspacing=0 cellpadding=2 bordercolor="666633">   
                <tr>
                    <th>Id</th>
                    <th>Id usuario</th>
                    <th>Nombre</th>
                </tr>
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
