<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='../template/header.jsp'/>

<body>
<jsp:include page='../template/navbar.jsp'/>
	<div class="container">
	<h1>Categoria</h1>
			<hr>
	<h2>Crear categoria</h2>
			<div class="container-fluid">
		<form:form method="post" action="/categoria/crearCa" modelAttribute="Categoria">
			<form:label path="nombre">Nombre:</form:label>
			<form:input type="text" path="nombre"/>
			<br>
			<form:label path="descripcion">Descripcion:</form:label>
			<form:input type="text" path="descripcion"/>
			<br>
			
			<input type="button" value="Limpiar">
			<input type="submit" value="Submit">
		</form:form>
		<br>
		
		
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Nombre</th>
		      <th scope="col">Descripcion</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${listaCategoria}" var="categoria">
			    <tr>
			      <th scope="row">${categoria.getId()}</th>
			      <td>${categoria.getNombre()}</td>
			      <td>${categoria.getDescripcion()}</td>
			   
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>	
		
		
	</div>
		
	</div>
	<jsp:include page='../template/footer.jsp'/>
</body>

</html>