<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h3>Consulta</h3>
		</div>
		
		<c:url var="addAction" value="/consulta/add" ></c:url>
		
		<form:form action="${addAction}" modelAttribute="consulta" method="POST">
			<form:hidden path="idConsulta" />
			<form:hidden path="agendamento.idAgendamento" />
			
			<h4>Cliente: <c:out value="${consulta.agendamento.cliente.nome}" /></h4>
						
			<c:if test="${!empty consultasAnteriores}">
				<div class="page-header">
					<h4>Consultas Anteriores</h4>
				</div>
						
				<table class="table">
					<tr>
						<th>Data / Hora</th>
						<th>Nutricionista</th>
						<th>Ações</th>
					</tr>
					<c:forEach items="${consultasAnteriores}" var="consulta">
						<tr>
							<td>${consulta.agendamento.dataAgendamento}</td>
							<td>${consulta.agendamento.nutricionista.nome}</td>
							<td><a href="<c:url value='/consulta/historico/${consulta.idConsulta}' />" >Visualizar</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<div class="form-group row">
				<div class="col-xs-6">
		    		<form:label path="valor">Valor</form:label>
					<form:input path="valor" cssClass="form-control"/>
				</div>
				<div class="col-xs-6">
		    		<form:label path="pago">Pago</form:label>
					<form:select path="pago" cssClass="form-control">
						<form:option value="false">Não</form:option>
						<form:option value="true">Sim</form:option>
					</form:select>
				</div>
			</div> 
			<div class="form-group row">
				<div class="col-xs-4">
		    		<form:label path="pesoCliente">Peso Atual</form:label>
					<form:input path="pesoCliente" cssClass="form-control"/>
					</div>
				<div class="col-xs-4">
		    		<form:label path="meta">Meta de Peso</form:label>
					<form:input path="meta" cssClass="form-control"/>
				</div>
				<div class="col-xs-4">
		    		<form:label path="calorias">Calorias</form:label>
					<form:input path="calorias" cssClass="form-control"/>
				</div>
			</div>
			
			<h4>Avaliação Antropométrica</h4>
						
			<div class="form-group row">
	    		<div class="col-xs-6">
			    	<form:label path="antropometria.pesoUsual">Peso Usual</form:label>
					<form:input path="antropometria.pesoUsual" cssClass="form-control"/>
				</div>
				<div class="col-xs-6">
		    		<form:label path="antropometria.pesoDesejavel">Peso Desejável</form:label>
					<form:input path="antropometria.pesoDesejavel" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-3">
		    		<form:label path="antropometria.torax">Tórax</form:label>
					<form:input path="antropometria.torax" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
		    		<form:label path="antropometria.bracoRelaxado">Braço Relaxado</form:label>
					<form:input path="antropometria.bracoRelaxado" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
		    		<form:label path="antropometria.bracoFletido">Braço Fletido</form:label>
					<form:input path="antropometria.bracoFletido" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
		    		<form:label path="antropometria.cintura">Cintura</form:label>
					<form:input path="antropometria.cintura" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-3">
		    		<form:label path="antropometria.abdomen">Abdômen</form:label>
					<form:input path="antropometria.abdomen" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
		    		<form:label path="antropometria.quadril">Quadril</form:label>
					<form:input path="antropometria.quadril" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
		    		<form:label path="antropometria.coxa">Coxa</form:label>
					<form:input path="antropometria.coxa" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
		    		<form:label path="antropometria.coxaProximal">Coxa Proximal</form:label>
					<form:input path="antropometria.coxaProximal" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-3">
		    		<form:label path="antropometria.panturrilha">Panturrilha</form:label>
					<form:input path="antropometria.panturrilha" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
		    		<form:label path="antropometria.triciptal">Triciptal</form:label>
					<form:input path="antropometria.triciptal" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
		    		<form:label path="antropometria.peitoral">Peitoral</form:label>
					<form:input path="antropometria.peitoral" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
		    		<form:label path="antropometria.axilarMedia">Axilar Média</form:label>
					<form:input path="antropometria.axilarMedia" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-3">
		    		<form:label path="antropometria.coxaMedial">Coxa Medial</form:label>
					<form:input path="antropometria.coxaMedial" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
		    		<form:label path="antropometria.subescapular">Subescapular</form:label>
					<form:input path="antropometria.subescapular" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
		    		<form:label path="antropometria.abdominal">Abdominal</form:label>
					<form:input path="antropometria.abdominal" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
		    		<form:label path="antropometria.suparaliaca">Supra Ilíaca</form:label>
					<form:input path="antropometria.suparaliaca" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="antropometria.somatorio">Somatório</form:label>
					<form:input path="antropometria.somatorio" cssClass="form-control"/>
				</div>
			</div>
			
			<h4>Avaliação Alimentar</h4>
					
			<div class="form-group row">
				<div class="col-xs-3">
		    		<form:label path="avaliacaoAlimentar.stAcompanhamentoNutricional">Fez Acompanhamento Anterior?</form:label>
					<form:select path="avaliacaoAlimentar.stAcompanhamentoNutricional" cssClass="form-control">
						<form:option value="N">Não</form:option>
						<form:option value="S">Sim</form:option>
					</form:select>
				</div>
				<div class="col-xs-9">
		    		<form:label path="avaliacaoAlimentar.nutricionistaAcompanhamentoAnterior">Nome da Nutricionista</form:label>
					<form:input path="avaliacaoAlimentar.nutricionistaAcompanhamentoAnterior" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="avaliacaoAlimentar.objetivoAcompanhamento">Objetivo do Acompanhamento</form:label>
					<form:input path="avaliacaoAlimentar.objetivoAcompanhamento" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="avaliacaoAlimentar.alergiaAlimentar">Alergia Alimentar</form:label>
					<form:input path="avaliacaoAlimentar.alergiaAlimentar" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="avaliacaoAlimentar.intoleranciaAlimentar">Intolerância Alimentar</form:label>
					<form:input path="avaliacaoAlimentar.intoleranciaAlimentar" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="avaliacaoAlimentar.preferenciaAlimentar">Preferência Alimentar</form:label>
					<form:input path="avaliacaoAlimentar.preferenciaAlimentar" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="avaliacaoAlimentar.alimentoPreterido">Alimento Preterido</form:label>
					<form:input path="avaliacaoAlimentar.alimentoPreterido" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="avaliacaoAlimentar.classificacaoApetite">Classificação Apetite</form:label>
					<form:input path="avaliacaoAlimentar.classificacaoApetite" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="avaliacaoAlimentar.horarioFome">Horário de Fome</form:label>
					<form:input path="avaliacaoAlimentar.horarioFome" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="avaliacaoAlimentar.alteracaoApetite">Alteração de Apetite</form:label>
					<form:input path="avaliacaoAlimentar.alteracaoApetite" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="avaliacaoAlimentar.alteracaoApetite">Motivo da Alteração</form:label>
					<form:input path="avaliacaoAlimentar.alteracaoApetite" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-4">
		    		<form:label path="avaliacaoAlimentar.beliscaEntreRefeicao">Belisca Entre Refeição</form:label>
					<form:select path="avaliacaoAlimentar.beliscaEntreRefeicao" cssClass="form-control">
						<form:option value="false">Não</form:option>
						<form:option value="true">Sim</form:option>
					</form:select>
				</div>
				<div class="col-xs-4">
		    		<form:label path="avaliacaoAlimentar.qtdAguaDia">Quantidade de Água diária</form:label>
					<form:input path="avaliacaoAlimentar.qtdAguaDia" cssClass="form-control"/>
				</div>
				<div class="col-xs-4">
		    		<form:label path="avaliacaoAlimentar.qtdLiquidoDia">Quantidade de Líquido diário</form:label>
					<form:input path="avaliacaoAlimentar.qtdLiquidoDia" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-6">
		    		<form:label path="avaliacaoAlimentar.ingereLiquidoRefeicao">Ingere líquido durante as refeições</form:label>
					<form:select path="avaliacaoAlimentar.ingereLiquidoRefeicao" cssClass="form-control">
						<form:option value="false">Não</form:option>
						<form:option value="true">Sim</form:option>
					</form:select>
				</div>
				<div class="col-xs-6">
		    		<form:label path="avaliacaoAlimentar.qtdLiquidoRefeicao">Quantidade de Líquido durante as refeições</form:label>
					<form:input path="avaliacaoAlimentar.qtdLiquidoRefeicao" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-4">
		    		<form:label path="avaliacaoAlimentar.usaSuplemento">Usa Suplemento?</form:label>
					<form:select path="avaliacaoAlimentar.usaSuplemento" cssClass="form-control">
						<form:option value="false">Não</form:option>
						<form:option value="true">Sim</form:option>
					</form:select>
				</div>
				<div class="col-xs-8">
		    		<form:label path="avaliacaoAlimentar.indicacaoUsoSuplemento">Indicação de Uso do Suplemento</form:label>
					<form:input path="avaliacaoAlimentar.indicacaoUsoSuplemento" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="avaliacaoAlimentar.quemPreparaRefeicao">Quem prepara as refeições?</form:label>
					<form:input path="avaliacaoAlimentar.quemPreparaRefeicao" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="avaliacaoAlimentar.quemEscolheAlimento">Quem escolhe os alimentos?</form:label>
					<form:input path="avaliacaoAlimentar.quemEscolheAlimento" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="avaliacaoAlimentar.formaPreparoRefeicao">Qual a forma de preparo das refeições</form:label>
					<form:input path="avaliacaoAlimentar.formaPreparoRefeicao" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="avaliacaoAlimentar.gorduraPreparoRefeicao">Quanto de gordura é utilizado no preparo?</form:label>
					<form:input path="avaliacaoAlimentar.gorduraPreparoRefeicao" cssClass="form-control"/>
				</div>
			</div>
			
			
			<div class="form-group row">
				<div class="col-xs-4">
		    		<form:label path="avaliacaoAlimentar.nrPessoasCozinha">Pessoas na Cozinha</form:label>
					<form:input path="avaliacaoAlimentar.nrPessoasCozinha" cssClass="form-control"/>
				</div>
				<div class="col-xs-4">
		    		<form:label path="avaliacaoAlimentar.qtdSal">Qtd. Sal</form:label>
					<form:input path="avaliacaoAlimentar.qtdSal" cssClass="form-control"/>
				</div>
				<div class="col-xs-4">
		    		<form:label path="avaliacaoAlimentar.qtdGordura">Qtd. Gordura</form:label>
					<form:input path="avaliacaoAlimentar.qtdGordura" cssClass="form-control"/>
				</div>
			</div>
			
			<div class="form-group row">
				<div class="col-xs-3">
		    		<form:label path="avaliacaoAlimentar.totSalDia">Sal / Dia</form:label>
					<form:input path="avaliacaoAlimentar.totSalDia" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
		    		<form:label path="avaliacaoAlimentar.totSalMes">Sal / Mês</form:label>
					<form:input path="avaliacaoAlimentar.totSalMes" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
		    		<form:label path="avaliacaoAlimentar.totOleoDia">Óleo / dia</form:label>
					<form:input path="avaliacaoAlimentar.totOleoDia" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
		    		<form:label path="avaliacaoAlimentar.totalOleoMes">Óleo / mês</form:label>
					<form:input path="avaliacaoAlimentar.totalOleoMes" cssClass="form-control"/>
				</div>
			</div>
			
			<h4>Dieta Nutricional</h4>
			
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="dietaNutricional.cafeDaManha">Café da Manhã</form:label>
					<form:input path="dietaNutricional.cafeDaManha" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
	    		<div class="col-xs-12">
		    		<form:label path="dietaNutricional.lancheDaManha">Lanche da manhã</form:label>
					<form:input path="dietaNutricional.lancheDaManha" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="dietaNutricional.almoco">Almoco</form:label>
					<form:input path="dietaNutricional.almoco" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="dietaNutricional.lancheTarde">Lanche da tarde</form:label>
					<form:input path="dietaNutricional.lancheTarde" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="dietaNutricional.jantar">Jantar</form:label>
					<form:input path="dietaNutricional.jantar" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-12">
		    		<form:label path="dietaNutricional.ceia">Ceia</form:label>
					<form:input path="dietaNutricional.ceia" cssClass="form-control"/>
				</div>
			</div>
			
			<h4>Dados Laboratoriais <c:if test="${consulta.agendamento.cliente.dadoLaboratorial.data != null}">(Última Atualização: <c:out value="${consulta.agendamento.cliente.dadoLaboratorial.data}" />)</c:if></h4>
			
			<div class="form-group row">
				<div class="col-xs-3">
		    		<form:label path="agendamento.cliente.dadoLaboratorial.acidoUrico">Ácido Úrico</form:label>
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
		    		<form:label path="agendamento.cliente.dadoLaboratorial.ureia">Uréia</form:label>
					<form:input path="agendamento.cliente.dadoLaboratorial.ureia" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
					<form:label path="agendamento.cliente.dadoLaboratorial.capacFixacaoFerro">Capacidade de fixação de ferro</form:label>
					<form:input path="agendamento.cliente.dadoLaboratorial.capacFixacaoFerro" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
					<form:label path="agendamento.cliente.dadoLaboratorial.fosfoquinase">Fosfoquinase</form:label>
					<form:input path="agendamento.cliente.dadoLaboratorial.fosfoquinase" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
					<form:label path="agendamento.cliente.dadoLaboratorial.glicemiaPosPrandial">Glicemia pós prandial</form:label>
					<form:input path="agendamento.cliente.dadoLaboratorial.glicemiaPosPrandial" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-3">
		    		<form:label path="agendamento.cliente.dadoLaboratorial.hemoglobinaGlicada">Hemoglobina Glicada</form:label>
					<form:input path="agendamento.cliente.dadoLaboratorial.hemoglobinaGlicada" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
					<form:label path="agendamento.cliente.dadoLaboratorial.homocisteina">Homocisteína</form:label>
					<form:input path="agendamento.cliente.dadoLaboratorial.homocisteina" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
					<form:label path="agendamento.cliente.dadoLaboratorial.insulina">Insulina</form:label>
					<form:input path="agendamento.cliente.dadoLaboratorial.insulina" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
					<form:label path="agendamento.cliente.dadoLaboratorial.saturacaoTransferrina">Saturação Transferrina</form:label>
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
					<form:label path="agendamento.cliente.dadoLaboratorial.eritrocitos">Eritrócitos</form:label>
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
					<form:label path="agendamento.cliente.dadoLaboratorial.leucocitosTotais">Leucócitos Totais</form:label>
					<form:input path="agendamento.cliente.dadoLaboratorial.leucocitosTotais" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
					<form:label path="agendamento.cliente.dadoLaboratorial.basofilo">Basófilo</form:label>
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
					<form:label path="agendamento.cliente.dadoLaboratorial.eosinofilos">Eosinófilos</form:label>
					<form:input path="agendamento.cliente.dadoLaboratorial.eosinofilos" cssClass="form-control"/>
				</div>
				<div class="col-xs-3">
					<form:label path="agendamento.cliente.dadoLaboratorial.linfocitos">Linfócitos</form:label>
					<form:input path="agendamento.cliente.dadoLaboratorial.linfocitos" cssClass="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-xs-3">
		    		<form:label path="agendamento.cliente.dadoLaboratorial.metamielocitos">Metamielocitos</form:label>
					<form:input path="agendamento.cliente.dadoLaboratorial.metamielocitos" cssClass="form-control"/>
				</div>
				<div class="col-xs-9"></div>
			</div>
			
			<div class="form-group row">
				<input type="submit" class="btn" value="<spring:message text="Salvar Consulta"/>" />
			</div>
		</form:form>
	</div>
	
	<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>