<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			
			
			
		</div>

		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
					<li><a href="${pageContext.request.contextPath}/interno/adesao/simulacao">Agendamento</a></li>
					<li><a href="${pageContext.request.contextPath}/interno/adesao/simulacao">Consulta</a></li>
					<li><a href="${pageContext.request.contextPath}/interno/adesao/simulacao">Gráfico de Evolução</a></li>
					<li><a href="${pageContext.request.contextPath}/interno/adesao/simulacao">Relatórios</a></li>
					<li><a href="${pageContext.request.contextPath}/interno/adesao/simulacao">Pagamento</a></li>
					<%-- <li><a href="${pageContext.request.contextPath}/interno/adesao/simulacao"><i class="fa fa-plus" aria-hidden="true" style="color: grey;"></i><span class="text"> CREATE</span></a></li> --%>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Administração <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/interno/adesao/adesao">Solicitação</a></li>
							<li><a href="${pageContext.request.contextPath}/interno/adesao/acompanhar">Acompanhamento</a></li>
						</ul>
					</li>
					<li><a href="${pageContext.request.contextPath}/<c:url value='j_spring_security_logout' />">Sair</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	<!--/.container-fluid -->
</nav>