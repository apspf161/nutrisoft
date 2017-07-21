<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="pageReq" value="${pageContext.request}" />
<c:set var="urlBase" value="${fn:replace(pageReq.requestURL, pageReq.requestURI, pageReq.contextPath)}/" scope="request" />
<html>
<head>
<c:import url="/WEB-INF/views/imports.jsp" />
</head>
<body>
	<c:import url="/WEB-INF/views/header.jsp"></c:import>
	<section>

		<div class="alert alert-success alert-dismissible"
			style="display: none; margin-top: 10px;" id="myAlert">
			<a href="#" class="close">&times;</a> <strong>Confira seu
				e-mail! </strong>O endereço indicado receberá um e-mail com instruções de
			como criar uma nova senha.
		</div>

		<div class="login-card">
			<c:if test="${not empty error}">
				<div class="alert alert-danger">
					<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
				</div>
			</c:if>

			<form action="${pageContext.request.contextPath}/j_spring_security_check" class="form-signin"  method="POST" >
			  
				<!-- commandName="usuario"> -->
				<span class="reauth-email"></span>
				<%-- <form:input path="login" cssClass="form-control" placeholder="E-mail" onfocus="true"  />
            	<form:password path="senha" cssClass="form-control" placeholder="Senha" /> --%>

				<input type="text" name="j_username" cssClass="form-control" placeholder="E-mail" onfocus="true" />
				<input type="password" name="j_password" cssClass="form-control" placeholder="Senha" />

 				<sec:csrfInput />
 				
				<button class="btn btn-primary btn-block btn-lg btn-signin"
					type="submit">Entrar</button>
			</form>
			<a href="${urlBase}trocarSenha" class="forgot-password">Esqueci
				minha senha</a>
		</div>
	</section>
	
	<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>