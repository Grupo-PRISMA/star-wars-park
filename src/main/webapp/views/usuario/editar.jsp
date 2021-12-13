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

<!--
		<c:if test="${attraction != null && !attraction.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al actualizar la atracción.</p>
			</div>
		</c:if>
 -->
 		<div class="bg-light p-4 mb-3 rounded">
			<h2><c:out value= "${usuario.getId() > 0 ? 'Modificar' : 'Crear'}"></c:out> Usuario</h2>
		</div>
		<form class="row" action="/star-wars-park/usuario/editar.do" method="post" id="formularioABM">
			<input type="hidden" name="id" value="${usuario.getId()}">
			
			
			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
				  <span class="col-4 input-group-text" id="basic-addon1">PRUEBA</span>
				  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
				</div>
			</div>
		
			<div class="mb-3 col-md-4 offset-md-3">
				<div class="input-group">
				  <span class="col-4 input-group-text" id="basic-addon1">PRUEBA22222</span>
				  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
				</div>
			</div>
				
			
			
			<div class="row" style="margin-top:2%">
            	<div class="col-md-3 offset-md-3">
					<label for="usuario" class="form-label">Usuario</label>
					<c:if test="${usuario.getId() == 0}">
						<input placeholder="Ingrese su nombre de usuario" type="text" name="usuario" value="${usuario.getUsuario()}" onblur="validarVacio(this);">
					</c:if>
					<c:if test="${usuario.getId() > 0}">
						<c:out value= "${usuario.getUsuario()}"></c:out>
						<input type="hidden" name="usuario" value="${usuario.getUsuario()}">
					</c:if>
				</div>
            </div>

			<div class="row" style="margin-top:1%">
            	<div class="col-md-3 offset-md-3">
					<label for="clave" class="form-label">Contraseña</label>
					<input type="text" name="clave" value="${usuario.getClave()}" onblur="validarVacio(this);">
				</div>
            </div>
			<br>
			Nombre <input type="text" name="nombre" value="${usuario.getNombre()}" onblur="validarVacio(this);">
			<br>
			Preferencia <select name="preferencia" >
			<c:forEach items="${tipos}" var="tipo">

				<option <c:if test="${usuario.getPreferencia().equals(tipo.getTipo())}"><c:out value="selected"/></c:if> 
				value="<c:out value="${tipo.getTipo()}"></c:out>"><c:out value="${tipo.getTipo()}"></c:out></option>	
				
			
			</c:forEach>		
			</select>

			<br>
			Presupuesto <input type="text" name="presupuesto" value="${usuario.getPresupuesto() < 0 ? '' : usuario.getPresupuesto()}" onblur="validarNumero(this);">
			<br>
			Tiempo disponible <input type="text" name="tiempo" value="${usuario.getTiempoDisponibleHs() < 0 ? '' : usuario.getTiempoDisponibleHs()}" onblur="validarNumero(this);">
			<br>
			Admin <input type="checkbox" name="admin" <c:if test="${usuario.isAdmin()}"><c:out value="checked"/></c:if>> 
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
