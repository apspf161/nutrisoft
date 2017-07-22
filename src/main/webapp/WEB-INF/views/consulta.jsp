<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Cadastro de Consulta</title>
</head>
<body>
	<div class="page-header">
		<h3>Consulta</h3>
	</div>
	
	<c:url var="addAction" value="/consulta/add" ></c:url>
	
	<form:form action="${addAction}" modelAttribute="consulta" method="POST">
		<form:hidden path="idConsulta" />
		<form:hidden path="agendamento.idAgendamento" />
		
		<div class="form-group">
    		<form:label path="agendamento.cliente.nome">Cliente</form:label>
    		<c:out value="${consulta.agendamento.cliente.nome}" />
		</div>
		<div class="form-group">
    		<form:label path="pesoCliente">Peso Atual</form:label>
			<form:input path="pesoCliente" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="meta">Meta de Peso</form:label>
			<form:input path="meta" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="calorias">Calorias</form:label>
			<form:input path="calorias" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="valor">Valor</form:label>
			<form:input path="valor" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="pago">Pago</form:label>
			<form:select path="pago" cssClass="form-control">
				<form:option value="false">Não</form:option>
				<form:option value="true">Sim</form:option>
			</form:select>
		</div>
		
		<%--
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
		--%>
		<div class="form-group">
			<input type="submit" class="btn" value="<spring:message text="Salvar Consulta"/>" />
		</div>
	</form:form>
</body>
</html>