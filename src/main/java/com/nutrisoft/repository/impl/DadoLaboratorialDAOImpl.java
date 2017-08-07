package com.nutrisoft.repository.impl;

import org.springframework.stereotype.Repository;

import com.nutrisoft.model.DadoLaboratorial;
import com.nutrisoft.repository.DadoLaboratorialDAO;
import com.nutrisoft.repository.RepositorioGenericoDados;

@Repository
public class DadoLaboratorialDAOImpl extends RepositorioGenericoDados<DadoLaboratorial, Integer> implements DadoLaboratorialDAO {
	
	public DadoLaboratorialDAOImpl() {
		super(DadoLaboratorial.class);
	}

	@Override
	public void salvar(DadoLaboratorial dadoLaboratorial){
		super.salvar(dadoLaboratorial);
	}

	@Override
	public void alterar(DadoLaboratorial dadoLaboratorial){
		super.alterar(dadoLaboratorial);
	}
}