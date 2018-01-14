<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informe de alumnos</title>
    </head>
    <body>
        <#include "menu.ftl">
        <div style="margin-left:1%">
             <div class="col-xs-6 col-xs-offset-2" style="margin: 0%">
        <h1>Informe de alumnos</h1>
        <hr/>
        <h3>Todas las notas del alumno: <font color="red"><#if alumno??>${alumno}</#if></font> iniciado en sesión.</h3>
        (Si la tabla está vacia es que aun no hay notas puestas)
        <br><br>
        <table class="table table-striped">
            <tr><th>Asignatura</th><th>Nota</th></tr>
             <#list informe3 as informe3>
                <tr><td>${informe3.asignatura}</td><td>${informe3.nota}</td></tr>
           </#list>
        </table>
        </div>
            </div>
    </body>
</html>
