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
        <h1>Informe de alumnos</h1>
        <hr/>
        <h3>Todas las notas del alumno: <font color="red"><#if alumno??>${alumno}</#if></font> iniciado en sesión.</h3>
        (Si la tabla está vacia es que aun no hay notas puestas)
        <br><br>
        <table  border=1 cellspacing=0 cellpadding=2 bordercolor="666633">
            <tr><th>Asignatura</th><th>Nota</th></tr>
             <#list informe3 as informe3>
                <tr><td>${informe3.asignatura}</td><td>${informe3.nota}</td></tr>
           </#list>
        </table>
    </body>
</html>
