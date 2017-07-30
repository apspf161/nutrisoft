<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Agendamentos de Hoje</title>
</head>
<body>
	<div class="page-header">
		<h3>Agendamentos de Hoje</h3>
	</div>
	
	<c:if test="${!empty agendamentos}">
		<table class="table">
			<tr>
				<th>Data / Hora</th>
				<th>Nutricionista</th>
				<th>Cliente</th>
				<th>Tipo Consulta</th>
				<th>Ação</th>
			</tr>
			<c:forEach items="${agendamentos}" var="agendamento">
				<tr>
					<td>${agendamento.dataAgendamento}</td>
					<td>${agendamento.nutricionista.nome}</td>
					<td>${agendamento.cliente.nome}</td>
					<td>${agendamento.tipoConsulta.formatado}</td>
					<td><a href="<c:url value='/consulta/add?idAgendamento=${agendamento.idAgendamento}' />" >Iniciar Consulta</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>