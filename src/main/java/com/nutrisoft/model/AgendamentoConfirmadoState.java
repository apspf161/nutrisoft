package com.nutrisoft.model;

import com.nutrisoft.model.enums.StatusAgendamentoEnum;

public class AgendamentoConfirmadoState implements AgendamentoState {

	public AgendamentoConfirmadoState(){  }
	 
    public AgendamentoConfirmadoState(final Agendamento agendamento){
    	agendamento.setCurrentState(new AgendamentoConfirmadoState());
    }
    
	@Override
	public void marcar(Agendamento agendamento) { }

	@Override
	public void confirmar(Agendamento agendamento) {
		agendamento.setStAgendamento(StatusAgendamentoEnum.CONFIRMADO);
	}

	@Override
	public void cancelar(Agendamento agendamento) { }

	@Override
	public void realizarConsulta(Agendamento agendamento) { }
	
	
	public void solicitarExamesPrimeiraConsulta() {
		// TODO Auto-generated method stub

	}
	
	public void validarDataConsulta() {
		// TODO Auto-generated method stub

	}

}
