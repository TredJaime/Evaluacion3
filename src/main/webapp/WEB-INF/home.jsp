<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='template/header.jsp'/>

<body>
	<jsp:include page='template/navbar.jsp'/>
	<div class="container">
	<h1>Hola ${nombre_usuario} Bienvenido</h1>
	<hr>

	
	 <a href="<c:url value="/usuario/logout" />">Logout</a>
	
	
	
	
		
	</div>
	<jsp:include page='template/footer.jsp'/>
</body>

</html>