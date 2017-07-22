package com.nutrisoft.repository;

import java.util.List;

import com.nutrisoft.model.Consulta;

public interface ConsultaDAO {

	public void salvar(Consulta consulta);
	
	public void excluir(Consulta consulta);
	
	public void alterar(Consulta consulta);
	
	public Consulta obterPorIdConsulta(Integer id);
	
	public List<Consulta> obterTodasAsConsultas();
}