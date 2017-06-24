package com.nutrisoft.repository;

import java.util.List;

import com.nutrisoft.model.Consulta;

public interface ConsultaDAO {

	void salvar(Consulta consulta);
	
	void excluir(Consulta consulta);
	
	void alterar(Consulta consulta);
	
	Consulta obterPorIdConsulta(Integer id);
	
	List<Consulta> obterTodasAsConsultas();
}