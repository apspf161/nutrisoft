package com.nutrisoft.repository;

import java.util.List;

import com.nutrisoft.model.Pessoa;

public interface PessoaDAO {
	
	void salvar(Pessoa Pessoa);
	
	void excluir(Pessoa Pessoa);
	
	void alterar(Pessoa Pessoa);
	
	Pessoa obterPorId(Integer id);
	
	List<Pessoa> obterTodos();	
}