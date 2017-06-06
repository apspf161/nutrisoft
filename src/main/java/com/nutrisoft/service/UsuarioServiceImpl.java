package com.nutrisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nutrisoft.model.Usuario;
import com.nutrisoft.repository.PessoaDAO;
import com.nutrisoft.repository.UsuarioDAO;

@Service
@Transactional(propagation=Propagation.NOT_SUPPORTED)
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private PessoaDAO pessoaDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addUsuario(Usuario usuario) {
		this.pessoaDAO.addPessoa(usuario);
		this.usuarioDAO.addUsuario(usuario);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateUsuario(Usuario usuario) {
		this.pessoaDAO.updatePessoa(usuario);
		this.usuarioDAO.updateUsuario(usuario);
	}

	@Override
	public List<Usuario> listUsuarios() {
		return this.usuarioDAO.listUsuarios();
	}

	@Override
	public Usuario getUsuarioById(int id) {
		return this.usuarioDAO.getUsuarioById(id);
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
		this.usuarioDAO.removeUsuario(id);
		this.pessoaDAO.removePessoa(id);
	}
}