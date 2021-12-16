<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<script src="../assets/js/validaciones.js" type="text/javascript"></script>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">

 		<div class="bg-light p-4 mb-3 rounded">
			<h2><c:out value= "${tipo_atraccion == null || tipo_atraccion == '' ? 'Crear' : 'Modificar'}"></c:out> Tipo de Promoción</h2>
		</div>
		
		<form class="row" action="/star-wars-park/tipo-promocion/editar.do" method="post" id="formularioABM">
			<input type="hidden" name="id" value="${tipo_promocion}">
			
		<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
				  <span class="col-4 input-group-text" id="basic-addon1">Tipo</span>
				  	<input placeholder="Ingrese tipo" type="text" name ="tipo" class="form-control" 
				  	value="${tipo_promocion}" onblur="validarVacio(this);">	
				</div>
		</div>
	
		</form>
		
		<br>
			<button class="btn btn-primary" onclick="enviarFormulario();">Guardar</button>
			<!--<a onclick="window.history.back();" class="btn btn-secondary" role="button">-->
			<a href="/star-wars-park/tipo-promocion/index.do" class="btn btn-secondary" role="button">
				Cancelar
			</a>
		<br><br>
		
		<c:if test="${errores.size() > 0}">
			<ul class="col-lg-5 alert alert-danger">
				<c:forEach items="${errores}" var="error">
					<li><c:out value="${error}"></c:out></li>
				</c:forEach>
			</ul>
		</c:if>
		<ul class="col-lg-5 alert alert-danger" id="mensajes_validacion" style="display: none;">
		</ul>

	</main>
</body>
</html>
