<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<html>
<head></head>
<body>
	<header>
		<c:import url="/WEB-INF/views/header.jsp"></c:import>
	</header>

	<div class="container" id="container">

		<c:import url="/WEB-INF/views/menu.jsp"></c:import>

		<section>
			<div id="page-content-wrapper">
				<div class="form-group email required user_horizontal_email">
					<h2>Lista de Usuários</h2>

					<table class="table table-striped" id="content-table">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Email</th>
								<th>Login</th>
								<th>Perfil</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lista" items="${listaUsuarios}">
								<tr class="text-left">
									<td>${lista.nome}</td>
									<td>${lista.email}</td>
									<td>${lista.login}</td>
									<td>${lista.perfil}</td>
									<td>
										<a id="btnAlterar" href="<c:url value='/usuario/edit/${lista.idPessoa}' />" class="btn btn-sm btn-default"><i class="icon-edit icon-white"></i> Alterar</a>
									</td>
									<td>
										<a id="btnAlterar" href="<c:url value='/usuario/remove/${lista.idPessoa}' />" class="btn btn-sm btn-default"><i class="icon-edit icon-white"></i> Excluir</a>
									</td>

									<%-- 				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${lista.dt_agendamento}" /></td>	 --%>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr id="filterrow">
								<th></th>
							</tr>
							<tr id="buttons">
								<td class="result" colspan="6">
									<a id="btnInclui" href="<c:url value='/usuario/usuario' />" class="btn btn-sm btn-default"><i class="icon-plus icon-white"></i> Incluir</a>
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</section>
	</div>

	<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>

<script src="resources/js/agendamento.js"></script>
</html>