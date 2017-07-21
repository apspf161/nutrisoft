package com.nutrisoft.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.nutrisoft.model.Agendamento;
import com.nutrisoft.model.Agendamento_;
import com.nutrisoft.model.Cliente;
import com.nutrisoft.model.Consulta;
import com.nutrisoft.model.Consulta_;
import com.nutrisoft.repository.ConsultaDAO;
import com.nutrisoft.repository.RepositorioGenericoDados;

@Repository
public class ConsultaDAOImpl extends RepositorioGenericoDados<Consulta, Integer> implements ConsultaDAO {

	public ConsultaDAOImpl() {
		super(Consulta.class);
	}

	@Override
	public void salvar(Consulta consulta){
		super.salvar(consulta);
	}

	@Override
	public void excluir(Consulta consulta){
		super.excluir(consulta);
	}

	@Override
	public void alterar(Consulta consulta){
		super.alterar(consulta);
	}

	@Override
	public List<Consulta> obterTodasAsConsultas() {
		return this.obterTodos();
	}

	@Override
	public Consulta obterPorIdConsulta(Integer id) {
		return this.obterPorId(id);
	}


	@Override
	public List<Consulta> filtrarPagamentos(Consulta consulta) {
		
		CriteriaBuilder criteriaBuilder = this.getGerenciadorDeEntidade().getCriteriaBuilder();
		CriteriaQuery<Consulta> criteriaQuery = criteriaBuilder.createQuery(Consulta.class);
		Root<Consulta> from = criteriaQuery.from(Consulta.class);

		List<Predicate> condicoes = new ArrayList<Predicate>();

		from.fetch("agendamento").fetch("cliente");

		if(consulta.getAgendamento().getCliente().getNome() != null)
		{
			condicoes.add(criteriaBuilder.like(from.get("agendamento").get("cliente").get("nome"), "%"+consulta.getAgendamento().getCliente().getNome()+"%"));
		}

		if(consulta.getAgendamento().getCliente().getCpf() != null)
		{
			condicoes.add(criteriaBuilder.like(from.get("agendamento").get("cliente").get("cpf"), "%"+consulta.getAgendamento().getCliente().getCpf()+"%"));
		}

		condicoes.add(criteriaBuilder.equal(from.get("pago"),  consulta.getPago()));
		
		criteriaQuery.select(from).where(condicoes.toArray(new Predicate[]{}));
		return this.obterPorRestricao(criteriaQuery);
	}

}