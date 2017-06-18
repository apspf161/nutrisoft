package com.nutrisoft.repository;

import java.util.List;

import com.nutrisoft.model.Usuario;

public interface UsuarioDAO {
		
	void salvar(Usuario usuario);
	
	void excluir(Usuario usuario);
	
	void alterar(Usuario usuario);
	
	Usuario obterPorIdUsuario(Integer id);
	
	List<Usuario> obterTodosOsUsuarios();
	
	Usuario getUsuarioByLoginSenha(String login, String senha);
	
}