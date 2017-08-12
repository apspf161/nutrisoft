package com.nutrisoft.model;

public abstract class AgendamentoState {

	public void marcar(Agendamento agendamento) throws Exception { }
	
	public void confirmar(Agendamento agendamento) { }
	
	public void cancelar(Agendamento agendamento)  { }
	
	public void realizarConsulta(Agendamento agendamento) { }
}
