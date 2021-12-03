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
	<h2>Crear producto</h2>
	
		<div class="container-fluid">
		<form:form method="post" action="/producto/loginP" modelAttribute="producto">
			<form:label path="nombre">Nombre:</form:label>
			<form:input type="text" path="nombre"/>
			<br>
			<form:label path="valor">Valor:</form:label>
			<form:input type="number" path="valor"/>
			<br>
			<form:label path="descripcion">Descripcion:</form:label>
			<form:input type="text" path="descripcion"/>
			<br>
			<form:label path="categoria">Categoria:</form:label>
			<form:select class="form-select" path="categoria">
				<c:forEach var="categoria" items="${listaCategoria}">
					<form:option value="${categoria.getId()}">${categoria.getNombre()}</form:option>
				</c:forEach>
			</form:select>
			<br>
			<input type="submit" value="Submit">
		</form:form>
		<br>
		
		
		
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Nombre</th>
		      <th scope="col">Valor</th>
		      <th scope="col">Descripcion</th>
		       <th scope="col">Categoria</th>
		      <th scope="col">Acciones</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${listaProducto}" var="producto">
			    <tr>
			      <th scope="row">${producto.getId()}</th>
			      <td>${producto.getNombre()}</td>
			      <td>${producto.getValor()}</td>
			      <td>${producto.getDescripcion()}</td>
			      <td>${producto.getCategoria().getNombre()}</td>
			      <td>
			      <a href="/producto/${producto.getId()}/editarP" class="btn btn-primary" role="button" data-bs-toggle="button">Editar</a>
			
			      </td>
			      <td>
				      <form action="/producto/eliminarP" method="get">
				      	<input type="hidden" name="id" value="${producto.getId()}">
				      	<input type="submit" value="X">
				      </form>
			      </td>
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>	
		
		</div>
	</div>
	<jsp:include page='../template/footer.jsp'/>
</body>

</html>