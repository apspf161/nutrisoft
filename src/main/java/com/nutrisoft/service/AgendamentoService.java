package com.nutrisoft.service;

import java.util.List;

import com.nutrisoft.model.Agendamento;

public interface AgendamentoService {
	
	public List<Agendamento> listarAgendamentosDeHoje();
	
	public Agendamento getAgendamentoById(int id);
}