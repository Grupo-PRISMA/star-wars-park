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

		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${errors != null}">
						<ul>
							<c:forEach items="${errors}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>

		<div class="bg-light p-4 mb-3 rounded">
			<h1>Usuario</h1>
		</div>

		<div class="mb-3">
			<a href="/star-wars-park/usuario/editar.do" class="btn btn-primary" role="button">
				<i class="bi bi-plus-lg"></i> Nuevo Usuario
			</a>
		</div>
		
		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Usuario</th>
					<th>Nombre</th>
					<th>Preferencia</th>
					<th>Presupuesto</th>
					<th>Tiempo disponible</th>
					<th>Admin</th>
					<th>Activo</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td><c:out value="${usuario.getUsuario()}"></c:out></td>
						<td><c:out value="${usuario.getNombre()}"></c:out></td>
						<td><c:out value="${usuario.getPreferencia()}"></c:out></td>
						<td><c:out value="${usuario.getPresupuesto()}"></c:out></td>
						<td><c:out value="${usuario.getTiempoDisponibleHs()}"></c:out></td>
						<td><c:out value="${usuario.isAdmin() ? 'Si' : 'No'}"></c:out></td>
						<td><c:out value="${usuario.isActivo() ? 'Si' : 'No'}"></c:out></td>
						<td>
							<a href="/star-wars-park/usuario/editar.do?id=${usuario.getId()}" class="btn btn-light rounded-0" role="button">
								<i class="bi bi-pencil-fill"></i>
							</a>
							<a href="/star-wars-park/usuario/borrar.do?id=${usuario.getId()}"
							class="btn btn-<c:out value="${usuario.isActivo() ? 'success' : 'danger'}"></c:out> rounded" role="button">
								<c:choose>
									<c:when test="${usuario.isActivo()}">
										<i class="bi bi-check"></i>
									</c:when>
									<c:otherwise>
										<i class="bi bi-x-circle-fill"></i>
									</c:otherwise>
								</c:choose>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</main>

</body>
</html>