<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">

<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/assets/css/permisos.css">
        </head>
    <body>  
        <#include "menu.ftl">
    <#if content??>
        <div>${content}</div>
    <#else>
        <div>No content</div>
    </#if>
 <#if resultado??>
        <div>${resultado}</div>
    <#else>
        <div>No content</div>
    </#if>
        
       <form action="permisos" name="formulario1" method="get" >
          <input type="hidden" name ="op" id="op" value="test1"/>
  
          
            <div class="form_entry" style="float:right">
            <div class="msel-wrapper" title="Move items from list on the left to the right to choose." style="display: inline-block;float:">
                <div class="msel-from-wrapper" style="display: table-cell;">
                    <input class="msel-search" style="display: none;">
                    <select name="tablausuarios" multiple="multiple" size="10">
                        <optgroup label="Usuario sin alta">
                               <#list usuariosalt as usuariosalta>
     <option value="${usuariosalta.idUsuarios}">${usuariosalta.usuario}</option>
    </#list>	
                              </optgroup>
                        </select>
                    </div>
                <div class="msel-button-wrapper" style="display: none; vertical-align: middle;">
                    <button type="button" class="msel-button-promote" style="display: block;">&gt;&gt;</button>
                    <button type="button" class="msel-button-demote" style="display: block;">&lt;&lt;</button>
                    </div>
                <div class="msel-to-wrapper" style="display: none;">
                    <input class="msel-search" style="display: block;">
                    <select class="msel-selected" size="10" style="display: block; height: 100%;">
                        </select><div class="msel-payload">
                            </div>
                    </div>
                </div>
            </div>
          

        <div class="form_entry" style="float:right">
            
            <div class="msel-wrapper" title="Move items from list on the left to the right to choose." style="display: inline-block;">
                <div class="msel-from-wrapper" style="display: table-cell;">
                    <input class="msel-search" style="display: none;">
                    <select name="tablapermisos" multiple="multiple" size="10">
                        <optgroup label="Permisos">
                               <#list permisos as permiso>
     <option value="${permiso.idPermisos}">${permiso.valor}</option>
    </#list>	
                              </optgroup>
                        </select>
                    </div>
                <div class="msel-button-wrapper" style="display: none; vertical-align: middle;">
                    <button type="button" class="msel-button-promote" style="display: block;">&gt;&gt;</button>
                    <button type="button" class="msel-button-demote" style="display: block;">&lt;&lt;</button>
                    </div>
                <div class="msel-to-wrapper" style="display: none;">
                    <input class="msel-search" style="display: block;">
                    <select class="msel-selected" size="10" style="display: block; height: 100%;">
                        </select><div class="msel-payload">
                            </div>
                    </div>
                </div>
            </div>
        <div class="form_entry" style="float:right">
            
            <div class="msel-wrapper" title="Move items from list on the left to the right to choose." style="display: inline-block;">
                <div class="msel-from-wrapper" style="display: table-cell;">
                    <input class="msel-search" style="display: none;">
                    <select name="tablausuarios" multiple="multiple" size="10">
                        <optgroup label="Todos los Usuarios">
                               <#list usuarios as usuario>
     <option value="${usuario.idUsuarios}">${usuario.usuario}</option>
    </#list>	
                              </optgroup>

                        </select>
                    </div>
                <div class="msel-button-wrapper" style="display: none; vertical-align: middle;">
                    <button type="button" class="msel-button-promote" style="display: block;">&gt;&gt;</button>
                    <button type="button" class="msel-button-demote" style="display: block;">&lt;&lt;</button>
                    </div>
                <div class="msel-to-wrapper" style="display: none;">
                    <input class="msel-search" style="display: block;">
                    <select class="msel-selected" size="10" style="display: block; height: 100%;">
                        </select><div class="msel-payload">
                            </div>
                    </div>
                </div>
            </div>
          
       <!--third-->
             
        
          
  <button id="asociarpermisos" onclick="myFunction(id)">Asociar permisos</button><br><br>
    <button id="quitarpermisos" onclick="myFunction(id)">Quitar permisos</button>
      <!--<button id="dardealta" onclick="myFunction(id)">Dar de alta</button>-->     
        </form>
          <script src="assets/js/custom.js"></script>
        <script>
                function myFunction(id) {
                this.id = id;
                document.getElementById("op").value = id;

            }
            
    </script>
        </body>
    </html>
