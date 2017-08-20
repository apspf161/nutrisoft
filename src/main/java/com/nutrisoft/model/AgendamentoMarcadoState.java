package com.nutrisoft.model;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import com.nutrisoft.repository.AgendamentoDAO;
import com.nutrisoft.service.AgendamentoService;

public class AgendamentoMarcadoState extends AgendamentoState {

	private AgendamentoService agService;

	public AgendamentoMarcadoState(){  }

	public AgendamentoMarcadoState(final Agendamento agendamento){ }

	public void marcar(Agendamento agendamento, AgendamentoService agendamentoService) throws Exception {
		agendamento.setCurrentState(agendamento.getMarcadoState());

		agService = agendamentoService;

		validarDataConsulta(agendamento);
		validarDataDisponivel(agendamento);
	}

	public void confirmar(Agendamento agendamento) {
		agendamento.setCurrentState(agendamento.getConfirmadoState());
	}

	public void cancelar(Agendamento agendamento) {
		agendamento.setCurrentState(agendamento.getCanceladoState());
	}

	public void validarDataDisponivel(Agendamento agendamento) throws Exception {

		List<Agendamento> lista = agService.filtrarListaAgendamentosExistentes(agendamento);

		if(lista.size() > 1){
			throw new Exception("Já existe um agendamento marcado nesse horário.");
		}

	}

	public void validarDataConsulta(Agendamento agendamento) throws Exception {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(agendamento.getDataAgendamento());

		int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
		
		if(weekDay == 1 || weekDay == 7){
			throw new Exception("Não é possível agendar aos Sábados e Domingos.");
		}
		
		int hour = calendar.getTime().getHours();
		if(hour < 9 || hour >= 19){
			throw new Exception("Não é possível agendar antes das 9 horas e/ou depois das 19 horas.");
		}
	}
}
