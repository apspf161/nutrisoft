package com.nutrisoft.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="AGENDAMENTO_CONSULTA")
public class AgendamentoConsulta {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
		
/*	@Column(name="cpfCli")
	private Cliente cliente;*/
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data")
	private Date data;
	
	@Column(name = "estadoAgendamento", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private EstadoAgendamento estadoAgendamento;

	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "regN", nullable=false, insertable = false, updatable = false, foreignKey=@ForeignKey(name="fk_db.Atendimento_Consulta_db.Nutricionista1"))
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Nutricionista nutricionista;
	
	@PrePersist
	protected void onCreate()
	{
		estadoAgendamento = EstadoAgendamento.MARCADA;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

/*	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}*/

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public EstadoAgendamento getEstadoAgendamento() {
		return estadoAgendamento;
	}

	public void setEstadoAgendamento(EstadoAgendamento estadoAgendamento) {
		this.estadoAgendamento = estadoAgendamento;
	}

	public Nutricionista getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}
	
	
}
