<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Usuario::</title>
</head>

<body>
	<div class="container">
		<form:form method="post" action="/usuario/update/${usuario.id}" modelAttribute="usuario">
			
			<form:label path="nombre" class="col-sm-2 col-form-label">Nombre:</form:label>
			<form:input type="text" path="nombre" class="form-control"/>
			<br>
			<form:label path="apellido" class="col-sm-2 col-form-label">Apellido:</form:label>
			<form:input type="text" path="apellido" class="form-control"/>
			<br>
			<form:label path="rut" class="col-sm-2 col-form-label">RUT:</form:label>
			<form:input type="text" path="rut" class="form-control"/>
			<br>
			<form:label path="email" class="col-sm-2 col-form-label">Email</form:label>
			<form:input type="text" path="email" class="form-control"/>
			<br>
			<form:label path="password" class="col-sm-2 col-form-label">Password:</form:label>
			<form:input type="password" path="password" class="form-control"/>
			<br>
			<form:label path="passwordConfirmation" class="col-sm-2 col-form-label">Password Confirmation:</form:label>
			<form:input type="password" path="passwordConfirmation" class="form-control"/>
			<br>
			<input class="btn btn-warning" type="submit" value="editar">

		</form:form>
	</div>
</body>

</html>