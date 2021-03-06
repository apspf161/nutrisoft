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
					<h2>Relat�rio de Pagamentos de Consulta</h2>
					<p>
						<label>Filtro </label>
						<div class="input-group input-group-sm col-xs-5" style="margin: 10px 0 0 0;">
							<span class="input-group-addon" id="sizing-addon3">Per�odo</span>
							<div class="input-group date col-md-10">
				            	<input class="form-control" size="20" type="text" name="txtData" id="txtData" />
			                </div>
						</div>
						<div class="input-group input-group-sm col-xs-5" style="margin: 10px 0 0 0;">
							<span class="input-group-addon" id="sizing-addon3">Nutricionista</span> 
							<select class="form-control" name="cmbNutricionista" >
								<option value="0"><fmt:message key="AG004" /></option>
								<c:forEach items="${nutricionistas}" var="nutri">
									<option value="${nutri.idPessoa}">${nutri.nome}</option>
								</c:forEach>
							</select>
						</div>
						<div class="input-group input-group-sm col-xs-5" style="margin: 10px 0 0 0;">
							<span class="input-group-addon" id="sizing-addon3">Valor Pendente</span>
							<div class="input-group date col-md-10">
				            	<!-- <input class="form-control" size="20" type="text" name="txtValor" id="txtValor" /> -->
								<select class="form-control" name="cmbValor" >
									<option value=""></option>
									<option value="1">Sim</option>
									<option value="0">N�o</option>
								</select>
				                
								<span class="input-group-btn" style="margin: 0 10px 0 0"> 
									<a id="btnFiltrarRelPagamentos" class="btn btn-primary btn-sm" tabindex=0 role="button">Consultar</a>
								</span>
							</div>
						</div>
					</p>
				</div>	
					<table class="display" id="content-table-pagamentos">
						<thead>
							<tr>
								<th>Data da Consulta</th>
								<th>Hora da Consulta</th>
								<th>Cliente</th>
								<th>Telefone do Cliente</th>
								<th>Nutricionista</th>
								<th>Forma de Pagamento</th>
								<th>Valor da Consulta</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lista" items="${pagamentos}">
								<tr class="text-left">
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${lista.agendamento.dataAgendamento}" /></td>
									<td><fmt:formatDate pattern="HH:mm" value="${lista.agendamento.dataAgendamento}" /></td>
									<td>${lista.agendamento.cliente.nome}</td>
									<td>${lista.agendamento.cliente.telefone}</td>
									<td>${lista.agendamento.nutricionista.nome}</td>
									<td>${fn:toUpperCase(fn:substring(lista.formaPgto, 0, 1))}${fn:toLowerCase(fn:substring(lista.formaPgto, 1, -1))}</td>									
									<td><fmt:formatNumber type="currency" value="${lista.valor}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
		</section>
	</div>
	<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>