<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<sec:authentication var="user" property="principal" />
<sec:authentication property="authorities" var="roles" scope="page" />

<nav class="navbar navbar-default">
	<div class="container-fluid">
	  <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#"><img alt="Brand" src="resources/css/img/logo_navbar_nutrisoft.jpg"></a>
	    </div>
	    
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<sec:authorize access="hasAuthority('atendente')">
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Agendamento <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/agendamento/listaClientesParaAgendamento">Agendar Consulta</a></li>
							<li><a href="${pageContext.request.contextPath}/agendamento/listaAgendamento">Consulta Agendamentos</a></li>
						</ul>
					</li>
				</sec:authorize>

				<sec:authorize access="hasAuthority('nutricionista') ">
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Consultas <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/consulta/listarAgendamentosDeHoje">Nova Consulta</a></li>
							<li><a href="${pageContext.request.contextPath}/consulta">Histórico de Consultas</a></li>
						</ul>
					</li>
					<li><a href="${pageContext.request.contextPath}/consulta/consultaRelEvolucaoCliente">Gráfico de Evolução</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Relatórios <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/consulta/consultaRelEvolucaoCliente">Evolução do Cliente</a></li>
							<li><a href="${pageContext.request.contextPath}/consulta/consultaRelAtendimentos">Atendimentos</a></li>
							<li><a href="${pageContext.request.contextPath}/agendamento/consultaRelAgendamentos">Agendamentos</a></li>
							<li><a href="${pageContext.request.contextPath}/consulta/consultaRelPagamentos">Pagamentos de Consultas</a></li>
						</ul>
					</li>
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('atendente')">
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Pagamentos <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/consulta/listaClientesParaPagamento">Efetuar Pagamento</a></li>
							<li><a href="${pageContext.request.contextPath}/consulta/listaPagamento">Consultar Pagamentos</a></li>
						</ul>
					</li>
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('administrador') ">
					<li><a href="${pageContext.request.contextPath}/usuario">Usuários</a></li>
				</sec:authorize>
				<li><a href="<c:url value="j_spring_security_logout" />">Sair</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	<!--/.container-fluid -->
</nav>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />