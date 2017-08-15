<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<c:set var="pageReq" value="${pageContext.request}" />
<c:set var="urlBase"
	value="${fn:replace(pageReq.requestURL, pageReq.requestURI, pageReq.contextPath)}/"
	scope="request" />

<html>
<head>
<c:import url="/WEB-INF/views/imports.jsp"></c:import>
<link href="resources/css/agendamento.css" rel="stylesheet" />
<script src="resources/js/agendamento.js"></script>

<c:set value="show" var="classError"></c:set>

<c:if test="${empty error}"> 
  <c:set value="hide" var="classError"></c:set>
</c:if> 

</head>
<body>
	<c:import url="/WEB-INF/views/header.jsp"></c:import>

	<div class="container" id="container">

		<c:import url="/WEB-INF/views/menu.jsp"></c:import>

		<section>
			<div id="page-content-wrapper">
			 
				<div class="alert alert-danger ${classError}" id="alertError">${error}</div>
											
				<c:if test="${not empty success}">
					<div class="alert alert-success">${success}</div>
				</c:if>
	
				<div class="form-group email required user_horizontal_email">
					<h2>Consultar Agendamentos</h2>
					<p>
						<label>Filtro </label>
						<div class="input-group input-group-sm col-xs-4" style="margin: 10px 0 0 0;">
							<span class="input-group-addon" id="sizing-addon3">Data</span>
								<div class="input-group date form_datetime_dtp col-md-10" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
				                    <input class="form-control" size="16" type="text" name="txtData" id="txtData" readonly aria-describedby="sizing-addon3">
									<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
				                </div>
				                <span class="input-group-btn" style="margin: 0 10px 0 0; display:none;"> 
									<a id="btnFiltrarConsulta" class="btn btn-primary btn-sm" tabindex=0 role="button" >Consultar</a>
				            	</span>
						</div>
					</p>
					
					<table class="display" id="content-table-consulta">
						<thead>
							<tr>
								<th></th>
								<th></th>
								<th>Horário</th>
								<th>Cliente</th>
								<th>Nutricionista</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lista" items="${listaAgendamento}">
								<tr class="text-left">
									<td>${lista.idAgendamento}</td>
									<td class="details-control"></td>
									<td><fmt:formatDate pattern="HH:mm" value="${lista.dataAgendamento}" /></td>
									<td>${lista.cliente.nome}</td>
									<td>${lista.nutricionista.nome}</td>
									<td>${lista.cliente.cpf}</td>
									<td>${lista.cliente.telefone}</td>
								
								</tr>
							</c:forEach>
						</tbody>
							<tfoot>
								<tr id="filterrow">
									<th></th>
								</tr>
								<tr id="buttons">
									<td class="result" colspan="7">
										<a id="btnAlterar" class="btn btn-sm btn-default" ><i class="icon-plus"></i> Alterar Agendamento</a> 
										<a id="btnConfirmar" class="btn btn-sm btn-default" data-toggle="confirmation"><i class="icon-edit"></i> Confirmar Agendamento </a> 
										<a id="btnCancelar" class="btn btn-sm btn-default"  data-toggle="confirmation-cancelar"><i class="icon-eye-open"></i> Cancelar Agendamento</a>
									</td>
								</tr>
							</tfoot>
					</table>
					
				</div>
			</div>
		</section>
	</div>

	<form name="form" class="form"	method="post" commandName="agendamento">
		<input type="hidden" id="idAgendamento" name="idAgendamento" />
	</form >
	<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>