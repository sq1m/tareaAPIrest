<h1 style="color: green">TareaAPI</h1>
<h2>Importante: </h2>
<p>Para ingresar o crear nuevos registros que contengan una llave foranea(id) se debe usar de la siguiente forma: 
<strong>Para crear un Comentario, por ejemplo:</strong> </p>

```JSON
{
    "texto": "Este es un comentario de ejemplo.",
    "fechaCreacion": "Septiembre 2023",
    "tarea": 1
    
}
```
<p>El id de la tarea a asignar(llave foranea) se ingresa tal cual está en el ejemplo.
De la forma "tarea": {valor}</p><br>

<p><strong>Para crear una Tarea, por ejemplo:</strong></p>

```JSON
{
  "titulo": "Bug",
  "descripcion": "Arreglar el bug del boton en index.html",
  "fechaVencimiento": "Septiembre 2023",
  "usuario": 1
}
```
<p>El id del comentario a asignar(llave foranea) se ingresa tal cual está en el ejemplo.
De la forma "comentario": {valor}</p><br>

<p><strong>Para crear un Usuario:</strong> </p>

```JSON
{
  "nombreUsuario": "Johnny",
  "email": "johnny@mail.com"
}
```

<h2>Notas:</h2>
<p>Para el endpoint de borrar(en todos los controllers) se ingresa con parametros.<br>
Por Ejemplo:<br><i>/api/usuario/borrar?id=7</i><br><br>
Y para los de editar se pasa el ID por el path.<br>
Por Ejemplo:<br>
<i>/api/usuario/editar/1</i></p>

<h3>Endpoints:</h3>
<h4>GET</h4>
<span>/api/usuario/lista</span><br>
<span>/api/comentario/lista</span><br>
<span>/api/tarea/lista</span><br><br>
<h4>POST</h4>
<span>/api/usuario/registrar</span><br>
<span>/api/comentario/registrar</span><br>
<span>/api/tarea/registrar</span><br><br>
<h4>PUT</h4>
<span>/api/usuario/editar/{id}</span><br>
<span>/api/comentario/editar/{id}</span><br>
<span>/api/tarea/editar/{id}</span><br><br>
<h4>DELETE</h4>
<span>/api/usuario/borrar?id=</span><br>
<span>/api/comentario/borrar?id=</span><br>
<span>/api/tarea/borrar?id=</span><br>





<h2 style="color: green">Objetos que ocupé:</h2>
<h3>ResponseEntity<?> : </h3>
<p>Lo ocupé para manejar mejor los errores de los métodos CRUD dentro de <strong>UsuarioServiceImpl, ComentarioServiceImpl, TareaServiceImpl</strong> en los casos en que se ingrese un ID inexistente dentro de la base de datos.</p>

<h3>Optional<?> :</h3>
<p>Ocupé este objeto para manejar los resultados Null dentro de los metodos CRUD en <strong>UsuarioServiceImpl, ComentarioServiceImpl, TareaServiceImpl</strong> al momento de ir a buscar dentro de la base de datos una tupla inexistente.</p>