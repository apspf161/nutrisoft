package com.nutrisoft.repository;

import java.util.List;

import com.nutrisoft.model.Agendamento;

public interface AgendamentoDAO {
	
	public List<Agendamento> listarAgendamentosDeHoje();
	
	public Agendamento getAgendamentoById(int id);
	
	public void salvar(Agendamento agendamento);
}