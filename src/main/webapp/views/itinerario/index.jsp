<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<link href="assets/css/estilo.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="/partials/nav.jsp"></jsp:include>
<br>
	<main class="container">
		<div class="id bg-light p-4 mb-3 rounded">
			<h1>itinerario</h1>
			
		</div>
	
		<table id="lista" class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Atracciones</th>
					<th>Costo Total</th>
					<th>Tiempo Total</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itinerario}" var="i">
					<tr>
						<td><c:out value="${i.getAtracciones()}"></c:out></td>
						<td><c:out value="${i.getCosto()}"></c:out></td>
						<td><c:out value="${i.getTiempo()}"></c:out></td>
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