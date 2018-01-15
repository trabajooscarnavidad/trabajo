<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">

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
        <#include "menu.ftl">
        <div style="margin-left:1%">
             <div class="col-xs-6 col-xs-offset-2" style="margin: 0%">
        <h1>Lista de tareas:</h1>
        
        <hr/>
        <h3>Ver tareas del alumno: <font color="red"><#if alumno??>${alumno}</#if> </font></h3>
        
        <table class="table table-striped">
            <tr>
                <th>Tarea</th>
                <th>Fecha/hora de entrega</th>
                <th>Asignatura</th>
                <th>Marcar hecha</th>
                <th>Actualizar</th>
            </tr>
            <#list tareas as tareas>
                <tr>
                    <td>${tareas.tarea}</td>
                    <td>${tareas.fecha}</td>
                    <td>${tareas.asignatura}</td>               
                    <td><input type="checkbox" id="realizada" <#if tareas.realizada==true>checked</#if> /></td>
                    <td><button onclick="actualizar('${tareas.tareas_idTareas}', '${tareas.alumnos_idAlumnos}', '${tareas.tarea}', ${tareas.realizada?c})">Actualizar</button></td>
                </tr>
            </#list>
        </table>
        </div>
            </div>
    </body>
</html>
