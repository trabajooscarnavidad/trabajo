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
        ${nombreUsuario}<br>

    <br>

    <script>
       // location.href="/sesion/alumnos";
        </script>
        </#if>

    </head>

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
                    <div class="col-sm-5" style="margin-left:30%">
                        <div class="form-box">
                            <div class="form-top">
                                <div class="form-top-left">
                                    <h3>Cambiar contraseña</h3>
                                    <p>Introduce los siguientes datos:</p>
                                    </div>
                                <div class="form-top-right">
                                    <i class="fa fa-lock"></i>
                                    </div>
                                </div>

                            <div class="form-bottom">
                                <form role="form" action="users?accion=cambiarPass" method="post" class="login-form">
                                    <div style="padding-bottom: 10px; margin-top: -15px">
                                        <span style="color:indianred;"><#if errorLogin??>${errorLogin}"></#if></span>
                                        </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="passLogin">Contraseña actual</label>
                                        <input type="password" name="passLogin" placeholder="Contraseña actual..." class="form-password form-control" id="passLogin">
                                        </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="passNueva">Nueva contraseña</label>
                                        <input type="password" name="passNueva" placeholder="Nueva contraseña..." class="form-password form-control" id="passLogin">
                                        </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="passNueva2">Repita la contraseña</label>
                                        <input type="password" name="passNueva2" placeholder="Repita la contraseña actual..." class="form-password form-control" id="passLogin">
                                        </div>

                                    <button type="submit" class="btn">Cambiar contraseña</button>
                                    </form>
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

                <script src="assets/js/jquery-1.11.1.min.js"></script>
                <script src="assets/bootstrap/js/bootstrap.min.js"></script>
                <script src="assets/js/jquery.backstretch.min.js"></script>
                <script src="assets/js/scripts.js"></script>

                </body>
                </html>
