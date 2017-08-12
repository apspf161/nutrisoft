package com.nutrisoft.repository.impl;

import org.springframework.stereotype.Repository;

import com.nutrisoft.model.Antropometria;
import com.nutrisoft.repository.AntropometriaDAO;
import com.nutrisoft.repository.RepositorioGenericoDados;

@Repository
public class AntropometriaDAOImpl extends RepositorioGenericoDados<Antropometria, Integer> implements AntropometriaDAO {
	
	public AntropometriaDAOImpl() {
		super(Antropometria.class);
	}
}