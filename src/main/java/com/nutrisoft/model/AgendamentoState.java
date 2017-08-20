package com.nutrisoft.model;

import com.nutrisoft.service.AgendamentoService;

public abstract class AgendamentoState {

	public void marcar(Agendamento agendamento, AgendamentoService service ) throws Exception { }
	
	public void confirmar(Agendamento agendamento) { }
	
	public void cancelar(Agendamento agendamento)  { }
	
	public void realizarConsulta(Agendamento agendamento) { }
}
