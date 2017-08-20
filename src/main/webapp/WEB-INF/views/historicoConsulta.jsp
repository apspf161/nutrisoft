<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
			<h3>Hist�rico da Consulta</h3>
		</div>
		
		<div class="row">
			<div class="col-xs-12">
				<div class="card">
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#avaliacaoAntropometrica" aria-controls="avaliacaoAntropometrica" role="tab" data-toggle="tab">Avalia��o Antropom�trica</a></li>
						<li role="presentation"><a href="#avaliacaoAlimentar" aria-controls="avaliacaoAlimentar" role="tab" data-toggle="tab">Avalia��o Alimentar</a></li>
						<li role="presentation"><a href="#dietaNutricional" aria-controls="dietaNutricional" role="tab" data-toggle="tab">Dieta Nutricional</a></li>
						<li role="presentation"><a href="#dadosLaboratoriais" aria-controls="dadosLaboratoriais" role="tab" data-toggle="tab">Dados Laboratoriais</a></li>
					</ul>
					<div class="tab-content">
					    <div role="tabpanel" class="tab-pane active" id="avaliacaoAntropometrica">
				    		<div class="form-group row">
								<div class="col-xs-2">
						    		<label>Data da Consulta</label>
									<p class="form-control-static"><fmt:formatDate pattern="dd/MM/yyyy hh:mm" value="${historicoConsulta.agendamento.dataAgendamento}" /></p>
								</div>
								<div class="col-xs-4">
						    		<label>Nome</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.nome}" /></p>
								</div>
								<div class="col-xs-3">
						    		<label>Data de Nascimento</label>
									<p class="form-control-static"><fmt:formatDate pattern="dd/MM/yyyy" value="${historicoConsulta.agendamento.cliente.dataNascimento}" /></p>
								</div>
								<div class="col-xs-3">
						    		<label>Altura</label>
									<p class="form-control-static"><fmt:formatNumber pattern="#.00" value="${historicoConsulta.agendamento.cliente.altura}" />m</p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-3">
						    		<label>Peso Atual</label>
									<p class="form-control-static"><spring:bind path="historicoConsulta.pesoCliente">${status.value}</spring:bind></p>
								</div>
								<div class="col-xs-3">
						    		<label>IMC</label>
						    		<p class="form-control-static"><spring:bind path="historicoConsulta.imc">${status.value}</spring:bind></p>
								</div>
								<div class="col-xs-3">
						    		<label>TMB</label>
						    		<p class="form-control-static"><spring:bind path="historicoConsulta.tmb">${status.value}</spring:bind></p>
								</div>
								<div class="col-xs-3">
						    		<label>VET</label>
						    		<p class="form-control-static"><spring:bind path="historicoConsulta.vet">${status.value}</spring:bind></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-3">
						    		<label>Meta de Peso</label>
									<p class="form-control-static"><spring:bind path="historicoConsulta.meta">${status.value}</spring:bind></p>
								</div>
								<div class="col-xs-3">
						    		<label>Calorias</label>
									<p class="form-control-static"><spring:bind path="historicoConsulta.calorias">${status.value}</spring:bind></p>
								</div>
					    		<div class="col-xs-3">
							    	<label>Peso Usual</label>
									<p class="form-control-static"><spring:bind path="historicoConsulta.antropometria.pesoUsual">${status.value}</spring:bind></p>
								</div>
								<div class="col-xs-3">
						    		<label>Peso Desej�vel</label>
									<p class="form-control-static"><spring:bind path="historicoConsulta.antropometria.pesoDesejavel">${status.value}</spring:bind></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-3">
						    		<label>T�rax</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.torax}" /></p>
								</div>
								<div class="col-xs-3">
						    		<label>Bra�o Relaxado</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.bracoRelaxado}" /></p>
								</div>
								<div class="col-xs-3">
						    		<label>Bra�o Fletido</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.bracoFletido}" /></p>
								</div>
								<div class="col-xs-3">
						    		<label>Cintura</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.cintura}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-3">
						    		<label>Abd�men</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.abdomen}" /></p>
								</div>
								<div class="col-xs-3">
						    		<label>Quadril</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.quadril}" /></p>
								</div>
								<div class="col-xs-3">
						    		<label>Coxa</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.coxa}" /></p>
								</div>
								<div class="col-xs-3">
						    		<label>Coxa Proximal</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.coxaProximal}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-3">
						    		<label>Panturrilha</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.panturrilha}" /></p>
								</div>
								<div class="col-xs-3">
						    		<label>Triciptal</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.triciptal}" /></p>
								</div>
								<div class="col-xs-3">
						    		<label>Peitoral</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.peitoral}" /></p>
								</div>
								<div class="col-xs-3">
						    		<label>Axilar M�dia</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.axilarMedia}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-3">
						    		<label>Coxa Medial</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.coxaMedial}" /></p>
								</div>
								<div class="col-xs-3">
						    		<label>Subescapular</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.subescapular}" /></p>
								</div>
								<div class="col-xs-3">
						    		<label>Abdominal</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.abdominal}" /></p>
								</div>
								<div class="col-xs-3">
						    		<label>Supra Il�aca</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.suparaliaca}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-3">
									<label>% Gordura</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.percGordura}" /></p>
								</div>
								<div class="col-xs-9">
									<label>Classifica��o do % de Gordura</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.antropometria.classifPercGordura}" /></p>
								</div>
							</div>
						</div>
					    <div role="tabpanel" class="tab-pane" id="avaliacaoAlimentar">
							<div class="form-group row">
								<div class="col-xs-3">
						    		<label>Fez Acompanhamento Anterior?</label>
									<p class="form-control-static">
										<c:if test="${historicoConsulta.avaliacaoAlimentar.stAcompanhamentoNutricional == 'S'.charAt(0)}">
											Sim
										</c:if>
										<c:if test="${historicoConsulta.avaliacaoAlimentar.stAcompanhamentoNutricional == 'N'.charAt(0)}">
											N�o
										</c:if>
									</p>
								</div>
								<div class="col-xs-9">
						    		<label>Nome da Nutricionista</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.nutricionistaAcompanhamentoAnterior}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Objetivo do Acompanhamento</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.objetivoAcompanhamento}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Alergia Alimentar</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.alergiaAlimentar}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Intoler�ncia Alimentar</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.intoleranciaAlimentar}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Prefer�ncia Alimentar</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.preferenciaAlimentar}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Alimento Preterido</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.alimentoPreterido}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Classifica��o Apetite</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.classificacaoApetite}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Hor�rio de Fome</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.horarioFome}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Altera��o de Apetite</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.alteracaoApetite}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Motivo da Altera��o</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.motivoAlteracao}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-4">
						    		<label>Belisca Entre Refei��o</label>
									<p class="form-control-static">
										<c:if test="${historicoConsulta.avaliacaoAlimentar.beliscaEntreRefeicao}">Sim</c:if>
										<c:if test="${!historicoConsulta.avaliacaoAlimentar.beliscaEntreRefeicao}">N�o</c:if>
									</p>
								</div>
								<div class="col-xs-4">
						    		<label>Quantidade de �gua di�ria</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.qtdAguaDia}" /></p>
								</div>
								<div class="col-xs-4">
						    		<label>Quantidade de L�quido di�rio</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.qtdLiquidoDia}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-6">
						    		<label>Ingere l�quido durante as refei��es</label>
						    		<p class="form-control-static">
										<c:if test="${historicoConsulta.avaliacaoAlimentar.ingereLiquidoRefeicao}">Sim</c:if>
										<c:if test="${!historicoConsulta.avaliacaoAlimentar.ingereLiquidoRefeicao}">N�o</c:if>
									</p>
								</div>
								<div class="col-xs-6">
						    		<label>Quantidade de L�quido durante as refei��es</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.qtdLiquidoRefeicao}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-4">
						    		<label>Usa Suplemento?</label>
						    		<p class="form-control-static">
										<c:if test="${historicoConsulta.avaliacaoAlimentar.usaSuplemento}">Sim</c:if>
										<c:if test="${!historicoConsulta.avaliacaoAlimentar.usaSuplemento}">N�o</c:if>
									</p>
								</div>
								<div class="col-xs-8">
						    		<label>Indica��o de Uso do Suplemento</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.indicacaoUsoSuplemento}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Quem prepara as refei��es?</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.quemPreparaRefeicao}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Quem escolhe os alimentos?</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.quemEscolheAlimento}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Qual a forma de preparo das refei��es</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.formaPreparoRefeicao}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Quanto de gordura � utilizado no preparo?</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.gorduraPreparoRefeicao}" /></p>
								</div>
							</div>
							
							
							<div class="form-group row">
								<div class="col-xs-4">
						    		<label>Pessoas na Cozinha</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.nrPessoasCozinha}" /></p>
								</div>
								<div class="col-xs-4">
						    		<label>Qtd. Sal</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.qtdSal}" /></p>
								</div>
								<div class="col-xs-4">
						    		<label>Qtd. Gordura</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.qtdGordura}" /></p>
								</div>
							</div>
							
							<div class="form-group row">
								<div class="col-xs-3">
						    		<label>Sal / Dia</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.totSalDia}" /></p>
								</div>
								<div class="col-xs-3">
						    		<label>Sal / M�s</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.totSalMes}" /></p>
								</div>
								<div class="col-xs-3">
						    		<label>�leo / dia</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.totOleoDia}" /></p>
								</div>
								<div class="col-xs-3">
						    		<label>�leo / m�s</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.avaliacaoAlimentar.totalOleoMes}" /></p>
								</div>
							</div>
						</div>
					    <div role="tabpanel" class="tab-pane" id="dietaNutricional">
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Caf� da Manh�</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.dietaNutricional.cafeDaManha}" /></p>
								</div>
							</div>
							<div class="form-group row">
					    		<div class="col-xs-12">
						    		<label>Lanche da manh�</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.dietaNutricional.lancheDaManha}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Almoco</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.dietaNutricional.almoco}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Lanche da tarde</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.dietaNutricional.lancheTarde}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Jantar</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.dietaNutricional.jantar}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-12">
						    		<label>Ceia</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.dietaNutricional.ceia}" /></p>
								</div>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane" id="dadosLaboratoriais">
							<c:if test="${historicoConsulta.agendamento.cliente.dadoLaboratorial.data != null}">
								<div class="form-group row">
									<div class="col-xs-12">
										(�ltima Atualiza��o: <fmt:formatDate pattern="dd/MM/yyyy hh:mm" value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.data}" />)
									</div>
								</div>
							</c:if>
		
							<div class="form-group row">
								<div class="col-xs-3">
						    		<label>�cido �rico</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.acidoUrico}" /></p>
								</div>
								<div class="col-xs-3">
									<label>Creatinina</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.creatinina}" /></p>
								</div>
								<div class="col-xs-3">
									<label>Ferritina</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.ferritina}" /></p>
								</div>
								<div class="col-xs-3">
									<label>Glicemia Jejum</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.glicemiaJejum}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-3">
						    		<label>Ur�ia</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.ureia}" /></p>
								</div>
								<div class="col-xs-3">
									<label>Capacidade de fixa��o de ferro</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.capacFixacaoFerro}" /></p>
								</div>
								<div class="col-xs-3">
									<label>Fosfoquinase</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.fosfoquinase}" /></p>
								</div>
								<div class="col-xs-3">
									<label>Glicemia p�s prandial</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.glicemiaPosPrandial}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-3">
						    		<label>Hemoglobina Glicada</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.hemoglobinaGlicada}" /></p>
								</div>
								<div class="col-xs-3">
									<label>Homociste�na</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.homocisteina}" /></p>
								</div>
								<div class="col-xs-3">
									<label>Insulina</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.insulina}" /></p>
								</div>
								<div class="col-xs-3">
									<label>Satura��o Transferrina</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.saturacaoTransferrina}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-3">
						    		<label>Transferrina</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.transferrina}" /></p>
								</div>
								<div class="col-xs-3">
									<label>TGO</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.tgo}" /></p>
								</div>
								<div class="col-xs-3">
									<label>TGP</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.tgp}" /></p>
								</div>
								<div class="col-xs-3">
									<label>Eritr�citos</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.eritrocitos}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-3">
						    		<label>Hematocrito</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.hematocrito}" /></p>
								</div>
								<div class="col-xs-3">
									<label>Hemoglobina</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.hemoglobina}" /></p>
								</div>
								<div class="col-xs-3">
									<label>VCM</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.vcm}" /></p>
								</div>
								<div class="col-xs-3">
									<label>HCM</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.hcm}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-3">
						    		<label>RDW</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.rdw}" /></p>
								</div>
								<div class="col-xs-3">
									<label>CHCM</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.chcm}" /></p>
								</div>
								<div class="col-xs-3">
									<label>Leuc�citos Totais</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.leucocitosTotais}" /></p>
								</div>
								<div class="col-xs-3">
									<label>Bas�filo</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.basofilo}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-3">
						    		<label>Bastonete</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.bastonete}" /></p>
								</div>
								<div class="col-xs-3">
									<label>Blastos</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.blastos}" /></p>
								</div>
								<div class="col-xs-3">
									<label>Eosin�filos</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.eosinofilos}" /></p>
								</div>
								<div class="col-xs-3">
									<label>Linf�citos</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.linfocitos}" /></p>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-3">
						    		<label>Metamielocitos</label>
									<p class="form-control-static"><c:out value="${historicoConsulta.agendamento.cliente.dadoLaboratorial.metamielocitos}" /></p>
								</div>
								<div class="col-xs-9"></div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>
	
	<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>