var idSelecionado = 0;
var dataTableCliente;
var dataTableConsulta;
$(document).ready(function() {

	carregaBotoes();
	
    $('.form_datetime').datetimepicker({
        language: 'pt-BR',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
        pickerPosition: 'top-left',
        minuteStep:30,
        daysOfWeekDisabled:[0,6],
    	hoursDisabled: '0,1,2,3,4,5,6,7,8,19,20,21,22,23',
    	startDate:new Date()
    });

    $('.form_datetime_dtp').datetimepicker({
        language: 'pt-BR',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0,
		pickerPosition: 'top-left',
		minuteStep:30,
        daysOfWeekDisabled:[0,6],
    	hoursDisabled: '0,1,2,3,4,5,6,7,8,19,20,21,22,23'
    	//, startDate:new Date()
    }); 	
    
	$("#btnFiltrarCliente").click(function() {
		var txtNome = $("input[name='txtNome']").val();
		var txtCPF = $("input[name='txtCPF']").val();

	    if(txtNome.length === 0 && txtCPF.length === 0){
	    	 $(".alert-danger").addClass("show");
		    $(".alert-danger").removeClass("hide");
		    $(".alert-danger").removeAttr("style")
			$("#alertError").text("Preencha os campos para pesquisa.");
	    } else {
			txtNome = txtNome.length === 0 ? "x$x" : txtNome;
			txtCPF = txtCPF.length === 0 ? "x$x" : txtCPF;
			
	    	$(this).attr("href", "agendamento/filtraListaClientesParaAgendamento/"+txtNome+"/"+txtCPF );
	    }
	});
	
	$("#txtData").on("change paste keyup", function() {
		$("#btnFiltrarConsulta").trigger("click");
	});
	
	$("#btnFiltrarConsulta").click(function() {
		var txtData = $("input[name='txtData']").val();
		
	    if(txtData.length === 0 ){
	    	$(".alert-danger").addClass("show");
		    $(".alert-danger").removeClass("hide");
		    $(".alert-danger").removeAttr("style")
			$("#alertError").text("Preencha os campos para pesquisa.");
	    } else {
			var dia = txtData.substring(0,2);
			var mes = txtData.substring(3,5);
			var ano = txtData.substring(6);
			
			txtData = ano + "-" + mes + "-" + dia;			
	    	$(this).attr("href", "agendamento/filtraListaAgendamento/"+txtData );
	    	window.location.href = $(this).attr('href');
	    }
	});
	
	
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
	        //"order": [[ 1, "asc" ]],
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
	            $(this).attr("href", "agendamento/cadAgendamento/"+idSelecionado);
	            window.location.href = $(this).attr('href');
	        }
	    });
	}

	if($("#content-table-consulta").length > 0) 
	{
		dataTableConsulta = $('#content-table-consulta').DataTable(
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
	        "columnDefs": [ {"targets": [ 0, 5, 6 ], "visible": false }, { "targets": [1], "orderable": false},  ]
		});
		
		var detailRows = [];

		$('#content-table-consulta tbody').on( 'click', 'tr', function () {
	        if ( $(this).hasClass('selected') ) {
	            $(this).removeClass('selected');
	        }
	        else {
	        	dataTableConsulta.$('tr.selected').removeClass('selected');
	            $(this).addClass('selected');
	            idSelecionado = dataTableConsulta.row( this ).data()[0];
	            $("#idAgendamento").val(idSelecionado);
	        }
	    });
		
	    $('#content-table-consulta tbody').on( 'click', 'tr td.details-control', function () {
	        var tr = $(this).closest('tr');
	        var row = dataTableConsulta.row( tr );
	        var idx = $.inArray( tr.attr('id'), detailRows );
	 
	        if ( row.child.isShown() ) {
	            tr.removeClass( 'details' );
	            row.child.hide();
	            // Remove from the 'open' array
	            detailRows.splice( idx, 1 );
	        }
	        else {
	            tr.addClass( 'details' );
	            row.child( formatRowDetail( row.data() ) ).show();
	 
	            // Add to the 'open' array
	            if ( idx === -1 ) {
	                detailRows.push( tr.attr('id') );
	            }
	        }
	    } );
	    
	    // On each draw, loop over the `detailRows` array and show any child rows
	    dataTableConsulta.on( 'draw', function () {
	        $.each( detailRows, function ( i, id ) {
	            $('#'+id+' td.details-control').trigger( 'click' );
	        } );
	    } );
	}
	
/*	$('#formPrc').on('keyup keypress', function(e) {
		
		  var keyCode = e.keyCode || e.which;
		  		  
		  if (keyCode === 13) { 
		    e.preventDefault();
		    return false;
		  }
	});*/
});


function carregaBotoes()
{
	$('a#btnConfirmar').on('click', function(e) {
		idSelecionado = $("#idAgendamento").val();
		if(idSelecionado === 0 || idSelecionado === "" )
		{
		    $(".alert-danger").addClass("show");
		    $(".alert-danger").removeClass("hide");
		    $(".alert-danger").removeAttr("style")
			$("#alertError").text("Selecione uma linha!");
			return false;
		}
		else
		{
			$("[data-toggle=confirmation]").confirmation({
				container:"body",
				title: "Deseja confirmar o agendamento selecionado?",
				btnOkClass:"btn btn-sm btn-success",
				btnOkLabel:"Ok",
				btnCancelClass:"btn btn-sm btn-danger",
				btnCancelLabel:"Cancelar",
				href:"agendamento/confirmarAgendamento/"+idSelecionado
			});		
		}
	});

	$('a#btnAlterar').on('click', function(){
		idSelecionado = $("#idAgendamento").val();		
		if(idSelecionado === 0 || idSelecionado === "" )
		{
		    $(".alert-danger").addClass("show");
		    $(".alert-danger").removeClass("hide");
		    $(".alert-danger").removeAttr("style")
			$("#alertError").text("Selecione uma linha!");
			return false;
		}
		else
		{
		    $(this).attr("href", "agendamento/alterarAgendamento/"+idSelecionado);
		}
	});
	

	$('a#btnCancelar').on('click', function(){
		idSelecionado = $("#idAgendamento").val();		
		if(idSelecionado === 0 || idSelecionado === "" )
		{
		    $(".alert-danger").addClass("show");
		    $(".alert-danger").removeClass("hide");
		    $(".alert-danger").removeAttr("style")
			$("#alertError").text("Selecione uma linha!");
			return false;
		}
		else
		{
			$("[data-toggle=confirmation-cancelar]").confirmation({
				container:"body",
				title: "Deseja cancelar o agendamento selecionado?",
				btnOkClass:"btn btn-sm btn-success",
				btnOkLabel:"Ok",
				btnCancelClass:"btn btn-sm btn-danger",
				btnCancelLabel:"Cancelar",
				href:"agendamento/cancelarAgendamento/"+idSelecionado
			});		
		}
	});

}

function formatRowDetail ( d ) {
	
	var html = "<div class='row' >";
	html += "<div class='col title'><b>Dados do Cliente</b></div>";
	html += "<div class='col minhas-colunas'><b>CPF:</b> "+d[5]+"</div>";
	html += "<div class='col minhas-colunas'><b>Telefone:</b> "+d[6]+"</div>";
	html += "</div>";
	
    return html;
}