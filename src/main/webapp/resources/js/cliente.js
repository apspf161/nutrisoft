var idSelecionado = 0;
var dataTableCliente;
$(document).ready(function() {

	carregaBotoes();
	
	if($("#content-table-cliente").length > 0) 
	{
		dataTableCliente = $('#content-table-cliente').DataTable(
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
	        "columnDefs": [ {"targets": [ 0 ], "visible": false },  ]
		});
		
		var detailRows = [];

		$('#content-table-cliente tbody').on( 'click', 'tr', function () {
	        if ( $(this).hasClass('selected') ) {
	            $(this).removeClass('selected');
	        }
	        else {
	        	dataTableCliente.$('tr.selected').removeClass('selected');
	            $(this).addClass('selected');
	            idSelecionado = dataTableCliente.row( this ).data()[0];
	            $("#idCliente").val(idSelecionado);
	        }
	    });
		
	    $('#content-table-cliente tbody').on( 'click', 'tr td.details-control', function () {
	        var tr = $(this).closest('tr');
	        var row = dataTableCliente.row( tr );
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
	    dataTableCliente.on( 'draw', function () {
	        $.each( detailRows, function ( i, id ) {
	            $('#'+id+' td.details-control').trigger( 'click' );
	        } );
	    } );
	}
});


function carregaBotoes()
{
	$('a#btnAlterar').on('click', function(){
		idSelecionado = $("#idCliente").val();		
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
		    $(this).attr("href", "cliente/alterarCliente/"+idSelecionado);
		}
	});
	

	$('a#btnExcluir').on('click', function(){
		idSelecionado = $("#idCliente").val();		
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
			$("[data-toggle=confirmation-excluir]").confirmation({
				container:"body",
				title: "Deseja excluir o usuário selecionado?",
				btnOkClass:"btn btn-sm btn-success",
				btnOkLabel:"Ok",
				btnCancelClass:"btn btn-sm btn-danger",
				btnCancelLabel:"Cancelar",
				href:"cliente/excluirCliente/"+idSelecionado
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