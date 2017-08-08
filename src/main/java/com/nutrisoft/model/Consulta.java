package com.nutrisoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="Consulta")
@Inheritance(strategy=InheritanceType.JOINED)
public class Consulta implements Serializable {
	
	private static final long serialVersionUID = -5519349579288254871L;
	
	@Id
	@Column(name="idConsulta")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idConsulta;
	
	@Column(name = "pesoCliente", precision = 4, scale = 1)  
	private Float pesoCliente;
	
	@Column(name = "meta", precision = 4, scale = 1)  
	private Float meta;	

	@Column(name = "valor", precision = 5, scale = 2)
	@NumberFormat(pattern = "#.###,###")
	private Float valor;

	@Column(name = "calorias")  
	private Float calorias;
	
	@Column(name="pago",nullable = false)
	private Boolean pago;
	
	@Column(name="formaPgto")
	private String formaPgto;	
	
	@OneToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "idAgendamento")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Agendamento agendamento;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="idConsulta")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private DietaNutricional dietaNutricional;

	@OneToOne
	@PrimaryKeyJoinColumn(name="idConsulta")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Antropometria antropometria;

	@OneToOne
	@PrimaryKeyJoinColumn(name="idConsulta")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private AvaliacaoAlimentar avaliacaoAlimentar;
	
//	@PrePersist
//	protected void onCreate() {
//		data = new Date();
//	}

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Float getPesoCliente() {
		return pesoCliente;
	}

	public void setPesoCliente(Float pesoCliente) {
		this.pesoCliente = pesoCliente;
	}

	public Float getMeta() {
		return meta;
	}

	public void setMeta(Float meta) {
		this.meta = meta;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Float getCalorias() {
		return calorias;
	}

	public void setCalorias(Float calorias) {
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

	public String getFormaPgto() {
		return formaPgto;
	}

	public void setFormaPgto(String formaPgto) {
		this.formaPgto = formaPgto;
	}

}