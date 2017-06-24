<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Cadastro de Clientes</title>
</head>
<body>
	<div class="page-header">
		<h3>Novo Cliente</h3>
	</div>
	
	<c:url var="addAction" value="/cliente/add" ></c:url>

	<form:form action="${addAction}" commandName="cliente" method="POST">
	
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
    		<form:label path="profissao">Profissão</form:label>
			<form:input path="profissao" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="altura">Altura</form:label>
			<form:input path="altura" cssClass="form-control"/>
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
    		<form:label path="obs">Observações</form:label>
			<form:input path="obs" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<c:if test="${!empty cliente.nome}">
				<input type="submit" class="btn" value="<spring:message text="Alterar Usuário"/>" />
			</c:if>
			<c:if test="${empty cliente.nome}">
				<input type="submit" class="btn" value="<spring:message text="Incluir Usuário"/>" />
			</c:if>
		</div>
	</form:form>
	
	<br>
		
	<div class="page-header">
		<h3>Clientes</h3>
	</div>
	
	<c:if test="${!empty clientes}">
		<table class="table">
			<tr>
				<th>Cpf</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Alterar</th>
				<th>Excluir</th>
			</tr>
			<c:forEach items="${clientes}" var="cliente">
				<tr>
					<td>${cliente.cpf}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.email}</td>
					<td><a href="<c:url value='/cliente/edit/${cliente.idPessoa}' />" >Alterar</a></td>
					<td><a href="<c:url value='/cliente/remove/${cliente.idPessoa}' />" >Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
