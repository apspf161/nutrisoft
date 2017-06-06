package com.nutrisoft.model;

import java.math.BigDecimal;

public class Consulta {

	private Integer id;
	private String motivo;
	private BigDecimal pesoAtual;
	private BigDecimal pesoMeta;
	private BigDecimal valor;
	private Integer calorias;
	private Boolean pago;
	private Agendamento agendamento;
	private DietaNutricional dietaNutricional;
	private Antropometria antropometria;
	private AvaliacaoAlimentar avaliacaoAlimentar;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public BigDecimal getPesoAtual() {
		return pesoAtual;
	}
	public void setPesoAtual(BigDecimal pesoAtual) {
		this.pesoAtual = pesoAtual;
	}
	public BigDecimal getPesoMeta() {
		return pesoMeta;
	}
	public void setPesoMeta(BigDecimal pesoMeta) {
		this.pesoMeta = pesoMeta;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Integer getCalorias() {
		return calorias;
	}
	public void setCalorias(Integer calorias) {
		this.calorias = calorias;
	}
	public Boolean getPago() {
		return pago;
	}
	public void setPago(Boolean pago) {
		this.pago = pago;
	}
	public Agendamento getAgendamento() {
		return agendamento;
	}
	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
	public DietaNutricional getDietaNutricional() {
		return dietaNutricional;
	}
	public void setDietaNutricional(DietaNutricional dietaNutricional) {
		this.dietaNutricional = dietaNutricional;
	}
	public Antropometria getAntropometria() {
		return antropometria;
	}
	public void setAntropometria(Antropometria antropometria) {
		this.antropometria = antropometria;
	}
	public AvaliacaoAlimentar getAvaliacaoAlimentar() {
		return avaliacaoAlimentar;
	}
	public void setAvaliacaoAlimentar(AvaliacaoAlimentar avaliacaoAlimentar) {
		this.avaliacaoAlimentar = avaliacaoAlimentar;
	}
}