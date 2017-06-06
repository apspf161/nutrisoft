package com.nutrisoft.model;

import java.util.Date;

import com.nutrisoft.model.enums.StatusAgendamentoEnum;
import com.nutrisoft.model.enums.TipoConsultaEnum;

public class Agendamento {
	
	private Integer id;
	private Date data;
	private StatusAgendamentoEnum statusAgendamento;
	private Cliente cliente;
	private Nutricionista nutricionista;
	private TipoConsultaEnum tipoConsulta;
	private Consulta consulta;
	
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public StatusAgendamentoEnum getStatusAgendamento() {
		return statusAgendamento;
	}
	public void setStatusAgendamento(StatusAgendamentoEnum statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Nutricionista getNutricionista() {
		return nutricionista;
	}
	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}
	public TipoConsultaEnum getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(TipoConsultaEnum tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
}