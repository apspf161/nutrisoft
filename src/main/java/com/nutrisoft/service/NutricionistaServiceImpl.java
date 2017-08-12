package com.nutrisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nutrisoft.model.Nutricionista;
import com.nutrisoft.repository.NutricionistaDAO;

@Service
@Transactional(propagation=Propagation.NOT_SUPPORTED)
public class NutricionistaServiceImpl implements NutricionistaService {
	
	@Autowired
	private NutricionistaDAO nutricionistaDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addNutricionista(Nutricionista nutricionista) {
		this.nutricionistaDAO.salvar(nutricionista);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateNutricionista(Nutricionista nutricionista) {
		this.nutricionistaDAO.alterar(nutricionista);
	}

	@Override
	public Nutricionista getNutricionistaById(int id) {
		return this.nutricionistaDAO.obterPorId(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void removeNutricionista(int id) {
		Nutricionista nutricionista = nutricionistaDAO.obterPorId(id);
		this.nutricionistaDAO.excluir(nutricionista);
	}

	@Override
	public List<Nutricionista> listNutricionistas() {
		return this.nutricionistaDAO.obterTodos();
	}	
}