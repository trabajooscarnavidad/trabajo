<%-- 
    Document   : asociacion
    Created on : 08-ene-2018, 19:02:45
    Author     : Samu
--%>

<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">

<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            .hidden {display:none;}
body {
    padding:2ex 0;
    margin:0px auto;
    font-family:"Lucida Grande", Tahoma, Verdana, sans-serif;
    line-height:1.25em;
    display: table;
    min-width: 100%;
}
a img {
    border: none;
}

input, select {
    font-size:1em;
    padding:0.15em
}
.form_entry input[type="text"], input[type="email"], input[type="date"], input[type="time"], .form_entry input[type="password"], .form_entry select {
    min-width:15em;
    padding:0.15em}
.form_entry input.race_text, .form_entry input.small, .form_entry select.small {
    min-width:3em;
    width: auto;
}

div.form_entry {margin-bottom:1em;}
div.form_entry * {vertical-align:top;}

.form_h {display:inline-block;zoom:1;*display:inline;width:5em;text-align:right;margin-right:1em;font-weight:bold;color:#5b6065;vertical-align:top;}
.form_b {display:inline-block;zoom:1;*display:inline;vertical-align:top;margin-left:1em;}

.msel-wrapper select {
    width: 40ex;
}

.msel-wrapper {
    border: 1px solid #CCCCCC;
    border-radius: 0.5ex 0.5ex 0.5ex 0.5ex;
    padding: 1ex;
    background: #eee;
}

.msel-search {
    width: 98%;
}

.msel-button-promote, .msel-button-demote {
    border-radius: 0.5ex 0.5ex 0.5ex 0.5ex;
    border-width: 1px;
    font-family: sans-serif;
    font-size: 10pt;
    margin: 1ex;
    padding: 0.5ex 0;
}

noscript p {
    background-color: #F1CB5E;
    background-image: url("imp.png");
    background-position: -2em -1em;
    background-repeat: no-repeat;
    border: 3px double #FFA500;
    margin: 1em 3em;
    padding: 1em 1em 1em 5em;
}
            </style>
        </head>
    <body>  
    <#if content??>
        <div>${content}</div>
    <#else>
        <div>No content</div>
    </#if>

   
      <form action="permisos" name="formulario1" method="get" >
          <input type="hidden" name ="op" id="op" value="test1"/>
        <div class="form_entry">
            
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
            

        <div class="form_entry">
            
            <div class="msel-wrapper" title="Move items from list on the left to the right to choose." style="display: inline-block;">
                <div class="msel-from-wrapper" style="display: table-cell;">
                    <input class="msel-search" style="display: none;">
                    <select name="tablausuarios" multiple="multiple" size="10">
                        <optgroup label="Usuarios">
                               <#list usuarios as usuario>
     <option value="${usuario.idUsuarios}">${usuario.usuario}</option>
    </#list>	
                              </optgroup>
                        <optgroup label="Usuarios sin alta">
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
          
       <!--third-->
             
        <div class="form_entry">
            <div class="msel-wrapper" title="Move items from list on the left to the right to choose." style="display: inline-block;">
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
          
          
  <button id="asociarpermisos" onclick="myFunction(id)">Asociar permisos</button>
    <button id="quitarpermisos" onclick="myFunction(id)">Quitar permisos</button>
      <button id="dardealta" onclick="myFunction(id)">Dar de alta</button>     
        </form>
        <script>
                function myFunction(id) {
                this.id = id;
                document.getElementById("op").value = id;

            }
            
            
            /**
 * Make more useful form objects out of multiple-selects
 *
 * @author OpenWeb Solutions, LLC
 */

function OWSMultSelect(elem) {
    if (!(elem instanceof HTMLSelectElement) || !elem.multiple)
        return;

    var myObj = this;

    this.name = elem.name;
    this.fromElement = elem;
    this.fromElement.name = "";
    this.fromElement.ondblclick = function(evt) {
        myObj.promoteSelected();
    };
    var w = document.createElement("div");
    w.setAttribute("class", "msel-wrapper");
    w.setAttribute("title", "Move items from list on the left to the right to choose.");
    w.style.display = "inline-block";
    this.fromElement.parentNode.insertBefore(w, this.fromElement);

    // First cell
    var c = document.createElement("div");
    c.setAttribute("class", "msel-from-wrapper");
    c.style.display = "table-cell";
    w.appendChild(c);

    this.fromSearch = document.createElement("input");
    this.fromSearch.setAttribute("class", "msel-search");
    this.fromSearch.style.display = "block";
    this.fromSearch.onkeyup = function(evt) {
        myObj.performFromSearch();
    };
    c.appendChild(this.fromSearch);
    c.appendChild(this.fromElement);

    // Button cell
    c = document.createElement("div");
    c.setAttribute("class", "msel-button-wrapper");
    c.style.display = "table-cell";
    c.style.verticalAlign = "middle";
    w.appendChild(c);

    var b = document.createElement("button");
    b.setAttribute("type", "button");
    b.setAttribute("class", "msel-button-promote");
    b.style.display = "block";
    b.appendChild(document.createTextNode(">>"));
    b.onclick = function(evt) {
        myObj.promoteSelected();
    };
    c.appendChild(b);

    b = document.createElement("button");
    b.setAttribute("type", "button");
    b.setAttribute("class", "msel-button-demote");
    b.style.display = "block";
    b.appendChild(document.createTextNode("<<"));
    b.onclick = function(evt) {
        myObj.demoteSelected();
    };
    c.appendChild(b);

    // Results cell
    c = document.createElement("div");
    c.setAttribute("class", "msel-to-wrapper");
    c.style.display = "table-cell";
    w.appendChild(c);

    this.toSearch = document.createElement("input");
    this.toSearch.setAttribute("class", "msel-search");
    this.toSearch.style.display = "block";
    this.toSearch.onkeyup = function(evt) {
        myObj.performToSearch();
    };
    c.appendChild(this.toSearch);

    this.toElement = document.createElement("select");
    this.toElement.setAttribute("class", "msel-selected");
    this.toElement.style.display = "block";
    this.toElement.style.height = "100%";
    this.toElement.style.width = this.fromElement.innerWidth + "px";
    this.toElement.setAttribute("size", this.fromElement.getAttribute("size"));
    this.toElement.ondblclick = function(evt) {
        myObj.demoteSelected();
    };
    c.appendChild(this.toElement);

    // Hidden Elements
    this.payload = document.createElement("div");
    this.payload.setAttribute("class", "msel-payload");
    c.appendChild(this.payload);

    this.payloadMap = {};
    this.fromMap = {};

    // Load any existing ones
    this.promoteSelected();
}

OWSMultSelect.prototype.performFromSearch = function() {
    var term = this.fromSearch.value.trim();
    var re = null;
    if (term.length > 0)
        re = new RegExp(term, "i");
    for (var i = 0; i < this.fromElement.length; i++) {
        var opt = this.fromElement.item(i);
        if (re !== null && !re.test(opt.childNodes[0].nodeValue)) {
            opt.style.display = "none";
        }
        else if (!opt.selected) {
            opt.style.display = "";
        }
    }
};

OWSMultSelect.prototype.performToSearch = function() {
    var term = this.toSearch.value.trim();
    var re = null;
    if (term.length > 0)
        re = new RegExp(term, "i");
    for (var i = 0; i < this.toElement.length; i++) {
        var opt = this.toElement.item(i);
        if (re !== null && !re.test(opt.childNodes[0].nodeValue)) {
            opt.style.display = "none";
        }
        else if (!("mselChosen" in opt.dataset) || opt.dataset.mselChosen != "1") {
            opt.style.display = "";
        }
    }
};

OWSMultSelect.prototype.promoteSelected = function() {
    for (var i = 0; i < this.fromElement.length; i++) {
        var opt = this.fromElement.item(i);
        if (opt.selected) {
            if (!("mselChosen" in opt.dataset) || opt.dataset.mselChosen != "1") {
                this.toElement.appendChild(opt.cloneNode(true));
                opt.dataset.mselChosen = "1";
                opt.style.display = "none";
                var c = document.createElement("input");
                c.type = "hidden";
                c.name = this.name;
                c.value = opt.value;
                this.payload.appendChild(c);
                this.payloadMap[opt.value] = c;
                this.fromMap[opt.value] = opt;
            }
        }
    }
};

OWSMultSelect.prototype.demoteSelected = function() {
    for (var i = 0; i < this.toElement.length; i++) {
        var opt = this.toElement.item(i);
        if (opt.selected) {
            this.toElement.removeChild(opt);
            this.payload.removeChild(this.payloadMap[opt.value]);
            this.fromMap[opt.value].dataset.mselChosen = "0";
            this.fromMap[opt.value].style.display = "";
        }
    }
};



window.addEventListener('load', function(evt) {
    var selects = document.getElementsByTagName("select");
    for (var i = 0; i < selects.length; i++) {
        if (selects[i].multiple)
            new OWSMultSelect(selects[i]);
    }
}, false);
    </script>
        </body>
    </html>

