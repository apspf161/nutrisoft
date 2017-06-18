package com.nutrisoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name="Cliente")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumns({@PrimaryKeyJoinColumn(name="idCliente",referencedColumnName="idPessoa")})
public class Cliente extends Pessoa {

	private String motivoConsulta;
	
	private String profissao;
	
	private Float altura;
	
	@Column(name = "obs", columnDefinition = "TEXT")
	private String obs;
	
	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

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

	@Override
	public String toString() {
		return this.toString() + " - Cliente [motivoConsulta=" + motivoConsulta + ", profissao=" + profissao + ", altura=" + altura + ", obs=" + obs + "]";
	}
}
