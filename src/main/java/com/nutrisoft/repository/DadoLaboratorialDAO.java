package com.nutrisoft.repository;

import com.nutrisoft.model.DadoLaboratorial;

public interface DadoLaboratorialDAO {

	void salvar(DadoLaboratorial dadoLaboratorial);
	
	void alterar(DadoLaboratorial dadoLaboratorial);
}