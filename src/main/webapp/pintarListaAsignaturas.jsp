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
        <title>JSP Page</title>
        <script>
            function cargarAsignatura(nombre) {
                document.getElementById("nombre").value = nombre;
                document.getElementById("insertar").disabled = true;
            }
            function accionInsertar() {
                document.getElementById("accion").value = "insertar";
            }
            
            function cargarCurso1(nombre1) {
                document.getElementById("nombre1").value = nombre1;
                document.getElementById("insertar1").disabled = true;
            }
            function accionInsertar1() {
                document.getElementById("accion").value = "insertar1";
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
                            <td><button onclick="ver_asignaturas($curso.idCursos)" ></button></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
