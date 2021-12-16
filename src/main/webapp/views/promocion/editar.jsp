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
			<h2><c:out value= "${promocion.getId() > 0 ? 'Modificar' : 'Crear'}"></c:out> Promoción</h2>
		</div>
		
		<form class="row" action="/star-wars-park/promocion/editar.do" method="post" id="formularioABM">
			<input type="hidden" name="id" value="${promocion.getId()}">
	
			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
					<span class="col-5 input-group-text" id="basic-addon1">Tipo promoción</span>
					<select name="tipoPromo" class="form-select">
						<c:forEach items="${tiposPromo}" var="tipo">
							<option value="<c:out value="${tipo.getTipo()}"></c:out>"><c:out value="${tipo.getTipo()}"></c:out></option>	
						</c:forEach>		
					</select>
				</div>
			</div>
	
			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
					<span class="col-5 input-group-text" id="basic-addon1">Tipo atracción</span>
					<select name="tipo" class="form-select">
						<c:forEach items="${tiposAtraccion}" var="tipo">
							<option value="<c:out value="${tipo.getTipo()}"></c:out>"><c:out value="${tipo.getTipo()}"></c:out></option>	
						</c:forEach>		
					</select>
				</div>
			</div>
			
			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
					<span class="col-5 input-group-text" id="basic-addon1">Atracciones</span>
					<select name=atraccion class="form-select" multiple data-mdb-placeholder="Example placeholder" multiple>
						<c:forEach items="${atracciones}" var="atraccion">
							<option value="<c:out value="${atraccion.getNombre()}"></c:out>"><c:out value="${atraccion.getNombre()}"></c:out></option>	
						</c:forEach>		
					</select>
				</div>
			</div>

			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
				  <span class="col-5 input-group-text" id="basic-addon1">Descuento</span>
				  	<input placeholder="Ingrese descuento" type="text" name ="descuento" class="form-control"
				  	value="${promocion.getDescuento() < 0 ? '' : promocion.getDescuento()}" onblur="validarNumero(this);">
				</div>
			</div>
			
			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
					<span class="col-5 input-group-text" id="basic-addon1">Atracción gratis</span>
					<select name="atraccionGratis" class="form-select">
						<c:forEach items="${atracciones}" var="atraccion">
							<option value="<c:out value="${atraccion.getId()}"></c:out>"><c:out value="${atraccion.getNombre()}"></c:out></option>	
						</c:forEach>		
					</select>
				</div>
			</div>
			
			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
				  <span class="col-5 input-group-text" id="basic-addon1">Costo total</span>
				  	<input placeholder="Ingrese costo total" type="text" name ="costoTotal" class="form-control" 
				  	value="${promocion.getCostoTotal() < 0 ? '' : promocion.getCostoTotal()}" onblur="validarNumero(this);">
				</div>
			</div>

			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
				  <span class="col-5 input-group-text" id="basic-addon1">Duración</span>
				  	<input placeholder="Ingrese duración en horas" type="text" name ="duracionTotal" class="form-control" 
				  	value="${promocion.getDuracionTotal() < 0 ? '' : promocion.getDuracionTotal()}" onblur="validarNumero(this);">
				</div>
			</div>


		</form>
			<br>
			<button class="btn btn-primary" onclick="enviarFormulario();">Guardar</button>
			<!--<a onclick="window.history.back();" class="btn btn-secondary" role="button">-->
			<a href="/star-wars-park/promocion/index.do" class="btn btn-secondary" role="button">
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
