package com.nutrisoft.model;

import com.nutrisoft.model.enums.StatusAgendamentoEnum;
import com.nutrisoft.util.Validacao;

public class AgendamentoMarcadoState implements AgendamentoState {

	 public AgendamentoMarcadoState(){  }
	 
    public AgendamentoMarcadoState(final Agendamento agendamento){
    	agendamento.setCurrentState(new AgendamentoMarcadoState());
    }

	@Override
	public void marcar(Agendamento agendamento) {
		agendamento.setStAgendamento(StatusAgendamentoEnum.MARCADO);
	}

	@Override
	public void confirmar(Agendamento agendamento) {	}

	@Override
	public void cancelar(Agendamento agendamento) {	}

	@Override
	public void realizarConsulta(Agendamento agendamento) {	}

	public Validacao validarDataDisponivel(Agendamento agendamento) {
		Validacao validacao = new Validacao();

		
		return validacao;
	}
	
	public Validacao validarDataConsulta(Agendamento agendamento) {
		Validacao validacao = new Validacao();

		return validacao;
	}
}
