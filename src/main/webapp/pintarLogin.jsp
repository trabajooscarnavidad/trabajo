<%-- 
    Document   : login
    Created on : Nov 28, 2017, 10:43:51 AM
    Author     : ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="utils.Constantes" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function myFunction(id) {
                this.id = id;
                document.getElementById("op").value = id;

            }
            function myFunction2(id) {
                this.id = id;
                document.getElementById("op2").value = id;

            }
        </script>
    </head>
    <body>

        <h1>Login!</h1>
        <form action="login" name="formulario1" method="get" >
            <input type="hidden" name ="op" id="op" value="test1"/>
            Usuario  <input type="text" name="usuario" id="usuario" size="12"/>
            Password <input type="text" name="password" id="password" size="12"/>
            <button id="login" onclick="myFunction(id)">Login</button>              
        </form>
        <h1>Registro</h1>

        <form action="login" name="formulario2" method="get" >
            <input type="hidden" name ="op" id="op2" value="test2"/>
            Usuario  <input type="text" name="usuario" id="usuario" size="12"/>
            Password <input type="text" name="password" id="password" size="12"/>
            Email <input type="text" name="email" id="email" size="12"/>
            <br>

            <button id="registro" onclick="myFunction2(id)">Registro</button>     
            <br>
            <button id="desloguear" onclick="myFunction2(id)">Desloguear</button>   

        </form>
        <c:out value="${mensaje}"/>
        <br>
        Estas logeado?
        <c:out value = "${LOGIN}"/>
        <br>

    </body>

</html>
