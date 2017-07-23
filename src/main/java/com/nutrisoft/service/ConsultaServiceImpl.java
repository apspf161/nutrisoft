package com.nutrisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nutrisoft.model.Agendamento;
import com.nutrisoft.model.Antropometria;
import com.nutrisoft.model.AvaliacaoAlimentar;
import com.nutrisoft.model.Cliente;
import com.nutrisoft.model.Consulta;
import com.nutrisoft.model.DietaNutricional;
import com.nutrisoft.model.enums.StatusAgendamentoEnum;
import com.nutrisoft.repository.AgendamentoDAO;
import com.nutrisoft.repository.AntropometriaDAO;
import com.nutrisoft.repository.AvaliacaoAlimentarDAO;
import com.nutrisoft.repository.ConsultaDAO;
import com.nutrisoft.repository.DietaNutricionalDAO;

@Service
@Transactional(propagation=Propagation.NOT_SUPPORTED)
public class ConsultaServiceImpl implements ConsultaService {

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
		Agendamento agendamento = this.agendamentoDAO.getAgendamentoById(consulta.getAgendamento().getIdAgendamento());
		
		agendamento.setStatusAgendamento(StatusAgendamentoEnum.REALIZADO);
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
		
//		atualizar dado laboratorial
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
	public List<Consulta> listarConsultasAnteriores(Cliente cliente) {
		return this.consultaDAO.listarConsultasAnteriores(cliente);
	}
}