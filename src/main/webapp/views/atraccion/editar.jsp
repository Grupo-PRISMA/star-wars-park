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
			<h2><c:out value= "${atraccion.getId() > 0 ? 'Modificar' : 'Crear'}"></c:out> Atracción</h2>
		</div>
		<form class="row" action="/star-wars-park/atraccion/editar.do" method="post" id="formularioABM">
			<input type="hidden" name="id" value="${atraccion.getId()}">
			
			
		<!-- <div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
				  <span class="col-5 input-group-text" id="basic-addon1">Atracción</span>
				  	<c:if test="${atraccion.getId() == 0}">
				  		<input placeholder="Ingrese nombre" type="text" name ="atraccion" class="form-control" 
				  	aria-label="atraccion" aria-describedby="basic-addon1" value="${atraccion.getNombre()}" 
				  	onblur="validarVacio(this);">
				 	</c:if>
					<c:if test="${atraccion.getId() > 0}">
						<input type="text" class="form-control" value="${atraccion.getNombre()}" disabled="disabled">
						<input type="hidden" name="atraccion" value="${atraccion.getNombre()}">
					</c:if>
				</div>
			</div>
		 -->	
			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
				  <span class="col-5 input-group-text" id="basic-addon1">Nombre</span>
				  	<input placeholder="Ingrese nombre" type="text" name ="nombre" class="form-control" 
				  	aria-label="nombre" aria-describedby="basic-addon1" value="${atraccion.getNombre()}" 
				  	onblur="validarVacio(this);">	
				</div>
			</div>

			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
					<span class="col-5 input-group-text" id="basic-addon1">Tipo de atracción</span>
					<select name="tipo" class="form-select">
						<c:forEach items="${tipos}" var="tipo">
							<option <c:if test="${atraccion.getTipo().equals(tipo.getTipo())}"><c:out value="selected"/></c:if> 
							value="<c:out value="${tipo.getTipo()}"></c:out>"><c:out value="${tipo.getTipo()}"></c:out></option>	
						</c:forEach>		
					</select>
				</div>
			</div>

			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
				  <span class="col-5 input-group-text" id="basic-addon1">Costo</span>
				  	<input placeholder="Ingrese costo" type="text" name ="costo" class="form-control" 
				  	value="${atraccion.getCosto() < 0 ? '' : atraccion.getCosto()}" onblur="validarNumero(this);">
				</div>
			</div>

			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
				  <span class="col-5 input-group-text" id="basic-addon1">Duración</span>
				  	<input placeholder="Ingrese duración en horas" type="text" name ="duracion" class="form-control" 
				  	value="${atraccion.getDuracionHs() < 0 ? '' : atraccion.getDuracionHs()}" onblur="validarNumero(this);">
				</div>
			</div>
						<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
				  <span class="col-5 input-group-text" id="basic-addon1">Capacidad</span>
				  	<input placeholder="Ingrese capacidad" type="text" name ="cupo" class="form-control" 
				  	value="${atraccion.getCupoPersonas() < 0 ? '' : atraccion.getCupoPersonas()}" onblur="validarNumero(this);">
				</div>
			</div>

		</form>
			<br>
			<button class="btn btn-primary" onclick="enviarFormulario();">Guardar</button>
			<!--<a onclick="window.history.back();" class="btn btn-secondary" role="button">-->
			<a href="/star-wars-park/atraccion/index.do" class="btn btn-secondary" role="button">
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
