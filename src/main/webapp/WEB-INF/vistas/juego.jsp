<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align:center">Elije tu propia aventura!!</h1>
	
	<hr>
	<p> ruta: ${ruta} </p>
	<p> opcion 1: ${opcion1} </p>
	<p> opcion 2: ${opcion2} </p>
	<p> dinero: ${dinero} </p>
	<p> Rendimiento: ${rendimiento} </p>
	<p> Social: ${social} </p>
	<p> Estres: ${estres} </p>
	
	<p style="text-align:center">${TextoHistoria}</p>
<form:form modelAtribute="respuesta" action="mostrarRuta" method="Post">
	<c:set var = "op" value="${opcion1}" />
	<c:set var = "var" value="no" />
	
	<c:choose>
	
	 <c:when test="${op==var}">
	  <input type="submit" name="respuesta" path="respuesta" value="${opcion3}"></"></input> 
	</c:when>
	
	<c:otherwise>
 	<input type="submit" name="respuesta" path="respuesta" value="${opcion1}"></input>
 	<input type="submit" name="respuesta" path="respuesta" value="${opcion2}"></input>
	</c:otherwise>
	
	</c:choose>

</form:form>	
</body>
</html>
