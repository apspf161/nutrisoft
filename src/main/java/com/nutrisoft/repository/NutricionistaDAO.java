package com.nutrisoft.repository;

import java.util.List;

import com.nutrisoft.model.Nutricionista;

public interface NutricionistaDAO {
	
	void salvar(Nutricionista nutricionista);
	
	void excluir(Nutricionista nutricionista);
	
	void alterar(Nutricionista nutricionista);
	
	Nutricionista obterPorId(Integer id);
	
	List<Nutricionista> obterTodos();
	
	List<Nutricionista> buscarFiltroListaNutricionista(Nutricionista nutricionista);
}
