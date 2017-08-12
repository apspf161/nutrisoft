package com.nutrisoft.repository.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.nutrisoft.model.Nutricionista;
import com.nutrisoft.model.Usuario;
import com.nutrisoft.repository.RepositorioGenericoDados;
import com.nutrisoft.repository.UsuarioDAO;

@Repository
public class UsuarioDAOImpl extends RepositorioGenericoDados<Usuario, Integer> implements UsuarioDAO {
	
	public UsuarioDAOImpl() {
		super(Usuario.class);
	}
	
	@Override
	public Usuario getUsuarioByLoginSenha(String login, String senha) {
		Map<String, Object> mapeamentoAtributos = new HashMap<String, Object>();
		mapeamentoAtributos.put("login", login);
		mapeamentoAtributos.put("senha", senha);
		return this.obterUnicoPorCriterios(mapeamentoAtributos);
	}
	
	@Override
	public Nutricionista getNutricionistaByLogin(String login) {
		TypedQuery<Nutricionista> query = getGerenciadorDeEntidade().createQuery("select n from Nutricionista n where n.login = :login", Nutricionista.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}
}