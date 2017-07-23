package com.nutrisoft.repository.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.nutrisoft.model.Cliente;
import com.nutrisoft.model.Consulta;
import com.nutrisoft.model.enums.StatusAgendamentoEnum;
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
	public List<Consulta> listarConsultasAnteriores(Cliente cliente) {
		TypedQuery<Consulta> query = getGerenciadorDeEntidade().createQuery("select c from Consulta c where c.agendamento.cliente.idPessoa = :idCliente and c.agendamento.statusAgendamento = :stAgendamentoRealizado order by dataAgendamento", Consulta.class);
		query.setParameter("idCliente", cliente.getIdPessoa());
		query.setParameter("stAgendamentoRealizado", StatusAgendamentoEnum.REALIZADO);
	    return query.getResultList();
	}
}