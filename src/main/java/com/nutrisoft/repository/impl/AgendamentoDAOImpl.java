package com.nutrisoft.repository.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.nutrisoft.model.Agendamento;
import com.nutrisoft.model.Cliente;
import com.nutrisoft.model.Nutricionista;
import com.nutrisoft.model.enums.StatusAgendamentoEnum;
import com.nutrisoft.repository.AgendamentoDAO;
import com.nutrisoft.repository.RepositorioGenericoDados;

@Repository
public class AgendamentoDAOImpl extends RepositorioGenericoDados<Agendamento, Integer> implements AgendamentoDAO {

	public AgendamentoDAOImpl() {
		super(Agendamento.class);
	}

	@Override
	public List<Agendamento> filtrarAgendamentos(Agendamento agendamento) {
		TypedQuery<Agendamento> query = getGerenciadorDeEntidade().createQuery("select a from Agendamento a where date(a.dataAgendamento) = :dataSelecionada and a.stAgendamento = :stAgendamentoMarcado order by a.dataAgendamento", Agendamento.class);
		query.setParameter("dataSelecionada", agendamento.getDataAgendamento(), TemporalType.DATE);
		
		query.setParameter("stAgendamentoMarcado", agendamento.getStAgendamento());
		
		return query.getResultList();
	}

	@Override
	public List<Agendamento> filtrarListaAgendamentosExistentes(Agendamento agendamento) {
		TypedQuery<Agendamento> query = getGerenciadorDeEntidade().createQuery("select a from Agendamento a where date(a.dataAgendamento) = :dataSelecionada order by a.dataAgendamento", Agendamento.class);
		query.setParameter("dataSelecionada", agendamento.getDataAgendamento(), TemporalType.DATE);
		return query.getResultList();
	}	
	

	@Override
	public Agendamento obterPorIdAgendamento(Integer id) {
		return this.obterPorId(id);
	}

	@Override
	public List<Agendamento> listarAgendamentosNutricionistaDeHoje(Nutricionista nutricionista) {
		TypedQuery<Agendamento> query = getGerenciadorDeEntidade().createQuery("select a from Agendamento a where date(a.dataAgendamento) = date(current_date) and a.stAgendamento = :stAgendamentoConfirmado and a.nutricionista = :nutricionista order by a.dataAgendamento", Agendamento.class);
		query.setParameter("stAgendamentoConfirmado", StatusAgendamentoEnum.CONFIRMADO);
		query.setParameter("nutricionista", nutricionista);
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

	@Override
	public List<Cliente> listarClienteRelatorioEvolucao(Agendamento agendamento) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "", sqlCondicao = "";

		sql += "SELECT distinct agendamento.cliente ";
		sql += "FROM Agendamento agendamento \n";
		sql += "WHERE ";

		if(agendamento.getCliente().getNome() != null)
		{
			sqlCondicao += "agendamento.cliente.nome like '%"+ agendamento.getCliente().getNome()+" %'  \n";	
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

		sql += sqlCondicao;
		sql += " ORDER BY dataAgendamento";

		TypedQuery<Cliente> query = getGerenciadorDeEntidade().createQuery(sql, Cliente.class);
		return query.getResultList();
	}
}