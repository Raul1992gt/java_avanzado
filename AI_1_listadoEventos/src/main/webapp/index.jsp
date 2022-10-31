<%@page import="modelo.daos.IntEventoDao"%>
<%@page import="modelo.daos.EventoDaoImpl"%>
<%@page import="modelo.beans.Evento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestión Eventos</title>
<link href="css/estilos.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<% 
	List<Evento> listaEvento = (List<Evento>)request.getAttribute("listaEventos"); 
	String mensaje = (String)request.getAttribute("mensaje");
	%>
	
	<h1>Aplicación de Gestión de Eventos</h1>
	
	<h2>Listado de Eventos Activos</h2>
	</br>
	
	<a href="#" class="enlaces-prinipales">Eventos</a><a href="tipos.jsp" class="enlaces-prinipales">Tipos</a><a href="obras.jsp" class="enlaces-prinipales">Usuarios</a>
	<a href="obras.jsp" class="enlaces-prinipales">Login</a><a href="obras.jsp" class="enlaces-prinipales">Registro</a><a href="obras.jsp" class="enlaces-prinipales">Salir</a>
	</br>
	
	<h3>Mensajes : <%= (mensaje!=null)?mensaje: ""%></h3>
	<h3><a href="FormAltaEvento.jsp" class="newEvento">Nuevo Evento</a></h3>
	<table class="table">
	<tr>
		<th>Id</th>
		<th>Nombre</th>
		<th>Precio</th>
		<th colspan="3">Opciones</th>
	</tr>
	<%for (Evento ele: listaEvento){ %>
	<tr>
		<td><%=ele.getIdEvento()%></td>
		<td><%=ele.getNombre()%></td>
		<td><%=ele.getPrecio()%></td>
		<td><a href="eventos?opcion=editar&id=<%=ele.getIdEvento()%>">Editar</a></td>
		<td><a href="eventos?opcion=eliminar&id=<%=ele.getIdEvento()%>">Eliminar</a></td>
		<td><a href="eventos?opcion=cancelar&id=<%=ele.getIdEvento()%>">Cancelar</a></td>
	</tr>
	<%} %>
	</table>
</body>
</html>