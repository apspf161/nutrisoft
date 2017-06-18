package com.nutrisoft.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="Agendamento")
@Inheritance(strategy=InheritanceType.JOINED)
public class Agendamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAgendamento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAgendamento;
	
	private char stAgendamento;

	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "idNutricionista", nullable=false, insertable = false, updatable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Nutricionista nutricionista;

	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "idCliente", nullable=false, insertable = false, updatable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Cliente cliente;
	
	private char tipoConsulta;
	
	@PrePersist
	protected void onCreate()
	{
		//estadoAgendamento = EstadoAgendamento.MARCADA;
	}

	public Integer getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(Integer idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public char getStAgendamento() {
		return stAgendamento;
	}

	public void setStAgendamento(char stAgendamento) {
		this.stAgendamento = stAgendamento;
	}

	public Nutricionista getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public char getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(char tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
}
