package com.nutrisoft.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nutrisoft.model.Nutricionista;
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
		//Quando se tenta fazer um merge em um objeto n�o gerenciado e h� um registro na tabela usuario e nutricionista ao mesmo tempo, ocorre uma WrongClassException. Ela n�o ocorre caso o objeto seja gerenciado.
		Usuario usuarioBanco = this.usuarioDAO.obterPorId(usuario.getIdPessoa());
		BeanUtils.copyProperties(usuario, usuarioBanco);
		this.usuarioDAO.alterar(usuarioBanco);
	}

	@Override
	public Usuario getUsuarioById(int id) {
		return this.usuarioDAO.obterPorId(id);
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
	public Nutricionista getNutricionistaByLogin(String login) {
		try {
			return this.usuarioDAO.getNutricionistaByLogin(login);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void removeUsuario(int id) {
		Usuario usuario = usuarioDAO.obterPorId(id);
		this.usuarioDAO.excluir(usuario);
	}

	@Override
	public List<Usuario> listUsuarios() {
		return this.usuarioDAO.obterTodos();
	}	
}