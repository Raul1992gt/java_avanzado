<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Eventos</title>
<link href="css/estilos.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>Formulario Eventos</h1>
	<form action="eventos?opcion=alta" method="post">
	  <p>Id: <input type="text" name="id" size="10"></p>
	  <p>Nombre: <input type="text" name="nombre" size="40"></p>
	  <p>Descripcion: <input type="text" name="descrpcion" size="40"></p>
	  <p>Fecha de Inicio: <input type="date" name="fehcaInicio"></p>
	  <p>Duración: <input type="number" name="duracion"> (minutos)</p>
	  <p>Dirección: <input type="text" name="direccion"></p>
	  <p>Estado: 
	  <select name="estado">
	  		<option value="activo">Activo</option>
	  		<option value="cancelado">Cancelado</option>
	  </select>
	  </p>
	  <p>Destacado: 
	  		<input type="radio" name="destacado" value="s"> Destacado
    		<input type="radio" name="destacado" value="n"> No destacado
   	  </p>
      <p>Aforo máximo: <input type="number" name="aforoMaximo"></p>
      <p>Mínimo de asistencia: <input type="number" name="minAsistencia"></p>
      <p>Precio: <input type="number" name="precio"></p>
      <p>Tipo:
      	<select name="tipoEvento">
      		<option value="concierto">Concierto</option>
      		<option value="despedida">Despedida</option>
      		<option value="cumpleaños">Cumpleaños</option>
      		<option value="boda">Boda</option>
      	</select>
	  <p>
	    <input type="submit" value="Enviar">
	    <input type="reset" value="Borrar">
	  </p>
	</form>

	
	<p><a href="home" class="newEvento">Volver atrás</a></p>
	
	<br>
	<p>Muestro un formulario entero, pero los únicos datos <br>que vamos a rescatar son Id, Nombre y Precio</p>
</body>
</html>