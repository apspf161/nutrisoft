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
<script src="resources/js/agendamento.js"></script>


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

		<form:form action="agendamento/agendarConsulta" id="form" commandName="agendamento" method="post" class="simple_form form-horizontal" style="margin-top: 50px;">
			<div id="page-content-wrapper">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<c:if test="${inclusao}">
							<fmt:message key='AG001' />
							<a id="voltar" href="agendamento/listaClientesParaAgendamento" class="btn btn-info btn-xs" style="float: right;" role="button"><fmt:message key='AG003' /></a>
						</c:if>
						<c:if test="${ not inclusao}">
							<fmt:message key='AG002' />
							<a id="voltar" href="agendamento/listaAgendamento" class="btn btn-info btn-xs" style="float: right;" role="button"><fmt:message key='AG003' /></a>
						</c:if>
 
						
					</div>

					<div class="panel-body">

 						<c:if test="${not empty error}">
							<div class="alert alert-danger">${error}</div>
						</c:if>
						<c:if test="${not empty sucess}">
							<div class="alert alert-success">${sucess}</div>
						</c:if>
 
						<input name="cliente.idPessoa" id="idPessoa" type="hidden" value="<c:out value="${ cliente.idPessoa }"  />"> 
						<%-- <input name="inclusao" type="hidden" value="<c:out value="${ inclusao }"  />"> --%>

						<div class="form-group row">
							<div class="col-xs-12">
								<label for="example-text-input"><fmt:message key="AG005" /></label>
								<input class="form-control" name="cliente.nome" value="${cliente.nome}" disabled="disabled">
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-xs-6">
								<label for="example-text-input"><fmt:message key="AG006" /></label>
								<input class="form-control" name="cliente.cpf" value="${cliente.cpf}" disabled="disabled">
							</div>
							
							<div class="col-xs-6">
								<label for="example-text-input"><fmt:message key="AG007" /></label>
								<input class="form-control" name="cliente.telefone" value="${cliente.telefone}" disabled="disabled">
							</div>
						</div>
						
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-4 col-form-label"><fmt:message key="AG004" /></label>
							<div class="col-xs-12">
								<select class="form-control" required="required" name="nutricionista.idPessoa" disabled="${not inclusao ? 'disabled' : ''}">
									<option value=""><fmt:message key="AG004" /></option>
									<c:forEach items="${nutricionistas}" var="nutri">
										<option value="${nutri.idPessoa}"	${nutri.idPessoa == agendamento.nutricionista.idPessoa ? 'selected="selected"' : '' }>${nutri.nome }</option>
									</c:forEach>
								</select>
							</div>
						</div>
			    
						<div class="form-group form-inline row">
							<div class="col-xs-12">
								<label for="example-text-input"><fmt:message key="AG011" /></label>
								<input class="form-check-input" type="radio" name="tipoConsulta" id="tipoConsulta" value="P"  disabled="${not inclusao ? 'disabled' : ''}" checked="${tipoConsulta == 'P' ? 'checked' : '' }" required="required"><fmt:message key="AG008" />
							    <input class="form-check-input" type="radio" name="tipoConsulta" id="tipoConsulta" value="A"  disabled="${not inclusao ? 'disabled' : ''}" checked="${tipoConsulta == 'A' ? 'checked' : '' }" ><fmt:message key="AG009" />

							</div>
						</div>
						
						<div class="form-group row">
						  <label  for="example-text-input" class="col-xs-4 col-form-label"><fmt:message key="AG010" /></label>
						  <div class="col-xs-12">
<%-- 								<div id="datetimepicker1" class="input-append date">
								  <input data-format="dd/MM/yyyy hh:mm" value="${dataAgendamento}" name="dataAgendamento" id="dataAgendamento" type="text"></input>
								  <span class="add-on">
								    <!-- <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i> -->
								    <span class="glyphicon glyphicon-calendar" ></span>
								  </span>
								    					  <div class="col-xs-12">
								<div id="datetimepicker1" class="input-append date">
								  <input value="${dataAgendamento}" name="dataAgendamento" id="dataAgendamento" type="datetime-local"></input>
								</div>
								</div> --%>
								<div class="input-group date form_datetime col-md-5" data-date-format="dd/mm/yyyy hh:ii" data-link-field="dtp_input1">
				                    <input class="form-control" size="16" type="text" value="<fmt:formatDate pattern='dd/MM/yyyy hh:mm' value='${agendamento.dataAgendamento}' />"  name="dataAgendamento" id="dataAgendamento" readonly>
									<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
				                </div>
  						  </div>
						</div>
						
					</div>
					
					<div class="text-center" style="margin: 10px 0 20px 0;"> 
						<button type="submit" class="btn btn-primary">${not inclusao ? 'Alterar Agendamento' : 'Agendar Consulta'}</button> 
					</div>
				</div>
			</div>
		</form:form>
	</div>

	<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>