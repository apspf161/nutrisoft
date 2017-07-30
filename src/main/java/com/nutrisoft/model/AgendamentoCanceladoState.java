package com.nutrisoft.model;

import com.nutrisoft.model.enums.StatusAgendamentoEnum;

public class AgendamentoCanceladoState implements AgendamentoState {
	
	public AgendamentoCanceladoState(){ }

    public AgendamentoCanceladoState(Agendamento agendamento){
    	agendamento.setCurrentState(new AgendamentoCanceladoState());
    }
    
	@Override
	public void marcar(Agendamento agendamento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void confirmar(Agendamento agendamento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelar(Agendamento agendamento) {
		agendamento.setStAgendamento(StatusAgendamentoEnum.CANCELADO);
	}

	@Override
	public void realizarConsulta(Agendamento agendamento) {
		// TODO Auto-generated method stub

	}

}
