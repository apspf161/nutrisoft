package com.nutrisoft.repository.impl;

import java.text.SimpleDateFormat;
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
		/*		Map<String, Object> mapeamentoAtributos = new HashMap<String, Object>();

		if(agendamento.getCliente().getNome() != null)
		{
			mapeamentoAtributos.put("nome", agendamento.getCliente().getNome());
		}
		
		if(agendamento.getCliente().getNome() != null)
		{
			mapeamentoAtributos.put("nome", agendamento.getCliente().getNome());
		}*/
		/*
		if(agendamento.getDataAgendamento() != null)
		{
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			//SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
			String ds2 = sdf1.format(agendamento.getDataAgendamento());
			System.out.println(ds2); //will be 30/06/2007
			
			mapeamentoAtributos.put("date(dataAgendamento)", ds2);
		}*/

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String data = sdf1.format(agendamento.getDataAgendamento());
				
		String sql = "SELECT agendamento ";
		sql += "FROM Agendamento agendamento \n";
		sql += "WHERE date(dataAgendamento) = '"+data+"' \n";
		sql += "AND stAgendamento = '"+StatusAgendamentoEnum.MARCADO+"'  \n";
		sql += "ORDER BY dataAgendamento";
		
	    TypedQuery<Agendamento> query = getGerenciadorDeEntidade().createQuery(sql, Agendamento.class);
	    return query.getResultList();
	}
	
	@Override
	public Agendamento obterPorIdAgendamento(Integer id) {
		return this.obterPorId(id);
	}
		
	@Override
	public List<Agendamento> listarAgendamentosDeHoje() {
		TypedQuery<Agendamento> query = getGerenciadorDeEntidade().createQuery("select a from Agendamento a where date(a.dataAgendamento) = date(current_date) and a.stAgendamento = :stAgendamentoConfirmado order by a.dataAgendamento", Agendamento.class);
		query.setParameter("stAgendamentoConfirmado", StatusAgendamentoEnum.CONFIRMADO);
		return query.getResultList();
	}
	
	@Override
	public Agendamento getAgendamentoById(int id) {
		return this.obterPorId(id);
	}

	@Override
	public List<Agendamento> listarRelatorioAgendamento(Agendamento agendamento) {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "", sqlCondicao = "";
				
		sql += "SELECT agendamento ";
		sql += "FROM Agendamento agendamento \n";
		sql += "WHERE ";

		if(agendamento.getNutricionista().getIdPessoa() != 0)
		{
			sqlCondicao += "agendamento.nutricionista.idPessoa = '"+ agendamento.getNutricionista().getIdPessoa()+"'  \n";	
		}
		
		if(agendamento.getDataPeriodoFinal() != null)
		{
			String dataInicio = sdf1.format(agendamento.getDataPeriodoInicial());
			String dataFim = sdf1.format(agendamento.getDataPeriodoFinal());
			
			if(sqlCondicao.length() != 0)
			{
				sqlCondicao += "AND ";	
			}
			
			sqlCondicao += "date(agendamento.dataAgendamento) BETWEEN '"+dataInicio+"' AND '"+dataFim+"' \n";
		}
		
		if(agendamento.getTurnoAgendamento() != null)
		{
			if(sqlCondicao.length() != 0)
			{
				sqlCondicao += "AND ";	
			}
			
			switch (agendamento.getTurnoAgendamento()) {
			case "M":
				sqlCondicao += "date_format(dataAgendamento,'%H') >= '05' and date_format(dataAgendamento,'%H') <= '11' \n";
				break;
			case "T":
				sqlCondicao += "date_format(dataAgendamento,'%H') >= 12 and date_format(dataAgendamento,'%H') <= 17 \n";
				break;
			case "N":
				sqlCondicao += "date_format(dataAgendamento,'%H') >= 18 and date_format(dataAgendamento,'%H') <= 23 \n";
				break;
			default:
				sqlCondicao += " \n";
				break;
			}
		}

		sql += sqlCondicao;
		sql += " ORDER BY dataAgendamento";
		
	    TypedQuery<Agendamento> query = getGerenciadorDeEntidade().createQuery(sql, Agendamento.class);
	    return query.getResultList();
	}
}