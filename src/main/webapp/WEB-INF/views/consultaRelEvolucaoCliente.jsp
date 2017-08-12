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
<link href="resources/css/relatorio.css" rel="stylesheet" />
<script src="resources/js/relatorio.js"></script>

<c:set value="show" var="classError"></c:set>
<c:set value="block" var="displayTable"></c:set>

<c:if test="${empty error}">
	<c:set value="hide" var="classError"></c:set>
</c:if>

<c:if test="${empty evolucoes}">
	<c:set value="none" var="displayTable"></c:set>
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
					<h2>Relatório de Evolução do Cliente</h2>
					<p>
						<label>Filtro </label>
					<div class="input-group input-group-sm col-xs-4">
						<span class="input-group-addon" id="sizing-addon3">Cliente</span>
						<input type="text" class="form-control" placeholder="Cliente"
							name="txtNome" aria-describedby="sizing-addon3">
					</div>
					<div class="input-group input-group-sm col-xs-5"
						style="margin: 10px 0 0 0;">
						<span class="input-group-addon" id="sizing-addon3">Período</span>
						<div class="input-group date col-md-10">
							<input class="form-control" size="20" type="text" name="txtData"
								id="txtData">
						</div>

						<span class="input-group-btn" style="margin: 0 10px 0 0"> <a
							id="btnFiltrarRelEvolucao" class="btn btn-primary btn-sm"
							tabindex=0 role="button">Consultar</a>
						</span>
					</div>
					</p>

					<table class="display" id="content-table-evolucao">
						<thead>
							<tr>
								<th>Consulta</th>
								<th>Nutricionista</th>
								<th>Cliente</th>
								<th>Idade</th>
								<th>Peso recomendado</th>
								<th>Altura</th>
								<th>IMC</th>
								<th>Risco de Comorbidades</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lista" items="${evolucoes}">
								<tr class="text-left">
									<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${lista.agendamento.dataAgendamento}" /></td>
									<td>${lista.agendamento.nutricionista.nome}</td>
									<td>${lista.agendamento.cliente.nome}</td>
									<td>Idade</td>
									<td>${lista.antropometria.pesoDesejavel}</td>
									<td>${lista.agendamento.cliente.altura}</td>
									<td>IMC</td>
									<td>Risco de Comorbidades</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<table id="content-table-medidas" class="display" style="display:${displayTable}" >
							<thead>
								<tr>
									<th></th>
									<c:forEach var="lista" items="${evolucoes}">
										<th><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${lista.agendamento.dataAgendamento}" /></th>
									</c:forEach>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Panturrilha (cm)</td>
									
									<c:forEach var="lista" items="${evolucoes}">
									<td>${lista.antropometria.panturrilha}</td>
									</c:forEach>
								</tr>
								<tr>
									<td>Braço relaxado (cm)</td>
									<c:forEach var="lista" items="${evolucoes}">
									<td>${lista.antropometria.bracoRelaxado}</td>
									</c:forEach>
								</tr>
								<tr>
									<td>Coxa medial (cm)</td>
									<c:forEach var="lista" items="${evolucoes}">
									<td>${lista.antropometria.coxaMedial}</td>
									</c:forEach>
								</tr>
								<tr>
									<td>Coxa proximal (cm)</td>
									<c:forEach var="lista" items="${evolucoes}">
									<td>${lista.antropometria.coxaProximal}</td>
									</c:forEach>
								</tr>
								<tr>
									<td>Quadril (cm)</td>
									<c:forEach var="lista" items="${evolucoes}">
									<td>${lista.antropometria.quadril}</td>
									</c:forEach>
								</tr>
								<tr>
									<td>Abdômen (cm)</td>
									<c:forEach var="lista" items="${evolucoes}">
									<td>${lista.antropometria.abdomen}</td>
									</c:forEach>
								</tr>
								<tr>
									<td>Cintura (cm)</td>
									<c:forEach var="lista" items="${evolucoes}">
									<td>${lista.antropometria.cintura}</td>
									</c:forEach>
								</tr>
								<tr>
									<td>Braço fletido (cm)</td>
									<c:forEach var="lista" items="${evolucoes}">
									<td>${lista.antropometria.bracoFletido}</td>
									</c:forEach>
								</tr>
								<tr>
									<td>Braço relaxado (cm)</td>
									<c:forEach var="lista" items="${evolucoes}">
									<td>${lista.antropometria.bracoRelaxado}</td>
									</c:forEach>
								</tr>
								<tr>
									<td>Tórax (cm)</td>
									<c:forEach var="lista" items="${evolucoes}">
									<td>${lista.antropometria.torax}</td>
									</c:forEach>
								</tr>
								<tr>
									<td>Triciptal (mm)</td>
									<c:forEach var="lista" items="${evolucoes}">
									<td>${lista.antropometria.triciptal}</td>
									</c:forEach>
								</tr>
								<tr>
									<td>Peitoral (mm)</td>
									<c:forEach var="lista" items="${evolucoes}">
									<td>${lista.antropometria.peitoral}</td>
									</c:forEach>
								</tr>
								<tr>
									<td>Axilar média (mm)</td>
									<c:forEach var="lista" items="${evolucoes}">
									<td>${lista.antropometria.axilarMedia}</td>
									</c:forEach>
								</tr>
								<tr>
									<td>Subescapular (mm)</td>
									<c:forEach var="lista" items="${evolucoes}">
									<td>${lista.antropometria.subescapular}</td>
									</c:forEach>
								</tr>
								<tr>
									<td>Abdominal (mm)</td>
									<c:forEach var="lista" items="${evolucoes}">
									<td>${lista.antropometria.abdominal}</td>
									</c:forEach>
								</tr>
								<tr>
									<td>Suprailíaca (mm)</td>
									<c:forEach var="lista" items="${evolucoes}">								
									<td>${lista.antropometria.suparaliaca}</td>
									</c:forEach>
								</tr>
								<tr>
									<td>Coxa (mm)</td>
									<c:forEach var="lista" items="${evolucoes}">
									<td>${lista.antropometria.coxa}</td>
									</c:forEach>
								</tr>
						</tbody>
					</table>
				</div>
			</div>
		</section>
	</div>
	<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>