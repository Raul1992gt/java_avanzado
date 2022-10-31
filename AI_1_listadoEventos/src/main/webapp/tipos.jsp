<%@page import="modelo.beans.Tipo"%>
<%@page import="java.util.List"%>
<%@page import="modelo.daos.TipoDaoImpl"%>
<%@page import="modelo.daos.IntTipoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/estilos.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<% 
	IntTipoDao tdao = new TipoDaoImpl();
	List<Tipo> listaTipo = tdao.mostrarTodos();//(List<Evento>)request.getAttribute("eventos"); 
	String mensaje = (String)request.getAttribute("mensaje");
	%>
	
	<h1>Aplicación de Gestión de Tipos</h1>
	
	
	<h2>Listado de Tipos</h2>
	</br>
	
	<a href="home" class="enlaces-prinipales">Eventos</a><a href="obras.jsp" class="enlaces-prinipales">Usuarios</a>
	<a href="obras.jsp" class="enlaces-prinipales">Login</a><a href="obras.jsp" class="enlaces-prinipales">Registro</a><a href="obras.jsp" class="enlaces-prinipales">Salir</a>
	</br>
	</br>
	<h3><a href="FormAltaTipo.jsp" class="newEvento">Nuevo Tipo</a></h3>
	<table class="table">
	<tr>
		<th>Id</th>
		<th>Nombre</th>
		<th>Precio</th>
		<th colspan="3">Opciones</th>
	</tr>
	<%for (Tipo ele: listaTipo){ %>
	<tr>
		<td><%=ele.getIdTipo()%></td>
		<td><%=ele.getNombre()%></td>
		<td><a href="eventos?opcion=editar&id=<%=ele.getIdTipo()%>">Editar</a></td>
		<td><a href="eventos?opcion=eliminar&id=<%=ele.getIdTipo()%>">Eliminar</a></td>
		<td><a href="eventos?opcion=cancelar&id=<%=ele.getIdTipo()%>">Cancelar</a></td>
	</tr>
	<%} %>
	</table>
	
	<h3>No tiene funcionalidad</h3>
</body>
</html>