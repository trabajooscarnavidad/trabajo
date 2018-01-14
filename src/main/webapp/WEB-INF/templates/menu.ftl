
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">

     
<nav class="navbar navbar-inverse bg-faded">
  <a class="navbar-brand" href="#">Logo</a>
  
    <ul class="nav navbar-nav">
        
                <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
            Alumnos
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/notasalumno">Notas</a></li>
            <li><a class="dropdown-item" href="/tareasalumno">Tareas</a></li>
            <li><a class="dropdown-item" href="/informes_alumnos">Informe Notas</a></li>
          </ul>
        </li>
        
             <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
            Profesores
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/notas">Notas</a></li>
            <li><a class="dropdown-item" href="/asignarTareas">Tareas</a></li>
            <li><a class="dropdown-item" href="/informes_profesores">Informes</a></li>

          </ul>
        </li>
        
        
        
      <li class="nav-item">
        <a class="nav-link" href="/alumnos_profesores">Admins</a>
        </li>
        
              <li class="nav-item">
        <a class="nav-link" href="/permisos">Superadmin</a>
        </li>

              <li class="nav-item">
        <a class="nav-link" href="/password">Cambiar Password</a>
        </li>
        <#if nombreUsuario??>
              <li class="nav-item">
         <span style="cursor: default" class="navbar-brand"><strong> ${nombreUsuario}<br></strong></span>
        </li>
        <#else>
          <li class="nav-item">
         <a class="nav-link" href="/users">Login</a>
        </li>
        </#if>
        

                 <li class="nav nav-item ">
         <a href="/users?accion=logout"><span class="glyphicon glyphicon-log-out"></span> Cerrar sesión</a>
        </li>
    </ul>
</nav>
<script src="assets/js/jquery-3.2.1.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
     
  