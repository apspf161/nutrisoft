package com.nutrisoft.service;

import java.util.List;

import com.nutrisoft.model.Usuario;

public interface UsuarioService {
	void addUsuario(Usuario u);

	void updateUsuario(Usuario u);
	
	void removeUsuario(int id);
	
	List<Usuario> listUsuarios();
	
	Usuario getUsuarioById(int id);
	
	Usuario getUsuarioByLoginSenha(String login, String senha);
}