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
			<h2><c:out value= "${usuario.getId() > 0 ? 'Modificar' : 'Crear'}"></c:out> Usuario</h2>
		</div>
		<form class="row" action="/star-wars-park/usuario/editar.do" method="post" id="formularioABM" autocomplete="false">
			<input type="hidden" name="id" value="${usuario.getId()}">
			
			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
				  <span class="col-5 input-group-text" id="basic-addon1">Usuario</span>
				  	<c:if test="${usuario.getId() == 0}">
				  		<input autocomplete="false" placeholder="Ingrese usuario" type="text" name ="usuario" class="form-control" 
				  	aria-label="usuario" aria-describedby="basic-addon1" value="${usuario.getUsuario()}" 
				  	onblur="validarVacio(this);">
				 	</c:if>
					<c:if test="${usuario.getId() > 0}">
						<input type="text" class="form-control" value="${usuario.getUsuario()}" disabled="disabled">
						<input type="hidden" name="usuario" value="${usuario.getUsuario()}">
					</c:if>
				</div>
			</div>
		
			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
				  <span class="col-5 input-group-text" id="basic-addon1">Contraseña</span>
				  	<input placeholder="Ingrese contraseña" type="password" name ="clave" class="form-control" 
				  	aria-label="clave" aria-describedby="basic-addon1" value="">
				  	<!-- onblur="validarVacio(this);" -->
				</div>
			</div>

			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
				  <span class="col-5 input-group-text" id="basic-addon1">Nombre</span>
				  	<input placeholder="Ingrese nombre" type="text" name ="nombre" class="form-control" 
				  	aria-label="nombre" aria-describedby="basic-addon1" value="${usuario.getNombre()}" 
				  	onblur="validarVacio(this);">	
				</div>
			</div>

			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
					<span class="col-5 input-group-text" id="basic-addon1">Preferencia</span>
					<select name="preferencia" class="form-select">
						<c:forEach items="${tipos}" var="tipo">
							<option <c:if test="${usuario.getPreferencia().equals(tipo.getTipo())}"><c:out value="selected"/></c:if> 
							value="<c:out value="${tipo.getTipo()}"></c:out>"><c:out value="${tipo.getTipo()}"></c:out></option>	
						</c:forEach>		
					</select>
				</div>
			</div>

			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
				  <span class="col-5 input-group-text" id="basic-addon1">Presupuesto</span>
				  	<input placeholder="Ingrese presupuesto" type="text" name ="presupuesto" class="form-control" 
				  	value="${usuario.getPresupuesto() < 0 ? '' : usuario.getPresupuesto()}" onblur="validarNumero(this);">
				</div>
			</div>

			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
				  <span class="col-5 input-group-text" id="basic-addon1">Tiempo disponible</span>
				  	<input placeholder="Ingrese tiempo en horas" type="text" name ="tiempo" class="form-control" 
				  	value="${usuario.getTiempoDisponibleHs() < 0 ? '' : usuario.getTiempoDisponibleHs()}" onblur="validarNumero(this);">
				</div>
			</div>
			
			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
				  <span class="col-5 input-group-text" id="basic-addon1">Admin</span>
				  	<input style="width:1em; height:1em;" class="col-5" type="checkbox" name="admin" <c:if test="${usuario.isAdmin()}"><c:out value="checked"/></c:if>> 
				</div>
			</div> 
		</form>
			<br>
			<button class="btn btn-primary" onclick="enviarFormulario();">Guardar</button>
			<!--<a onclick="window.history.back();" class="btn btn-secondary" role="button">-->
			<a href="/star-wars-park/usuario/index.do" class="btn btn-secondary" role="button">
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