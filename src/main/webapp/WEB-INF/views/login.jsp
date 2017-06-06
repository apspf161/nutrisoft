<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Acesso ao Sistema</title>
</head>
<body>
	<div class="page-header">
		<h3>Acesso ao Sistema</h3>
	</div>
	
	<c:url var="loginAction" value="/usuario/login"></c:url>
	
	<form:form action="${loginAction}" commandName="usuario" method="POST">
		<div class="form-group">
    		<form:label path="login">Login</form:label>
			<form:input path="login" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="senha">Senha</form:label>
			<form:password path="senha" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<input type="submit" class="btn" value="<spring:message text="Entrar"/>" />
		</div>
	</form:form>
</body>
</html>