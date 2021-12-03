<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='../template/header.jsp'/>

<body>
	<jsp:include page='../template/navbar.jsp'/>
	<div class="container">
	<h1>Usuarios</h1>
			<hr>
	<h2>Crear usuarios</h2>
	
		<br>
		<hr>
		<h2>Lista de usuarios</h2>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Nombre</th>
		      <th scope="col">Apellido</th>
		      <th scope="col">Email</th>
		      <th scope="col-2">Acciones</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${listaUsuarios}" var="usuario" >
			    <tr>
			      <th scope="row">${usuario.getId()}</th>
			      <td>${usuario.getNombre()}</td>
			      <td>${usuario.getApellido()}</td>
				  <td>${usuario.getEmail()}</td>
			      <td>
			      <a href="/usuario/${usuario.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button" target="_blank" >Editar</a>
			      </td>
			      <td>
				      <form action="/usuario/eliminar" method="get">
				      	<input type="hidden" name="id" value="${usuario.getId()}">
				      	<input class="btn btn-danger" type="submit" value="Eliminar">
				      </form>
			      </td>
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>
	</div>
	<jsp:include page='../template/footer.jsp'/>
</body>

</html>