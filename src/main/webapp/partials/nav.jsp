<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String urlParte = request.getServletPath().replaceAll("/views/", "");

int fin = urlParte.indexOf('/', 1);

String seccion = "";

if (fin != -1) {
	seccion = urlParte.substring(0, fin);
}
%>

<nav class="navbar navbar-dark bg-dark navbar-expand-lg">
	<div class="container-fluid">
		<a class="navbar-brand" href="/star-wars-park/index.jsp">Star Wars Park</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menuColapsable" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="menuColapsable">
			<ul class="navbar-nav mb-2 mb-lg-0 ms-auto">
	        	<c:if test="${usuario.isAdmin()}">
				<li class="nav-item">
					<a class="nav-link <%= seccion.equals("usuario") ? "active" : "" %>" aria-current="page" href="/star-wars-park/usuario/index.do">
						Usuarios
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link <%= seccion.equals("tipo_atraccion") ? "active" : "" %>" aria-current="page" href="/star-wars-park/tipo-atraccion/index.do">Tipo Atracciones</a>
				</li>
				<li class="nav-item">
					<a class="nav-link <%= seccion.equals("atraccion") ? "active" : "" %>" aria-current="page" href="/star-wars-park/atraccion/index.do">Atracciones</a>
				</li>
				<li class="nav-item">
					<a class="nav-link <%= seccion.equals("tipo_promocion") ? "active" : "" %>" aria-current="page" href="/star-wars-park/tipo-promocion/index.do">Tipo Promociones</a>
				</li>
				<li class="nav-item">
					<a class="nav-link <%= seccion.equals("promocion") ? "active" : "" %>" aria-current="page" href="/star-wars-park/promocion/index.do">Promociones</a>
				</li>
				</c:if>
				<li class="nav-item">
					<a class="nav-link <%= seccion.equals("sugerencia") ? "active" : "" %>" aria-current="page" href="/star-wars-park/sugerencias">Sugerencias</a>
				</li>
				<li class="nav-item">
					<a class="nav-link <%= seccion.equals("itinerario") ? "active" : "" %>" aria-current="page" href="/star-wars-park/itinerario">Itinerario</a>
				</li>
			</ul>
			
			
			<ul class="navbar-nav">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						<c:out value="${usuario.getUsuario()}"></c:out>
					</a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item disabled" style="color: black;">
							<i title="monedas" style="color: gold;" class="bi bi-coin"></i> <c:out value="${usuario.getPresupuesto()}"></c:out>
						</a></li>
						<li><a class="dropdown-item disabled" style="color: black;">
							<i title="tiempo" style="color: blue;" class="bi bi-clock-fill"></i> <c:out value="${usuario.getTiempoDisponibleHs()}h"></c:out>
						</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a href="/star-wars-park/logout" class="dropdown-item">Salir</a></li>
					</ul>
				</li>
			</ul>
			
			
		</div>
	</div>
</nav>


<!--<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
	<div class="container">
		<a class="navbar-brand" href="/star-wars-park/index.jsp">Star Wars Park</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav me-auto mb-2 mb-md-0">
				<c:if test="${usuario.isAdmin()}">
				<li class="nav-item">
					<a class="nav-link <%= seccion.equals("usuario") ? "active" : "" %>" aria-current="page" href="/star-wars-park/usuario/index.do">
						Usuarios
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link <%= seccion.equals("tipo_atraccion") ? "active" : "" %>" aria-current="page" href="/star-wars-park/tipo-atraccion/index.do">Tipo Atracciones</a>
				</li>
				<li class="nav-item">
					<a class="nav-link <%= seccion.equals("atraccion") ? "active" : "" %>" aria-current="page" href="/star-wars-park/atraccion/index.do">Atracciones</a>
				</li>
				<li class="nav-item">
					<a class="nav-link <%= seccion.equals("tipo_promocion") ? "active" : "" %>" aria-current="page" href="/star-wars-park/tipo-promocion/index.do">Tipo Promociones</a>
				</li>
				<li class="nav-item">
					<a class="nav-link <%= seccion.equals("promocion") ? "active" : "" %>" aria-current="page" href="/star-wars-park/promocion/index.do">Promociones</a>
				</li>
				</c:if>
				<li class="nav-item">
					<a class="nav-link <%= seccion.equals("sugerencia") ? "active" : "" %>" aria-current="page" href="/star-wars-park/sugerencias">Sugerencias</a>
				</li>
				<li class="nav-item">
					<a class="nav-link <%= seccion.equals("itinerario") ? "active" : "" %>" aria-current="page" href="/star-wars-park/itinerario">Itinerario</a>
				</li>
				<!--
				<li class="nav-item">
					<a class="nav-link" aria-current="page" href="#"><%= request.getContextPath() %></a>
					<a class="nav-link" aria-current="page" href="#"><%= request.getServletContext() %></a>
					<a class="nav-link" aria-current="page" href="#"><%= request.getServletPath() %></a>
				</li>
				-->
			<!--</ul>
			<ul class="navbar-nav">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						<c:out value="${usuario.getUsuario()}"></c:out>
					</a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item disabled" style="color: black;">
							<i title="monedas" style="color: gold;" class="bi bi-coin"></i> <c:out value="${usuario.getPresupuesto()}"></c:out>
						</a></li>
						<li><a class="dropdown-item disabled" style="color: black;">
							<i title="tiempo" style="color: blue;" class="bi bi-clock-fill"></i> <c:out value="${usuario.getTiempoDisponibleHs()}h"></c:out>
						</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a href="/star-wars-park/logout" class="dropdown-item">Salir</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>-->
