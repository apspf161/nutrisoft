package com.nutrisoft.service;

import java.util.List;

import com.nutrisoft.model.Usuario;

public interface UsuarioService {
	public void addUsuario(Usuario u);
	public void updateUsuario(Usuario u);
	public List<Usuario> listUsuarios();
	public Usuario getUsuarioById(int id);
	public Usuario getUsuarioByLoginSenha(String login, String senha);
	public void removeUsuario(int id);
}