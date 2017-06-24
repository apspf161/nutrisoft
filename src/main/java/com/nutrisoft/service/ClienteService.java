package com.nutrisoft.service;

import java.util.List;

import com.nutrisoft.model.Cliente;

public interface ClienteService {
	
	void addCliente(Cliente cliente);

	void updateCliente(Cliente cliente);
	
	void removeCliente(int id);
	
	List<Cliente> listClientes();
	
	Cliente getClienteById(int id);
}