package com.nutrisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nutrisoft.model.Cliente;
import com.nutrisoft.repository.ClienteDAO;

@Service
@Transactional(propagation=Propagation.NOT_SUPPORTED)
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addCliente(Cliente cliente) {
		this.clienteDAO.salvar(cliente);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateCliente(Cliente cliente) {
		this.clienteDAO.alterar(cliente);
	}

	@Override
	public Cliente getClienteById(int id) {
		return this.clienteDAO.obterPorIdCliente(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void removeCliente(int id) {
		Cliente cliente = clienteDAO.obterPorIdCliente(id);
		this.clienteDAO.excluir(cliente);
	}

	@Override
	public List<Cliente> listClientes() {
		return this.clienteDAO.obterTodosOsClientes();
	}
	
	@Override
	public List<Cliente> filtrarListaCliente(Cliente cliente) {
		return this.clienteDAO.filtrarClientes(cliente);
	}	
}