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

            function cargarAsignatura(id, nombre) {
                document.getElementById("idAsignatura").value = id;
                document.getElementById("nombreAsignatura").value = nombre;
            }
                 function cargarTarea (id, id2, nombre, fecha) {
                document.getElementById("idTarea").value = id;
                    document.getElementById("idAsignatura").value = id2;
                document.getElementById("nombre").value = nombre;
                    document.getElementById("fecha").value = fecha;
            }

            function borrar() {
                document.getElementById("accion").value = "borrar";
            }
            function cargar() {
                document.getElementById("accion").value = "cargar";
            }
                function asignar(){
                   document.getElementById("accion").value = "asignar";
                }
                    function modificar (){
                        document.getElementById("accion").value = "modificar";
                    }

        </script>
    </head>
    <body>
      <#include "menu.ftl">
        <div class="container">
            <div class="col-xs-8 col-xs-offset-2">
                <h1>Asignar Tareas</h1>
   <h3> <#if mensaje??>${mensaje}</#if></h3>
                <br>
                <br>
                <br>
                <form action="asignarTareas">
                   <table class="table-condensed" style="margin: auto">
                    <tr>
                            <td>
                                Tarea
                                <br>
                                <input type="hidden" id="idTarea" name="idTarea" size="1" value="<#if idAlu??>${idAlu}</#if>">
                                <input type="text" name="nombre" id="nombre" value="<#if nomAlu??>${nomAlu}</#if>">
                               <input type="datetime-local" name="fecha" id="fecha"><br>
                            </td>
                            <td>
                                ASIGNATURA
                                <br>
                                <input type="hidden" id="idAsignatura" name="idAsignatura" size="1" value="<#if idAsig??>${idAsig}</#if>">
                                <input type="text" name="nombreAsignatura" id="nombreAsignatura" value="<#if nomAsig??>${nomAsig}</#if>">
                            </td>
                                                      

                        </tr>
                        <tr>
                      
                            <td>
                                <br>
                                <input type="hidden" id="accion" name="accion" value="">
                                <button onclick="asignar()">Asignar</button>
                                <button onclick="modificar()">Modificar</button>
                                <button onclick="borrar()">Borrar</button>
                            </td>
                        </tr>
                    </table>
                    <br>
                    <br>
                                
                <table class="table table-striped">
                    
                    <#list asignaturas as asignatura>
                        <tr>
                            <td>${asignatura.idAsignaturas}</td>
                            <td>${asignatura.nombre}</td>
                            <td>
                        <input type="button" value="✔" 
                               onclick="cargarAsignatura('${asignatura.idAsignaturas}',
                                           '${asignatura.nombre}')
                                           "/>
                    </td> 
                        </tr>
                   </#list>
                </table>
            </div>
            
                            <table class="table table-striped">
                    
                    <#list tareas as tarea>
                        <tr>
                            <td>${tarea.idTareas}</td><td>${tarea.asignaturas_idAsignaturas}</td><td>${tarea.nombre}</td><td>${tarea.fecha}</td>
                           <td> <input type="button" value="✔" 
                               onclick="cargarTarea('${tarea.idTareas}',
                                           '${tarea.asignaturas_idAsignaturas}',
                                           '${tarea.nombre}',
                                           '${tarea.fecha}')
                                           "/>
                            </td>
                        </tr>
                   </#list>
                </table>
            </div>
            
  
       </div>
                </form>
                <br>

            </div>
        </div>

     

    
          <script src="assets/js/jquery-3.2.1.js"></script>
                  <script>
                function myFunction(id) {
                this.id = id;
                document.getElementById("op").value = id;
            }
            
    </script>

    </body>
</html>

