<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@ page import="java.util.Date"%>

<c:set var="pageReq" value="${pageContext.request}" />
<c:set var="urlBase" value="${fn:replace(pageReq.requestURL, pageReq.requestURI, pageReq.contextPath)}/" scope="request" />
<!DOCTYPE HTML>
<html>
<head>
<c:import url="/WEB-INF/views/imports.jsp"></c:import>

<link rel="stylesheet" href="resources/css/agendamento.css">
<script src="resources/js/chart.js"></script>
<script src="resources/js/chart_utils.js"></script>
<script src="resources/js/graficoMetaPeso.js"></script>
<script src="resources/js/graficoComposicaoCorporal.js"></script>

<c:set value="show" var="classError"></c:set>

<c:if test="${empty error}"> 
  <c:set value="hide" var="classError"></c:set>
</c:if> 

</head>
<body>
	<c:import url="/WEB-INF/views/header.jsp"></c:import>

	<div class="container" id="container">

		<c:import url="/WEB-INF/views/menu.jsp"></c:import>
		
		<form:form action="grafico/graficoEvolucoes" id="form" commandName="cliente" method="post" class="simple_form form-horizontal" style="margin-top: 50px;">
			<div id="page-content-wrapper">
				<div class="panel panel-primary">
					<div class="panel-heading">
							<fmt:message key='AG023' />
							<a id="voltar" href="grafico/listaClientesParaGrafico" class="btn btn-info btn-xs" style="float: right;" role="button"><fmt:message key='AG022' /></a>
					</div>

					<div class="panel-body">

 						<div class="alert alert-danger ${classError}" id="alertError">${error}</div>
 						
						<c:if test="${not empty sucess}">
							<div class="alert alert-success">${sucess}</div>
						</c:if>
						
						<input name="idPessoa" id="idPessoa" type="hidden" value="<c:out value="${ cliente.idPessoa }"  />"> 

						<div style="width: 50%" class="center-block">
						        <canvas id="canvasId"></canvas>
								<br /><br />
						        <canvas id="canvasIdCompCorp"></canvas>
						</div>
					</div>
				</div>
			</div>			
		</form:form>
	</div>

	<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>