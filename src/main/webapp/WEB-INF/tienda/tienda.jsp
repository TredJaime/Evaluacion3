<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='../template/header.jsp'/>

<body>
	
	<jsp:include page='../template/navbar.jsp'/>
		
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Nombre</th>
		      <th scope="col">Valor</th>
		      <th scope="col">Descripcion</th>
		       <th scope="col">Categoria</th>
		      <th scope="col">Cantidad</th>
		      <th scope="col">ID CATE</th>
		      <th scope="col">Buscar por categoria</th>
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
			      <td>${producto.getCategoria().getId()}</td>
				  <td>
				        <form action="/usuario/carrito" method="post">
				      	<input type="number" name="cantidad">
				      	<input type="submit" value="Agregar al carro">
				      </form>
				  </td>
				  
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>	
		
		<!-- TABLA BUSCAR -->
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Deporte</th>
		      <th scope="col">Pistola</th>
		      <th scope="col">auto</th>
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
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>	
		
		
		
		
		
		
		
		
	</div>
		

</body>
</html>