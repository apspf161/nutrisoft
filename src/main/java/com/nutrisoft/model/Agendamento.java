package com.nutrisoft.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import com.nutrisoft.model.enums.StatusAgendamentoEnum;
import com.nutrisoft.model.enums.TipoConsultaEnum;


@Entity
@Table(name="Agendamento")
@Inheritance(strategy=InheritanceType.JOINED)
public class Agendamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAgendamento;
	
	@Column(name="dataAgendamento")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataAgendamento;
	
	@Column(name="stAgendamento")
	@Enumerated(EnumType.STRING)
	private StatusAgendamentoEnum statusAgendamento;
	
	@Column(name="tipoConsulta")
	@Enumerated(EnumType.STRING)
	private TipoConsultaEnum tipoConsulta;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "idNutricionista", nullable=false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Nutricionista nutricionista;

	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "idCliente", nullable=false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Cliente cliente;

//	@PrePersist
//	protected void onCreate() {
//		estadoAgendamento = EstadoAgendamento.MARCADA;
//	}

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

	public StatusAgendamentoEnum getStatusAgendamento() {
		return statusAgendamento;
	}

	public void setStatusAgendamento(StatusAgendamentoEnum statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
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

	public TipoConsultaEnum getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(TipoConsultaEnum tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
}