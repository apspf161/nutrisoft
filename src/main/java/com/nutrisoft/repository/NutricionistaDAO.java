package com.nutrisoft.repository;

import java.util.List;

import com.nutrisoft.model.Nutricionista;
import com.nutrisoft.model.Pessoa;

public interface NutricionistaDAO {
	
	void salvar(Nutricionista nutricionista);
	
	void excluir(Nutricionista nutricionista);
	
	void alterar(Nutricionista nutricionista);
	
	Pessoa obterPorId(Integer id);
	
	List<Nutricionista> obterTodasAsNutricionistas();
	
	List<Nutricionista> buscarFiltroListaNutricionista(Nutricionista nutricionista);
}
