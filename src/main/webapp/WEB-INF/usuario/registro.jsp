<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='../template/header.jsp'/>

<body>
	<div class="container">
	<h1>Usuarios</h1>
			<hr>
	<h2>Crear usuarios</h2>
	
		<form:form method="post" action="/usuario/registrar" modelAttribute="usuario">
			<input type="hidden" name="_method" value="put">
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
			<input type="submit" class="btn btn-primary" value="Registrar Usuario">
		</form:form>
	</div>
	<jsp:include page='../template/footer.jsp'/>
</body>

</html>