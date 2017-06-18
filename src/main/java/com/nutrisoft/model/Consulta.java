package com.nutrisoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="Consulta")
@Inheritance(strategy=InheritanceType.JOINED)
public class Consulta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idConsulta;
		
	@Column(name = "pesoCliente", precision = 4, scale = 1)  
	private Float pesoCliente;
	
	@Column(name = "meta", precision = 4, scale = 1)  
	private Float meta;	

	@Column(name = "valor", precision = 5, scale = 2)  
	private Float valor;

	@Column(name = "calorias")  
	private Float calorias;
	
	@Column (name="pago",nullable = false)
	private Boolean pago;

	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "idAgendamento", nullable=false, insertable = false, updatable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Agendamento agendamento;
	
	@PrePersist
	protected void onCreate()
	{
	//	data = new Date();
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
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

	public Boolean isPago() {
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
}
