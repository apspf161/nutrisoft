package com.nutrisoft.repository.impl;

import org.springframework.stereotype.Repository;

import com.nutrisoft.model.DietaNutricional;
import com.nutrisoft.repository.DietaNutricionalDAO;
import com.nutrisoft.repository.RepositorioGenericoDados;

@Repository
public class DietaNutricionalDAOImpl extends RepositorioGenericoDados<DietaNutricional, Integer> implements DietaNutricionalDAO {
	
	public DietaNutricionalDAOImpl() {
		super(DietaNutricional.class);
	}
}