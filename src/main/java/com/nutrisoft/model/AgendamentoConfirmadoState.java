package com.nutrisoft.model;

public class AgendamentoConfirmadoState extends AgendamentoState {

	public AgendamentoConfirmadoState(){  }
	 
    public AgendamentoConfirmadoState(final Agendamento agendamento){

    }
	
	public void cancelar(Agendamento agendamento) {
		agendamento.setCurrentState(agendamento.getCanceladoState());
	}
	    
	public void realizarConsulta(Agendamento agendamento) {
		agendamento.setCurrentState(agendamento.getRealizadoState());
	}	
	
}
