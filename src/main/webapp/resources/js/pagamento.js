var idSelecionado = 0;
var dataTableCliente;
var dataTablePagamento;
$(document).ready(function() {
   
	$('#valor').mask("#.##0,00", {reverse: true});
	 
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
			
	    	$(this).attr("href", "consulta/filtraListaClientesParaPagamento/"+txtNome+"/"+txtCPF );
	    }
	});
		
	$("#btnFiltrarPagamento").click(function() {
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
});

function formatRowDetail ( d ) {
	
	var html = "<div class='row' >";
	html += "<div class='col title'><b>Dados do Pagamento</b></div>";
	html += "<div class='col minhas-colunas'><b>Valor:</b> "+d[6]+"</div>";
	html += "<div class='col minhas-colunas'><b>Forma de Pagamento:</b> "+d[7]+"</div>";
	html += "</div>";
	
    return html;
}