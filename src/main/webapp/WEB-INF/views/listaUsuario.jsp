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
<c:import url="/WEB-INF/views/imports.jsp" />
<script src="resources/js/usuario.js"></script>

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
					<h2>Lista de Usuários</h2>
					
					<p></p>
					<table class="display" id="content-table-usuario">
						<thead>
							<tr>
								<th></th>
								<th>Nome</th>
								<th>Email</th>
								<th>Login</th>
								<th>Perfil</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lista" items="${listaUsuarios}">
								<tr class="text-left">
									<td>${lista.idPessoa}</td>
									<td>${lista.nome}</td>
									<td>${lista.email}</td>
									<td>${lista.login}</td>
									<td>${lista.perfil.formatado}</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr id="filterrow">
								<th></th>
							</tr>
							<tr id="buttons">
								<td class="result" colspan="5">
									<a id="btnAlterar" class="btn btn-sm btn-default" ><i class="icon-plus"></i> Alterar Usuário </a>
									<a id="btnExcluir" class="btn btn-sm btn-default"  data-toggle="confirmation-excluir"><i class="icon-eye-open"></i> Excluir Usuário</a>
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</section>
	</div>
	
	<form:form name="form" class="form"	method="post" commandName="usuario">
		<input type="hidden" id="idUsuario" name="idUsuario" />
	</form:form >
	
	<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>