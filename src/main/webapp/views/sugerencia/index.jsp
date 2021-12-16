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

	<main class="container">
	

<!--
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
-->		<hr>
		<h2 class="tituloIndex">Sugerencias</h2>

		<c:if test="${mensaje != null}">
			<div class="alert alert-<c:out value="${tipo_mensaje}" />">
				<p><c:out value="${mensaje}" /></p>
			</div>
		</c:if>
		 

		 
		<div class="bg-primary bg-gradient text-white p-2 mb-3 mt-4">
			<h3>Promociones de <c:out value="${usuario.getPreferencia()}"></c:out></h3>
		</div>
		<c:set var="sugerencias" value="${promociones_preferidas}" scope="request"></c:set>
		<c:set var="mostrar_encabezado" value="false" scope="request"></c:set>
		<c:set var="tipo" value="promocion" scope="request"></c:set>
		<c:set var="elementos_deshabilitados" value="${promociones_deshabilitadas}" scope="request"></c:set>
		<c:set var="elementos_comprados" value="${itinerario_promociones}" scope="request"></c:set>
		<jsp:include page="/partials/sugerencia_card.jsp">
			<jsp:param name="sugerencias" value="sugerencias" />
			<jsp:param name="mostrar_encabezado" value="mostrar_encabezado" />
			<jsp:param name="tipo" value="tipo" />
			<jsp:param name="elementos_deshabilitados" value="elementos_deshabilitados" />
			<jsp:param name="elementos_comprados" value="elementos_comprados" />
		</jsp:include>
		
		<div class="bg-primary bg-gradient text-white p-2 mb-3 mt-4">
			<h3>Otras Promociones</h3>
		</div>
		<c:set var="sugerencias" value="${promociones_comunes}" scope="request"></c:set>
		<c:set var="mostrar_encabezado" value="true" scope="request"></c:set>
		<jsp:include page="/partials/sugerencia_card.jsp">
			<jsp:param name="sugerencias" value="sugerencias" />
			<jsp:param name="mostrar_encabezado" value="mostrar_encabezado" />
			<jsp:param name="tipo" value="tipo" />
			<jsp:param name="elementos_deshabilitados" value="elementos_deshabilitados" />
			<jsp:param name="elementos_comprados" value="elementos_comprados" />
		</jsp:include>
		
		<div class="bg-primary bg-gradient text-white p-2 mb-3 mt-4">
			<h3>Atracciones de <c:out value="${usuario.getPreferencia()}"></c:out></h3>
		</div>
		<c:set var="sugerencias" value="${atracciones_preferidas}" scope="request"></c:set>
		<c:set var="mostrar_encabezado" value="false" scope="request"></c:set>
		<c:set var="tipo" value="atraccion" scope="request"></c:set>
		<c:set var="elementos_deshabilitados" value="${atracciones_deshabilitadas}" scope="request"></c:set>
		<c:set var="elementos_comprados" value="${itinerario_atracciones}" scope="request"></c:set>
		<jsp:include page="/partials/sugerencia_card.jsp">
			<jsp:param name="sugerencias" value="sugerencias" />
			<jsp:param name="mostrar_encabezado" value="mostrar_encabezado" />
			<jsp:param name="tipo" value="tipo" />
			<jsp:param name="elementos_deshabilitados" value="elementos_deshabilitados" />
			<jsp:param name="elementos_comprados" value="elementos_comprados" />
		</jsp:include>
		
		<div class="bg-primary bg-gradient text-white p-2 mb-3 mt-4">
			<h3>Otras atracciones</h3>
		</div>
		<c:set var="sugerencias" value="${atracciones_comunes}" scope="request"></c:set>
		<c:set var="mostrar_encabezado" value="true" scope="request"></c:set>
		<jsp:include page="/partials/sugerencia_card.jsp">
			<jsp:param name="sugerencias" value="sugerencias" />
			<jsp:param name="mostrar_encabezado" value="mostrar_encabezado" />
			<jsp:param name="tipo" value="tipo" />
			<jsp:param name="elementos_deshabilitados" value="elementos_deshabilitados" />
			<jsp:param name="elementos_comprados" value="elementos_comprados" />
		</jsp:include>
	</main>
	
	<form action="/star-wars-park/sugerencias" method="post" id="formularioComprar">
		<input type="hidden" name="tipo" value="">
		<input type="hidden" name="id" value="">
	</form>
	
	<script>
	function comprar(tipo, id)
	{
		let formulario = $("#formularioComprar");
		formulario.find('input[name="tipo"]').val(tipo);
		formulario.find('input[name="id"]').val(id);
		formulario.submit();
	}
	</script>
</body>
</html>