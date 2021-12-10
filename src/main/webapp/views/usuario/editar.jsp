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
			<h2>Agregar / Modificar: Usuario</h2>
		</div>
		<form action="/star-wars-park/usuario/editar.do" method="post">
		<input type="hidden" name="id" value="${usuario.getId()}">
			
			
			Usuario <c:if test="${usuario.getId() == 0}"><input type="text" name="usuario" value="${usuario.getUsuario()}"></c:if> 
			<c:if test="${usuario.getId()== 1}"><c:out value= "${usuario.getUsuario()}"></c:out></c:if>
			
			<!-- 
			Usuario <c:out value= "${usuario.getUsuario()}"></c:out> 
			Usuario <input type="text" disabled="disabled" name="usuario" value="${usuario.getUsuario()}">
			-->
			<br>
			Contraseña <input type="text" name="clave" value="${usuario.getClave()}">
			<br>
			Nombre <input type="text" name="nombre" value="${usuario.getNombre()}">
			<br>
			Preferencia <select name="preferencia" >
			<c:forEach items="${tipos}" var="tipo">

				<option <c:if test="${usuario.getPreferencia().equals(tipo.getTipo())}"><c:out value="selected"/></c:if> 
				value="<c:out value="${tipo.getTipo()}"></c:out>"><c:out value="${tipo.getTipo()}"></c:out></option>	
				
			
			</c:forEach>		
			</select>

			<br>
			Presupuesto <input type="text" name="presupuesto" value="${usuario.getPresupuesto()}">
			<br>
			Tiempo disponible <input type="text" name="tiempo" value="${usuario.getTiempoDisponibleHs()}">
			<br>
			Admin <input type="checkbox" name="admin" <c:if test="${usuario.isAdmin()}"><c:out value="checked"/></c:if>> 
			<br>
			<button type="submit" class="btn btn-primary">Guardar</button>
			<a onclick="window.history.back();" class="btn btn-secondary" role="button">
				Cancelar
			</a>
		</form>
	</main>
</body>
</html>
