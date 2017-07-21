package com.nutrisoft.service;

import java.util.List;

import com.nutrisoft.model.Nutricionista;

public interface NutricionistaService {
	
	void addNutricionista(Nutricionista nutricionista);

	void updateNutricionista(Nutricionista nutricionista);
	
	void removeNutricionista(int id);
	
	List<Nutricionista> listNutricionistas();
	
	Nutricionista getNutricionistaById(int id);
}