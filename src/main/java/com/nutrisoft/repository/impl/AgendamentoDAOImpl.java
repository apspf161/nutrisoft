package com.nutrisoft.repository.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.nutrisoft.model.Agendamento;
import com.nutrisoft.model.enums.StatusAgendamentoEnum;
import com.nutrisoft.repository.AgendamentoDAO;
import com.nutrisoft.repository.RepositorioGenericoDados;

@Repository
public class AgendamentoDAOImpl extends RepositorioGenericoDados<Agendamento, Integer> implements AgendamentoDAO {
	
	public AgendamentoDAOImpl() {
		super(Agendamento.class);
	}
	
	@Override
	public List<Agendamento> listarAgendamentosDeHoje() {
		TypedQuery<Agendamento> query = getGerenciadorDeEntidade().createQuery("select a from Agendamento a where date(dataAgendamento) = date(current_date) and stAgendamento = :stAgendamentoConfirmado order by dataAgendamento", Agendamento.class);
		query.setParameter("stAgendamentoConfirmado", StatusAgendamentoEnum.CONFIRMADO.toString());
		return query.getResultList();
	}

	@Override
	public Agendamento getAgendamentoById(int id) {
		return this.obterPorId(id);
	}
	
	@Override
	public void salvar(Agendamento agendamento) {
		super.salvar(agendamento);
	}
}