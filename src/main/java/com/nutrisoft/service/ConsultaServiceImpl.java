package com.nutrisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nutrisoft.model.Consulta;
import com.nutrisoft.repository.ConsultaDAO;

@Service
@Transactional(propagation=Propagation.NOT_SUPPORTED)
public class ConsultaServiceImpl implements ConsultaService {
	
	@Autowired
	private ConsultaDAO consultaDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addConsulta(Consulta consulta) {
		this.consultaDAO.salvar(consulta);
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
}