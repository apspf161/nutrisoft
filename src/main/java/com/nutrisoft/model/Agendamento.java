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
import javax.persistence.Transient;

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
	private StatusAgendamentoEnum stAgendamento;

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

//	@Transient
//	private AgendamentoState currentState;
//	
//	@Transient
//	private AgendamentoState marcadoState;
//
//	@Transient
//	private AgendamentoState confirmadoState;
//
//	@Transient
//	private AgendamentoState canceladoState;
//
//	@Transient
//	private AgendamentoState realizadoState;

	@Transient
	private Date dataPeriodoInicial;
	
	@Transient
	private Date dataPeriodoFinal;

	@Transient
	private String turnoAgendamento;
	
//	public Agendamento()
//	{
//		this.marcadoState = new AgendamentoMarcadoState(this);
//		this.confirmadoState = new AgendamentoConfirmadoState(this);
//		this.canceladoState = new AgendamentoCanceladoState(this);
//		this.realizadoState = new AgendamentoRealizadoState(this);
//		this.currentState = this.marcadoState;
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

/*	public StatusAgendamentoEnum getStatusAgendamento() {
		return statusAgendamento;
	}

	public void setStatusAgendamento(StatusAgendamentoEnum statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}*/

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

//	public void marcar() {
//		currentState.marcar(this);
//	}
//
//	public void confirmar() {
//		currentState.confirmar(this);
//	}
//
//	public void cancelar() {
//		currentState.cancelar(this);
//	}
//
//	public void realizarConsulta() {
//		currentState.realizarConsulta(this);
//	}
//
//	public AgendamentoState getCurrentState() {
//		return currentState;
//	}
//
//	public void setCurrentState(AgendamentoState currentState) {
//		this.currentState = currentState;
//	}

	public StatusAgendamentoEnum getStAgendamento() {
//		StatusAgendamentoEnum stAgendamento = null;
//		
//		if(this.getCurrentState() instanceof AgendamentoMarcadoState)
//		{
//			stAgendamento = StatusAgendamentoEnum.MARCADO;
//		} else if(this.getCurrentState() instanceof AgendamentoConfirmadoState)
//		{
//			stAgendamento = StatusAgendamentoEnum.CONFIRMADO;
//		} else if(this.getCurrentState() instanceof AgendamentoCanceladoState)
//		{
//			stAgendamento = StatusAgendamentoEnum.CANCELADO;
//		} else if(this.getCurrentState() instanceof AgendamentoRealizadoState)
//		{
//			stAgendamento = StatusAgendamentoEnum.REALIZADO;
//		} else {
//			stAgendamento = StatusAgendamentoEnum.MARCADO;
//		}

		return stAgendamento;
	}

	public void setStAgendamento(StatusAgendamentoEnum stAgendamento) {
		this.stAgendamento = stAgendamento;
		
//		switch (stAgendamento) {
//		case MARCADO:
//			this.currentState = this.marcadoState;
//			break;
//		case CONFIRMADO:
//			this.currentState = this.confirmadoState;
//			break;
//		case CANCELADO:
//			this.currentState = this.canceladoState;
//			break;
//		case REALIZADO:
//			this.currentState = this.realizadoState;
//			break;
//		default:
//			this.currentState = this.marcadoState;
//			break;
//		}
	}

	public Date getDataPeriodoInicial() {
		return dataPeriodoInicial;
	}

	public void setDataPeriodoInicial(Date dataPeriodoInicial) {
		this.dataPeriodoInicial = dataPeriodoInicial;
	}

	public Date getDataPeriodoFinal() {
		return dataPeriodoFinal;
	}

	public void setDataPeriodoFinal(Date dataPeriodoFinal) {
		this.dataPeriodoFinal = dataPeriodoFinal;
	}

	public String getTurnoAgendamento() {
		return turnoAgendamento;
	}

	public void setTurnoAgendamento(String turnoAgendamento) {
		this.turnoAgendamento = turnoAgendamento;
	}

}