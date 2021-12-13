const MENSAJE_ERROR_VACIO = " no puede estar vacío";
const MENSAJE_ERROR_INVALIDO = " es inválido";
const MENSAJE_ERROR_NUMERO = " debe ser un número igual o mayor a cero";
	
var errores = [];
var puedeEnviar = true;

function validarVacio(campo)
{
	var condicionError = campo.value.trim().length < 1;
	manejarErrores(campo, MENSAJE_ERROR_VACIO, condicionError);
}

function validarNumero(campo)
{
	var condicionError = campo.value.trim().length < 1 || parseInt(campo.value) < 0;
	manejarErrores(campo, MENSAJE_ERROR_NUMERO, condicionError);
}

function manejarErrores(campo, mensaje, condicionError)
{
	var error = { campo: campo.name, mensaje: mensaje }
	
	if (condicionError) {
		if (!errorRepetido(error)) {
			errores.push(error);
			puedeEnviar = false;
		}
	} else {
		sacarError(error);
		puedeEnviar = errores.length < 1;
	}
	
	actualizarListaErrores();
}

function sacarError(error) {
	erroresLimpio = [];
	
	for (let err of errores) {
		if (err.campo !== error.campo) {
			erroresLimpio.push(err);
		}
	}
	
	errores = erroresLimpio;
}

function errorRepetido(error) {
	for (let e of errores) {
		if (e.campo == error.campo) {
			return true;
		}
	}
	
	return false;
}

function actualizarListaErrores() {
	var contenedor = $("#mensajes_validacion");
	
	contenedor.html("");
	
	for (let error of errores) {
		contenedor.html(contenedor.html() + "<li>" + error.campo + " " + error.mensaje + "</li>");
	}
	
	errores.length < 1 ? contenedor.hide() : contenedor.show();
}

function enviarFormulario() {
	if (puedeEnviar) {
		$("#formularioABM").submit();
	}
}