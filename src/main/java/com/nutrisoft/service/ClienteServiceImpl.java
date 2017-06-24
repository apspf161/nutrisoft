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
	private ClienteDAO usuarioDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addCliente(Cliente usuario) {
		this.usuarioDAO.salvar(usuario);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateCliente(Cliente usuario) {
		this.usuarioDAO.alterar(usuario);
	}

	@Override
	public Cliente getClienteById(int id) {
		return this.usuarioDAO.obterPorIdCliente(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void removeCliente(int id) {
		Cliente usuario = usuarioDAO.obterPorIdCliente(id);
		this.usuarioDAO.excluir(usuario);
	}

	@Override
	public List<Cliente> listClientes() {
		return this.usuarioDAO.obterTodosOsClientes();
	}	
}