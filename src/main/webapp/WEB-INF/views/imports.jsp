<base href="${urlBase}">
<title>Nutrisoft</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />

<link rel="stylesheet" href="resources/css/bootstrap.min.css"> 
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css" media="screen">
<link rel="stylesheet" href="resources/css/bootstrap-datetimepicker.min.css" media="screen">
<link rel="stylesheet" href="resources/css/login.min.css">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/header.css">
<!-- <link rel="stylesheet" href="resources/css/footer.css"> -->
<link rel="stylesheet" href="resources/css/dataTables.bootstrap.css">
<link rel="stylesheet" href="resources/css/daterangepicker.css">
<link rel="stylesheet" href="resources/css/buttons.dataTables.min.css" />

<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui.min.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script src="resources/js/locales/bootstrap-datetimepicker.pt-BR.js" charset="UTF-8"></script>
<script src="resources/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="resources/bootstrap/js/bootstrap-confirmation.js"></script>
<script type="text/javascript" src="resources/js/jquery.mask.min.js"></script>
<script src="resources/js/moment.min.js"></script>
<script src="resources/js/daterangepicker.js"></script>
<script src="resources/js/dataTables.buttons.min.js"></script>
<script src="resources/js/buttons.print.min.js"></script>


   
<script>

setInterval(function() {
    $(".alert-info").fadeTo(500, 0).slideUp(500, function(){
    //    $(this).hide();
    	$(".alert-info").removeClass( "show" ).addClass( "hide" );
    });
    
    $(".alert-success").fadeTo(500, 0).slideUp(500, function(){
     //   $(this).hide();
    	$(".alert-success").removeClass( "show" ).addClass( "hide" );
    });
    
    $(".alert-danger").fadeTo(500, 0).slideUp(500, function(){
    //	$(this).hide();
    	$(".alert-danger").removeClass( "show" ).addClass( "hide" );
    });
    
}, 5000);
	    

</script>