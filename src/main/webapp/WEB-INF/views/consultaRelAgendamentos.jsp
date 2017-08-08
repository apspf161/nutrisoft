<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<c:set var="pageReq" value="${pageContext.request}" />
<c:set var="urlBase" value="${fn:replace(pageReq.requestURL, pageReq.requestURI, pageReq.contextPath)}/" scope="request" />
<html>
<head>
<c:import url="/WEB-INF/views/imports.jsp"></c:import>
<link href="resources/css/relatorio.css" rel="stylesheet" />
<script src="resources/js/relatorio.js"></script>

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
					<h2>Relatório de Agendamentos</h2>
					<p>
						<label>Filtro </label>
						<div class="input-group input-group-sm col-xs-5" style="margin: 10px 0 0 0;">
							<span class="input-group-addon" id="sizing-addon3">Período</span>
							<div class="input-group date col-md-10">
				            	<input class="form-control" size="20" type="text" name="txtData" id="txtData">
			                </div>
						</div>
						<div class="input-group input-group-sm col-xs-5" style="margin: 10px 0 0 0;">
							<span class="input-group-addon" id="sizing-addon3">Turno</span>
							<select class="form-control" name="cmbTurno" >
								<option value="0"><fmt:message key="AG018" /></option>
								<option value="M"><fmt:message key="AG019" /></option>
								<option value="T"><fmt:message key="AG020" /></option>
								<option value="N"><fmt:message key="AG021" /></option>
							</select>
						</div>
						<div class="input-group input-group-sm col-xs-5" style="margin: 10px 0 0 0;">
							<span class="input-group-addon" id="sizing-addon3">Nutricionista</span> 
							<select class="form-control" name="cmbNutricionista" >
								<option value="0"><fmt:message key="AG004" /></option>
								<c:forEach items="${nutricionistas}" var="nutri">
									<option value="${nutri.idPessoa}">${nutri.nome}</option>
								</c:forEach>
							</select>
 
							<span class="input-group-btn" style="margin: 0 10px 0 0"> 
								<a id="btnFiltrarRelAgendamentos" class="btn btn-primary btn-sm" tabindex=0 role="button">Consultar</a>
							</span>
						</div>
					</p>
					
					<table class="display" id="content-table-agendamentos">
						<thead>
							<tr>
								<th>Data da Consulta</th>
								<th>Hora da Consulta</th>
								<th>Cliente</th>
								<th>Telefone do Cliente</th>
								<th>Nutricionista</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lista" items="${agendamentos}">
								<tr class="text-left">
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${lista.dataAgendamento}" /></td>
									<td><fmt:formatDate pattern="HH:mm" value="${lista.dataAgendamento}" /></td>
									<td>${lista.cliente.nome}</td>
									<td>${lista.cliente.telefone}</td>
									<td>${lista.nutricionista.nome}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</section>
	</div>
	<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>