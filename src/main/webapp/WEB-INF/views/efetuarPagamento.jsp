<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@ page import="java.util.Date"%>

<c:set var="pageReq" value="${pageContext.request}" />
<c:set var="urlBase"
	value="${fn:replace(pageReq.requestURL, pageReq.requestURI, pageReq.contextPath)}/"
	scope="request" />
<!DOCTYPE HTML>
<html>
<head>
<c:import url="/WEB-INF/views/imports.jsp"></c:import>

<link rel="stylesheet" href="resources/css/pagamento.css">
<script src="resources/js/pagamento.js"></script>


<!-- <script>
$("#formPrc").validate({
	lang : 'pt'
});
</script> -->
</head>
<body>
	<c:import url="/WEB-INF/views/header.jsp"></c:import>

	<div class="container" id="container">

		<c:import url="/WEB-INF/views/menu.jsp"></c:import>

		<form:form action="consulta/efetuarPagamento" id="form" commandName="consulta" method="post" class="simple_form form-horizontal" style="margin-top: 50px;">
			<div id="page-content-wrapper">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<fmt:message key='AG016' />
						<a id="voltar" href="consulta/listaClientesParaPagamento" class="btn btn-info btn-xs" style="float: right;" role="button"><fmt:message key='AG017' /></a>
					</div>

					<div class="panel-body">

						<c:if test="${not empty error}">
							<div class="alert alert-danger">${error}</div>
						</c:if>
						<c:if test="${not empty sucess}">
							<div class="alert alert-success">${sucess}</div>
						</c:if>

						<input name="consulta.agendamento.idAgendamento" id="idAgendamento"
							type="hidden"
							value="<c:out value="${ consulta.agendamento.idAgendamento }"  />">
						<input name="consulta.agendamento.cliente.idPessoa" id="idPessoa"
							type="hidden"
							value="<c:out value="${ consulta.agendamento.cliente.idPessoa }"  />">
						<%-- <input name="inclusao" type="hidden" value="<c:out value="${ inclusao }"  />"> --%>

						<div class="form-group row">
							<div class="col-xs-12">
								<label for="example-text-input"><fmt:message key="AG005" /></label>
								<input class="form-control" name="consulta.agendamento.cliente.nome"
									value="${consulta.agendamento.cliente.nome}" disabled="disabled">
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-xs-6">
								<label for="example-text-input"><fmt:message key="AG006" /></label>
								<input class="form-control" name="consulta.agendamento.cliente.cpf"
									value="${consulta.agendamento.cliente.cpf}" disabled="disabled">
							</div>

							<div class="col-xs-6">
								<label for="example-text-input"><fmt:message key="AG007" /></label>
								<input class="form-control" name="consulta.agendamento.cliente.telefone"
									value="${consulta.agendamento.cliente.telefone}" disabled="disabled">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-xs-12">
								<label for="example-text-input"><fmt:message key="AG004" /></label>
								<input class="form-control" name="consulta.agendamento.nutricionista.nome"
									value="${consulta.agendamento.nutricionista.nome}" disabled="disabled">
							</div>
						</div>
						
						<div class="form-group form-inline row">
							<div class="col-xs-12">
								<label for="example-text-input"><fmt:message key="AG012" /></label>
								<input class="form-check-input" type="radio" name="formaPgto" id="formaPgto" value="DINHEIRO" required="required"><fmt:message key="AG013" /> 
								<input class="form-check-input" type="radio" name="formaPgto" id="formaPgto" value="CHEQUE">
								<fmt:message key="AG014" />
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-xs-2">
								<label for="example-text-input"><fmt:message key="AG015" /></label>
								<input class="form-control" id="valor" name="valor" type="text"  value="${valor}">
							</div>
						</div>

						<div class="text-center" style="margin: 10px 0 20px 0;">
							<button type="submit" class="btn btn-primary">Efetuar Pagamento</button>
						</div>
					</div>
				</div>
			</div>
			
			<input type="hidden" name="idConsulta" value="${consulta.idConsulta}" />
			<input type="hidden" name="idAgendamento" value="${consulta.agendamento.idAgendamento}" />
			
		</form:form>
	</div>

	<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>