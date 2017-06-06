package com.nutrisoft.model;

public class HistoricoMedico {
	
	private Cliente cliente;
	private String doencasPreExistentes;
	private String historicoDoencaFamiliar;
	private String exameLaboratorial;
	private String observacoes;

	public String getDoencasPreExistentes() {
		return doencasPreExistentes;
	}
	public void setDoencasPreExistentes(String doencasPreExistentes) {
		this.doencasPreExistentes = doencasPreExistentes;
	}
	public String getHistoricoDoencaFamiliar() {
		return historicoDoencaFamiliar;
	}
	public void setHistoricoDoencaFamiliar(String historicoDoencaFamiliar) {
		this.historicoDoencaFamiliar = historicoDoencaFamiliar;
	}
	public String getExameLaboratorial() {
		return exameLaboratorial;
	}
	public void setExameLaboratorial(String exameLaboratorial) {
		this.exameLaboratorial = exameLaboratorial;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}