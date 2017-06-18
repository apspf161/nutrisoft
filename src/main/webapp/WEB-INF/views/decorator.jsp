<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="pageReq" value="${pageContext.request}" scope="page" />
<c:set var="urlBase" value="${fn:replace(pageReq.requestURL, pageReq.requestURI, pageReq.contextPath)}/" scope="request" />

<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<base href="${urlBase}">
	<title>Nutrisoft</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />

	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/login.min.css">
    <!-- <link rel="stylesheet" href="resources/css/header.css"> -->
    
    <script src="resources/js/jquery.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
		
		<%-- 	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery/jquery-3.1.1.min.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery/plugins/jquery.dataTables-1.10.13.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/dataTables.bootstrap-1.10.13.min.js"></script>	
	

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/core/jquery/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/core/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/core/js/bootstrap-datepicker.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/core/js/jquery.modal.min.js"></script>	

<link href="${pageContext.request.contextPath}/resources/core/menu/css/simple-sidebar.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery_media.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery/plugins/moment.js"></script> --%>

		
	<style type="text/css">
#header {
	width: 100%;
	position: fixed;
}

#header {
	margin:0px;
	height: 120px;
	top: 0px;
	z-index: 999;
	border-bottom: #FF00FF 3px solid;
	position:relative;
	clear: both;
}
.responsive-image
{
width: 100%;
background-color:#F7FFF1;
background-position:center top;
background-image: url('resources/img/logo_nutrisoft.jpg');
background-repeat:no-repeat;
background-size: 100% 100%;
}

 #footer {
    height: 60px;
    background-color: #F7FFF1;
}
/* Lastly, apply responsive CSS fixes as necessary */
 @media (max-width: 767px) {
    #footer {
        margin-left: -20px;
        margin-right: -20px;
        padding-left: 20px;
        padding-right: 20px;
    }
}

#table-list td, tr, th #table-list>tbody>tr>td, #table-list>tbody>tr>th,
	#table-list>tfoot>tr>td, #table-list>tfoot>tr>th, #table-list>thead>tr>td,
	#table-list>thead>tr>th {
	text-align: center;
}

#table-list thead, th {
	background-color: #D0D0D0;
}

#table-list tr:HOVER td{
	color: #FF6347;
}
#table-list th:HOVER {
	color: black;
}
</style>

<script type="text/javascript">
	function AjaxCall(url) {
		$.ajax({
			type : 'GET',
			url : url,
			data : 0,
			success : function(data) {
				location.reload();
			}
		});
	}
	function AjaxPOST(url) {
		$.ajax({
			type : 'POST',
			url : url,
			data : 0,
			success : function(data) {
				location.reload();
			}
		});
	}
</script>
</head>
<body>
 		<sitemesh:write property="body"/>
</body>
<div id="footer">
   <div class="container">
     <p class="text-muted">Nutrisoft 2017</p>
   </div>
</div>

</html>