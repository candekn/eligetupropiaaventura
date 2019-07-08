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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">



</head>
<body background="img/SinDinero.jpg">
	
	
<section id="hero">
    <div class="hero-container">
      <div class="wow fadeIn">


<h2>Pensandolo bien, no tengo dinero suficiente para gastarlo en esto, mejor cambio de opinion</h2>

<p>QUE HAY: ${RespuestaSiguiente}</p>

<form:form modelAttribute="respuesta" action="mostrarRuta" method="Post">
	
	 <div class="actions" >
	<form:button type="submit" class="btn-services" name="id" path="id" id="id" value="${RespuestaSiguiente}" >Siguiente</form:button>
	</div>
	
</form:form>

</div>
    </div>
  </section>

	
	
	
</body>
</html>
