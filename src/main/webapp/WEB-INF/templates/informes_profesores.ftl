<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informe de profesores</title>
    </head>
    <body>
        <#include "menu.ftl">
           <div style="margin-left:1%">
             <div class="col-xs-6 col-xs-offset-2" style="margin: 0%">
        <h1>Informe de profesores</h1>
        <hr/>
        
        <form action="informes_profesores" method="get">
            
        <h3>Todas las notas de los alumnos del profesor: <font color="red"><#if profesor_seleccionado??>${profesor_seleccionado}</#if></font> en todas las asignaturas.</h3>
        (Si la tabla está vacia es que este profesor aun no tiene datos)
        <br><br>
        Selecciona profesor:
            <select name="profesor">
               <#list profesores as profesor>
                    <option value="${profesor.nombre}">${profesor.nombre}</option>
               </#list>
            </select>
        <br><br>
        
        <table  class="table table-striped">
            <tr><th>Asignatura</th><th>Alumno</th><th>Nota</th></tr>
            <#list informe1 as informe1>
                <tr><td>${informe1.asignatura}</td><td>${informe1.alumno}</td><td>${informe1.nota}</td></tr>
            </#list>
        </table>
        
        <hr/>
        <h3>Todas las notas de las asignaturas del curso: <font color="red"><#if curso_seleccionado??>${curso_seleccionado}</#if></font> con sus profesores.</h3>
        (Si la tabla está vacia es que este curso aun no tiene datos)
        <br><br>
        Selecciona curso:
            <select name="curso">
                 <#list cursos as curso>
                   <option value="${curso.nombre}">${curso.nombre}</option>
                </#list>
            </select>
        <br><br>
        
        <table class="table table-striped">
            <tr><th>Asignatura</th><th>Profesor</th><th>Alumno</th><th>Nota</th></tr>
             <#list informe2 as informe2>
                <tr><td>${informe2.asignatura}</td><td>${informe2.profesor}</td><td>${informe2.alumno}</td><td>${informe2.nota}</td></tr>
            </#list>
        </table>
        <br>
        <input type="submit" value="Consultar">
        </form>
        </div>
               </div>
    </body>
</html>
