package com.nutrisoft.model;

public interface AgendamentoState {

	public void marcar(Agendamento agendamento);
	
	public void confirmar(Agendamento agendamento);
	
	public void cancelar(Agendamento agendamento);
	
	public void realizarConsulta(Agendamento agendamento);
}
