<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">

<!--
		<c:if test="${attraction != null && !attraction.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al actualizar la atracción.</p>
			</div>
		</c:if>
 -->
 		<div class="bg-light p-4 mb-3 rounded">
			<h2>Agregar / Modificar: Tipo de Promoción</h2>
		</div>
		<form action="/star-wars-park/tipo-promocion/editar.do" method="post">
		<input type="hidden" name="id" value="${tipo_promocion}">
			Tipo <input type="text" name="nuevo" value="${tipo_promocion}">
			<button type="submit" class="btn btn-primary">Guardar</button>
			<a onclick="window.history.back();" class="btn btn-secondary" role="button">
				Cancelar
			</a>
		</form>
	</main>
</body>
</html>
