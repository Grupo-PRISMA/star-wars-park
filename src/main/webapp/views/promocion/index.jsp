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

		<c:if test="${mensaje != null}">
			<div class="alert alert-success">
				<c:out value="${mensaje}" />
			</div>
			<c:remove var="mensaje" scope="session" />
		</c:if>
		
		<div class="bg-light p-4 mb-3 rounded">
			<h1>Promociones</h1>
		</div>

		<div class="mb-3">
			<a href="/star-wars-park/promocion/editar.do" class="btn btn-primary" role="button">
				<i class="bi bi-plus-lg"></i> Nueva Promoción
			</a>
		</div>
		
		<table id="lista" class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Tipo de promoción</th>
					<th>Pack</th>
					<th>Atracciones</th>
					<th>Descuento/Gratis</th>
					<th>Costo</th>
					<th>Duración</th>
					<th>Activo</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${promociones}" var="promocion">
					<tr>
						<td><c:out value="${promocion.getTipoPromo()}"></c:out></td>
						<td><c:out value="${promocion.getTipo()}"></c:out></td>
						<td><c:out value="${promocion.nombreAtracciones()}"></c:out></td>
						<td><c:out value="${promocion.getBonificacion()}"></c:out></td>
						<td><c:out value="${promocion.getCostoTotal()}"></c:out></td>
						<td><c:out value="${promocion.getDuracionTotal()}"></c:out></td>
						<td><c:out value="${promocion.isActivo() ? 'Si' : 'No'}"></c:out></td>
						<td>
							<a href="/star-wars-park/promocion/editar.do?id=${promocion.getId()}" class="btn btn-light rounded-0" role="button">
								<i class="bi bi-pencil-fill"></i>
							</a>
							<a href="/star-wars-park/promocion/borrar.do?id=${promocion.getId()}"
							class="btn btn-<c:out value="${promocion.isActivo() ? 'success' : 'danger'}"></c:out> rounded" role="button">
								<c:choose>
									<c:when test="${promocion.isActivo()}">
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
<script>
$(document).ready(function() {
    $('#lista').DataTable({language: {
    	"search":"Buscar:",
    	"lengthMenu": "Mostrar _MENU_",
    	"info": "Mostrando _START_ - _END_ de _TOTAL_",
    	"paginate": {
            "first":      "Primero",
            "last":       "Ultimo",
            "next":       "Siguiente",
            "previous":   "Anterior"
    	},
    	"emptyTable":     "No hay datos para mostrar",
    	"infoEmpty":      "Mostrando 0 - 0 de 0",
        "infoFiltered":   "(fitrados de _MAX_ elementos totales)",
        "zeroRecords":    "No matching records found",
    }});
} );
</script>

</body>
</html>