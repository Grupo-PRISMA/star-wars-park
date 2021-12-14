<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-3">
		<label for="nombre" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="nombre" name="nombre"
			required value="${atraccion.nombre}">
	</div>
	<div class="mb-3">
		<label for="costo"
			class='col-form-label ${atraccion.errors.get("costo") != null ? "is-invalid" : "" }'>Costo:</label>
		<input class="form-control" type="number" id="costo" name="costo"
			required value="${atraccion.costo}"></input>
		<div class="invalid-feedback">
			<c:out value='${atraccion.errors.get("costo")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="duracion"
			class='col-form-label ${atraccion.errors.get("duracion") != null ? "is-invalid" : "" }'>Duracion:</label>
		<input class="form-control" type="number" id="duracion" name="duracion"
			required value="${atraccion.duracion}"></input>
		<div class="invalid-feedback">
			<c:out value='${atraccion.errors.get("duracion")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="cupo"
			class='col-form-label ${atraccion.errors.get("cupo") != null ? "is-invalid" : "" }'>Cupo:</label>
		<input class="form-control" type="number" id="cupo" name="cupo"
			required value="${atraccion.cupo}"></input>
		<div class="invalid-feedback">
			<c:out value='${atraccion.errors.get("cupo")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="nombre" class="col-form-label">Activo:</label> <input
			type="number" class="form-control" id="activo" name="activo"
			required value="${atraccion.activo}">
	</div>
	<div class="mb-3">
		<label for="info" class="col-form-label">Info:</label> <input
			type="text" class="form-control" id="info" name="info"
			required value="${atraccion.info}">
	</div>
</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
