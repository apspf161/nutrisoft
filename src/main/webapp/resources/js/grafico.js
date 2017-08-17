var idSelecionado = 0;
var dataTableCliente;
$(document).ready(function() {
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
			
	    	$(this).attr("href", "grafico/filtraListaClientesParaGrafico/"+txtNome+"/"+txtCPF );
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
	            $(this).attr("href", "grafico/graficoEvolucoesCliente/"+idSelecionado);
	            window.location.href = $(this).attr('href');
	        }
	    });
	}

	
});
