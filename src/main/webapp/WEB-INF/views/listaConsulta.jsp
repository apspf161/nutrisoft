<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Consultas</title>
</head>
<body>
	<header>
		<c:import url="/WEB-INF/views/header.jsp"></c:import>
	</header>

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
				</tr>
				<c:forEach items="${consultas}" var="consulta">
					<tr>
						<td>${consulta.agendamento.dataAgendamento}</td>
						<td>${consulta.agendamento.nutricionista.nome}</td>
						<td>${consulta.agendamento.cliente.nome}</td>
						<td>${consulta.valor}</td>
						<td>${consulta.pago}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
	</div>
</body>
</html>