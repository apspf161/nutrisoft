package com.nutrisoft.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="ATENDIMENTO_CONSULTA")
public class AtendimentoConsulta {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="tipo")
	private int tipo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data")
	private Date data;

	@Temporal(TemporalType.TIME)
	@Column(name="horario")
	private Date horario;
	
	@Column(name = "pesoCliente", precision = 4, scale = 1)  
	private Float pesoCliente;

	@Column(name = "valor", precision = 5, scale = 2)  
	private Float valor;

	@Column(name = "calorias")  
	private Float calorias;
	
	@Column (name = "descPlanAlimentar", nullable = false, length = 50)
	private String descPlanAlimentar;
		
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "usuarioAgendado")
	private Usuario usuarioAgendado;
	
	@Column (name="pago",nullable = false)
	private boolean pago;

	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "regN", nullable=false, insertable = false, updatable = false, foreignKey=@ForeignKey(name="fk_db.Atendimento_Consulta_db.Nutricionista1"))
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Nutricionista nutricionista;
	
	@PrePersist
	protected void onCreate()
	{
		data = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Float getPesoCliente() {
		return pesoCliente;
	}

	public void setPesoCliente(Float pesoCliente) {
		this.pesoCliente = pesoCliente;
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

	public String getDescPlanAlimentar() {
		return descPlanAlimentar;
	}

	public void setDescPlanAlimentar(String descPlanAlimentar) {
		this.descPlanAlimentar = descPlanAlimentar;
	}

	public Usuario getUsuarioAgendado() {
		return usuarioAgendado;
	}

	public void setUsuarioAgendado(Usuario usuarioAgendado) {
		this.usuarioAgendado = usuarioAgendado;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public Nutricionista getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}
}
