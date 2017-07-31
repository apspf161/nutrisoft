var idSelecionado = 0;
var dataTableCliente;
var dataTablePagamento;
$(document).ready(function() {
   
	$('#valor').mask("#.##0,00", {reverse: true});
	 
	$("#btnFiltrarCliente").click(function() {
		var txtNome = $("input[name='txtNome']").val();
		var txtCPF = $("input[name='txtCPF']").val();
		
	    if(txtNome.length === 0 && txtCPF.length === 0){
	    	alert("Preencha os campos para pesquisa.")
	    } else {
	    	txtNome = txtNome.length === 0 ? "x$x" : txtNome;
			txtCPF = txtCPF.length === 0 ? "x$x" : txtCPF;
			
	    	$(this).attr("href", "consulta/filtraListaClientesParaPagamento/"+txtNome+"/"+txtCPF );
	    }
	});
		
	$("#btnFiltrarPagamento").click(function() {
		var txtNome = $("input[name='txtNome']").val();
		var txtCPF = $("input[name='txtCPF']").val();
		
	    if(txtNome.length === 0 || txtCPF.length === 0){
	    	alert("Preencha os campos para pesquisa.")
	    } else {
			txtNome = txtNome.length === 0 ? "x$x" : txtNome;
			txtCPF = txtCPF.length === 0 ? "x$x" : txtCPF;
			
	    	$(this).attr("href", "consulta/filtraListaPagamento/"+txtNome+"/"+txtCPF );
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
	            $(this).attr("href", "consulta/cadPagamento/"+idSelecionado);
	            window.location.href = $(this).attr('href');
	        }
	    });
	}

	if($("#content-table-pagamento").length > 0) 
	{
		dataTablePagamento = $('#content-table-pagamento').DataTable(
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
	        "columnDefs": [ {"targets": [ 0, 6, 7 ], "visible": false }, { "targets": [1], "orderable": false},  ]
		});
		
		var detailRows = [];

		$('#content-table-pagamento tbody').on( 'click', 'tr', function () {
	        if ( $(this).hasClass('selected') ) {
	            $(this).removeClass('selected');
	        }
	        else {
	        	dataTablePagamento.$('tr.selected').removeClass('selected');
	            $(this).addClass('selected');
	            idSelecionado = dataTablePagamento.row( this ).data()[0];
	            $("#idAgendamento").val(idSelecionado);
	        }
	    });
		
	    $('#content-table-pagamento tbody').on( 'click', 'tr td.details-control', function () {
	        var tr = $(this).closest('tr');
	        var row = dataTablePagamento.row( tr );
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
	    dataTablePagamento.on( 'draw', function () {
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
				btnOkClass:"btn btn-sm btn-success",
				btnCancelClass:"btn btn-sm btn-danger",
				href:"agendamento/alterarAgendamento/"+idSelecionado
			});		
		}
	});
	/*	
	$('a#btnConfirmar').confirmation({
		onConfirm: function(e, element) {				
			if($("#idAgendamento").val() === 0 || $("#idAgendamento").val() === "" )
			{
				alert("Selecione uma linha!");
				e.preventDefault(); 
				e.stopPropagation();
			}	
		}, 
		title : "Deseja confirmar o agendamento selecionado?",
		placement: "top",
		href: "agendamento/alterarAgendamento/"+idSelecionado
	});

	$('a#btnConfirmar').confirmation({
		onConfirm: function(e, element) { 
			idSelecionado = $("#idAgendamento").val();
			if(idSelecionado === 0 || idSelecionado === "" )
			{
				alert("Selecione uma linha!");
				e.preventDefault(); 
				e.stopPropagation();
			}	
		}, 
		href:"agendamento/alterarAgendamento/"+idSelecionado
	});
*/


	$('a#btnAlterar').on('click', function(){
		idSelecionado = $("#idAgendamento").val();		
		if(idSelecionado === 0 || idSelecionado === "" )
		{
			alert("Selecione uma linha!");
			return false;
		}
		else
		{
			alert('btnAlterar='+idSelecionado);
		    $(this).attr("href", "agendamento/alterarAgendamento/"+idSelecionado);
		}
	});
	

	$('a#btnCancelar').on('click', function(){
		idSelecionado = $("#idAgendamento").val();		
		if(idSelecionado === 0 || idSelecionado === "" )
		{
			alert("Selecione uma linha!");
			return false;
		}
		else
		{
			alert('btnCancelar='+idSelecionado);
			confirmar(idSelecionado);
		}
	});

}


/**
 * Confirma o agendamento selecionado
 * @param idAgendamento
 */
function confirmar($identificador) 
{
	alert("OI!");
	/*var _self = this;

	if( confirm(  "Deseja confirmar o agendamento selecionado?"  ) )
	{
		$("div#divLoading").show();
		
		$.ajax({
			'dataType': 'json',
			'type': 'POST',
			'url': 'interno/metadado/removerMetadado',
			'data': {
				idMetadado : $identificador
			},
			'success': function (validacao, textStatus, jqXHR) {
								
				if(!validacao.valido)
				{
					var mensagemError = "";
					
					for (var i = 0; i < validacao.errosGerais.length; i++) 
					{
						mensagemError += validacao.errosGerais[i] + " <br />";
					}
					$("#conteudo-lista-error" ).show();
					$("#conteudo-lista-error" ).html ( mensagemError );
				}
				else
				{
					 varDataTable.row('.selected').remove().draw( false );
					 $("#conteudo-lista-success" ).show();
					 $("#conteudo-lista-success" ).html ( validacao.mensagem );
				}
				
				$("div#divLoading").hide();
			},
			'error' : function (jqXHR, textStatus, errorThrown) {
				$("div#divLoading").hide();
			}
		});
	}*/
}

function formatRowDetail ( d ) {
	
	var html = "<div class='row' >";
	html += "<div class='col title'><b>Dados do Pagamento</b></div>";
	html += "<div class='col minhas-colunas'><b>Valor:</b> "+d[6]+"</div>";
	html += "<div class='col minhas-colunas'><b>Forma de Pagamento:</b> "+d[7]+"</div>";
	html += "</div>";
	
    return html;
}