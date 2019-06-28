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
  
  <!-- Estas evitan que la pagina deseada no se cargue en la cache y no pueda ser mostrada cuando se regresa atras. -->
  <meta http-equiv="Expires" CONTENT="0">
  <meta http-equiv="Cache-Control" CONTENT="no-cache">
  <meta http-equiv="Pragma" CONTENT="no-cache">

  <link href="css/Estilos.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<script language="JavaScript">
javascript:window.history.forward(0); //Esto es para cuando pulse al botón de Atrás
//javascript:window.history.back(1); //Esto para cuando pulse al botón de Adelante
</script>

</head>
<body background="img/${pregunta.imagen}" onload="Javascript:history.go(2);">


<script type="text/javascript">
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";//esta linea es necesaria para chrome
window.onhashchange=function(){window.location.hash="no-back-button";}
</script>
	

<div style="background: #d8d8d8;
    width: 120px;
    font-size: 29px;
    border-radius: 21px;
    border-style: ridge;display:block;float:left;margin-right:4px;"><img src="img/rendimiento.png" style="height:50px;width:50px;"><span style="text-align:center;font-size:30px;position: absolute;
    margin-top: 13px;
    margin-left: 7px;"><h4><b> ${rendimiento}</b></h4></span></div>&nbsp 

	
<div style="background: #d8d8d8;
    width: 120px;
    font-size: 29px;
    border-radius: 21px;
    border-style: ridge;display:block;float:left;margin-right:4px;">	<img src="img/estres.png" style="height:50px;width:50px;"><span style="text-align:center;font-size:30px;position: absolute;
    margin-top: 13px;
    margin-left: 7px;"><h4><b> ${estres}</b></h4></span></div>&nbsp 

	
<div style="background: #d8d8d8;
    width: 120px;
    font-size: 29px;
    border-radius: 21px;
    border-style: ridge;display:block;float:left;margin-right:4px;"><img src="img/social.png" style="height:50px;width:50px;"><span style="text-align:center;font-size:30px;position: absolute;
    margin-top: 13px;
    margin-left: 7px;"><h4><b>${social}</b></h4></span></div> &nbsp

<div style="background: #d8d8d8;
    width: 120px;
    font-size: 29px;
    border-radius: 21px;
    border-style: ridge;display:block;float:left;margin-right:4px;">	<img src="img/dinero.png" style="height:50px;width:50px;"><span style="text-align:center;font-size:30px;position: absolute;
    margin-top: 13px;
    margin-left: 7px;"><h4><b>${dinero}</b></h4></span></div>

	
	
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

	
<script> 
window.onbeforeunload = function () { 
   // Deshabilitar volver. 
} 
</script>	
	
</body>
</html>
