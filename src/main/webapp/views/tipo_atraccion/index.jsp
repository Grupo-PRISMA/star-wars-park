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
			<h1>Tipo de Atracción</h1>
		</div>

		<div class="mb-3">
			<a href="/star-wars-park/tipo-atraccion/editar.do" class="btn btn-primary" role="button">
				<i class="bi bi-plus-lg"></i> Nuevo Tipo de Atracción
			</a>
		</div>
		
		<table  id="lista" class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Tipo Atracción</th>
					<th>Activo</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tipo_atracciones}" var="tipo">
					<tr>
						<td><c:out value="${tipo.getTipo()}"></c:out></td>
						<td><c:out value="${tipo.isActivo() ? 'Si' : 'No'}"></c:out></td>
						<td>
							<a href="/star-wars-park/tipo-atraccion/editar.do?id=${tipo.getTipo()}" class="btn btn-light rounded-0" role="button">
								<i class="bi bi-pencil-fill"></i>
							</a>
							<span class="qform-check form-switch qbtn btn-lightd rounded-0">
								<input class="form-check-input" type="checkbox" onclick="cambiar('tipo-atraccion', '<c:out value="${tipo.getTipo()}"></c:out>')" <c:out value="${tipo.isActivo() ? 'checked' : ''}"></c:out>>
							</span>
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

function cambiar(entidad, id) {
	window.location = "/star-wars-park/" + entidad + "/borrar.do?id=" + id;
}
</script>

</body>
</html>