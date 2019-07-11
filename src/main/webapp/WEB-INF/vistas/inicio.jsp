<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Elige tu propia aventura</title>
    <link href="css/style.css" type="text/css" rel="stylesheet">
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
       
  
    
</head>
<body>
<div class="container-fluid" style="background-image: url('img/Entrada.jpg'); background-size:cover; background-position: center; 
min-height: 450px">
<nav class="navbar navbar-expand-md navbar-light bg-light mb-4">
    <a class="navbar-brand" href="#">Título del juego</a>
</nav>
	<h1 class="text-center">Bienvenidx ${jugador.nombre} </h1>
	  <c:if test="${not empty jugador.puntaje}">
			        <h3 class="text-center">Tu puntaje hasta el momento es: ${jugador.puntaje}</h3>
			        <br>
		        </c:if>
	<c:if test="${ empty jugador.puntaje }">
		<h3 class="text-center">¡Aún no tienes puntaje! Juega para conseguir puntos</h3>
	</c:if>
	<div class="row justify-content-center">
		<form:form modelAttribute="respuesta" action="mostrarRuta" method="Post">
			<form:input path="id" value="100" style="display:none" />
			<button class="btn btn-dark" type="submit">Jugar</button> 
		</form:form>
		
	</div>
	
</div>
	
	


</body>
</html>
