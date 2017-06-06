<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Cadastro de Usu�rios</title>
</head>
<body>
	<div class="page-header">
		<h3>Novo Usu�rio</h3>
	</div>
	
	<c:url var="addAction" value="/usuario/add" ></c:url>

	<form:form action="${addAction}" commandName="usuario">
		<form:hidden path="id"/>
		<div class="form-group">
    		<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="email">E-mail</form:label>
			<form:input path="email" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="login">Login</form:label>
			<form:input path="login" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="senha">Senha</form:label>
			<form:password path="senha" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="perfil">Senha</form:label>
			<form:select path="perfil" cssClass="form-control">
				<form:option value="1">Atendente</form:option>
				<form:option value="2">Nutricionista</form:option>
				<form:option value="3">Administrador</form:option>
			</form:select>
		</div>
		<div class="form-group">
			<c:if test="${!empty usuario.nome}">
				<input type="submit" class="btn" value="<spring:message text="Alterar Usu�rio"/>" />
			</c:if>
			<c:if test="${empty usuario.nome}">
				<input type="submit" class="btn" value="<spring:message text="Incluir Usu�rio"/>" />
			</c:if>
		</div>
	</form:form>
	
	<br>
		
	<div class="page-header">
		<h3>Usu�rios</h3>
	</div>
	
	<c:if test="${!empty usuarios}">
		<table class="table">
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Login</th>
				<th>perfil</th>
				<th>Alterar</th>
				<th>Excluir</th>
			</tr>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.nome}</td>
					<td>${usuario.email}</td>
					<td>${usuario.login}</td>
					<td>${usuario.perfil}</td>
					<td><a href="<c:url value='/edit/${person.id}' />" >Alterar</a></td>
					<td><a href="<c:url value='/remove/${person.id}' />" >Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
