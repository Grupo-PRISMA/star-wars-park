<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<body>

	<div class="col-lg-5 mx-auto p-3 py-md-5">

		<main>
			<h1>Star Wars Park</h1>

<%
if (request.getAttribute("mensaje") != null) {
%>
				<div class="alert alert-danger">
					<p><%= request.getAttribute("mensaje") %>
				</div>
<%	
}
%>
			<c:if test="${mensaje != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${mensaje}" />
					</p>
				</div>
			</c:if>

			<form action="/star-wars-park/login" method="post">

				<div class="mb-3">
					<label for="usuario" class="form-label">Usuario</label>
					<input class="form-control" name="usuario" value="admin">
				</div>

				<div class="mb-3">
					<label for="clave" class="form-label">Contraseña</label>
					<input type="password" class="form-control" name="clave" value="admin">
				</div>

				<div class="d-grid gap-2">
					<button type="submit" class="btn btn-lg btn-primary">Ingresar</button>
				</div>
			</form>

		</main>
	</div>
</body>
</html>