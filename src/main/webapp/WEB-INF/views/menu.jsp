<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<script src="resources/js/agendamento.js"></script>
</head>
<body>
	<header>
		<c:import url="/WEB-INF/views/header.jsp"></c:import>
	</header>

	<div class="container" id="container">

		<c:import url="/WEB-INF/views/menuLateral.jsp"></c:import>
		<section>
			<div id="page-content-wrapper">
				<div class="form-group email required user_horizontal_email">
					<h2>
						Próximas Consultas do Dia
					</h2>
		
					<table class="table table-striped" id="content-table">
						<thead>
							<tr>
								<th>1</th>
								<th>2</th>
								<th>3</th>
							</tr>
						</thead>
						<tbody>
							<%-- <c:forEach var="lista" items="${listaElegiveis}">
								<tr class="text-left">
									<td class="details-control"></td>
									<td>${lista.matricula}</td>
									<td>${lista.nome}</td>
									<td>${lista.adesao.documento}</td>
									<td><fmt:formatDate pattern="dd/MM/yyyy"
											value="${lista.adesao.dt_adesao}" /></td>
									<td><fmt:formatDate pattern="dd/MM/yyyy"
											value="${lista.dt_agendamento}" /></td>
									<td><fmt:formatDate pattern="dd/MM/yyyy"
											value="${lista.dt_Flexibilizacao}" /></td>
									<td>${lista.status.descricaoDoStatus}</td>
									<td><fmt:formatDate pattern="dd/MM/yyyy"
											value="${lista.dt_csa}" /></td>
									<td><fmt:formatDate pattern="dd/MM/yyyy"
											value="${lista.dt_rha}" /></td>
									<td><fmt:formatDate pattern="dd/MM/yyyy"
											value="${lista.dt_agendamento}" /></td>
								</tr>
							</c:forEach>
 --%>
							<tr class="text-left">
								<td>4</td>
								<td>5</td>
								<td>6</td>
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