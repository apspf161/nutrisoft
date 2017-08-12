package com.nutrisoft.model;

public class AgendamentoMarcadoState extends AgendamentoState {

	public AgendamentoMarcadoState(){  }

	public AgendamentoMarcadoState(final Agendamento agendamento){ }

	public void marcar(Agendamento agendamento) throws Exception {
		agendamento.setCurrentState(agendamento.getMarcadoState());
	}
	
	public void confirmar(Agendamento agendamento) {
		agendamento.setCurrentState(agendamento.getConfirmadoState());
	}
	
	public void cancelar(Agendamento agendamento) {
		agendamento.setCurrentState(agendamento.getCanceladoState());
	}
	
	public void validarDataDisponivel(Agendamento agendamento) throws Exception {
		/*if(agendamento.getDataAgendamento() == null){
			throw new Exception("ssss");
		}*/
	}

	public void validarDataConsulta(Agendamento agendamento) throws Exception {
		/*if(agendamento.getDataAgendamento() == null){
			throw new Exception("ssss");
		}*/
	}
}
