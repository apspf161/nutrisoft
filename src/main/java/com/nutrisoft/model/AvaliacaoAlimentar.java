package com.nutrisoft.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="Avaliacao_Alimentar")
public class AvaliacaoAlimentar implements Serializable {
	
	private static final long serialVersionUID = 6442541897068880914L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAvaliacao;

	@MapsId
	@OneToOne(mappedBy="avaliacaoAlimentar")
	@JoinColumn(name="idConsulta")
	private Consulta consulta;
	
	private char stAcompanhamentoNutricional;
	
	private String nutricionistaAcompanhamentoAnterior;
	
	private String objetivoAcompanhamento;
	
	private String alergiaAlimentar;
	
	private String intoleranciaAlimentar;
	
	private String preferenciaAlimentar;
	
	private String alimentoPreterido;
	
	private String classificacaoApetite;
	
	private String horarioFome;
	
	private Boolean beliscaEntreRefeicao;
	
	private String alteracaoApetite;
	
	private String motivoAlteracao;

	@NumberFormat(pattern = "#0,0")
	private Float qtdAguaDia;

	@NumberFormat(pattern = "#0,0")
	private Float qtdLiquidoDia;
	
	private Boolean ingereLiquidoRefeicao;

	@NumberFormat(pattern = "#0,00")
	private Float qtdLiquidoRefeicao;
	
	private Boolean usaSuplemento;
	
	private String indicacaoUsoSuplemento;
	
	private String quemEscolheAlimento;
	
	private String quemPreparaRefeicao;
	
	private String formaPreparoRefeicao;
	
	private String gorduraPreparoRefeicao;
	
	private Integer nrPessoasCozinha;

	@NumberFormat(pattern = "#0,0")
	private Float qtdSal;

	@NumberFormat(pattern = "#0,0")
	private Float qtdGordura;

	@NumberFormat(pattern = "#0,0")
	private Float totSalMes;

	@NumberFormat(pattern = "#0,0")
	private Float totSalDia;

	@NumberFormat(pattern = "#0,0")
	private Float totOleoDia;

	@NumberFormat(pattern = "#0,0")
	private Float totalOleoMes;

	public char getStAcompanhamentoNutricional() {
		return stAcompanhamentoNutricional;
	}

	public void setStAcompanhamentoNutricional(char stAcompanhamentoNutricional) {
		this.stAcompanhamentoNutricional = stAcompanhamentoNutricional;
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

	public String getPreferenciaAlimentar() {
		return preferenciaAlimentar;
	}

	public void setPreferenciaAlimentar(String preferenciaAlimentar) {
		this.preferenciaAlimentar = preferenciaAlimentar;
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

	public Float getQtdAguaDia() {
		return qtdAguaDia;
	}

	public void setQtdAguaDia(Float qtdAguaDia) {
		this.qtdAguaDia = qtdAguaDia;
	}

	public Float getQtdLiquidoDia() {
		return qtdLiquidoDia;
	}

	public void setQtdLiquidoDia(Float qtdLiquidoDia) {
		this.qtdLiquidoDia = qtdLiquidoDia;
	}

	public Boolean getIngereLiquidoRefeicao() {
		return ingereLiquidoRefeicao;
	}

	public void setIngereLiquidoRefeicao(Boolean ingereLiquidoRefeicao) {
		this.ingereLiquidoRefeicao = ingereLiquidoRefeicao;
	}

	public Float getQtdLiquidoRefeicao() {
		return qtdLiquidoRefeicao;
	}

	public void setQtdLiquidoRefeicao(Float qtdLiquidoRefeicao) {
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

	public Float getQtdSal() {
		return qtdSal;
	}

	public void setQtdSal(Float qtdSal) {
		this.qtdSal = qtdSal;
	}

	public Float getQtdGordura() {
		return qtdGordura;
	}

	public void setQtdGordura(Float qtdGordura) {
		this.qtdGordura = qtdGordura;
	}

	public Float getTotSalMes() {
		return totSalMes;
	}

	public void setTotSalMes(Float totSalMes) {
		this.totSalMes = totSalMes;
	}

	public Float getTotSalDia() {
		return totSalDia;
	}

	public void setTotSalDia(Float totSalDia) {
		this.totSalDia = totSalDia;
	}

	public Float getTotOleoDia() {
		return totOleoDia;
	}

	public void setTotOleoDia(Float totOleoDia) {
		this.totOleoDia = totOleoDia;
	}

	public Float getTotalOleoMes() {
		return totalOleoMes;
	}

	public void setTotalOleoMes(Float totalOleoMes) {
		this.totalOleoMes = totalOleoMes;
	}

	public Integer getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Integer idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
}
