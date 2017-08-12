package com.nutrisoft.repository;

import java.util.List;

import com.nutrisoft.model.Nutricionista;
import com.nutrisoft.model.Usuario;

public interface UsuarioDAO {
		
	void salvar(Usuario usuario);
	
	void excluir(Usuario usuario);
	
	void alterar(Usuario usuario);
	
	Usuario obterPorId(Integer id);
	
	List<Usuario> obterTodos();
	
	Usuario getUsuarioByLoginSenha(String login, String senha);
	
	Nutricionista getNutricionistaByLogin(String login);
}