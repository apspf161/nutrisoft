<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Cadastro de Consulta</title>
</head>
<body>
	<div class="page-header">
		<h3>Consulta</h3>
	</div>
	
	<c:url var="addAction" value="/consulta/add" ></c:url>
	
	<form:form action="${addAction}" modelAttribute="consulta" method="POST">
		<form:hidden path="idConsulta" />
		<form:hidden path="agendamento.idAgendamento" />
				
		<div class="form-group">
    		<form:label path="agendamento.cliente.nome">Cliente</form:label>
    		<c:out value="${consulta.agendamento.cliente.nome}" />
		</div>
		
		<c:if test="${!empty consultasAnteriores}">
			<div class="page-header">
				<h4>Consultas Anteriores</h4>
			</div>
					
			<table class="table">
				<tr>
					<th>Data / Hora</th>
					<th>Nutricionista</th>
					<th>Valor</th>
					<th>Pago</th>
					<th>Ações</th>
				</tr>
				<c:forEach items="${consultasAnteriores}" var="consulta">
					<tr>
						<td>${consulta.agendamento.dataAgendamento}</td>
						<td>${consulta.agendamento.nutricionista.nome}</td>
						<td>${consulta.valor}</td>
						<td>${consulta.pago}</td>
						<td>exibir botáo de consultar aqui...</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
		<div class="form-group">
    		<form:label path="pesoCliente">Peso Atual</form:label>
			<form:input path="pesoCliente" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="meta">Meta de Peso</form:label>
			<form:input path="meta" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="calorias">Calorias</form:label>
			<form:input path="calorias" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="valor">Valor</form:label>
			<form:input path="valor" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="pago">Pago</form:label>
			<form:select path="pago" cssClass="form-control">
				<form:option value="false">Não</form:option>
				<form:option value="true">Sim</form:option>
			</form:select>
		</div>
		
		<h4>Avaliação Antropométrica</h4>
				
		<div class="form-group">
    		<form:label path="antropometria.pesoUsual">Peso Usual</form:label>
			<form:input path="antropometria.pesoUsual" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.pesoDesejavel">Peso Desejável</form:label>
			<form:input path="antropometria.pesoDesejavel" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.torax">Tórax</form:label>
			<form:input path="antropometria.torax" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.bracoRelaxado">Braço Relaxado</form:label>
			<form:input path="antropometria.bracoRelaxado" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.bracoFletido">Braço Fletido</form:label>
			<form:input path="antropometria.bracoFletido" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.cintura">Cintura</form:label>
			<form:input path="antropometria.cintura" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.abdomen">Abdômen</form:label>
			<form:input path="antropometria.abdomen" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.quadril">Quadril</form:label>
			<form:input path="antropometria.quadril" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.coxa">Coxa</form:label>
			<form:input path="antropometria.coxa" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.coxaProximal">Coxa Proximal</form:label>
			<form:input path="antropometria.coxaProximal" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.panturrilha">Panturrilha</form:label>
			<form:input path="antropometria.panturrilha" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.triciptal">Triciptal</form:label>
			<form:input path="antropometria.triciptal" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.peitoral">Peitoral</form:label>
			<form:input path="antropometria.peitoral" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.axilarMedia">Axilar Média</form:label>
			<form:input path="antropometria.axilarMedia" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.coxaMedial">coxaMedial</form:label>
			<form:input path="antropometria.coxaMedial" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.subescapular">Subescapular</form:label>
			<form:input path="antropometria.subescapular" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.abdominal">Abdominal</form:label>
			<form:input path="antropometria.abdominal" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.suparaliaca">Supra Ilíaca</form:label>
			<form:input path="antropometria.suparaliaca" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="antropometria.somatorio">Somatório</form:label>
			<form:input path="antropometria.somatorio" cssClass="form-control"/>
		</div>
		
		<h4>Avaliação Alimentar</h4>
				
		<div class="form-group">
    		<form:label path="avaliacaoAlimentar.stAcompanhamentoNutricional">Fez Acompanhamento Anterior?</form:label>
			<form:select path="avaliacaoAlimentar.stAcompanhamentoNutricional" cssClass="form-control">
				<form:option value="N">Não</form:option>
				<form:option value="S">Sim</form:option>
			</form:select>
		</div>
		<div class="form-group">
    		<form:label path="avaliacaoAlimentar.nutricionistaAcompanhamentoAnterior">Nutricionista Acompanhamento Anterior</form:label>
			<form:input path="avaliacaoAlimentar.nutricionistaAcompanhamentoAnterior" cssClass="form-control"/>
		</div>
		<div class="form-group">
    		<form:label path="avaliacaoAlimentar.objetivoAcompanhamento">Objetivo Acompanhamento Anterior</form:label>
			<form:input path="avaliacaoAlimentar.objetivoAcompanhamento" cssClass="form-control"/>
		</div>
		
		Outros campos da avaliação...
		
		<h4>Dieta Nutricional</h4>
		
		<div class="form-group">
    		<form:label path="dietaNutricional.cafeDaManha">Café da Manhã</form:label>
			<form:input path="dietaNutricional.cafeDaManha" cssClass="form-control"/>
		</div>
		
		Outros campos da dieta...
		
		<div class="form-group">
			<input type="submit" class="btn" value="<spring:message text="Salvar Consulta"/>" />
		</div>
	</form:form>
</body>
</html>