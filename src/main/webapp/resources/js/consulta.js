function inicializarConsulta() {
	$('.maskPeso').mask('000,0', {reverse:true});
	$('.maskNumerico').mask('#', {maxlength:false});
	$('.maskPercent').mask('000,00', {maxlength:false});
	$('.maskQtdAgua, .maskQtdSal, .maskQtdOleo').mask('00,0', {reverse:true});
}
$(inicializarConsulta);

$(document).on('blur', '#peso', function() {
	var data = {};
	data.peso = $('#peso').val().replace(',', '.');
	data.altura = $('#altura').val();
	data.idade =  $('#idade').val();
	data.sexo = $('#sexo').val();
	$.getJSON('consulta/realizarCalculosAntropometria', data, function(json) {
		$('#imc').text(json.imc.toFixed(0));
		$('#tmb').text(json.tmb.toFixed(0));
		$('#vet').text(json.vet.toFixed(0));
	});
});