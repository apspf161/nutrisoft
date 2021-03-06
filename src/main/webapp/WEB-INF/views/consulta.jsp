<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<c:set var="pageReq" value="${pageContext.request}" />
<c:set var="urlBase"
	value="${fn:replace(pageReq.requestURL, pageReq.requestURI, pageReq.contextPath)}/"
	scope="request" />

<html>
<head>
<c:import url="/WEB-INF/views/imports.jsp"></c:import>
<script src="resources/js/consulta.js"></script>

<c:set value="show" var="classError"></c:set>

<c:if test="${empty error}"> 
  <c:set value="hide" var="classError"></c:set>
</c:if> 

</head>
<body>
	<c:import url="/WEB-INF/views/header.jsp"></c:import>

	<div class="container" id="container">

		<c:import url="/WEB-INF/views/menu.jsp"></c:import>

		<div class="page-header">
			<h3>Consulta</h3>
		</div>
		
		<c:url var="addAction" value="/consulta/add" ></c:url>
		
		<form:form action="${addAction}" modelAttribute="consulta" method="POST">
			<form:hidden path="idConsulta" />
			<form:hidden path="agendamento.idAgendamento" />
			<form:hidden path="pago" value="false" />
			<form:hidden path="agendamento.cliente.idade" id="idade" />
			<form:hidden path="agendamento.cliente.sexo" id="sexo" />
			
			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#avaliacaoAntropometrica" aria-controls="avaliacaoAntropometrica" role="tab" data-toggle="tab">Avalia��o Antropom�trica</a></li>
							<li role="presentation"><a href="#avaliacaoAlimentar" aria-controls="avaliacaoAlimentar" role="tab" data-toggle="tab">Avalia��o Alimentar</a></li>
							<li role="presentation"><a href="#dietaNutricional" aria-controls="dietaNutricional" role="tab" data-toggle="tab">Dieta Nutricional</a></li>
							<li role="presentation"><a href="#dadosLaboratoriais" aria-controls="dadosLaboratoriais" role="tab" data-toggle="tab">Dados Laboratoriais</a></li>
							<li role="presentation"><a href="#consultasAnteriores" aria-controls="consultasAnteriores" role="tab" data-toggle="tab">Consultas Anteriores</a></li>
						</ul>
						<div class="tab-content">
						    <div role="tabpanel" class="tab-pane active" id="avaliacaoAntropometrica">
								<div class="form-group row">
									<div class="col-xs-2">
							    		<label>Data da Consulta</label>
										<p class="form-control-static"><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${consulta.agendamento.dataAgendamento}" /></p>
									</div>
									<div class="col-xs-4">
							    		<label>Nome</label>
										<p class="form-control-static"><c:out value="${consulta.agendamento.cliente.nome}" /></p>
									</div>
									<div class="col-xs-3">
							    		<label>Data de Nascimento</label>
										<p class="form-control-static"><fmt:formatDate pattern="dd/MM/yyyy" value="${consulta.agendamento.cliente.dataNascimento}" /></p>
									</div>
									<div class="col-xs-3">
							    		<label>Altura</label>
										<form:hidden path="agendamento.cliente.altura" id="altura" />
										<p class="form-control-static"><fmt:formatNumber pattern="#.00" value="${consulta.agendamento.cliente.altura}" />m</p>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-3">
							    		<form:label path="pesoCliente">Peso Atual</form:label>
										<form:input path="pesoCliente" cssClass="form-control maskPeso" id="peso" />
									</div>
									<div class="col-xs-3">
							    		<label>IMC</label>
							    		<p class="form-control-static" id="imc"><spring:bind path="imc">${status.value}</spring:bind></p>
									</div>
									<div class="col-xs-3">
							    		<label>TMB</label>
							    		<p class="form-control-static" id="tmb"><spring:bind path="tmb">${status.value}</spring:bind></p>
									</div>
									<div class="col-xs-3">
							    		<label>VET</label>
							    		<p class="form-control-static" id="vet"><spring:bind path="vet">${status.value}</spring:bind></p>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-3">
							    		<form:label path="meta">Meta de Peso</form:label>
										<form:input path="meta" cssClass="form-control maskPeso" />
									</div>
									<div class="col-xs-3">
							    		<form:label path="calorias">Calorias</form:label>
										<form:input path="calorias" cssClass="form-control maskNumerico" maxlength="4" />
									</div>
						    		<div class="col-xs-3">
								    	<form:label path="antropometria.pesoUsual">Peso Usual</form:label>
										<form:input path="antropometria.pesoUsual" cssClass="form-control maskPeso" />
									</div>
									<div class="col-xs-3">
							    		<form:label path="antropometria.pesoDesejavel">Peso Desej�vel</form:label>
										<form:input path="antropometria.pesoDesejavel" cssClass="form-control maskPeso" />
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-3">
							    		<form:label path="antropometria.torax">T�rax</form:label>
										<form:input path="antropometria.torax" cssClass="form-control maskNumerico" maxlength="11" />
									</div>
									<div class="col-xs-3">
							    		<form:label path="antropometria.bracoRelaxado">Bra�o Relaxado</form:label>
										<form:input path="antropometria.bracoRelaxado" cssClass="form-control maskNumerico" maxlength="11" />
									</div>
									<div class="col-xs-3">
							    		<form:label path="antropometria.bracoFletido">Bra�o Fletido</form:label>
										<form:input path="antropometria.bracoFletido" cssClass="form-control maskNumerico" maxlength="11" />
									</div>
									<div class="col-xs-3">
							    		<form:label path="antropometria.cintura">Cintura</form:label>
										<form:input path="antropometria.cintura" cssClass="form-control maskNumerico" maxlength="11" />
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-3">
							    		<form:label path="antropometria.abdomen">Abd�men</form:label>
										<form:input path="antropometria.abdomen" cssClass="form-control maskNumerico" maxlength="11" />
									</div>
									<div class="col-xs-3">
							    		<form:label path="antropometria.quadril">Quadril</form:label>
										<form:input path="antropometria.quadril" cssClass="form-control maskNumerico" maxlength="11" />
									</div>
									<div class="col-xs-3">
							    		<form:label path="antropometria.coxa">Coxa</form:label>
										<form:input path="antropometria.coxa" cssClass="form-control maskNumerico" maxlength="11" />
									</div>
									<div class="col-xs-3">
							    		<form:label path="antropometria.coxaProximal">Coxa Proximal</form:label>
										<form:input path="antropometria.coxaProximal" cssClass="form-control maskNumerico" maxlength="11" />
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-3">
							    		<form:label path="antropometria.panturrilha">Panturrilha</form:label>
										<form:input path="antropometria.panturrilha" cssClass="form-control maskNumerico" maxlength="11" />
									</div>
									<div class="col-xs-3">
							    		<form:label path="antropometria.triciptal">Triciptal</form:label>
										<form:input path="antropometria.triciptal" cssClass="form-control maskNumerico" maxlength="11" />
									</div>
									<div class="col-xs-3">
							    		<form:label path="antropometria.peitoral">Peitoral</form:label>
										<form:input path="antropometria.peitoral" cssClass="form-control maskNumerico" maxlength="11" />
									</div>
									<div class="col-xs-3">
							    		<form:label path="antropometria.axilarMedia">Axilar M�dia</form:label>
										<form:input path="antropometria.axilarMedia" cssClass="form-control maskNumerico" maxlength="11" />
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-3">
							    		<form:label path="antropometria.coxaMedial">Coxa Medial</form:label>
										<form:input path="antropometria.coxaMedial" cssClass="form-control maskNumerico" maxlength="11" />
									</div>
									<div class="col-xs-3">
							    		<form:label path="antropometria.subescapular">Subescapular</form:label>
										<form:input path="antropometria.subescapular" cssClass="form-control maskNumerico" maxlength="11" />
									</div>
									<div class="col-xs-3">
							    		<form:label path="antropometria.abdominal">Abdominal</form:label>
										<form:input path="antropometria.abdominal" cssClass="form-control maskNumerico" maxlength="11" />
									</div>
									<div class="col-xs-3">
							    		<form:label path="antropometria.suparaliaca">Supra Il�aca</form:label>
										<form:input path="antropometria.suparaliaca" cssClass="form-control maskNumerico" maxlength="11" />
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-3">
							    		<form:label path="antropometria.percGordura">% Gordura</form:label>
										<form:input path="antropometria.percGordura" cssClass="form-control maskPercent" maxlength="11" />
									</div>
									<div class="col-xs-9">
										<form:label path="antropometria.classifPercGordura">Classifica��o do % de Gordura</form:label>
										<form:input path="antropometria.classifPercGordura" cssClass="form-control" />
									</div>
								</div>
							</div>
						    <div role="tabpanel" class="tab-pane" id="avaliacaoAlimentar">
								<div class="form-group row">
									<div class="col-xs-3">
							    		<form:label path="avaliacaoAlimentar.stAcompanhamentoNutricional">Fez Acompanhamento Anterior?</form:label>
										<form:select path="avaliacaoAlimentar.stAcompanhamentoNutricional" cssClass="form-control">
											<form:option value="N">N�o</form:option>
											<form:option value="S">Sim</form:option>
										</form:select>
									</div>
									<div class="col-xs-9">
							    		<form:label path="avaliacaoAlimentar.nutricionistaAcompanhamentoAnterior">Nome da Nutricionista</form:label>
										<form:input path="avaliacaoAlimentar.nutricionistaAcompanhamentoAnterior" cssClass="form-control" maxlength="50"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-12">
							    		<form:label path="avaliacaoAlimentar.objetivoAcompanhamento">Objetivo do Acompanhamento</form:label>
										<form:input path="avaliacaoAlimentar.objetivoAcompanhamento" cssClass="form-control" maxlength="100"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-12">
							    		<form:label path="avaliacaoAlimentar.alergiaAlimentar">Alergia Alimentar</form:label>
										<form:input path="avaliacaoAlimentar.alergiaAlimentar" cssClass="form-control" maxlength="50"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-12">
							    		<form:label path="avaliacaoAlimentar.intoleranciaAlimentar">Intoler�ncia Alimentar</form:label>
										<form:input path="avaliacaoAlimentar.intoleranciaAlimentar" cssClass="form-control" maxlength="50"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-12">
							    		<form:label path="avaliacaoAlimentar.preferenciaAlimentar">Prefer�ncia Alimentar</form:label>
										<form:input path="avaliacaoAlimentar.preferenciaAlimentar" cssClass="form-control" maxlength="50"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-12">
							    		<form:label path="avaliacaoAlimentar.alimentoPreterido">Alimento Preterido</form:label>
										<form:input path="avaliacaoAlimentar.alimentoPreterido" cssClass="form-control" maxlength="50"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-6">
							    		<form:label path="avaliacaoAlimentar.classificacaoApetite">Classifica��o Apetite</form:label>
										<form:input path="avaliacaoAlimentar.classificacaoApetite" cssClass="form-control" maxlength="20"/>
									</div>
									<div class="col-xs-6">
							    		<form:label path="avaliacaoAlimentar.horarioFome">Hor�rio de Fome</form:label>
										<form:input path="avaliacaoAlimentar.horarioFome" cssClass="form-control" maxlength="20"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-6">
							    		<form:label path="avaliacaoAlimentar.alteracaoApetite">Altera��o de Apetite</form:label>
										<form:input path="avaliacaoAlimentar.alteracaoApetite" cssClass="form-control" maxlength="20"/>
									</div>
									<div class="col-xs-6">
							    		<form:label path="avaliacaoAlimentar.motivoAlteracao">Motivo da Altera��o</form:label>
										<form:input path="avaliacaoAlimentar.motivoAlteracao" cssClass="form-control" maxlength="20"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-4">
							    		<form:label path="avaliacaoAlimentar.beliscaEntreRefeicao">Belisca Entre Refei��o</form:label>
										<form:select path="avaliacaoAlimentar.beliscaEntreRefeicao" cssClass="form-control">
											<form:option value="false">N�o</form:option>
											<form:option value="true">Sim</form:option>
										</form:select>
									</div>
									<div class="col-xs-4">
							    		<form:label path="avaliacaoAlimentar.qtdAguaDia">Quantidade de �gua di�ria</form:label>
										<form:input path="avaliacaoAlimentar.qtdAguaDia" cssClass="form-control maskQtdAgua" />
									</div>
									<div class="col-xs-4">
							    		<form:label path="avaliacaoAlimentar.qtdLiquidoDia">Quantidade de L�quido di�rio</form:label>
										<form:input path="avaliacaoAlimentar.qtdLiquidoDia" cssClass="form-control maskQtdAgua"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-4">
							    		<form:label path="avaliacaoAlimentar.ingereLiquidoRefeicao">Ingere l�quido durante as refei��es</form:label>
										<form:select path="avaliacaoAlimentar.ingereLiquidoRefeicao" cssClass="form-control">
											<form:option value="false">N�o</form:option>
											<form:option value="true">Sim</form:option>
										</form:select>
									</div>
									<div class="col-xs-4">
							    		<form:label path="avaliacaoAlimentar.qtdLiquidoRefeicao">Quantidade de L�quido durante as refei��es</form:label>
										<form:input path="avaliacaoAlimentar.qtdLiquidoRefeicao" cssClass="form-control maskQtdAgua"/>
									</div>
									<div class="col-xs-4">
							    		<form:label path="avaliacaoAlimentar.usaSuplemento">Usa Suplemento?</form:label>
										<form:select path="avaliacaoAlimentar.usaSuplemento" cssClass="form-control">
											<form:option value="false">N�o</form:option>
											<form:option value="true">Sim</form:option>
										</form:select>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-12">
							    		<form:label path="avaliacaoAlimentar.indicacaoUsoSuplemento">Indica��o de Uso do Suplemento</form:label>
										<form:input path="avaliacaoAlimentar.indicacaoUsoSuplemento" cssClass="form-control" maxlength="50"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-12">
							    		<form:label path="avaliacaoAlimentar.quemPreparaRefeicao">Quem prepara as refei��es?</form:label>
										<form:input path="avaliacaoAlimentar.quemPreparaRefeicao" cssClass="form-control" maxlength="50"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-12">
							    		<form:label path="avaliacaoAlimentar.quemEscolheAlimento">Quem escolhe os alimentos?</form:label>
										<form:input path="avaliacaoAlimentar.quemEscolheAlimento" cssClass="form-control" maxlength="50"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-12">
							    		<form:label path="avaliacaoAlimentar.formaPreparoRefeicao">Qual a forma de preparo das refei��es</form:label>
										<form:input path="avaliacaoAlimentar.formaPreparoRefeicao" cssClass="form-control" maxlength="100"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-12">
							    		<form:label path="avaliacaoAlimentar.gorduraPreparoRefeicao">Quanto de gordura � utilizado no preparo?</form:label>
										<form:input path="avaliacaoAlimentar.gorduraPreparoRefeicao" cssClass="form-control" maxlength="30"/>
									</div>
								</div>
								
								
								<div class="form-group row">
									<div class="col-xs-4">
							    		<form:label path="avaliacaoAlimentar.nrPessoasCozinha">Pessoas na Cozinha</form:label>
										<form:input path="avaliacaoAlimentar.nrPessoasCozinha" cssClass="form-control maskNumber" maxlength="11"/>
									</div>
									<div class="col-xs-4">
							    		<form:label path="avaliacaoAlimentar.qtdSal">Qtd. Sal</form:label>
										<form:input path="avaliacaoAlimentar.qtdSal" cssClass="form-control maskQtdSal"/>
									</div>
									<div class="col-xs-4">
							    		<form:label path="avaliacaoAlimentar.qtdGordura">Qtd. Gordura</form:label>
										<form:input path="avaliacaoAlimentar.qtdGordura" cssClass="form-control maskQtdSal"/>
									</div>
								</div>
								
								<div class="form-group row">
									<div class="col-xs-3">
							    		<form:label path="avaliacaoAlimentar.totSalDia">Sal / Dia</form:label>
										<form:input path="avaliacaoAlimentar.totSalDia" cssClass="form-control maskQtdSal"/>
									</div>
									<div class="col-xs-3">
							    		<form:label path="avaliacaoAlimentar.totSalMes">Sal / M�s</form:label>
										<form:input path="avaliacaoAlimentar.totSalMes" cssClass="form-control maskQtdSal"/>
									</div>
									<div class="col-xs-3">
							    		<form:label path="avaliacaoAlimentar.totOleoDia">�leo / dia</form:label>
										<form:input path="avaliacaoAlimentar.totOleoDia" cssClass="form-control maskQtdOleo"/>
									</div>
									<div class="col-xs-3">
							    		<form:label path="avaliacaoAlimentar.totalOleoMes">�leo / m�s</form:label>
										<form:input path="avaliacaoAlimentar.totalOleoMes" cssClass="form-control maskQtdOleo"/>
									</div>
								</div>
							</div>
						    <div role="tabpanel" class="tab-pane" id="dietaNutricional">
								<div class="form-group row">
									<div class="col-xs-12">
							    		<form:label path="dietaNutricional.cafeDaManha">Caf� da Manh�</form:label>
										<form:textarea path="dietaNutricional.cafeDaManha" cssClass="form-control"/>
									</div>
								</div>
								<div class="form-group row">
						    		<div class="col-xs-12">
							    		<form:label path="dietaNutricional.lancheDaManha">Lanche da manh�</form:label>
										<form:textarea path="dietaNutricional.lancheDaManha" cssClass="form-control"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-12">
							    		<form:label path="dietaNutricional.almoco">Almoco</form:label>
										<form:textarea path="dietaNutricional.almoco" cssClass="form-control"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-12">
							    		<form:label path="dietaNutricional.lancheTarde">Lanche da tarde</form:label>
										<form:textarea path="dietaNutricional.lancheTarde" cssClass="form-control"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-12">
							    		<form:label path="dietaNutricional.jantar">Jantar</form:label>
										<form:textarea path="dietaNutricional.jantar" cssClass="form-control"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-12">
							    		<form:label path="dietaNutricional.ceia">Ceia</form:label>
										<form:textarea path="dietaNutricional.ceia" cssClass="form-control"/>
									</div>
								</div>
							</div>
							<div role="tabpanel" class="tab-pane" id="dadosLaboratoriais">
								<c:if test="${consulta.agendamento.cliente.dadoLaboratorial.data != null}">
									<div class="form-group row">
										<div class="col-xs-12">
											(�ltima Atualiza��o: <fmt:formatDate pattern="dd/MM/yyyy hh:mm" value="${consulta.agendamento.cliente.dadoLaboratorial.data}" />)
										</div>
									</div>
								</c:if>
								<div class="form-group row">
									<div class="col-xs-3">
							    		<form:label path="agendamento.cliente.dadoLaboratorial.acidoUrico">�cido �rico</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.acidoUrico" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.creatinina">Creatinina</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.creatinina" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.ferritina">Ferritina</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.ferritina" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.glicemiaJejum">Glicemia Jejum</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.glicemiaJejum" cssClass="form-control"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-3">
							    		<form:label path="agendamento.cliente.dadoLaboratorial.ureia">Ur�ia</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.ureia" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.capacFixacaoFerro">Capacidade de fixa��o de ferro</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.capacFixacaoFerro" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.fosfoquinase">Fosfoquinase</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.fosfoquinase" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.glicemiaPosPrandial">Glicemia p�s prandial</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.glicemiaPosPrandial" cssClass="form-control"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-3">
							    		<form:label path="agendamento.cliente.dadoLaboratorial.hemoglobinaGlicada">Hemoglobina Glicada</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.hemoglobinaGlicada" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.homocisteina">Homociste�na</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.homocisteina" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.insulina">Insulina</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.insulina" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.saturacaoTransferrina">Satura��o Transferrina</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.saturacaoTransferrina" cssClass="form-control"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-3">
							    		<form:label path="agendamento.cliente.dadoLaboratorial.transferrina">Transferrina</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.transferrina" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.tgo">TGO</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.tgo" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.tgp">TGP</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.tgp" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.eritrocitos">Eritr�citos</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.eritrocitos" cssClass="form-control"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-3">
							    		<form:label path="agendamento.cliente.dadoLaboratorial.hematocrito">Hematocrito</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.hematocrito" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.hemoglobina">Hemoglobina</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.hemoglobina" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.vcm">VCM</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.vcm" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.hcm">HCM</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.hcm" cssClass="form-control"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-3">
							    		<form:label path="agendamento.cliente.dadoLaboratorial.rdw">RDW</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.rdw" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.chcm">CHCM</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.chcm" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.leucocitosTotais">Leuc�citos Totais</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.leucocitosTotais" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.basofilo">Bas�filo</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.basofilo" cssClass="form-control"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-3">
							    		<form:label path="agendamento.cliente.dadoLaboratorial.bastonete">Bastonete</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.bastonete" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.blastos">Blastos</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.blastos" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.eosinofilos">Eosin�filos</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.eosinofilos" cssClass="form-control"/>
									</div>
									<div class="col-xs-3">
										<form:label path="agendamento.cliente.dadoLaboratorial.linfocitos">Linf�citos</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.linfocitos" cssClass="form-control"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-3">
							    		<form:label path="agendamento.cliente.dadoLaboratorial.metamielocitos">Metamielocitos</form:label>
										<form:input path="agendamento.cliente.dadoLaboratorial.metamielocitos" cssClass="form-control" />
									</div>
									<div class="col-xs-9"></div>
								</div>
							</div>
						    <div role="tabpanel" class="tab-pane" id="consultasAnteriores">
								<c:if test="${not empty consultasAnteriores}">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>Data / Hora</th>
												<th>Nutricionista</th>
												<th>A��es</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${consultasAnteriores}" var="consultaAnterior">
												<tr class="text-left">
													<td><fmt:formatDate pattern="dd/MM/yyyy hh:mm" value="${consultaAnterior.agendamento.dataAgendamento}" /></td>
													<td>${consultaAnterior.agendamento.nutricionista.nome}</td>
													<td><a href="<c:url value='/consulta/historico/${consultaAnterior.idConsulta}' />" >Visualizar</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group row">
				<input type="submit" class="btn" value="<spring:message text="Salvar Consulta"/>" />
			</div>
		</form:form>
	</div>
	
	<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>