var indice = 1;

function cambiarFondo() {
	var viejo = indice + ".jpg";
	
	indice++;
	
	if (indice > 4) {
		indice = 1;
	}
	
	var imagen = $(".imagenFondo");
	imagen.css("background-image", imagen.css("background-image").replace(viejo, indice + ".jpg"));
}

setInterval(cambiarFondo, 3000);

function login() {
	//este mensaje vendra por ajax desde java
	var mensaje = "Usuario inexistente o contraseña incorrecta";
	
	$("#mensajeError").html(mensaje);
}
