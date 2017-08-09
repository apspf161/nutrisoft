package com.nutrisoft.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
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
		Cliente cliente = clienteDAO.obterPorIdCliente(agendamento.getCliente().getIdPessoa());
		Nutricionista nutricionista = nutricionistaDAO.obterPorIdNutricionista(agendamento.getNutricionista().getIdPessoa());
		
		agendamento.setCliente(cliente);
		agendamento.setNutricionista(nutricionista);		
		
		BeanUtils.copyProperties(agendamento, agendamentoBanco);
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
		return this.agendamentoDAO.obterTodosOsAgendamentos();
	}	

	@Override
	public List<Agendamento> filtrarListaAgendamentos(Agendamento agendamento) {
		return this.agendamentoDAO.filtrarAgendamentos(agendamento);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void confirmarConsulta(Agendamento agendamento) {
		
		Agendamento agendamentoBanco = this.agendamentoDAO.obterPorIdAgendamento(agendamento.getIdAgendamento());
		Cliente cliente = clienteDAO.obterPorIdCliente(agendamentoBanco.getCliente().getIdPessoa());
		Nutricionista nutricionista = nutricionistaDAO.obterPorIdNutricionista(agendamentoBanco.getNutricionista().getIdPessoa());

		agendamentoBanco.setStAgendamento(StatusAgendamentoEnum.CONFIRMADO);
		agendamentoBanco.setCliente(cliente);
		agendamentoBanco.setNutricionista(nutricionista);		
		
		this.agendamentoDAO.alterar(agendamentoBanco);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void cancelarAgendamento(Agendamento agendamento) {
		Cliente cliente = clienteDAO.obterPorIdCliente(agendamento.getCliente().getIdPessoa());
		Nutricionista nutricionista = nutricionistaDAO.obterPorIdNutricionista(agendamento.getNutricionista().getIdPessoa());
		
		agendamento.setCliente(cliente);
		agendamento.setNutricionista(nutricionista);		
		
		agendamento.setStAgendamento(StatusAgendamentoEnum.CANCELADO);
		this.agendamentoDAO.alterar(agendamento);
	}	

	public List<Agendamento> listarAgendamentosDeHoje() {
		return this.agendamentoDAO.listarAgendamentosDeHoje();
	}

	@Override
	public List<Agendamento> filtrarListaRelatorioAgendamento(Agendamento agendamento) {
		return this.agendamentoDAO.listarRelatorioAgendamento(agendamento);
	}
}