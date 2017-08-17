package com.nutrisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nutrisoft.model.Agendamento;
import com.nutrisoft.model.Cliente;
import com.nutrisoft.model.Nutricionista;
import com.nutrisoft.model.enums.StatusAgendamentoEnum;
import com.nutrisoft.repository.AgendamentoDAO;
import com.nutrisoft.repository.ClienteDAO;
import com.nutrisoft.repository.NutricionistaDAO;

@Service
@Transactional(propagation=Propagation.NOT_SUPPORTED)
public class AgendamentoServiceImpl implements AgendamentoService {
	
	@Autowired
	private AgendamentoDAO agendamentoDAO;
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private NutricionistaDAO nutricionistaDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addAgendamento(Agendamento agendamento) {
		agendamento.setStAgendamento(StatusAgendamentoEnum.MARCADO);
		this.agendamentoDAO.salvar(agendamento);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateAgendamento(Agendamento agendamento) {
		Agendamento agendamentoBanco = this.agendamentoDAO.obterPorIdAgendamento(agendamento.getIdAgendamento());
		agendamentoBanco.setDataAgendamento(agendamento.getDataAgendamento());
		this.agendamentoDAO.alterar(agendamentoBanco);
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
		return this.agendamentoDAO.obterTodos();
	}	

	@Override
	public List<Agendamento> filtrarListaAgendamentos(Agendamento agendamento) {
		return this.agendamentoDAO.filtrarAgendamentos(agendamento);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void confirmarConsulta(Agendamento agendamento) {
		
		Agendamento agendamentoBanco = this.agendamentoDAO.obterPorIdAgendamento(agendamento.getIdAgendamento());
		Cliente cliente = clienteDAO.obterPorId(agendamentoBanco.getCliente().getIdPessoa());
		Nutricionista nutricionista = nutricionistaDAO.obterPorId(agendamentoBanco.getNutricionista().getIdPessoa());

		agendamentoBanco.setStAgendamento(StatusAgendamentoEnum.CONFIRMADO);
		agendamentoBanco.setCliente(cliente);
		agendamentoBanco.setNutricionista(nutricionista);		
		
		this.agendamentoDAO.alterar(agendamentoBanco);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void cancelarAgendamento(Agendamento agendamento) {
		
		Agendamento agendamentoBanco = this.agendamentoDAO.obterPorIdAgendamento(agendamento.getIdAgendamento());
		Cliente cliente = clienteDAO.obterPorId(agendamento.getCliente().getIdPessoa());
		Nutricionista nutricionista = nutricionistaDAO.obterPorId(agendamento.getNutricionista().getIdPessoa());
		
		agendamentoBanco.setCliente(cliente);
		agendamentoBanco.setNutricionista(nutricionista);		
		agendamentoBanco.setStAgendamento(StatusAgendamentoEnum.CANCELADO);
		
		this.agendamentoDAO.alterar(agendamentoBanco);
	}	

	public List<Agendamento> listarAgendamentosNutricionistaDeHoje(Nutricionista nutricionista) {
		return this.agendamentoDAO.listarAgendamentosNutricionistaDeHoje(nutricionista);
	}

	@Override
	public List<Agendamento> filtrarListaRelatorioAgendamento(Agendamento agendamento) {
		return this.agendamentoDAO.listarRelatorioAgendamento(agendamento);
	}

	@Override
	public List<Cliente> filtrarListaClienteRelatorioEvolucao(Agendamento agendamento) {
		return this.agendamentoDAO.listarClienteRelatorioEvolucao(agendamento);
	}
}