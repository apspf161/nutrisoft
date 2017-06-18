package com.nutrisoft.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.nutrisoft.model.Usuario;
import com.nutrisoft.repository.RepositorioGenericoDados;
import com.nutrisoft.repository.UsuarioDAO;

@Repository
public class UsuarioDAOImpl extends RepositorioGenericoDados<Usuario, Integer> implements UsuarioDAO {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UsuarioDAOImpl() {
		super(Usuario.class);
	}

	@Override
	public void salvar(Usuario usuario){
		super.salvar(usuario);
	}

	@Override
	public void excluir(Usuario usuario){
		super.excluir(usuario);
	}

	@Override
	public void alterar(Usuario usuario){
		super.alterar(usuario);
	}

	@Override
	public List<Usuario> obterTodosOsUsuarios() {
		return this.obterTodos();
	}

	@Override
	public Usuario obterPorIdUsuario(Integer id) {
		return this.obterPorId(id);
	}


	@Override
	public Usuario getUsuarioByLoginSenha(String login, String senha) {
		//try{
			Map<String, Object> mapeamentoAtributos = new HashMap<String, Object>();
			mapeamentoAtributos.put("login", login);
			mapeamentoAtributos.put("senha", senha);

			return this.obterUnicoPorCriterios(mapeamentoAtributos);
	/*	} catch(Exception e)
		{

		}*/
	}
}