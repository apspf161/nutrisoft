package com.nutrisoft.repository;

import java.util.List;

import com.nutrisoft.model.Agendamento;

public interface AgendamentoDAO {

	void salvar(Agendamento agendamento);
	
	void excluir(Agendamento agendamento);
	
	void alterar(Agendamento agendamento);
	
	Agendamento obterPorIdAgendamento(Integer id);
	
	List<Agendamento> obterTodosOsAgendamentos();
	
	List<Agendamento> filtrarAgendamentos(Agendamento agendamento);
	
	public List<Agendamento> listarAgendamentosDeHoje();
	
	public Agendamento getAgendamentoById(int id);
}