<%@page import="modelo.beans.Evento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Evento</title>
<link href="css/estilos.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<%Evento evento = (Evento)request.getAttribute("evento");%>
	
	<h2>Los datos del evento que has decidido editar son :</h2>
	
	<div>
		<p>Id : <%=evento.getIdEvento() %></p>
		</br>
		<p>Nombre : <%=evento.getNombre() %></p>
		</br>
		<p>Descripción : <%=evento.getDescripcion()%></p>
		</br>
		<p>Fecha de inicio: <%=evento.getFechaInicio() %></p>
		</br>
		<p>Duración : <%=evento.getDuracion() %></p>
		</br>
		<p>Dirección : <%=evento.getDireccion() %></p>
		</br>
		<p>Estado : <%=evento.getEstado() %></p>
		</br>
		<p>Destacado : <%=evento.getDestacado() %></p>
		</br>
		<p>Tipo : <%=evento.getTipo().getNombre() %></p>
	</div>
	</br>
	
	<h2><a href="home" class="newEvento">Volver a Eventos</a></h2>
</body>
</html>