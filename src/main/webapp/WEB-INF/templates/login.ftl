<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">

<!DOCTYPE html>

<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/assets/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="/assets/css/form-elements.css">
        <link rel="stylesheet" href="/assets/css/style.css">

        <!-- Favicon and touch icons -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="/assets/ico/apple-touch-icon-57-precomposed.png">
        <#if nombreUsuario??>


    <br>
                               <#list permisos as permiso>
  
  <script>
             <#if permiso.permisos_idPermisos==3>
           location.href="/notasalumno";
               <#elseif permiso.permisos_idPermisos==2>
                   location.href="/notas";
                        <#elseif permiso.permisos_idPermisos==1>
                            location.href="/alumnos_profesores";
                             <#elseif permiso.permisos_idPermisos==999>
                                 location.href="/permisos";
                                     <#else>
               </#if>
                
                    
            </script>
            </#list>
      

        </#if>

        </head>
   <#include "menu.ftl">
    <body>
        <div class="top-content">
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>Bootstrap</strong> Login &amp; Register Forms</h1>
                            <div class="description">
                                <p>La magia de bootstrap</p>



                                <h1><strong><#if mensaje??>${mensaje}</#if></strong></h1>
                                <h3 style="color:white"><#if mensaje2??>${mensaje2}"></#if></h3>
                                </div>
                            </div>
                        </div>
                    <div class="row">
                        <div class="col-sm-5">
                            <div class="form-box">
                                <div class="form-top">
                                    <div class="form-top-left">
                                        <h3>Iniciar sesión</h3>
                                        <p>Introduce tus datos de inicio:</p>
                                        </div>
                                    <div class="form-top-right">
                                        <i class="fa fa-lock"></i>
                                        </div>
                                    </div>
                                <div class="form-bottom">
                                    <form role="form" action="users?accion=login" method="post" class="login-form">
                                        <div style="padding-bottom: 10px; margin-top: -15px">
                                            <span style="color:indianred;"><#if errorLogin??>${errorLogin}"></#if></span>
                                            </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="nombreLogin">Nombre de usuario</label>
                                            <input type="text" name="nombreLogin" placeholder="Nombre de usuario..." class="form-username form-control" id="nombreLogin">
                                            </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="passLogin">Contraseña</label>
                                            <input type="password" name="passLogin" placeholder="Contraseña..." class="form-password form-control" id="passLogin">
                                            </div>
                                        <button type="submit" class="btn">Log in</button>
                                        </form>
                                    </div>
                                </div>

                            </div>
                        <div class="col-sm-1 middle-border"></div>
                        <div class="col-sm-1"></div>
                        <div class="col-sm-5">
                            <div class="form-box">
                                <div class="form-top">
                                    <div class="form-top-left">
                                        <h3>Registrate ahora</h3>
                                        <p>Rellena los campos del formulario:</p>
                                        </div>
                                    <div class="form-top-right">
                                        <i class="fa fa-pencil"></i>
                                        </div>
                                    </div>
                                <div class="form-bottom">
                                    <form role="form" action="users?accion=registro" method="post" class="registration-form">
                                        <div style="padding-bottom: 10px; margin-top: -15px">
                                            <span style="color:indianred"><#if errorNombre??>${errorNombre}"></#if></span>
                                            </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="nombreRegistro">Nombre de usuario</label>
                                            <input type="text" name="nombreRegistro" placeholder="Nombre de usuario..." class="form-first-name form-control" id="nombreRegistro">
                                            </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="email">Email</label>
                                            <input type="text" name="emailRegistro" placeholder="Email..." class="form-email form-control" id="emailRegistro">
                                            </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="passRegistro">Cotraseña</label>
                                            <input type="password" name="passRegistro" placeholder="Contraseña..." class="form-password form-control" id="passRegistro">
                                            </div>
                                        <button class="btn">Regístrate</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                                                     <div class="col-sm-5">
                            <div class="form-box">
                                <div class="form-top">
                                    <div class="form-top-left">
                                        <h3>¿Olvidaste tu contraseña?</h3>
                                        <p>Introduce tu usuario y email</p>
                                    </div>
                                    <div class="form-top-right">
                                        <i class="fa fa-lock"></i>
                                    </div>
                                </div>
                            <div class="form-bottom">
                                    <form role="form" action="users?accion=recuperarPass" method="post" class="login-form">
                                        <div style="padding-bottom: 10px; margin-top: -15px">
                                            <span style="color:indianred;"><#if errorLogin??>${errorLogin}"></#if></span>
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="nombreLogin">Nombre de usuario</label>
                                            <input type="text" name="nombreLogin" placeholder="Nombre de usuario..." class="form-username form-control" id="nombreLogin">
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="passLogin">Email</label>
                                              <input type="text" name="emailRegistro" placeholder="Email..." class="form-email form-control" id="emailRegistro">
                                         </div>
                                        <button type="submit" class="btn">Recuperar contraseña</button>
                                    </form>
        </div>                            <div class="social-login">
                                <h3>...o inicia sesión con:</h3>
                                <div class="social-login-buttons">
                                    <a class="btn btn-link-2" href="#">
                                        <i class="fa fa-facebook"></i> Facebook
                                        </a>
                                    <a class="btn btn-link-2" href="#">
                                        <i class="fa fa-twitter"></i> Twitter
                                        </a>
                                    <a class="btn btn-link-2" href="#">
                                        <i class="fa fa-google-plus"></i> Google Plus
                                        </a>
                                    </div>
                                <p style="color:white; font-size: 12px">(No lo intentes. No funcionan)</p>
                                </div>
                    </div>
                </div>
            </div>
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 col-sm-offset-2">
                        <div class="footer-border"></div>
                        <p>Este formulario es una plantilla que me he descargado. No lo he hecho yo :(</p>
                        </div>
                    </div>
                </div>
            </footer>


      
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>

        </body>
    </html>
