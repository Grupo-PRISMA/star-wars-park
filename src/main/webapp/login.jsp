<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<script src="assets/js/funciones.js"></script>
<link href="assets/css/login.css" rel="stylesheet">

<body class="imagenFondo">

	<div class="col-lg-5 mx-auto p-3 py-md-5">

		<div class="titulo">Star Wars Park</div>
		<main class="form-signin">
			<c:if test="${mensaje != null}">
				<div class="alert alert-<c:out value="${tipo}" />">
					<p><c:out value="${mensaje}" /></p>
				</div>
			</c:if>
			
		<form action="/star-wars-park/login" method="post">
		<div class="form-floating">
			<input class="form-control" name="usuario" value="admin">
			<label for="floatingInput">usuario</label>
			<div class="invalid-feedback">
	      	</div>
		</div>
		
		<div class="form-floating">
			<input type="password" class="form-control" name="clave" value="admin">
			<label for="floatingPassword">contraseña</label>
		</div>
		
		<div class="d-grid gap-2">
			<button type="submit" class="btn btn-lg btn-primary">ingresar </button>
		</div>

	
	</form>
</main>
		
		
		
	</div>
</body>
</html>