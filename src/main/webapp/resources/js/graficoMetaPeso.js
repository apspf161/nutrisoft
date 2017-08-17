$(document).ready(function() {

	var idPessoa = $("#idPessoa").val();
	
	$.ajax({
		url: 'grafico/graficoMetaPeso',
		data: { idCliente : idPessoa },
		type: 'post',
		dataType: 'json',
		success: function (data) {
			var ctx = document.getElementById("canvasId").getContext('2d');
			var ds = data.datasets;

			var myChart = new Chart(ctx, {
				type: 'line',
				data: data,
				options: {
	                responsive: true,
	                title:{
	                    display:true,
	                    text:'Meta de Peso'
	                },
	            	legend: {
						position: 'bottom',
					},
	                tooltips: {
	                    mode: 'index',
	                    intersect: false,
	                },
	                hover: {
	                    mode: 'nearest',
	                    intersect: true
	                },
	                scales: {
	                    xAxes: [{
	                        display: true,
	                        scaleLabel: {
	                            display: true,
	                            labelString: 'Tempo'
	                        }
	                    }],
	                    yAxes: [{
	                        display: true,
	                        scaleLabel: {
	                            display: true,
	                            labelString: 'Peso'
	                        }
	                    }]
	                }
	            }
			});
		},
		error: function(xhr, textStatus, error){
			$(".alert-danger").addClass("show");
		    $(".alert-danger").removeClass("hide");
		    $(".alert-danger").removeAttr("style")
			$("#alertError").text("Não há dados para esse Cliente.");
		}
	});
});

