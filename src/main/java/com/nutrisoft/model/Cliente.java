package com.nutrisoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="Cliente")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="idCliente",referencedColumnName="idPessoa")
public class Cliente extends Pessoa {

	@Column(name="profissao")
	private String profissao;

	@Column(name="altura")
	private Float altura;	
	
	@Column(name = "motivoConsulta", columnDefinition = "TEXT")
	private String motivoConsulta;
	
	@Column(name = "obs", columnDefinition = "TEXT")
	private String obs;

	@Column(name = "doencasPreExist", columnDefinition = "TEXT")
	private String doencasPreExist;
	
    @Column(name = "histDoencaFamiliar", columnDefinition = "TEXT")
	private String histDoencaFamiliar;
	
    @Column(name = "exameLaboratorial", columnDefinition = "TEXT")
	private String exameLaboratorial;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="idCliente")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private DadoLaboratorial dadoLaboratorial;

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public DadoLaboratorial getDadoLaboratorial() {
		return dadoLaboratorial;
	}

	public void setDadoLaboratorial(DadoLaboratorial dadoLaboratorial) {
		this.dadoLaboratorial = dadoLaboratorial;
	}

	public String getDoencasPreExist() {
		return doencasPreExist;
	}

	public void setDoencasPreExist(String doencasPreExist) {
		this.doencasPreExist = doencasPreExist;
	}

	public String getHistDoencaFamiliar() {
		return histDoencaFamiliar;
	}

	public void setHistDoencaFamiliar(String histDoencaFamiliar) {
		this.histDoencaFamiliar = histDoencaFamiliar;
	}

	public String getExameLaboratorial() {
		return exameLaboratorial;
	}

	public void setExameLaboratorial(String exameLaboratorial) {
		this.exameLaboratorial = exameLaboratorial;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
}
