package com.nutrisoft.repository.impl;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.nutrisoft.model.Pessoa;
import com.nutrisoft.repository.PessoaDAO;
import com.nutrisoft.repository.RepositorioGenericoDados;

@Repository
public class PessoaDAOImpl extends RepositorioGenericoDados<Pessoa, Integer> implements PessoaDAO {
				
	public PessoaDAOImpl() {
		super(Pessoa.class);
	}
	
	@Override
	public void salvar(Pessoa Pessoa){
		super.salvar(Pessoa);
	}
	
	@Override
	public void excluir(Pessoa Pessoa){
		super.excluir(Pessoa);
	}
	
	@Override
	public void alterar(Pessoa Pessoa){
		super.alterar(Pessoa);
	}
	
	@Override
	public List<Pessoa> obterTodasAsPessoas(){
		return this.obterTodos();
	}
	
	@Override
	public Pessoa obterPorId(Integer id) {
		return obterPorId(id);
	}
}
