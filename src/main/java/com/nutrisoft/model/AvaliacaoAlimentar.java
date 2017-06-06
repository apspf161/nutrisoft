package com.nutrisoft.model;

import java.math.BigDecimal;

public class AvaliacaoAlimentar {

	private Consulta consulta;
	private Boolean fazAcompanhamentoNutricional;
	private String nutricionistaAcompanhamentoAnterior;
	private String objetivoAcompanhamento;
	private String alergiaAlimentar;
	private String intoleranciaAlimentar;
	private String alimentoPreterido;
	private String classificacaoApetite;
	private String horarioFome;
	private Boolean beliscaEntreRefeicao;  // big
	private String alteracaoApetite;
	private String motivoAlteracao;
	private BigDecimal qtdAguaDia; //float 
	private BigDecimal qtdLiquidoDia; //float 
	private Boolean ingereLiquidoRefeicao; // big 
	private BigDecimal qtdLiquidoRefeicao; // float 
	private Boolean usaSuplemento; // big
	private String indicacaoUsoSuplemento;
	private String quemEscolheAlimento;
	private String quemPreparaRefeicao;
	private String formaPreparoRefeicao;
	private String gorduraPreparoRefeicao;
	private Integer nrPessoasCozinha; //int
	private BigDecimal qtdSal; // float
	private BigDecimal qtdGordura; // float
	private BigDecimal totSalMes; // float
	private BigDecimal totSalDia; // float
	private BigDecimal totOleoDia; // float
	private BigDecimal totalOleoMes; // float
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public Boolean getFazAcompanhamentoNutricional() {
		return fazAcompanhamentoNutricional;
	}
	public void setFazAcompanhamentoNutricional(Boolean fazAcompanhamentoNutricional) {
		this.fazAcompanhamentoNutricional = fazAcompanhamentoNutricional;
	}
	public String getNutricionistaAcompanhamentoAnterior() {
		return nutricionistaAcompanhamentoAnterior;
	}
	public void setNutricionistaAcompanhamentoAnterior(String nutricionistaAcompanhamentoAnterior) {
		this.nutricionistaAcompanhamentoAnterior = nutricionistaAcompanhamentoAnterior;
	}
	public String getObjetivoAcompanhamento() {
		return objetivoAcompanhamento;
	}
	public void setObjetivoAcompanhamento(String objetivoAcompanhamento) {
		this.objetivoAcompanhamento = objetivoAcompanhamento;
	}
	public String getAlergiaAlimentar() {
		return alergiaAlimentar;
	}
	public void setAlergiaAlimentar(String alergiaAlimentar) {
		this.alergiaAlimentar = alergiaAlimentar;
	}
	public String getIntoleranciaAlimentar() {
		return intoleranciaAlimentar;
	}
	public void setIntoleranciaAlimentar(String intoleranciaAlimentar) {
		this.intoleranciaAlimentar = intoleranciaAlimentar;
	}
	public String getAlimentoPreterido() {
		return alimentoPreterido;
	}
	public void setAlimentoPreterido(String alimentoPreterido) {
		this.alimentoPreterido = alimentoPreterido;
	}
	public String getClassificacaoApetite() {
		return classificacaoApetite;
	}
	public void setClassificacaoApetite(String classificacaoApetite) {
		this.classificacaoApetite = classificacaoApetite;
	}
	public String getHorarioFome() {
		return horarioFome;
	}
	public void setHorarioFome(String horarioFome) {
		this.horarioFome = horarioFome;
	}
	public Boolean getBeliscaEntreRefeicao() {
		return beliscaEntreRefeicao;
	}
	public void setBeliscaEntreRefeicao(Boolean beliscaEntreRefeicao) {
		this.beliscaEntreRefeicao = beliscaEntreRefeicao;
	}
	public String getAlteracaoApetite() {
		return alteracaoApetite;
	}
	public void setAlteracaoApetite(String alteracaoApetite) {
		this.alteracaoApetite = alteracaoApetite;
	}
	public String getMotivoAlteracao() {
		return motivoAlteracao;
	}
	public void setMotivoAlteracao(String motivoAlteracao) {
		this.motivoAlteracao = motivoAlteracao;
	}
	public BigDecimal getQtdAguaDia() {
		return qtdAguaDia;
	}
	public void setQtdAguaDia(BigDecimal qtdAguaDia) {
		this.qtdAguaDia = qtdAguaDia;
	}
	public BigDecimal getQtdLiquidoDia() {
		return qtdLiquidoDia;
	}
	public void setQtdLiquidoDia(BigDecimal qtdLiquidoDia) {
		this.qtdLiquidoDia = qtdLiquidoDia;
	}
	public Boolean getIngereLiquidoRefeicao() {
		return ingereLiquidoRefeicao;
	}
	public void setIngereLiquidoRefeicao(Boolean ingereLiquidoRefeicao) {
		this.ingereLiquidoRefeicao = ingereLiquidoRefeicao;
	}
	public BigDecimal getQtdLiquidoRefeicao() {
		return qtdLiquidoRefeicao;
	}
	public void setQtdLiquidoRefeicao(BigDecimal qtdLiquidoRefeicao) {
		this.qtdLiquidoRefeicao = qtdLiquidoRefeicao;
	}
	public Boolean getUsaSuplemento() {
		return usaSuplemento;
	}
	public void setUsaSuplemento(Boolean usaSuplemento) {
		this.usaSuplemento = usaSuplemento;
	}
	public String getIndicacaoUsoSuplemento() {
		return indicacaoUsoSuplemento;
	}
	public void setIndicacaoUsoSuplemento(String indicacaoUsoSuplemento) {
		this.indicacaoUsoSuplemento = indicacaoUsoSuplemento;
	}
	public String getQuemEscolheAlimento() {
		return quemEscolheAlimento;
	}
	public void setQuemEscolheAlimento(String quemEscolheAlimento) {
		this.quemEscolheAlimento = quemEscolheAlimento;
	}
	public String getQuemPreparaRefeicao() {
		return quemPreparaRefeicao;
	}
	public void setQuemPreparaRefeicao(String quemPreparaRefeicao) {
		this.quemPreparaRefeicao = quemPreparaRefeicao;
	}
	public String getFormaPreparoRefeicao() {
		return formaPreparoRefeicao;
	}
	public void setFormaPreparoRefeicao(String formaPreparoRefeicao) {
		this.formaPreparoRefeicao = formaPreparoRefeicao;
	}
	public String getGorduraPreparoRefeicao() {
		return gorduraPreparoRefeicao;
	}
	public void setGorduraPreparoRefeicao(String gorduraPreparoRefeicao) {
		this.gorduraPreparoRefeicao = gorduraPreparoRefeicao;
	}
	public Integer getNrPessoasCozinha() {
		return nrPessoasCozinha;
	}
	public void setNrPessoasCozinha(Integer nrPessoasCozinha) {
		this.nrPessoasCozinha = nrPessoasCozinha;
	}
	public BigDecimal getQtdSal() {
		return qtdSal;
	}
	public void setQtdSal(BigDecimal qtdSal) {
		this.qtdSal = qtdSal;
	}
	public BigDecimal getQtdGordura() {
		return qtdGordura;
	}
	public void setQtdGordura(BigDecimal qtdGordura) {
		this.qtdGordura = qtdGordura;
	}
	public BigDecimal getTotSalMes() {
		return totSalMes;
	}
	public void setTotSalMes(BigDecimal totSalMes) {
		this.totSalMes = totSalMes;
	}
	public BigDecimal getTotSalDia() {
		return totSalDia;
	}
	public void setTotSalDia(BigDecimal totSalDia) {
		this.totSalDia = totSalDia;
	}
	public BigDecimal getTotOleoDia() {
		return totOleoDia;
	}
	public void setTotOleoDia(BigDecimal totOleoDia) {
		this.totOleoDia = totOleoDia;
	}
	public BigDecimal getTotalOleoMes() {
		return totalOleoMes;
	}
	public void setTotalOleoMes(BigDecimal totalOleoMes) {
		this.totalOleoMes = totalOleoMes;
	}
}