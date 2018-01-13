<%-- 
    Document   : pintarListaAsignaturas
    Created on : 07-nov-2017, 9:44:08
    Author     : Miguel Angel Diaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/assets/css/style.css">
        <script src="js/jquery-3.2.1.js"></script>
        <title>JSP Page</title>
        <script>
            function cargarAsignatura(nombre) 
            {
                document.getElementById("nombre").value = nombre;
                document.getElementById("insertar").disabled = true;
            }
            function accionInsertar() 
            {
                document.getElementById("accion").value = "insertar";
            }
            
            function cargarCurso1(nombre1) 
            {
                document.getElementById("nombre1").value = nombre1;
                document.getElementById("insertar1").disabled = true;
            }
            
            function accionInsertar1() 
            {
                document.getElementById("accion").value = "insertar1";
            }
            
            function comprobar_union()
            {
                var asignatura = document.getElementById("select_asignaturas").value;
                var curso = document.getElementById("select_cursos").value;
                
                var datos = "asignatura="+asignatura+"&curso="+curso+"&accion=comprobar_union";
                
                $.ajax({
                        type:'get',
                        url:'asignaturas',
                        data:datos,
                        success:function(resp)
                        {
                           if (resp == 0)
                           {
                               var eleccion = confirm("Este curso y asignatura no están relacionados. quieres relacionarlos?");
                               if (eleccion == true)
                               {
                                   relacionar(asignatura, curso);
                               }
                           }
                           else
                           {
                               var eleccion = confirm("Este curso y asignatura están relacionados. quieres quitar esta relacion?");
                               if (eleccion == true)
                               {
                                   quitar_relacion(asignatura, curso);
                               }
                           }
                        }
                });
            }
            
            function comprobar_union2()
            {
                var asignatura = document.getElementById("select_asignaturas2").value;
                var profesor = document.getElementById("select_profesor").value;
                
                var datos = "asignatura2="+asignatura+"&profesor="+profesor+"&accion=comprobar_union2";
                
                $.ajax({
                        type:'get',
                        url:'asignaturas',
                        data:datos,
                        success:function(resp)
                        {
                           if (resp == 0)
                           {
                               var eleccion = confirm("Este profesor y asignatura no están relacionados. quieres relacionarlos?");
                               if (eleccion == true)
                               {
                                   relacionar2(asignatura, profesor);
                               }
                           }
                           else
                           {
                               var eleccion = confirm("Este profesor y asignatura están relacionados. quieres quitar esta relacion?");
                               if (eleccion == true)
                               {
                                   quitar_relacion2(asignatura, profesor);
                               }
                           }
                        }
                });
            }
            
            function relacionar(asignatura, curso)
            {
                var datos = "asignatura="+asignatura+"&curso="+curso+"&accion=relacionar";
                $.ajax({
                        type:'get',
                        url:'asignaturas',
                        data:datos,
                        success:function(resp)
                        {
                            if (resp != 0)
                            {
                                alert("Se han relacionado el curso y la asignatura");
                            }
                            else
                            {
                                alert("Ha habido un error, vete tú a saber que coño es");
                            }
                           
                        }
                });
            }
            
            function quitar_relacion(asignatura, curso)
            {
                var datos = "asignatura="+asignatura+"&curso="+curso+"&accion=quitar_relacion";
                $.ajax({
                        type:'get',
                        url:'asignaturas',
                        data:datos,
                        success:function(resp)
                        {
                            if (resp != 0)
                            {
                                alert("Se ha eliminado la relacion entres el curso y la asignatura");
                            }
                            else
                            {
                                alert("Ha habido un error, vete tú a saber que coño es");
                            }
                           
                        }
                });
            }
            
            function relacionar2(asignatura, profesor)
            {
                var datos = "asignatura="+asignatura+"&profesor="+profesor+"&accion=relacionar2";
                $.ajax({
                        type:'get',
                        url:'asignaturas',
                        data:datos,
                        success:function(resp)
                        {
                            if (resp != 0)
                            {
                                alert("Se han relacionado el profesor y la asignatura");
                            }
                            else
                            {
                                alert("Ha habido un error, vete tú a saber que coño es");
                            }
                           
                        }
                });
            }
            
            function quitar_relacion2(asignatura, profesor)
            {
                var datos = "asignatura="+asignatura+"&profesor="+profesor+"&accion=quitar_relacion2";
                $.ajax({
                        type:'get',
                        url:'asignaturas',
                        data:datos,
                        success:function(resp)
                        {
                            if (resp != 0)
                            {
                                alert("Se ha eliminado la relacion entre el profesor y la asignatura");
                            }
                            else
                            {
                                alert("Ha habido un error, vete tú a saber que coño es");
                            }
                           
                        }
                });
            }
            
            function ver_asignaturas (id, nombre)
            {
                var datos = "id="+id+"&accion=ver_asignaturas";
                $.ajax({
                        type:'get',
                        url:'asignaturas',
                        data:datos,
                        success:function(resp)
                        {
                           document.getElementById("espacio").innerHTML = "Las asignaturas de "+nombre+" son: "+resp;
                        }
                });
            }
            
            function ver_cursos (id, nombre)
            {
                var datos = "id="+id+"&accion=ver_cursos";
                $.ajax({
                        type:'get',
                        url:'asignaturas',
                        data:datos,
                        success:function(resp)
                        {
                           document.getElementById("espacio").innerHTML = "Los cursos de "+nombre+" son: "+resp;
                        }
                });
            }
            
            function ver_profesores (id, nombre)
            {
                var datos = "id="+id+"&accion=ver_profesores";
                $.ajax({
                        type:'get',
                        url:'asignaturas',
                        data:datos,
                        success:function(resp)
                        {
                           document.getElementById("espacio").innerHTML = "Los profesores de "+nombre+" son: "+resp;
                        }
                });
            }
        </script>
    </head>
    <body>
        <nav class="navbar navbar-inverse" style="border-radius: 0">
            <div class="container-fluid">
                <div style=" margin-right: 100px" class="navbar-header">
                    <span style="cursor: default" class="navbar-brand"><strong><c:out value="${nombreUsuario}"></c:out></strong></span>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="/sesion/alumnos">Alumnos</a></li>
                    <li class="active"><a style="cursor: default; pointer-events: none" href="#">Asignaturas</a></li>
                    <li><a href="/sesion/notas">Notas</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="/users?accion=logout"><span class="glyphicon glyphicon-log-out"></span> Cerrar sesión</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <div class="col-xs-6 col-xs-offset-2" style="margin: 0%">
                <h1>Asignaturas</h1>
                <form name="formulario" action="asignaturas">
                    <input type="text" id="nombre" name="nombre">
                    <input type="hidden" id="accion" name="accion">
                    <br>
                    <br>
                    <button id="insertar" onclick="accionInsertar()">Insertar</button>
                </form>
                <h3><c:out value="${mensaje}"></c:out></h3>
                <table class="table table-striped">
                    
                    <c:forEach items="${asignaturas}" var="asignatura">
                        <tr>
                            <td>${asignatura.nombre}</td>
                            <td><button onclick="ver_cursos(${asignatura.idAsignaturas}, '${asignatura.nombre}')" >Ver cursos</button></td>
                            <td><button onclick="ver_profesores(${asignatura.idAsignaturas}, '${asignatura.nombre}')" >Ver profesores</button></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            
                
                
            <div class="col-xs-6 col-xs-offset-2" style="margin: 0%">
                <h1>Cursos</h1>
                <form name="formulario" action="asignaturas">
                    <input type="hidden" id="accion" name="accion" value="insertar1">
                    <input type="text" id="nombre1" name="nombre1">
                    <br>
                    <br>
                    <input type="submit" valor="Insertar">
                </form>
                <h3><c:out value="${mensaje}"></c:out></h3>
                <table class="table table-striped">
                    <tr style="font-weight: bold">
                        
                    </tr>
                    <c:forEach items="${cursos}" var="curso">
                        <tr>
                            <td>${curso.nombre}</td>
                            <td><button onclick="ver_asignaturas(${curso.idCursos}, '${curso.nombre}')" >Ver asignaturas</button></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
                
            <hr/>
            
            
            <div id="espacio" class="col-xs-12 col-xs-offset-2" style="margin: 3%"></div>
            <div class="col-xs-12 col-xs-offset-2" style="margin: 3%">
                Relacion asignatura-curso: 
                <select id="select_asignaturas">
                    <c:forEach items="${asignaturas}" var="asignatura">
                        <option value="${asignatura.idAsignaturas}">${asignatura.nombre}</option>
                    </c:forEach>
                </select>
                <select id="select_cursos">
                    <c:forEach items="${cursos}" var="curso">
                        <option value="${curso.idCursos}">${curso.nombre}</option>
                    </c:forEach>
                </select>
                <button onclick="comprobar_union()">Comprobar</button>
            </div>
            <div class="col-xs-12 col-xs-offset-2" style="margin: 3%">
                Relacion asignatura-profesor: 
                <select id="select_asignaturas2">
                    <c:forEach items="${asignaturas}" var="asignatura">
                        <option value="${asignatura.idAsignaturas}">${asignatura.nombre}</option>
                    </c:forEach>
                </select>
                <select id="select_profesor">
                    <c:forEach items="${profesores}" var="profesor">
                        <option value="${profesor.idProfesores}">${profesor.nombre}</option>
                    </c:forEach>
                </select>
                <button onclick="comprobar_union2()">Comprobar</button>
            </div>
            <br>
            
            
            
        </div>
    </body>
</html>
