function inicializarConsulta() {
	$('.maskPeso').mask('000,0', {reverse:true});
	$('.maskNumerico').mask('#', {maxlength:false});
	$('.maskQtdAgua, .maskQtdSal, .maskQtdOleo').mask('00,0', {reverse:true});
}
$(inicializarConsulta);

$(document).on('blur', '#peso', function() {
	var peso = parseFloat($('#peso').val());
	if (!isNaN(peso)) {
		var altura = parseFloat($('#altura').val());
		var imc = calcularIMC(peso, altura);
		$('#imc').text(imc.toFixed(0));
		
		var idade = null;
		var sexo = null;
		
		var tmb = calcularTMB(sexo, idade, peso);
		$('#tmb').text(tmb.toFixed(0));
		
		var vet = calcularVET(sexo, idade, peso);
		$('#vet').text(vet);
	} else {
		$('#imc').text(' ');
		$('#tmb').text(' ');
		$('#vet').text(' ');
	}
});

function calcularIMC(peso, altura) {
	return (peso / (altura * altura));
}

function calcularTMB(sexo, idade, peso) {
	return 0;
}

function calcularVET(sexo, idade, peso) {
	return 0;
}