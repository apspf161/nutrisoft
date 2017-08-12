package com.nutrisoft.model;

import com.nutrisoft.model.enums.StatusAgendamentoEnum;

public class AgendamentoRealizadoState implements AgendamentoState {

	public AgendamentoRealizadoState(){}
	
    public AgendamentoRealizadoState(Agendamento agendamento){
//        agendamento.setCurrentState(new AgendamentoRealizadoState());
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
		// TODO Auto-generated method stub

	}

	@Override
	public void realizarConsulta(Agendamento agendamento) {
		agendamento.setStAgendamento(StatusAgendamentoEnum.REALIZADO);
	}
	
	public void iniciarConsulta() {
		// TODO Auto-generated method stub

	}
}
