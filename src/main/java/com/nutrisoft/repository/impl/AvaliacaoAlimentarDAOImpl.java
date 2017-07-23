package com.nutrisoft.repository.impl;

import org.springframework.stereotype.Repository;

import com.nutrisoft.model.AvaliacaoAlimentar;
import com.nutrisoft.repository.AvaliacaoAlimentarDAO;
import com.nutrisoft.repository.RepositorioGenericoDados;

@Repository
public class AvaliacaoAlimentarDAOImpl extends RepositorioGenericoDados<AvaliacaoAlimentar, Integer> implements AvaliacaoAlimentarDAO {
	
	public AvaliacaoAlimentarDAOImpl() {
		super(AvaliacaoAlimentar.class);
	}

	@Override
	public void salvar(AvaliacaoAlimentar antropometria){
		super.salvar(antropometria);
	}
}