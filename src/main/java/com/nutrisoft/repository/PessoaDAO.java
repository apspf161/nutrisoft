package com.nutrisoft.repository;

import java.util.List;

import com.nutrisoft.model.Pessoa;

public interface PessoaDAO {
	public void addPessoa(Pessoa u);
	public void updatePessoa(Pessoa u);
	public List<Pessoa> listPessoas();
	public Pessoa getPessoaById(int id);
	public void removePessoa(int id);
}