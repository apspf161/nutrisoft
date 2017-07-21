package com.nutrisoft.repository.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nutrisoft.model.Agendamento;
import com.nutrisoft.repository.AgendamentoDAO;
import com.nutrisoft.repository.RepositorioGenericoDados;

@Repository
public class AgendamentoDAOImpl extends RepositorioGenericoDados<Agendamento, Integer> implements AgendamentoDAO {

	
	public AgendamentoDAOImpl() {
		super(Agendamento.class);
	}

	@Override
	public void salvar(Agendamento agendamento){
		super.salvar(agendamento);
	}

	@Override
	public void excluir(Agendamento agendamento){
		super.excluir(agendamento);
	}

	@Override
	public void alterar(Agendamento agendamento){
		super.alterar(agendamento);
	}

	@Override
	public List<Agendamento> obterTodosOsAgendamentos() {
		return this.obterTodos();
	}

	@Override
	public List<Agendamento> filtrarAgendamentos(Agendamento agendamento) {
		Map<String, Object> mapeamentoAtributos = new HashMap<String, Object>();

/*		if(agendamento.getCliente().getNome() != null)
		{
			mapeamentoAtributos.put("nome", agendamento.getCliente().getNome());
		}
		
		if(agendamento.getCliente().getNome() != null)
		{
			mapeamentoAtributos.put("nome", agendamento.getCliente().getNome());
		}*/
		
		if(agendamento.getDataAgendamento() != null)
		{
			mapeamentoAtributos.put("dataAgendamento", agendamento.getDataAgendamento());
		}

		return this.obterPorCriteriosLikeOrEquals(mapeamentoAtributos);
		/*return this.obterListaComRelacionamento(mapeamentoAtributos, "cliente");*/
	}
	
	@Override
	public Agendamento obterPorIdAgendamento(Integer id) {
		return this.obterPorId(id);
	}
}