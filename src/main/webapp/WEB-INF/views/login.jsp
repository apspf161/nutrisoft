<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head></head>
<body>
	<header>
		<c:import url="/WEB-INF/views/header.jsp"></c:import>
	</header>
	<section>
	
  <div class="alert alert-success alert-dismissible" style="display:none; margin-top:10px;" id="myAlert" >
    <a href="#" class="close">&times;</a>
    <strong>Confira seu e-mail! </strong>O endereço indicado receberá um e-mail com instruções de como criar uma nova senha.
  </div>
	  
    <div class="login-card">
        <c:url var="loginAction" value="/usuario/login"></c:url>
		<form:form action="${loginAction}" class="form-signin" commandName="usuario" method="POST"> 
	    	<span class="reauth-email"></span>
            <%-- <form:input path="login" cssClass="form-control" placeholder="E-mail" onfocus="true"  />
            <form:password path="senha" cssClass="form-control" placeholder="Senha" /> --%>

			<input type="text" name="login" cssClass="form-control" placeholder="E-mail" onfocus="true"  />
            <input type="password" name="senha" cssClass="form-control" placeholder="Senha" /> 


            <button class="btn btn-primary btn-block btn-lg btn-signin" type="submit">Entrar</button>
        </form:form>
        <a href="${urlBase}/mudarSenha" class="forgot-password">Esqueci minha senha</a></div>
        </section>
        
        <c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>