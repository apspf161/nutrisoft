package com.nutrisoft.repository;

import java.util.List;

import com.nutrisoft.model.Agendamento;
import com.nutrisoft.model.Nutricionista;

public interface AgendamentoDAO {

	void salvar(Agendamento agendamento);
	
	void excluir(Agendamento agendamento);
	
	void alterar(Agendamento agendamento);
	
	Agendamento obterPorIdAgendamento(Integer id);
	
	List<Agendamento> obterTodos();
	
	List<Agendamento> filtrarAgendamentos(Agendamento agendamento);
	
	List<Agendamento> listarAgendamentosNutricionistaDeHoje(Nutricionista nutricionista);
	
	Agendamento getAgendamentoById(int id);

	List<Agendamento> listarRelatorioAgendamento(Agendamento agendamento);
}