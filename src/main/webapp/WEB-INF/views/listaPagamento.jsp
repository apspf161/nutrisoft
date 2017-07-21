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
<link href="resources/css/pagamento.css" rel="stylesheet" />
<script src="resources/js/pagamento.js"></script>

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
					<h2>Consultar Pagamentos</h2>
					<p>
						<label>Filtro </label>
						<div class="input-group input-group-sm col-xs-4">
							<span class="input-group-addon" id="sizing-addon3">Nome</span> <input
								type="text" class="form-control" placeholder="Nome"
								name="txtNome" aria-describedby="sizing-addon3">
						</div>

						<div class="input-group input-group-sm col-xs-4"
							style="margin: 10px 0 0 0;">
							<span class="input-group-addon" id="sizing-addon3">CPF</span> 
							<input type="text" class="form-control" placeholder="CPF" name="txtCPF" aria-describedby="sizing-addon3"> 
							<span class="input-group-btn" style="margin: 0 10px 0 0"> 
								<a id="btnFiltrarPagamento" class="btn btn-primary btn-sm" tabindex=0 role="button">Consultar</a>
							</span>
						</div>
					</p>
					
					
					<table class="display" id="content-table-pagamento">
						<thead>
							<tr>
								<th></th>
								<th></th>
								<th>Data da Consulta</th>
								<th>Cliente</th>
								<th>CPF</th>
								<th>Nutricionista</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lista" items="${listaPagamento}">
								<tr class="text-left">
									<td>${lista.idConsulta}</td>
									<td class="details-control"></td>
									<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${lista.agendamento.dataAgendamento}" /></td>
									<td>${lista.agendamento.cliente.nome}</td>
									<td>${lista.agendamento.cliente.cpf}</td>
									<td>${lista.agendamento.nutricionista.nome}</td>
									<td><fmt:formatNumber type="currency" value="${lista.valor}" /></td>
									<td>Dinheiro</td>
									<%-- <td>${lista.formaPagamento}</td> --%>
								</tr>
							</c:forEach>
						</tbody>
							<tfoot>
								<tr id="filterrow">
									<th></th>
								</tr>
							</tfoot>
					</table>
					
				</div>
			</div>
		</section>
	</div>

	<form name="form" class="form"	method="post" commandName="consulta">
		<input type="hidden" id="idConsulta" name="idConsulta" />
	</form >
	<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>