var idSelecionado = 0;
var dataTableCliente;
var dataTableClienteMedidas;
$(document).ready(function() {
	
	$("#txtData").keypress(function(event) {event.preventDefault();});
	
	$('#txtData').daterangepicker({
		 "showDropdowns": true,
		 "autoUpdateInput": false,
		 "locale" : {format: 'DD/MM/YYYY'}		 
	 }, function(start, end, label) {
		 $('#txtData').val(start.format('DD/MM/YYYY') + " - " + end.format('DD/MM/YYYY'));
	 });

	$("#btnFiltrarRelAtendimentos").click(function() {
		var txtData = $("input[name='txtData']").val();
		var cmbNutricionista = $("select[name='cmbNutricionista']").val();
		
		if(txtData.length === 0 && cmbNutricionista == 0 ){
			$("#alertError").removeClass("hide").addClass( "show" ).css( "opacity" , 1).show().text("Preencha pelo menos um dos campos para pesquisa.");
	    } else {
	    	
	    	var txtDataInicial = "";
			var txtDataFinal = "";
		
	    	if(txtData.length === 0)
    		{
				txtDataInicial = "x$x";
				txtDataFinal = "x$x";    		
    		} 
	    	else 
	    	{
		    	var datas = txtData.split(" - ");
		    	var datasI = datas[0];
		    	var datasF = datas[1];
		    	
		    	var diaI = datasI.substring(0,2);
				var mesI = datasI.substring(3,5);
				var anoI = datasI.substring(6);
				
				var diaF = datasF.substring(0,2);
				var mesF = datasF.substring(3,5);
				var anoF = datasF.substring(6);
				
				var txtDataInicial = anoI + "-" + mesI + "-" + diaI;
				var txtDataFinal = anoF + "-" + mesF + "-" + diaF;
    		}
	    	
	    	$(this).attr("href", "consulta/filtraRelatorioAtendimentos/"+txtDataInicial+"/"+txtDataFinal+"/"+cmbNutricionista );
	    	window.location.href = $(this).attr('href');
	    }
	});	

	$("#btnFiltrarRelAgendamentos").click(function() {
		var txtData = $("input[name='txtData']").val();
		var cmbNutricionista = $("select[name='cmbNutricionista']").val();
		var cmbTurno = $("select[name='cmbTurno']").val();
		
		if(txtData.length === 0 ){
			$("#alertError").removeClass("hide").addClass( "show" ).css( "opacity" , 1).show().text("Período é um campo obrigatório.");
	    } else {
	    	
	    	var txtDataInicial = "";
			var txtDataFinal = "";
		
	    	if(txtData.length === 0)
    		{
				txtDataInicial = "x$x";
				txtDataFinal = "x$x";    		
    		} 
	    	else 
	    	{
		    	var datas = txtData.split(" - ");
		    	var datasI = datas[0];
		    	var datasF = datas[1];
		    	
		    	var diaI = datasI.substring(0,2);
				var mesI = datasI.substring(3,5);
				var anoI = datasI.substring(6);
				
				var diaF = datasF.substring(0,2);
				var mesF = datasF.substring(3,5);
				var anoF = datasF.substring(6);
				
				var txtDataInicial = anoI + "-" + mesI + "-" + diaI;
				var txtDataFinal = anoF + "-" + mesF + "-" + diaF;
    		}
	    	
	    	$(this).attr("href", "agendamento/filtraRelatorioAgendamentos/"+txtDataInicial+"/"+txtDataFinal+"/"+cmbNutricionista+"/" +cmbTurno );
	    	window.location.href = $(this).attr('href');
	    }
	});	
	
	$("#btnFiltrarRelEvolucao").click(function() {
		var txtData = $("input[name='txtData']").val();
		var txtNome = $("input[name='txtNome']").val();
		
		if(txtData.length === 0 && txtNome.length == 0 ){
			$("#alertError").removeClass("hide").addClass( "show" ).css( "opacity" , 1).show().text("Preencha pelo menos um dos campos para pesquisa.");
	    } else {
	    	
	    	var txtDataInicial = "";
			var txtDataFinal = "";
		
	    	if(txtData.length === 0)
    		{
				txtDataInicial = "x$x";
				txtDataFinal = "x$x";    		
    		} 
	    	else 
	    	{
		    	var datas = txtData.split(" - ");
		    	var datasI = datas[0];
		    	var datasF = datas[1];
		    	
		    	var diaI = datasI.substring(0,2);
				var mesI = datasI.substring(3,5);
				var anoI = datasI.substring(6);
				
				var diaF = datasF.substring(0,2);
				var mesF = datasF.substring(3,5);
				var anoF = datasF.substring(6);
				
				var txtDataInicial = anoI + "-" + mesI + "-" + diaI;
				var txtDataFinal = anoF + "-" + mesF + "-" + diaF;
    		}
	    	
	    	$(this).attr("href", "consulta/filtraRelatorioEvolucao/"+txtDataInicial+"/"+txtDataFinal+"/"+txtNome );
	    	window.location.href = $(this).attr('href');
	    }
	});	


	$("#btnFiltrarRelPagamentos").click(function() {
		var txtData = $("input[name='txtData']").val();
		var cmbNutricionista = $("select[name='cmbNutricionista']").val();
		var txtValor = $("input[name='txtValor']").val();
		
		if(txtData.length === 0 ){
			$("#alertError").removeClass("hide").addClass( "show" ).css( "opacity" , 1).show().text("Período é um campo obrigatório.");
	    } else {
	    	
	    	var txtDataInicial = "";
			var txtDataFinal = "";
		
	    	if(txtData.length === 0)
    		{
				txtDataInicial = "x$x";
				txtDataFinal = "x$x";    		
    		} 
	    	else 
	    	{
		    	var datas = txtData.split(" - ");
		    	var datasI = datas[0];
		    	var datasF = datas[1];
		    	
		    	var diaI = datasI.substring(0,2);
				var mesI = datasI.substring(3,5);
				var anoI = datasI.substring(6);
				
				var diaF = datasF.substring(0,2);
				var mesF = datasF.substring(3,5);
				var anoF = datasF.substring(6);
				
				var txtDataInicial = anoI + "-" + mesI + "-" + diaI;
				var txtDataFinal = anoF + "-" + mesF + "-" + diaF;
    		}
	    	
	    	$(this).attr("href", "consulta/filtraRelatorioPagamentos/"+txtDataInicial+"/"+txtDataFinal+"/"+cmbNutricionista+"/0" );
	    	window.location.href = $(this).attr('href');
	    }
	});	

	if($("#content-table-atendimentos").length > 0) 
	{
		dataTableCliente = $('#content-table-atendimentos').DataTable(
		{
			dom: 'Bti',
			buttons: [
	            {
	            	text: 'Imprimir',
	            	extend: 'print',
	                message: 'Relatório de Atendimentos ',
	                customize: function ( win ) {
	                    $(win.document.body)
	                        .css( 'font-size', '14pt' );
	                    $(win.document.body).find( 'table' )
                        	.addClass( 'compact' )
                        	.css( 'font-size', 'inherit' );
	                }
	            }
	        ],
			"language": {
			  	  processing:	"Processando...",
				  search:		"Pesquisar:",
				  lengthMenu:	"Exibir _MENU_ registros por página",
				  info:         "Exibindo _START_ &agrave; _END_ de _TOTAL_ registros",
				  infoEmpty:    "Nenhum registro encontrado",
				  infoFiltered: "(filtrado de um total de _MAX_ registros)",
				  infoPostFix:  "",
				  zeroRecords:  "Sem registro",
				  emptyTable:   "Sem registro",
				  paginate: {
					  first:    "Primeira",
					  previous: "Anterior",
					  next:     "Próxima",
					  last:     "Última",
				  }
	        }
		});
	} else 	if($("#content-table-agendamentos").length > 0) 
	{
		dataTableCliente = $('#content-table-agendamentos').DataTable(
		{
			dom: 'Bti',
			buttons: [
	            {
	            	text: 'Imprimir',
	            	extend: 'print',
	                message: 'Relatório de Agendamentos ',
	                customize: function ( win ) {
	                    $(win.document.body)
	                        .css( 'font-size', '12pt' );
	                    $(win.document.body).find( 'table' )
                        	.addClass( 'compact' )
                        	.css( 'font-size', 'inherit' );
	                }
	            }
	        ],
			"language": {
			  	  processing:	"Processando...",
				  search:		"Pesquisar:",
				  lengthMenu:	"Exibir _MENU_ registros por página",
				  info:         "Exibindo _START_ &agrave; _END_ de _TOTAL_ registros",
				  infoEmpty:    "Nenhum registro encontrado",
				  infoFiltered: "(filtrado de um total de _MAX_ registros)",
				  infoPostFix:  "",
				  zeroRecords:  "Sem registro",
				  emptyTable:   "Sem registro",
				  paginate: {
					  first:    "Primeira",
					  previous: "Anterior",
					  next:     "Próxima",
					  last:     "Última",
				  }
	        }
		});
	} else 	if($("#content-table-pagamentos").length > 0) 
	{
		dataTableCliente = $('#content-table-pagamentos').DataTable(
		{
			dom: 'Bti',
			buttons: [
	            {
	            	text: 'Imprimir',
	            	extend: 'print',
	                message: 'Relatório de Pagamentos ',
	                customize: function ( win ) {
	                    $(win.document.body)
	                        .css( 'font-size', '12pt' );
	                    $(win.document.body).find( 'table' )
                        	.addClass( 'compact' )
                        	.css( 'font-size', 'inherit' );
	                }
	            }
	        ],
			"language": {
			  	  processing:	"Processando...",
				  search:		"Pesquisar:",
				  lengthMenu:	"Exibir _MENU_ registros por página",
				  info:         "Exibindo _START_ &agrave; _END_ de _TOTAL_ registros",
				  infoEmpty:    "Nenhum registro encontrado",
				  infoFiltered: "(filtrado de um total de _MAX_ registros)",
				  infoPostFix:  "",
				  zeroRecords:  "Sem registro",
				  emptyTable:   "Sem registro",
				  paginate: {
					  first:    "Primeira",
					  previous: "Anterior",
					  next:     "Próxima",
					  last:     "Última",
				  }
	        }
		});
	} else 	if($("#content-table-evolucao").length > 0) 
	{
		dataTableCliente = $('#content-table-evolucao').DataTable(
		{
			dom: 'Bt',
			buttons: [
	            {
	            	text: 'Imprimir',
	            	extend: 'print',
	                message: 'Relatório de Pagamentos ',
	                customize: function ( win ) {
	                    $(win.document.body)
	                        .css( 'font-size', '12pt' );
	                    $(win.document.body).find( 'table' )
                        	.addClass( 'compact' )
                        	.css( 'font-size', 'inherit' );
	                }
	            }
	        ],
			"language": {
			  	  processing:	"Processando...",
				  search:		"Pesquisar:",
				  lengthMenu:	"Exibir _MENU_ registros por página",
				  info:         "Exibindo _START_ &agrave; _END_ de _TOTAL_ registros",
				  infoEmpty:    "Nenhum registro encontrado",
				  infoFiltered: "(filtrado de um total de _MAX_ registros)",
				  infoPostFix:  "",
				  zeroRecords:  "Sem registro",
				  emptyTable:   "Sem registro",
				  paginate: {
					  first:    "Primeira",
					  previous: "Anterior",
					  next:     "Próxima",
					  last:     "Última",
				  }
	        },
	        "rowReorder": {
	        	dataSrc: 0
	        },
	        "ordering": false
		});
		
		dataTableClienteMedidas = $('#content-table-medidas').DataTable(
		{
			dom: '<"clear">t',
			"language": {
			  	  processing:	"Processando...",
				  search:		"Pesquisar:",
				  lengthMenu:	"Exibir _MENU_ registros por página",
				  info:         "Exibindo _START_ &agrave; _END_ de _TOTAL_ registros",
				  infoEmpty:    "Nenhum registro encontrado",
				  infoFiltered: "(filtrado de um total de _MAX_ registros)",
				  infoPostFix:  "",
				  zeroRecords:  "Sem registro",
				  emptyTable:   "Sem registro",
				  paginate: {
					  first:    "Primeira",
					  previous: "Anterior",
					  next:     "Próxima",
					  last:     "Última",
				  }
	        },
	        "rowReorder": {
	        	dataSrc: 0
	        },
	        "ordering": false
		});
	}
	
	if($("#content-table-clientes").length > 0) 
	{
		dataTableCliente = $('#content-table-clientes').DataTable(
		{
			"dom": 'ti',
			"language": {
			  	  processing:	"Processando...",
				  search:		"Pesquisar:",
				  lengthMenu:	"Exibir _MENU_ registros por página",
				  info:         "Exibindo _START_ &agrave; _END_ de _TOTAL_ registros",
				  infoEmpty:    "Nenhum registro encontrado",
				  infoFiltered: "(filtrado de um total de _MAX_ registros)",
				  infoPostFix:  "",
				  zeroRecords:  "Sem registro",
				  emptyTable:   "Sem registro",
				  paginate: {
					  first:    "Primeira",
					  previous: "Anterior",
					  next:     "Próxima",
					  last:     "Última",
				  }
	        },
	        "columnDefs": [ {"targets": [ 0 ], "visible": false } ]
		});
		
		$('#content-table-clientes tbody').on( 'click', 'tr', function () {
	        if ( $(this).hasClass('selected') ) {
	            $(this).removeClass('selected');
	        }
	        else {
	        	dataTableCliente.$('tr.selected').removeClass('selected');
	            $(this).addClass('selected');
	            idSelecionado = dataTableCliente.row( this ).data()[0];
	            $(this).attr("href", "consulta/montaEvolucaoPorCliente/"+idSelecionado);
	            window.location.href = $(this).attr('href');
	        }
	    });
	}

	
});