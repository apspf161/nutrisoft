<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<c:set value="show" var="classError"></c:set>

<c:if test="${empty error}"> 
  <c:set value="hide" var="classError"></c:set>
</c:if> 

</head>
<body>
	<c:import url="/WEB-INF/views/header.jsp"></c:import>

	<div class="container" id="container">

		<c:import url="/WEB-INF/views/menu.jsp"></c:import>

		
		<div class="page-header">
			<h3>Consultas</h3>
		</div>
		
		<c:if test="${!empty consultas}">
			<table class="table">
				<tr>
					<th>Data / Hora</th>
					<th>Nutricionista</th>
					<th>Cliente</th>
					<th>Valor</th>
					<th>Pago</th>
					<th>A��es</th>
				</tr>
				<c:forEach items="${consultas}" var="consulta">
					<tr>
						<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${consulta.agendamento.dataAgendamento}" /></td>
						<td>${consulta.agendamento.nutricionista.nome}</td>
						<td>${consulta.agendamento.cliente.nome}</td>
						<td>
							<c:if test="${not empty consulta.valor}">
								R$ <fmt:formatNumber pattern="#.00" value="${consulta.valor}" />
							</c:if>
						</td>
						<td>
							<c:if test="${consulta.pago}">Sim</c:if>
							<c:if test="${!consulta.pago}">N�o</c:if>
						</td>
						<td><a href="<c:url value='/consulta/historico/${consulta.idConsulta}' />" >Visualizar</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
	</div>
</body>
</html>