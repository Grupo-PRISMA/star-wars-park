<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<jsp:include page="partials/head.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="partials/nav.jsp"></jsp:include>

	<main class="container">
		<div class="bg-light p-4 rounded">
			<h1>
				Bienvenido <c:out value="${usuario.getUsuario()}" />
			</h1>
		</div>
	</main>
	
	<div id="carouselExampleCaptions" class="carousel slide"
		data-bs-ride="carousel">
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
				<img src="assets/img/porcentual.jpg" class="d-block w-100"
					alt="Promocion Porcentual">
				<div class="carousel-caption d-none d-md-block">
					<h5>Promocion Porcentual</h5>
					<h5>Atracciones incluidas: Hoth y Estrella de la muerte</h5>
				</div>
			</div>
			<div class="carousel-item">
				<img src="assets/img/absoluta.jpg" class="d-block w-100"
					alt="Promocion Absoluta">
				<div class="carousel-caption d-none d-md-block">
					<h5>Promocion Absoluta</h5>
					<h5>Atracciones incluidas: Coruscant y Geonosis</h5>
				</div>
			</div>
			<div class="carousel-item">
				<img src="assets/img/AxB.jpg" class="d-block w-100" alt="Promocion AxB">
				<div class="carousel-caption d-none d-md-block">

					<h5>Promocion AxB</h5>
					<h5>Atracciones incluidas: Naboo, Tatooine y Kashyyyk</h5>
				</div>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
	
	<button class="btn btn-primary" type="button"
		data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight"
		aria-controls="offcanvasRight">Tu itinerario</button>

	<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight"
		aria-labelledby="offcanvasRightLabel">
		<div class="offcanvas-header">
			<h5 id="offcanvasRightLabel"># tu itinerario #</h5>
			<button type="button" class="btn-close text-reset"
				data-bs-dismiss="offcanvas" aria-label="Close"></button>
		</div>
		<div class="offcanvas-body">contenido del itinerario
		</div>
		
		
	</div>

	<div class="wrapper">
		<div class="one">
			<div class="card mb-3" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="assets/img/logoporcentual.jpg" class="img-fluid rounded-start"
							alt="logo porcentual">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">Promocion Porcentual</h5>
							<ul>
								<li>Hoth</li>
								<li>Estrella de la Muerte</li>
							</ul>
							<p class="card-text">
								<small class="text-muted">Aventura</small> <br> <strong
									class="text-decoration-underline">20./. off!</strong>
							</p>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary"
						data-bs-toggle="modal" data-bs-target="#exampleModal">
						comprar</button>

					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">confirmar
										compra</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<p>Se añadiran a tu carrito:</p>
									<ul>
										<li>Hoth</li>
										<li>Estrella de la Muerte</li>
									</ul>
									<p>total: ?</p>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">cerrar</button>
									<button type="button" class="btn btn-primary">comprar</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="two">
			<div class="card mb-3" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="assets/img/logoabsoluta.jpg" class="img-fluid rounded-start"
							alt="logo absoluta">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">Promocion Absoluta</h5>
							<ul>
								<li>Coruscant</li>
								<li>Geonosis</li>
								<li>Costo: $3</li>
							</ul>
							<p class="card-text">
								<small class="text-muted">Degustacion</small> <br> <strong
									class="text-decoration-underline">Descuento!</strong>
							</p>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary"
						data-bs-toggle="modal" data-bs-target="#exampleModal">
						hola</button>

					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">holi</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body"><p>holaholahoal</p></div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Cerrar</button>
									<button type="button" class="btn btn-primary">Save
										</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="three">
			<div class="card mb-3" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="assets/img/logoAxB.jpg" class="img-fluid rounded-start"
							alt="logo AXB">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">Promocion AxB</h5>
							<ul>
								<li>Kashyyk</li>
								<li>Tatooine</li>
								<li>Naboo</li>
							</ul>
							<p class="card-text">
								<small class="text-muted">Paisaje</small> <br> <strong
									class="text-decoration-underline">Compra 2, llevate 1
									gratis!</strong>
							</p>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary"
						data-bs-toggle="modal" data-bs-target="#exampleModal">
						Launch demo modal</button>

					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">...</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save
										changes</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="four">
			<div class="card mb-3" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="assets/img/hoth1.jpg" class="img-fluid rounded-start"
							alt="hoth">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">hoth</h5>
							<p>costo: $10</p>
							<p>duracion: 2 horas</p>
							<p>cupo disponible: 6 personas</p>
							<p class="card-text">
								<small class="text-muted">Aventura</small>
							</p>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary"
						data-bs-toggle="modal" data-bs-target="#exampleModal">
						Launch demo modal</button>

					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">...</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save
										changes</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="five">
			<div class="card mb-3" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="assets/img/deathstar1.jpg" class="img-fluid rounded-start"
							alt="death star">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">estrella de la muerte</h5>
							<p>costo: $25</p>
							<p>duracion: 3 horas</p>
							<p>cupo disponible: 4 personas</p>
							<p class="card-text">
								<small class="text-muted">Aventura</small>
							</p>
						</div>
					</div>
				</div>
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary" data-bs-toggle="modal"
					data-bs-target="#exampleModal">Launch demo modal</button>

				<!-- Modal -->
				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">...</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save
									changes</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="six">
			<div class="card mb-3" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="assets/img/coruscant1.jpg" class="img-fluid rounded-start"
							alt="coruscant">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">coruscant</h5>
							<p>costo: $3</p>
							<p>duracion: 6.5 horas</p>
							<p>cupo disponible: 150 personas</p>
							<p class="card-text">
								<small class="text-muted">Degustacion</small>
							</p>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary"
						data-bs-toggle="modal" data-bs-target="#exampleModal">
						Launch demo modal</button>

					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">...</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save
										changes</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="seven">
			<div class="card mb-3" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="assets/img/geonosis2.jpg" class="img-fluid rounded-start"
							alt="geonesis">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">geonosis</h5>
							<p>costo: $35</p>
							<p>duracion: 1 hora</p>
							<p>cupo disponible: 30 personas</p>
							<p class="card-text">
								<small class="text-muted">Degustacion</small>
							</p>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary"
						data-bs-toggle="modal" data-bs-target="#exampleModal">
						Launch demo modal</button>

					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">...</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save
										changes</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="eight">
			<div class="card mb-3" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="assets/img/naboo3.jpg" class="img-fluid rounded-start"
							alt="naboo">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">naboo</h5>
							<p>costo: $12</p>
							<p>duracion: 3 horas</p>
							<p>cupo disponible: 32 personas</p>
							<p class="card-text">
								<small class="text-muted">Paisaje</small>
							</p>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary"
						data-bs-toggle="modal" data-bs-target="#exampleModal">
						Launch demo modal</button>

					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">...</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save
										changes</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="nine">
			<div class="card mb-3" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="assets/img/tatooine1.jpg" class="img-fluid rounded-start"
							alt="tatooine">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">tatooine</h5>
							<p>costo: $5</p>
							<p>duracion: 2.5 horas</p>
							<p>cupo disponible: 25 personas</p>
							<p class="card-text">
								<small class="text-muted">Paisaje</small>
							</p>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary"
						data-bs-toggle="modal" data-bs-target="#exampleModal">
						Launch demo modal</button>

					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">...</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save
										changes</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="ten">
			<div class="card mb-3" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="assets/img/kashyyk2.jpg" class="img-fluid rounded-start"
							alt="kashyyyk">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">kashyyyk</h5>
							<p>costo: $5</p>
							<p>duracion: 2 horas</p>
							<p>cupo disponible: 15 personas</p>
							<p class="card-text">
								<small class="text-muted">Paisaje</small>
							</p>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary"
						data-bs-toggle="modal" data-bs-target="#exampleModal">
						Launch demo modal</button>

					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">...</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save
										changes</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="eleven">
			<div class="card mb-3" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="assets/img/kamino2.jpg" class="img-fluid rounded-start"
							alt="kamino">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">kamino</h5>
							<p>costo: $3</p>
							<p>duracion: 4 horas</p>
							<p>cupo disponible: 12 personas</p>
							<p class="card-text">
								<small class="text-muted">Aventura</small>
							</p>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary"
						data-bs-toggle="modal" data-bs-target="#exampleModal">
						Launch demo modal</button>

					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">...</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save
										changes</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>

<footer class="foot">
	<p style="color: #ffe81f">"Star Wars" pertenece a Disney, todos los
		derechos reservados ™</p>
	<p style="color: #ffe81f">By: Grupo prisma</p>
	<a href="https://github.com/Grupo-PRISMA">Nuestro github</a>
	<p style="color: #ffe81f">Made: with love</p>
	<a href="#" class="fa fa-facebook"></a>
	<a href="#"class="fa fa-twitter"></a> 
	<a href="#" class="fa fa-youtube"></a> 
	<a href="#" class="fa fa-instagram"></a>
</footer>

</html>