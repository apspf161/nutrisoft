$(document).ready(function() {

	if($("#content-table").length > 0) 
	{
		$('#content-table').DataTable(
				{
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
			        //"columnDefs": [ { "targets": [2, 3 ,4 , 5, 6], "orderable": false }, { "targets": [ 0, 1 ] } ]
				});
	}
	
/*	$('#formPrc').on('keyup keypress', function(e) {
		
		  var keyCode = e.keyCode || e.which;
		  		  
		  if (keyCode === 13) { 
		    e.preventDefault();
		    return false;
		  }
	});*/
});
