package com.nutrisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nutrisoft.model.Usuario;
import com.nutrisoft.repository.UsuarioDAO;

@Service
@Transactional(propagation=Propagation.NOT_SUPPORTED)
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	@Transactional
	public void addUsuario(Usuario usuario) {
		
		this.usuarioDAO.salvar(usuario);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateUsuario(Usuario usuario) {
		this.usuarioDAO.alterar(usuario);
	}

	@Override
	public Usuario getUsuarioById(int id) {
		return this.usuarioDAO.obterPorIdUsuario(id);
	}
	
	@Override
	public Usuario getUsuarioByLoginSenha(String login, String senha) {
		try {
			return this.usuarioDAO.getUsuarioByLoginSenha(login, senha);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void removeUsuario(int id) {
		Usuario usuario = usuarioDAO.obterPorIdUsuario(id);
		this.usuarioDAO.excluir(usuario);
	}

	@Override
	public List<Usuario> listUsuarios() {
		return this.usuarioDAO.obterTodosOsUsuarios();
	}	
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}


	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
}