package com.nutrisoft.repository.impl;
import org.springframework.stereotype.Repository;

import com.nutrisoft.model.Pessoa;
import com.nutrisoft.repository.PessoaDAO;
import com.nutrisoft.repository.RepositorioGenericoDados;

@Repository
public class PessoaDAOImpl extends RepositorioGenericoDados<Pessoa, Integer> implements PessoaDAO {
				
	public PessoaDAOImpl() {
		super(Pessoa.class);
	}
}