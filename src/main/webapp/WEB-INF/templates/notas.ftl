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
                function next(){
                   document.getElementById("accion").value = "next";
                }
                    function back (){
                        document.getElementById("accion").value = "back";
                    }

        </script>
    </head>
    <body>
      <#include "menu.ftl">
        <div class="container">
            <div class="col-xs-8 col-xs-offset-2">
                <h1>Notas</h1>

                <span>Alumno: </span>
                <select id="alumno" onchange="cargarAlumno(this.value, this.options[this.selectedIndex].innerHTML)">
                    <option disabled selected>Selecciona un alumno</option>
                    <option disabled>-------------------------</option>
        

                <#list alumnos as alumno>
                        <option value="${alumno.idAlumnos}" name="${alumno.nombre}">${alumno.nombre}</option>
                    </#list>	
                </select>
                <br>
                <span>Asignatura: </span>
                <select id="asignatura" onchange="cargarAsignatura(this.value, this.options[this.selectedIndex].innerHTML)">
                    <option disabled selected>Selecciona una asignatura</option>
                    <option disabled>-------------------------</option>
                     <#list asignaturas as asignatura>
                   <option value="${asignatura.idAsignaturas}" name="${asignatura.nombre}">${asignatura.nombre}</option>
                    </#list>
                   
                </select>
                <br>
        
                <br>
                <br>
                <br>
                <form action="notas">
                   <table class="table-condensed" style="margin: auto">
                    <tr>
                            <td>
                                ALUMNO
                                <br>
                                <input type="hidden" id="idAlumno" name="idAlumno" size="1" value="<#if idAlu??>${idAlu}</#if>">
                                <input type="text" name="nombreAlumno" id="nombreAlumno" value="<#if nomAlu??>${nomAlu}</#if>">
                            </td>
                            <td>
                                ASIGNATURA
                                <br>
                                <input type="hidden" id="idAsignatura" name="idAsignatura" size="1" value="<#if idAsig??>${idAsig}</#if>">
                                <input type="text" name="nombreAsignatura" id="nombreAsignatura" value="<#if nomAsig??>${nomAsig}</#if>">
                            </td>
                                                      
                            <td>
                                <br>
                                <button onclick="cargar()">Cargar</button>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br>
                                NOTA <input type="text" value="<#if nota??>${nota.nota}</#if>" id="nota" name="nota" size="1">
                            </td>
                            <td>
                                <br>
                                <input type="hidden" id="accion" name="accion" value="">
                                <button onclick="guardar()">Guardar</button>
                                <button onclick="borrar()">Borrar</button>
                            </td>
                        </tr>
                    </table>
                    <br>
                    <br>
                     <div class="col-xs-6 col-xs-offset-2" style="margin: 0%">
                         <p> Ejemplo paginacion </p>
                      <table class="table table-striped ">
                    <tr><td>id</td><td>nombre</td><td class="mt-1"></td></tr>
                    <#list alumnospaginados as alumnop>
                        <tr>
                            <td>${alumnop.idAlumnos}</td>
                            <td>${alumnop.nombre}</td>
                                                <td>
                        <input type="button" value="✔" 
                               onclick="cargarAlumno('${alumnop.idAlumnos}',
                                           '${alumnop.nombre}')
                                           "/>
                    </td> 
                            <#else><td colspan="3"><p>No hay mas alumnos vuelva atras!</p></td>   
                        </tr>
                   </#list>
                </table>
                       

                    
                     <input type="hidden" name="offset" value="<#if offset??>${offset}</#if>">
                     <input type="hidden" name="limit" value="2">
                                          
                            <button class="btn btn-default btn-sm" onclick="back()">
          <span class="glyphicon glyphicon-arrow-left"></span> Back
        </button>
                    
                            <button class="btn btn-default btn-sm" onclick="next()">
          <span class="glyphicon glyphicon-arrow-right"></span> Next
        </button>
       </div>
                </form>
                <br>
                <h3><#if mensaje??>${mensaje}</#if></h3>
            </div>
        </div>

     

    
          <script src="assets/js/jquery-3.2.1.js"></script>

    </body>
</html>

