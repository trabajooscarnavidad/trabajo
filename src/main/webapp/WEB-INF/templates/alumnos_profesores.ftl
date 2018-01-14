<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">

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
                <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    
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
<#include "menu.ftl">
        <div style="margin-left:1%">
             <div class="col-xs-6 col-xs-offset-2" style="margin: 0%">
        <h2>REGISTRAR ALUMNOS/PROFESORES</h2>
        <hr/>
        <h2>Alumnos</h2>
        Nombre: <input type="text" id="alumno_nombre"><br>
        Contraseña <input type="password" id="alumno_pass"><br>
        Email: <input type="text" id="alumno_email"><br>
        Fecha nacimiento: <input type="date" id="alumno_date"><br>
        Mayor: <input type="checkbox" id="alumno_mayor"><br>
        <button onclick="registrar_alumno()" >Registrar</button><br><br>
        
        <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Id usuario</th>
                    <th>Nombre</th>
                    <th>Fecha</th>
                    <th>Mayor</th>
                </tr>
                                 
     
             <#list alumnos as alumno>
                <tr>
                    <td>${alumno.idAlumnos}</td>
                    <td>${alumno.usuarios_idUsuarios}</td>
                    <td>${alumno.nombre}</td>
                    <td>${alumno.fecha_nac}</td>
                    <td>${alumno.mayor}</td>
                </tr>
                </#list>

        </table>
        
        <br>
        <hr/>
        
        <h2>Profesores</h2>
        Nombre: <input type="text" id="profesor_nombre"><br>
        Contraseña <input type="password" id="profesor_pass"><br>
        Email: <input type="text" id="profesor_email"><br>
        <button onclick="registrar_profesor()" >Registrar</button><br>
        
        <br>
        
        <table class="table table-striped">   
                <tr>
                    <th>Id</th>
                    <th>Id usuario</th>
                    <th>Nombre</th>
                </tr>
            <#list profesores as profesor>
                <tr>
                    <td>${profesor.idProfesores}</td>
                    <td>${profesor.usuarios_idUsuarios}</td>
                    <td>${profesor.nombre}</td>
                </tr>
            </#list>
        </table>
        <br>
        <div id="espacio"></div>
        </div>
        </div>
    </body>
</html>
