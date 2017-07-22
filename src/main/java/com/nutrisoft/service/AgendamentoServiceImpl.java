package com.nutrisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nutrisoft.model.Agendamento;
import com.nutrisoft.repository.AgendamentoDAO;

@Service
@Transactional(propagation=Propagation.NOT_SUPPORTED)
public class AgendamentoServiceImpl implements AgendamentoService {
	
	@Autowired
	private AgendamentoDAO agendamentoDAO;
	
	@Override
	public List<Agendamento> listarAgendamentosDeHoje() {
		return this.agendamentoDAO.listarAgendamentosDeHoje();
	}

	@Override
	public Agendamento getAgendamentoById(int id) {
		return this.agendamentoDAO.getAgendamentoById(id);
	}
}