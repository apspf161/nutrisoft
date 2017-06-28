<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Cadastro de Usuários</title>
</head>
<body>
	<div class="page-header">
		<h3>Novo Usuário</h3>
	</div>
	
	<c:url var="addAction" value="/usuario/add" ></c:url>

	<form:form action="${addAction}" commandName="usuario" method="POST">
	
		<form:hidden path="idPessoa" />
		
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
    		<form:label path="perfil">Perfil</form:label>
			<form:select path="perfil" cssClass="form-control">
				<form:option value="">Selecione</form:option>
				<form:option value="ATENDENTE">Atendente</form:option>
				<form:option value="NUTRICIONISTA">Nutricionista</form:option>
				<form:option value="ADMINISTRADOR">Administrador</form:option>
			</form:select>
		</div>
		
		<div class="form-group">
    		<form:label path="sexo">Sexo</form:label>
			<form:select path="sexo" cssClass="form-control">
				<form:option value="F">Feminino</form:option>
				<form:option value="M">Masculino</form:option>
			</form:select>
		</div>
		<div class="form-group">
    		<form:label path="cpf">CPF</form:label>
			<form:input path="cpf" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
    		<form:label path="endereco">Endereco</form:label>
			<form:input path="endereco" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
    		<form:label path="cep">CEP</form:label>
			<form:input path="cep" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
    		<form:label path="cidade">Cidade</form:label>
			<form:input path="cidade" cssClass="form-control"/>
		</div>
		
		
		<div class="form-group">
    		<form:label path="uf">UF</form:label>
			<form:input path="uf" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="telefone">Telefone</form:label>
			<form:input path="telefone" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
    		<form:label path="celular">Celular</form:label>
			<form:input path="celular" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="dataNascimento">Data de Nascimento</form:label>
			<form:input path="dataNascimento" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<c:if test="${!empty usuario.nome}">
				<input type="submit" class="btn" value="<spring:message text="Alterar Usuário"/>" />
			</c:if>
			<c:if test="${empty usuario.nome}">
				<input type="submit" class="btn" value="<spring:message text="Incluir Usuário"/>" />
			</c:if>
		</div>
	</form:form>
	
	<br>
		
	<div class="page-header">
		<h3>Usuários</h3>
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
					<td>${usuario.perfil.formatado}</td>
					<td><a href="<c:url value='/usuario/edit/${usuario.idPessoa}' />" >Alterar</a></td>
					<td><a href="<c:url value='/usuario/remove/${usuario.idPessoa}' />" >Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
