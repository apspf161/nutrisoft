package com.nutrisoft.repository;

import java.util.List;

import com.nutrisoft.model.Cliente;

public interface ClienteDAO {

	void salvar(Cliente cliente);
	
	void excluir(Cliente cliente);
	
	void alterar(Cliente cliente);
	
	Cliente obterPorId(Integer id);
	
	List<Cliente> obterTodos();

	List<Cliente> filtrarClientes(Cliente cliente);
}