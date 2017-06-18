<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head></head>
<body>
	<header>
		<c:import url="/WEB-INF/views/header.jsp"></c:import>
	</header>
	<section>
		
		  <div class="alert alert-danger alert-dismissible" style="display:none; margin-top:10px;" id="myAlert" >
		    <a href="#" class="close">&times;</a>
		    <strong>Atenção! </strong>O endereço indicado é inválido ou inexistente.
		  </div>
  
			<div class="forgot-password-card text-center">
				<h3>
					<i class="fa fa-lock fa-4x"></i>
				</h3>
				<p>
				<h2 class="text-center">Esqueceu a senha?</h2>
				</p>
				<p>Você pode resetar sua senha aqui.</p>
				<div class="reauth-email">

					<form class="form">
						<fieldset>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-envelope color-blue"></i></span> <input
										id="emailInput" placeholder="E-mail"
										class="form-control" type="email"
										onnvalid="setCustomValidity('Please enter a valid email address!')"
										onchange="try{setCustomValidity('')}catch(e){}" required="">
								</div>
							</div>
							<div class="form-group">
								<input class="btn btn-lg btn-primary btn-block"
									value="Enviar minha Senha" type="submit">
							</div>
						</fieldset>
					</form>

				</div>
			</div>
		
	</section>
	<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>