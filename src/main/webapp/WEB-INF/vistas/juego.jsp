<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="utf-8">
  <title>Imperial Boootstrap Template</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

  <link href="css/Estilos.css" rel="stylesheet">

</head>
<body background="img/${pregunta.imagen}">

<p>Rendimiento: ${respuesta.rendimiento} </p>
<p>Social: ${respuesta.social} </p>
<p>Estres: ${respuesta.estres} </p>
<p>Dinero: ${respuesta.dinero} </p>

<section id="hero">
    <div class="hero-container">
      <div class="wow fadeIn">


<h2>${pregunta.textoDeLaPregunta}</h2>


<form:form modelAttribute="respuesta" action="mostrarRuta" method="Post">
	<c:forEach items="${listaR}" var="lR">
	 <div class="actions" >
	<form:button type="submit" class="btn-services" name="id" path="id" id="id" value="${lR.id}" >${lR.opcion}</form:button>
	</div>
	</c:forEach> 
</form:form>

</div>
    </div>
  </section>

</body>
</html>
