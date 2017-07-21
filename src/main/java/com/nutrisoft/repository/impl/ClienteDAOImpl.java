package com.nutrisoft.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nutrisoft.model.Cliente;
import com.nutrisoft.repository.ClienteDAO;
import com.nutrisoft.repository.RepositorioGenericoDados;

@Repository
public class ClienteDAOImpl extends RepositorioGenericoDados<Cliente, Integer> implements ClienteDAO {
	
	public ClienteDAOImpl() {
		super(Cliente.class);
	}

	@Override
	public void salvar(Cliente cliente){
		super.salvar(cliente);
	}

	@Override
	public void excluir(Cliente cliente){
		super.excluir(cliente);
	}

	@Override
	public void alterar(Cliente cliente){
		super.alterar(cliente);
	}

	@Override
	public List<Cliente> obterTodosOsClientes() {
		return this.obterTodos();
	}

	@Override
	public Cliente obterPorIdCliente(Integer id) {
		return this.obterPorId(id);
	}

	@Override
	public List<Cliente> filtrarClientes(Cliente cliente) {
		Map<String, Object> mapeamentoAtributos = new HashMap<String, Object>();

		if(cliente.getNome() != null)
		{
			mapeamentoAtributos.put("nome", cliente.getNome());
		}
		
		if(cliente.getCpf() != null)
		{
			mapeamentoAtributos.put("cpf", cliente.getCpf());
		}
		
		List<Cliente> listaClientes = this.obterPorCriteriosLike(mapeamentoAtributos);
		return listaClientes;
	}
	
	
}