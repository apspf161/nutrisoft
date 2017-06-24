package com.nutrisoft.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nutrisoft.model.Consulta;
import com.nutrisoft.repository.ConsultaDAO;
import com.nutrisoft.repository.RepositorioGenericoDados;

@Repository
public class ConsultaDAOImpl extends RepositorioGenericoDados<Consulta, Integer> implements ConsultaDAO {
	
	public ConsultaDAOImpl() {
		super(Consulta.class);
	}

	@Override
	public void salvar(Consulta consulta){
		super.salvar(consulta);
	}

	@Override
	public void excluir(Consulta consulta){
		super.excluir(consulta);
	}

	@Override
	public void alterar(Consulta consulta){
		super.alterar(consulta);
	}

	@Override
	public List<Consulta> obterTodasAsConsultas() {
		return this.obterTodos();
	}

	@Override
	public Consulta obterPorIdConsulta(Integer id) {
		return this.obterPorId(id);
	}
}