package com.nutrisoft.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nutrisoft.model.Pessoa;

@Repository
public class PessoaDAOImpl implements PessoaDAO {

	@Autowired
	private DataSource dataSource;
	
	public void addPessoa(Pessoa pessoa) {
	}

	public void updatePessoa(Pessoa pessoa) {
	}

	public List<Pessoa> listPessoas() {
		return null;
	}

	public Pessoa getPessoaById(int id) {
		return null;
	}

	public void removePessoa(int id) {
		
	}
}