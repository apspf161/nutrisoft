package com.nutrisoft.repository.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

	@Override
	public List<Consulta> listarConsultasAnteriores(Cliente cliente) {
		TypedQuery<Consulta> query = getGerenciadorDeEntidade().createQuery("select c from Consulta c where c.agendamento.cliente.idPessoa = :idCliente and c.agendamento.stAgendamento = :stAgendamentoRealizado order by dataAgendamento", Consulta.class);
		query.setParameter("idCliente", cliente.getIdPessoa());
		query.setParameter("stAgendamentoRealizado", StatusAgendamentoEnum.REALIZADO);
	    return query.getResultList();
	}

	@Override
	public List<Consulta> listarRelatorioAtendimento(Consulta consulta) {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "", sqlCondicao = "";
		
		sql += "SELECT c ";
		sql += "FROM Consulta c \n";
		sql += "WHERE ";

		if(consulta.getAgendamento().getNutricionista().getIdPessoa() != 0)
		{
			sqlCondicao += "c.agendamento.nutricionista.idPessoa = '"+ consulta.getAgendamento().getNutricionista().getIdPessoa()+"'  \n";	
		}
		
		if(consulta.getAgendamento().getDataPeriodoFinal() != null)
		{
			String dataInicio = sdf1.format(consulta.getAgendamento().getDataPeriodoInicial());
			String dataFim = sdf1.format(consulta.getAgendamento().getDataPeriodoFinal());
			
			if(sqlCondicao.length() != 0)
			{
				sqlCondicao += "AND ";	
			}
			
			sqlCondicao += "date(c.agendamento.dataAgendamento) BETWEEN '"+dataInicio+"' AND '"+dataFim+"' \n";
		}
		
		sql += sqlCondicao;
		sql += "ORDER BY c.agendamento.dataAgendamento";
		
		TypedQuery<Consulta> query = getGerenciadorDeEntidade().createQuery(sql, Consulta.class);
		return query.getResultList();
	}

	@Override
	public List<Consulta> listarEvolucaoCliente(Consulta consulta) {
		
		String sql = "";
		
		sql += "SELECT c ";
		sql += "FROM Consulta c \n";
		sql += "WHERE ";

		if(consulta.getAgendamento().getCliente().getIdPessoa() != 0)
		{
			sql += "c.agendamento.cliente.idPessoa = "+ consulta.getAgendamento().getCliente().getIdPessoa()+"  \n";	
		}

		sql += "ORDER BY c.agendamento.dataAgendamento";
		
		TypedQuery<Consulta> query = getGerenciadorDeEntidade().createQuery(sql, Consulta.class);
		return query.getResultList();
	}
	
	@Override
	public List<Consulta> listarGraficoEvolucaoCliente(Cliente cliente) {
		
		String sql = "";
		
		sql += "SELECT c ";
		sql += "FROM Consulta c \n";
		sql += "WHERE ";
		sql += "c.agendamento.cliente.idPessoa= "+ cliente.getIdPessoa()+" \n";	
		sql += "ORDER BY c.agendamento.dataAgendamento";
		
		TypedQuery<Consulta> query = getGerenciadorDeEntidade().createQuery(sql, Consulta.class);
		return query.getResultList();
	}
}