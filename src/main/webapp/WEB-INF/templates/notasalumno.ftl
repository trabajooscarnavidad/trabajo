<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/assets/css/style.css">
        <title>JSP Page</title>
        <script>
            function cargarAlumno(id, nombre) {
                document.getElementById("idAlumno").value = id;
                document.getElementById("nombreAlumno").value = nombre;
            }
            function cargarAsignatura(id, nombre) {
                document.getElementById("idAsignatura").value = id;
                document.getElementById("nombreAsignatura").value = nombre;
            }
                 function cargarCurso (id, nombre) {
                document.getElementById("idCurso").value = id;
                document.getElementById("nombreCurso").value = nombre;
            }
            function guardar() {
                document.getElementById("accion").value = "guardar";
            }
            function borrar() {
                document.getElementById("accion").value = "borrar";
            }
            function cargar() {
                document.getElementById("accion").value = "cargar";
            }

        </script>
    </head>
    <body>
      <#include "menu.ftl">
        <div class="container">
            <div class="col-xs-8 col-xs-offset-2">
                <h1>Notas</h1>

                <br>
                <br>
 <table border=1 cellspacing=0 cellpadding=2 bordercolor="666633">
              <tr>

                    <th>Materia</th>
                    <th>Nota</th>

                </tr>
                                 
     
             <#list notas as nota>
                  <tr>

                    <td>${nota.nombre}</td>
                    <td>${nota.nota}</td>  
                </tr>

                </#list>

        </table>
        
                <br>
                <h3><#if mensaje??>${mensaje}</#if></h3>
            </div>
        </div>
    </body>
</html>

