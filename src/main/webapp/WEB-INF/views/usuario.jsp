<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@ page import="java.util.Date"%>

<c:set var="pageReq" value="${pageContext.request}" />
<c:set var="urlBase" value="${fn:replace(pageReq.requestURL, pageReq.requestURI, pageReq.contextPath)}/" scope="request" />
<!DOCTYPE HTML>
<html>
<head>
<c:import url="/WEB-INF/views/imports.jsp"></c:import>
<script src="resources/js/usuario.js"></script>

</head>
<body>
	<c:import url="/WEB-INF/views/header.jsp"></c:import>

	<div class="container" id="container">

		<c:import url="/WEB-INF/views/menu.jsp"></c:import>
		
		<c:set var = "campoDesabilitado" value="${not inclusao ? 'disabled=disabled' : ''}"/>
		
		<form:form action="usuario/incluirUsuario" commandName="usuario" method="POST" class="simple_form form-horizontal" style="margin-top: 50px;">
			<div id="page-content-wrapper">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<%-- <c:if test="${ inclusao}"><fmt:message key='AG027' /></c:if>
						<c:if test="${ not inclusao}"><fmt:message key='AG028' /></c:if> --%>
						<fmt:message key='AG027' />
						<a id="voltar" href="usuario/listaUsuario" class="btn btn-info btn-xs" style="float: right;" role="button"><fmt:message key='AG029' /></a>
					</div>
						
					<div class="panel-body">

 						<c:if test="${not empty error}">
							<div class="alert alert-danger">${error}</div>
						</c:if>
						<c:if test="${not empty sucess}">
							<div class="alert alert-success">${sucess}</div>
						</c:if>
 
						<div class="form-group row">
							<div class="col-xs-12">
								<form:label path="nome">Nome</form:label>
								<form:input path="nome" cssClass="form-control" required="true" />
							</div>
						</div>

						<div class="form-group row">
							<div class="col-xs-6">
								<form:label path="dataNascimento">Data de Nascimento</form:label>
								<form:input path="dataNascimento" cssClass="form-control" required="true"  />
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-xs-6">
								<form:label path="cpf">CPF</form:label>
								<form:input path="cpf" cssClass="form-control" required="true"  />
							</div>

							<div class="col-xs-6">
								<form:label path="email">E-mail</form:label>
								<form:input path="email" cssClass="form-control" required="true"  />
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-xs-12">
								<form:label path="login">Login</form:label>
								<form:input path="login" cssClass="form-control" />
							</div>
						</div>			
						
						<div class="form-group row">
							<div class="col-xs-12">
							</div>
						</div>			
						<div class="form-group row">
							<div class="col-xs-6">
								<form:label path="perfil">Perfil</form:label>
								<form:select path="perfil" cssClass="form-control">
									<form:option value="ADMINISTRADOR">Administrador </form:option>
									<form:option value="ATENDENTE">Atendente </form:option>
									<form:option value="NUTRICIONISTA">Nutricionista </form:option>
								</form:select>

							</div>
							<div class="col-xs-6">
								<form:label path="sexo">Sexo</form:label>
								<form:select path="sexo" cssClass="form-control">
									<form:option value="F">Feminino </form:option>
									<form:option value="M">Masculino </form:option>
								</form:select>
							</div>			
						</div>
					
						<div class="form-group row">
							<div class="col-xs-8">
								<form:label path="endereco">Endereco</form:label>
								<form:input path="endereco" cssClass="form-control" />
							</div>
						
							<div class="col-xs-4">
								<form:label path="cep">CEP</form:label>
								<form:input path="cep" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group row">
							<div class="col-xs-6">
								<form:label path="cidade">Cidade</form:label>
								<form:input path="cidade" cssClass="form-control" />
							</div>
							<div class="col-xs-6">
								<form:label path="uf">UF</form:label>
								<form:input path="uf" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-xs-6">
								<form:label path="telefone">Telefone</form:label>
								<form:input path="telefone" cssClass="form-control" />
							</div>
							<div class="col-xs-6">
								<form:label path="celular">Celular</form:label>
								<form:input path="celular" cssClass="form-control" />
							</div>
						</div>
														
						<div class="text-center" style="margin: 10px 0 20px 0;"> 
							<button type="submit" class="btn btn-primary">Salvar</button> 
						</div>
				</div>
			</div>
			</div>
			
			<input type="hidden" name="usuario.idPessoa" id="idPessoa" value="5" />
		</form:form>
	</div>

	<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>