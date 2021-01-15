var rut = document.getElementById("rut");
var nombre = document.getElementById("nombre");
var apellido = document.getElementById("apellido");
var fechaN = document.getElementById("fechaN");
var direccion = document.getElementById("direccion");
/* var telefono = document.getElementById("telefono"); */
var opciones = document.getElementById("opciones");

var error = document.getElementById("error");
error.style.color = "blue";
var input = document.getElementById('anoVehiculo');

var tipoVehiculo = document.getElementById('tipoVehiculo');
var marca = document.getElementById('marca');
var modelo = document.getElementById('modelo');
var anoVehiculo = document.getElementById('anoVehiculo');
var revisionTecnica = document.getElementById('revisionTecnica');
var trabajador = document.getElementById('trabajador');
var fechaAtencion = document.getElementById('fechaAtencion');

var form = document.getElementById("formulario");

var error = document.getElementById("error");

function valor(){
	var exterior = document.getElementById("exterior");
	var interior = document.getElementById("interior");
        var motor = document.getElementById("motor");
        var resultado = document.getElementById("resultado");
        
	var n1 = 5000;
	var n2 = 3000;
        var n3 = 12000;
        
	var total1 = n1 * 1.19;
	var total2 = n2 * 1.19;
        var total3 = n3 * 1.19;
        
	var suma;
        
	if(exterior.checked === true){
            resultado.innerHTML = total1;
	}if(interior.checked === true){
            resultado.innerHTML = total2;
	}if(motor.checked === true){
            resultado.innerHTML = total3;
        }if(interior.checked === true && exterior.checked === true){
            suma = total1+total2;
            resultado.innerHTML = suma;
	}if(interior.checked === true && motor.checked === true){
            suma = total2+total3;
            resultado.innerHTML = suma;
        }if(motor.checked === true && exterior.checked === true){
            suma = total3 + total1;
            resultado.innerHTML = suma;
        }if(interior.checked === true && exterior.checked===true && motor.checked===true){
            suma = total1+total2+total3;
            resultado.innerHTML = suma;
        }
}




function validarNombre() {
	let esValido = false;

	var mensaje = document.getElementById("mensaje1");

	const patron = new RegExp("^[A-Z]+$", "i");

	if (!nombre.value) { //!
		esValido = false;
	} else {
		if (!patron.test(nombre.value)) {
			esValido = false;
		} else {
			esValido = true;
		}
	}

	if (!esValido) {
		nombre.style.borderColor = "red";
		mensaje.hidden = false;
	} else {
		nombre.style.borderColor = "green";
		mensaje.hidden = true;
	}

}

function validarApellido() {
	let esValido = false;


	var mensaje = document.getElementById("mensaje2");
	//tomamos el id del div para mostrar mensajes

	const patron = new RegExp("^[A-Z]+$", "i");


	if (!apellido.value) { //!
		esValido = false;
	} else {
		if (!patron.test(apellido.value)) {
			esValido = false;
		} else {
			esValido = true;
		}
	}

	if (!esValido) {
		apellido.style.borderColor = "red";
		mensaje.hidden = false;
	} else {
		apellido.style.borderColor = "green";
		mensaje.hidden = true;
	}

}

function validarDireccion(direccion) {
	let esValido = false;
	var valor = direccion.value;
	const patron = /[^0-9a-zA-Z\s]/g;
	valor = valor.replace(patron, "");

	var mensaje = document.getElementById("mensaje3");
	//tomamos el id del div para mostrar mensajes

	if (!valor) {
		esValido = false;
	} else {
		if (!patron.test(valor)) {
			esValido = false;
		} else {
			esValido = true;
		}
	}

	if (esValido) {
		mensaje.style.borderColor = "red";
		mensaje.hidden = false;
	} else {
		mensaje.style.borderColor = "green";
		mensaje.hidden = true;
	}
	direccion.value = valor;
}

function ingresarSoloLetras(element) {
	var valor = element.value;
	const patron = /[^a-zA-Z\s]/g;
	valor = valor.replace(patron, "");
	element.value = valor;
}

function validarRut(rut) {
	//Despejar puntos
	var valor = rut.value.replaceAll(".", "");

	//despejar guión
	const reg = /[^0-9kK]/g;
	valor = valor.replace(reg, "");

	//separar cuerpo y DV
	var cuerpo = valor.slice(0, -1);//indice y final
	var dv = valor.slice(-1).toUpperCase();


	rut.value = cuerpo + "-" + dv;


	if (cuerpo.length < 7) {
		rut.setCustomValidity("Rut incompleto");
		return false;
	}

	var suma = 0;
	var multiplo = 2;


	for (let i = 1; i <= cuerpo.length; i++) {

		var producto = multiplo * valor.charAt(cuerpo.length - i);

		suma = suma + producto;


		if (multiplo < 7) {
			multiplo = multiplo + 1;
		} else {
			multiplo = 2;
		}
	}


	var digit = 11 - (suma % 11);


	dv = (dv == "K") ? 10 : dv;
	dv = (dv == 0) ? 11 : dv;


	if (digit != dv) {
		rut.setCustomValidity("Rut inválido");
		return false;
	}


	rut.setCustomValidity("");
}

function soloNum(evt) {
	//operador ternario
	var tecla = window.event ? evt.which : evt.keyCode;
	if (tecla < 48 || tecla > 57) {
		evt.preventDefault();
		//limite(this);

	}

}



function validarMarca() {
	let esValido = false;

	var mensaje = document.getElementById("mensaje4");
	//tomamos el id del div para mostrar mensajes

	const patron = new RegExp("^[A-Z]+$", "i");


	if (!marca.value) { //!
		esValido = false;
	} else {
		if (!patron.test(marca.value)) {
			esValido = false;
		} else {
			esValido = true;
		}
	}

	if (!esValido) {
		marca.style.borderColor = "red";
		mensaje.hidden = false;
	} else {
		marca.style.borderColor = "green";
		mensaje.hidden = true;
	}

}



function validarModelo() {
	let esValido = false;

	var mensaje = document.getElementById("mensaje5");
	//tomamos el id del div para mostrar mensajes

	const patron = new RegExp("^[A-Z]+$", "i");

	if (!modelo.value) {
		esValido = false;
	} else {
		if (!patron.test(modelo.value)) {
			esValido = false;
		} else {
			esValido = true;
		}
	}

	if (!esValido) {
		modelo.style.borderColor = "red";
		mensaje.hidden = false;
	} else {
		modelo.style.borderColor = "green";
		mensaje.hidden = true;
	}

}



function soloLetras() {
	if ((event.keyCode != 32) && (event.keyCode < 65) || (event.keyCode > 90) && (event.keyCode < 97) || (event.keyCode > 122))
		event.returnValue = false;
}

function getValues() {

	if (!rut.value) {
		return null;
	}

	if (!nombre.value) {
		return null;
	}

	if (!apellido.value) {
		return null;
	}

	if (!fechaN.value) {
		return null;
	}

	if (!direccion.value) {
		return null;
	}

	/* if(!telefono.value){
		return null;
	} */

	var textVehiculo = tipoVehiculo.options[tipoVehiculo.selectedIndex].text;
	if (!(tipoVehiculo.selectedIndex !== "1")) {
		return null;
	}

	if (!marca.value) {
		return null;
	}

	if (!modelo.value) {
		return null;
	}

	if (!anoVehiculo.value) {
		return null;
	}

	if ($('input[name="revision"]:checked').val() === null || $('input[name="revision"]:checked').val() === undefined) {
		return null;
	}

	var textTrabajador = trabajador.options[trabajador.selectedIndex].text;
	if (!(trabajador.selectedIndex !== "1")) {
		return null;
	}

	if (!fechaAtencion.value) {
		return null;
	}

	var tarifa = parseInt(getValueCheckbox("inlineCheckbox1")) + parseInt(getValueCheckbox("inlineCheckbox2"));
	if (!(tarifa > 0)) {
		return null;
	}

	const data = {
		rut: rut.value,
		nombre: nombre.value,
		apellido: apellido.value,
		fechaN: fechaN.value,
		direccion: direccion.value,
		tarifa: tarifa*1.19,
		tipoVehiculo: textVehiculo,
		marca: marca.value,
		modelo: modelo.value,
		anoVehiculo: anoVehiculo.value,
		revisionTecnica: ("true" == $('input[name="revision"]:checked').val()),
		trabajador: textTrabajador,
		fechaAtencion: fechaAtencion.value
	}

	return data;
}

function getValueCheckbox(elementId) {
	var element = document.getElementById(elementId);
	return (element.checked) ? element.value : 0;
}


function enviarFormulario() {
	const data = getValues();

	if (!data) {
		alert("Aún faltan datos");
		return;
	}
	alert(JSON.stringify(data));
}


input.addEventListener('input', function () {
	if (this.value.length > 4)
		this.value = this.value.slice(0, 4);
})


form.addEventListener("submit",function(evt){
	//referencia al elemento que se esta utilizando
	evt.preventDefault();
	
	var mensajesError = [];

	
	if(tipoVehiculo.value == 0 || tipoVehiculo.value == ""){
		mensajesError.push("Opción Invalida");
	tipoVehiculo.focus();
}

error.innerHTML = mensajesError.join("<br>");
console.log("ingresado");

});
