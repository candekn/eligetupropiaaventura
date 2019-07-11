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
    
    <script>
    	if(history.forward(1) )
    	{
    		location.replace(history.forward(1))
    		
    	}
    </script>
    
  
    
</head>
<body>


<nav class="navbar navbar-expand-md navbar-light bg-light mb-4">
    <a class="navbar-brand" href="#">Título del juego</a>

    <div class="navbar">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <img src="img/rendimiento.png" class="estadisticas"> ${rendimiento}
            </li>
            <li class="nav-item">
                <img src="img/estres.png" class="estadisticas"> ${estres}
            </li>
            <li class="nav-item">
                <img src="img/social.png" class="estadisticas"> ${social}
            </li>
            <li class="nav-item">
                <img src="img/dinero.png" class="estadisticas"> ${dinero}
            </li>
        </ul>
    </div>
</nav>
   
<div class=row>

<div class="col-8 col-md-10">
<div class="container-fluid"  style="background-image: url('img/${imagenDeFondo}');
background-size:cover; background-position: center;
min-height: 450px">

<!-- El "container" contiene las fotos de los personajes q van apareciendo. Hay que agregarlos al modelo y hacer un foreach para
que aparezcan dependiendo la historia. Acá puse estos como ejemplo -->
        <div class="container"> <!-- Container -->
        <div class="row">
           
           <c:forEach items="${listaDePersonajes}" var="lP">
            <div class="col-3 col-md-4">
                <img src="img/${lP.nombre}" class="img-fluid imgp">
            </div>
            </c:forEach>
        </div>
	</div> <!-- /Container -->
    </div>
    
    <div class="card-text text-dark bg-light"
         style="padding: 30px">
         ${pregunta.textoDeLaPregunta}
        <div class="card-group justify-content-center" style="padding-top: 15px">
            <form:form modelAttribute="respuesta" action="mostrarRuta" method="Post">
				<c:forEach items="${listaR}" var="lR">
					<form:button type="submit" class="btn btn-dark" name="id" path="id" id="id" value="${lR.id}" >${lR.opcion}</form:button>
				</c:forEach> 
			</form:form>
        </div>
    </div>
</div>
	<div class="col-3 col-md-2 bg-light">
		<div class="container-fluid">
			<h2>Ranking</h2>
			<p>Mejores promedios</p>
			<ol>
	 		<c:forEach items="${ranking}" var="r">
				<li>${r.jugador.nombre} : ${r.nota}
			</c:forEach> 
			</ol>
		</div>
	</div>
</div>

</body>
</html>