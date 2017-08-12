package com.nutrisoft.service;

import java.util.List;

import com.nutrisoft.model.Agendamento;
import com.nutrisoft.model.Nutricionista;

public interface AgendamentoService {
	
	void addAgendamento(Agendamento agendamento);

	void updateAgendamento(Agendamento agendamento);
	
	void removeAgendamento(int id);
	
	List<Agendamento> listaAgendamentos();
	
	List<Agendamento> filtrarListaAgendamentos(Agendamento agendamento);
	
	Agendamento getAgendamentoById(int id);

	void confirmarConsulta(Agendamento agendamento);

	void cancelarAgendamento(Agendamento agendamento);

	List<Agendamento> listarAgendamentosNutricionistaDeHoje(Nutricionista nutricionista);

	List<Agendamento> filtrarListaRelatorioAgendamento(Agendamento agendamento);
}