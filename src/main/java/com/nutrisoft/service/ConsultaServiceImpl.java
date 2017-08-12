package com.nutrisoft.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nutrisoft.model.Agendamento;
import com.nutrisoft.model.Antropometria;
import com.nutrisoft.model.AvaliacaoAlimentar;
import com.nutrisoft.model.Cliente;
import com.nutrisoft.model.Consulta;
import com.nutrisoft.model.DadoLaboratorial;
import com.nutrisoft.model.DietaNutricional;
import com.nutrisoft.model.enums.StatusAgendamentoEnum;
import com.nutrisoft.repository.AgendamentoDAO;
import com.nutrisoft.repository.AntropometriaDAO;
import com.nutrisoft.repository.AvaliacaoAlimentarDAO;
import com.nutrisoft.repository.ConsultaDAO;
import com.nutrisoft.repository.DadoLaboratorialDAO;
import com.nutrisoft.repository.DietaNutricionalDAO;

@Service
@Transactional(propagation=Propagation.NOT_SUPPORTED)
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	private DadoLaboratorialDAO dadoLaboratorialDAO;
	
	@Autowired
	private AgendamentoDAO agendamentoDAO;
	
	@Autowired
	private ConsultaDAO consultaDAO;
	
	@Autowired
	private AntropometriaDAO antropometriaDAO;
	
	@Autowired
	private AvaliacaoAlimentarDAO avaliacaoAlimentarDAO;
	
	@Autowired
	private DietaNutricionalDAO dietaNutricionalDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addConsulta(Consulta consulta) {
		DadoLaboratorial dadoLaboratorialTela = consulta.getAgendamento().getCliente().getDadoLaboratorial();
		
		Agendamento agendamento = this.agendamentoDAO.getAgendamentoById(consulta.getAgendamento().getIdAgendamento());
		agendamento.setStAgendamento(StatusAgendamentoEnum.REALIZADO);
		this.agendamentoDAO.salvar(agendamento);
		
		this.consultaDAO.salvar(consulta);
		
		Antropometria antropometria = consulta.getAntropometria();
		antropometria.setConsulta(consulta);
		this.antropometriaDAO.salvar(antropometria);
		
		AvaliacaoAlimentar avaliacaoAlimentar = consulta.getAvaliacaoAlimentar();
		avaliacaoAlimentar.setConsulta(consulta);
		this.avaliacaoAlimentarDAO.salvar(avaliacaoAlimentar);
		
		DietaNutricional dietaNutricional = consulta.getDietaNutricional();
		dietaNutricional.setConsulta(consulta);
		this.dietaNutricionalDAO.salvar(dietaNutricional);
		
		DadoLaboratorial dadoLaboratorial = agendamento.getCliente().getDadoLaboratorial();
		if (dadoLaboratorial != null) {
			BeanUtils.copyProperties(dadoLaboratorialTela, dadoLaboratorial);
			dadoLaboratorial.setIdCliente(agendamento.getCliente().getIdPessoa());
			dadoLaboratorial.setCliente(agendamento.getCliente());
			dadoLaboratorial.setData(new Date());
			dadoLaboratorialDAO.alterar(dadoLaboratorial);
		} else {
			dadoLaboratorialTela.setIdCliente(agendamento.getCliente().getIdPessoa());
			dadoLaboratorialTela.setCliente(agendamento.getCliente());
			dadoLaboratorialTela.setData(new Date());
			dadoLaboratorialDAO.salvar(dadoLaboratorialTela);
		}
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateConsulta(Consulta consulta) {
		this.consultaDAO.alterar(consulta);
	}

	@Override
	public Consulta getConsultaById(int id) {
		return this.consultaDAO.obterPorIdConsulta(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void removeConsulta(int id) {
		Consulta consulta = consultaDAO.obterPorIdConsulta(id);
		this.consultaDAO.excluir(consulta);
	}

	@Override
	public List<Consulta> listConsultas() {
		return this.consultaDAO.obterTodasAsConsultas();
	}

	@Override
	public List<Consulta> filtrarListaPagamentos(Consulta consulta) {
		return this.consultaDAO.filtrarPagamentos(consulta);
	}

	@Override
	public void efetuarPagamento(Consulta consulta) {
		this.consultaDAO.alterar(consulta);		
	}	
	
	@Override
	public List<Consulta> listarConsultasAnteriores(Cliente cliente) {
		return this.consultaDAO.listarConsultasAnteriores(cliente);
	}
	
	@Override
	public List<Consulta> filtrarListaRelatorioAtendimento(Consulta consulta) {
		return this.consultaDAO.listarRelatorioAtendimento(consulta);
	}

	@Override
	public List<Consulta> filtrarListaEvolucaoCliente(Consulta consulta) {
		return this.consultaDAO.listarEvolucaoCliente(consulta);
	}
}