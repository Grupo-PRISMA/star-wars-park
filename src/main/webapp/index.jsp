<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>

<link href="assets/css/estilo.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body class="imagenFondo">

	<jsp:include page="partials/nav.jsp"></jsp:include>

	<main class="container">
	<hr>
		<h3 class="tituloIndex">
				Bienvenido/a <c:out value="${usuario.getNombre()}" />
			</h3>
		
	<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="0" class="active" aria-current="true"
					aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="2" aria-label="Slide 3"></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="assets/img/promo_porcentual.jpg" class="d-block w-100"
						alt="Promocion Porcentual">
					<div class="carousel-caption d-none d-md-block">
						<h5>Pack Aventura</h5>
						<h5>Hoth y Estrella de la muerte</h5>
					</div>
				</div>
				<div class="carousel-item">
					<img src="assets/img/promo_absoluta.jpg" class="d-block w-100"
						alt="Promocion Absoluta">
					<div class="carousel-caption d-none d-md-block">
						<h5>Pack Degustación</h5>
						<h5>Coruscant y Geonosis</h5>
					</div>
				</div>
				<div class="carousel-item">
					<img src="assets/img/promo_AxB.jpg" class="d-block w-100" alt="Promocion AxB">
					<div class="carousel-caption d-none d-md-block">
						<h5>Pack Paisaje</h5>
						<h5>Naboo, Tatooine y Kashyyyk</h5>
					</div>
				</div>
			</div>
			<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="visually-hidden">Next</span>
			</button>
		</div>
	</main>
</body>
<br>
<footer class="foot">
	<div>

		<p style="color: #ffe81f">"Star Wars" pertenece a Disney, todos los
		derechos reservados</p>
		<p style="color: #ffe81f"><a href="https://github.com/Grupo-PRISMA">By: Grupo prisma </a></p>
		<a href="www.facebook.com/starwarsla/" class="fa fa-facebook"></a>
		<a href="https://twitter.com/starwars"class="fa fa-twitter"></a> 
		<a href="https://www.youtube.com/c/Disney" class="fa fa-youtube"></a> 
		<a href="https://www.instagram.com/santi.posse/" class="fa fa-instagram"></a>
	</div>
</footer>
</html>
