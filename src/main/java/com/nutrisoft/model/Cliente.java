package com.nutrisoft.model;
import java.math.BigDecimal;

public class Cliente extends Pessoa {

	private String profissao;
	private BigDecimal altura;
	private String observacoes;
	private DadoLaboratorial dadoLaboratorial;

	public DadoLaboratorial getDadoLaboratorial() {
		return dadoLaboratorial;
	}
	public void setDadoLaboratorial(DadoLaboratorial dadoLaboratorial) {
		this.dadoLaboratorial = dadoLaboratorial;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public BigDecimal getAltura() {
		return altura;
	}
	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
}