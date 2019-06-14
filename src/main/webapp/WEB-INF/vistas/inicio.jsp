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
	<h1 style="text-align:center">Bienvenido ${nombre} !!</h1>
	
	<hr>
	
	<h2>Presentacion del juego</h2>
	<h2>Iniciar sesion/Registrarse</h2>
	<form:form modelAttribute="respuesta" action="mostrarRuta" method="Post">
	<form:input path="id" value="101" style="display:none" />
	<button type="submit">Jugar</button> 
	

</form:form>
</body>
</html>