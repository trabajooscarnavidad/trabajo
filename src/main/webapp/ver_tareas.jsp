<%-- 
    Document   : ver_tareas
    Created on : 14-ene-2018, 21:59:57
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
        <title>Ver tareas</title>
        <script src="assets/js/jquery-3.2.1.js"></script>
        <script>
            function actualizar(id_tarea, id_alumno, nombre_tarea, realizada)
            {
                
                
                if (realizada == true)
                {
                    realizada = 0;
                }
                else
                {
                    realizada = 1;
                }
                
                
                var datos = "id_tarea="+id_tarea+"&id_alumno="+id_alumno+"&realizada="+realizada+"&op=actualizar";
                
                $.ajax({
                        type:'get',
                        url:'tareas',
                        data:datos,
                        success:function(resp)
                        {
                           if (resp == 1)
                           {
                               alert("La tarea "+nombre_tarea+" se ha actualizado");
                           }
                           else
                           {
                               alert("Ha habido un fallo a la hora de actualizar");
                           }
                        }
                });
            }
        </script>
            
    </head>
    <body>
        <h1>Lista de tareas:</h1>
        
        <hr/>
        <h3>Ver tareas del alumno: <font color="red"><c:out value = "${alumno}"/>. </font></h3>
        
        <table border="1">
            <tr>
                <th>Tarea</th>
                <th>Fecha/hora de entrega</th>
                <th>Asignatura</th>
                <th>Marcar hecha</th>
                <th>Actualizar</th>
            </tr>
            <c:forEach items="${tareas}" var="tareas">
                <tr>
                    <td>${tareas.tarea}</td>
                    <td>${tareas.fecha}</td>
                    <td>${tareas.asignatura}</td>
                    <td><input type="checkbox" id="realizada" <c:if test="${tareas.realizada}" >checked</c:if> /></td>
                    <td><button onclick="actualizar('${tareas.tareas_idTareas}', '${tareas.alumnos_idAlumnos}', '${tareas.tarea}', ${tareas.realizada})">Actualizar</button></td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
