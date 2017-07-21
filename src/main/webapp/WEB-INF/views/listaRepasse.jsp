<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.Date"%>
<c:set var="pageReq" value="${pageContext.request}" scope="page" />
<c:set var="urlBase" value="${fn:replace(pageReq.requestURL, pageReq.requestURI, pageReq.contextPath)}/" scope="request" />
<!DOCTYPE html>
<html lang="pt-br">
<head>
<base href="${urlBase}">
<c:import url="/WEB-INF/jsp/header.jsp"></c:import>
<script src="resources/js/prc.js"></script>
</head>

<c:url var="images"
	value="${pageContext.request.contextPath}/resources/core/img/"></c:url>
<div class="media" id="header"></div>
<div class="container" id="container">

	<c:import url="/WEB-INF/jsp/sidebar.jsp"></c:import>

		<div id="page-content-wrapper">
				<div class="form-group email required user_horizontal_email">
					<h2>
						<fmt:message key='M0122' />
					</h2>
					<p>
					<%-- 	<fmt:message key='M0123' /> --%>
					</p> 
					
					<p>
						<label>Filtro </label>	
						<label class="radio-inline" style="margin-left:10px;"> <input type="radio" name="optradio" id="optradio" value="X">Todos</label>
						<label class="radio-inline"> <input type="radio" name="optradio" id="optradio" value="PRC">PRC</label>
						<label class="radio-inline"> <input type="radio" name="optradio" id="optradio" value="DRC">DRC</label>
						<a id="btnFiltrar" class="btn btn-primary btn-sm">Filtrar</a>			
						
						<input type="hidden" name="vlrOptRadio" id="vlrOptRadio" value="${vlrOptRadio}" />	
					</p>
					
					<table class="table table-striped" id="content-table-repasse">
						<thead>
							<tr>
								<th><fmt:message key='S0001' /></th>
								<th><fmt:message key='S0002' /></th>
								<th><fmt:message key='M0060' /></th>								
								<th><fmt:message key='M0124' /></th>
								<%-- <th><fmt:message key='M0085' /></th> --%>
								<th><fmt:message key='M0127' /></th>								
								<th><fmt:message key='M0125' /></th>
								<th><fmt:message key='M0126' /></th>
								<th><fmt:message key='M0128' /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lista" items="${listaRepasse}">
								<tr class="text-left">
									<td>${lista.matricula}</td>
									<td>${lista.elegivel.nome}</td>
									<td>${lista.numeroPrc}</td>														
									<%-- <td><fmt:formatDate pattern="dd/MM/yyyy  HH:mm:ss" value="${lista.dtPrc}" /></td> --%> 
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${lista.elegivel.dataLimite}" /></td> 
									<td>${lista.descStatusPrc}</td>
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${lista.dtAprovadoGerente}" /></td>
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${lista.elegivel.dt_PPA}" /></td>
									<td>${lista.tipoRepasse}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

</div>
</body>
</html>