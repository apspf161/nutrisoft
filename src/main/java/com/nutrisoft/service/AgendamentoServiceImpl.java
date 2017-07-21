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
	@Transactional(propagation=Propagation.REQUIRED)
	public void addAgendamento(Agendamento agendamento) {
		this.agendamentoDAO.salvar(agendamento);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateAgendamento(Agendamento agendamento) {
		this.agendamentoDAO.alterar(agendamento);
	}

	@Override
	public Agendamento getAgendamentoById(int id) {
		return this.agendamentoDAO.obterPorIdAgendamento(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void removeAgendamento(int id) {
		Agendamento agendamento = agendamentoDAO.obterPorIdAgendamento(id);
		this.agendamentoDAO.excluir(agendamento);
	}

	@Override
	public List<Agendamento> listaAgendamentos() {
		return this.agendamentoDAO.obterTodosOsAgendamentos();
	}	

	@Override
	public List<Agendamento> filtrarListaAgendamentos(Agendamento agendamento) {
		return this.agendamentoDAO.filtrarAgendamentos(agendamento);
	}

	@Override
	public void confirmarConsulta(Agendamento agendamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarAgendamento(Agendamento agendamento) {
		// TODO Auto-generated method stub
		
	}	
}