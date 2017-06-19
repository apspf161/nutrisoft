<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<sec:authentication var="user" property="principal" />
<sec:authentication property="authorities" var="roles" scope="page" />

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<sec:authorize access="hasAuthority('atendente')">
					<li><a href="${pageContext.request.contextPath}/agendamento">Agendamento</a></li>
				</sec:authorize>

				<sec:authorize access="hasAuthority('nutricionista') ">
					<li><a href="${pageContext.request.contextPath}/consulta">Consulta</a></li>
					<li><a href="${pageContext.request.contextPath}/consulta/grafico">Gráfico de Evolução</a></li>
					<li><a href="${pageContext.request.contextPath}/relatorios">Relatórios</a></li>
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('atendente')">
					<li><a href="${pageContext.request.contextPath}/consulta/pagamento">Pagamento</a></li>
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('administrador') ">
					<li><a href="${pageContext.request.contextPath}/usuario">Usuários</a></li>
				</sec:authorize>
				
			<%-- 
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Administração <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/adesao/adesao">Solicitação</a></li>
						<li><a href="${pageContext.request.contextPath}/adesao/acompanhar">Acompanhamento</a></li>
					</ul>
				</li>
			--%>
				<li><a href="<c:url value="j_spring_security_logout" />">Sair</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	<!--/.container-fluid -->
</nav>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />