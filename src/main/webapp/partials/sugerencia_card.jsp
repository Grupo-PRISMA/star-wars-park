<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<link href="assets/css/estilo.css" rel="stylesheet">
</head>

<body class="imagenFondo">
<!-- sugerencias representa atracciones y promociones -->
<c:set var="sugerencias" value="${requestScope.sugerencias}" scope="page"></c:set>
<c:set var="mostrar_encabezado" value="${Boolean.parseBoolean(requestScope.mostrar_encabezado)}" scope="page"></c:set>
<c:set var="tipo" value="${requestScope.tipo}" scope="page"></c:set>
<c:set var="elementos_deshabilitados" value="${requestScope.elementos_deshabilitados}" scope="page"></c:set>
<c:set var="elementos_comprados" value="${requestScope.elementos_comprados}" scope="page"></c:set>

<div class="row row-cols-5 row-cols-md-5 g-4">
	<c:forEach items="${sugerencias}" var="sugerencia">
		
		<c:set var="deshabilitado" value="${false}" scope="page"></c:set>
		<c:forEach items="${elementos_deshabilitados}" var="elemento">
			<c:if test="${elemento == sugerencia.getId()}">
				<c:set var="deshabilitado" value="${true}" scope="page"></c:set>
			</c:if>
		</c:forEach>
	
		<c:set var="habilitado" value="${true}" scope="page"></c:set>
		<c:if test="${usuario.getTiempoDisponibleHs() < sugerencia.getDuracionTotal() || usuario.getPresupuesto() < sugerencia.getCostoTotal() || deshabilitado}">
			<c:set var="habilitado" value="${false}" scope="page"></c:set>
		</c:if>
		
		<c:set var="comprado" value="${false}" scope="page"></c:set>
		<c:forEach items="${elementos_comprados}" var="elemento">
			<c:if test="${elemento.getIdLugar() == sugerencia.getId()}">
				<c:set var="comprado" value="${true}" scope="page"></c:set>
			</c:if>
		</c:forEach>
		<div class="card-group">
			<div class="card">
				<c:if test="${mostrar_encabezado}">
					<small class="card-header"><c:out value="${sugerencia.getTipo()}"></c:out></small>
				</c:if>
				<div class="card-body">
					<h4 class="card-title"><c:out value="${sugerencia.toString()}"></c:out></h4>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item text-center">
						<i class="bi bi-clock fs-3"></i> <c:out value="${sugerencia.getDuracionTotal()}"></c:out>
						&nbsp;
						<i class="bi bi-coin fs-3"></i> <c:out value="${sugerencia.getCostoTotal()}"></c:out>
						&nbsp;
						<c:choose>
							<c:when test="${comprado}">
								<br/>
								<i class="bi bi-check btn btn-success rounded"></i>
							</c:when>
							<c:otherwise>
								<button
									class="btn btn-primary"
									onclick='comprar("<c:out value="${tipo}"></c:out>", <c:out value="${sugerencia.getId()}"></c:out>)'
									<c:if test="${!habilitado}">
										disabled
									</c:if>>
									comprar
								</button>
							</c:otherwise>
						</c:choose>
					</li>			
				</ul>
			</div>
		</div>
	</c:forEach>
</div>
</body>
</html>	
	<!--
	http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote
	
	https://swapi.dev/api/planets?name=tatooine
	
	
	-->