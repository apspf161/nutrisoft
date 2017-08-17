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
<script src="resources/js/grafico.js"></script>
</head>
<body>
	<c:import url="/WEB-INF/views/header.jsp"></c:import>

	<div class="container" id="container">

		<c:import url="/WEB-INF/views/menu.jsp"></c:import>

		<section>
			<div id="page-content-wrapper">
				<c:if test="${not empty error}">
					<div class="alert alert-danger">${error}</div>
				</c:if>
				<c:if test="${not empty success}">
					<div class="alert alert-success">${success}</div>
				</c:if>
	
				<div class="form-group email required user_horizontal_email">
					<h2>Gráfico de Evolução</h2>

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
								<a id="btnFiltrarCliente" class="btn btn-primary btn-sm" tabindex=0 role="button">Consultar</a>
							</span>
						</div>
					</p>
					
					<table class="table table-striped" id="content-table-clientes">
						<thead>
							<tr>
								<th></th>
								<th>Nome</th>
								<th>CPF</th>
								<th>Telefone</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lista" items="${listaCliente}">
								<tr class="text-left">
									<td>${lista.idPessoa}</td>
									<td>${lista.nome}</td>
									<td>${lista.cpf}</td>
									<td>${lista.telefone}</td>
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