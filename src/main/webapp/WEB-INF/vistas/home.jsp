<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="css/style.css" type="text/css" rel="stylesheet">
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <title>Inicio</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light bg-light mb-4">
    <a class="navbar-brand" href="#">Título del juego</a>
</nav>
<div class="container-fluid" style="background-image: url('img/inicio.jpg')">
    <h1 class="text-center card-title bg-light">Bienvenido a Elige tu propia aventura</h1>
       <c:if test="${not empty error}">
			        <div class="alert-warning"><span>${error}</span></div>
			        <br>
		        </c:if>
    <div class="row">
        <div class="col-12 col-md-6">
            <div class="container-fluid bordes">
                <form:form class="form-check" modelAttribute="jugador" method="post" action="registro">
                    <h3 class="text-center">Registrarse</h3>
               
                    <div class="form-group">
                        <label>Nombre: </label>
                        <form:input class="form-control" type="text" path="nombre" />
                    </div>
                    <div class="form-group">
                        <label>Email:</label>
                        <form:input class="form-control" type="email" path="email" />
                    </div>
                    <div class="form-group">
                        <label>Contraseña: </label>
                        <form:input class="form-control" type="password" path="password" />
                    </div>
                    <div class="form-group">
                        <label>Repita la contraseña: </label>
                        <input class="form-control" type="password" id="pass2" name="pass2">
                    </div>
                    <div class="form-group">
                        <form:button type="submit" class="btn btn-dark">Registrarme</form:button>
                        <form:button type="reset" class="btn btn-dark">Cancelar</form:button>
                    </div>
                </form:form>
            </div>

        </div> <!--/primer col registro-->
        <div class="col-12 col-md-6">
            <div class="container-fluid bordes">
                <form:form class="form-check" modelAttribute="jugador" method="post" action="validar-login">
                    <h3 class="text-center">Ingresar</h3>
                    <div class="form-group">
                        <label>Email:</label>
                        <form:input class="form-control" type="email" path="email" />
                    </div>
                    <div class="form-group">
                        <label>Contraseña:</label>
                        <form:input class="form-control" type="password" path="password" />
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-dark">Ingresar</button>
                        <button type="reset" class="btn btn-dark">Cancelar</button>
                    </div>
                </form:form>
            </div>
        </div> <!--/segundo registro ingreso-->
    </div> <!--/row-->
 
</div>


</body>
</html>