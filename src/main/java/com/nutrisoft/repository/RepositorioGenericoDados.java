package com.nutrisoft.repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.nutrisoft.repository.impl.RepositorioGenericoDadosImpl;

@Repository
public abstract class RepositorioGenericoDados<T, TipoId> implements RepositorioGenericoDadosImpl<T, TipoId> {

	@PersistenceContext
	private EntityManager gerenciadorDeEntidade;
	private Class<T> clazz;

	public RepositorioGenericoDados(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void salvar(T entidade) {
		this.gerenciadorDeEntidade.persist(entidade);
	}

	public void excluir(T entidade) {

		if (gerenciadorDeEntidade.contains(entidade)) {
			this.gerenciadorDeEntidade.remove(entidade);
		} else {

			entidade = this.gerenciadorDeEntidade.merge(entidade);  
			this.gerenciadorDeEntidade.remove(entidade);  
		}
	}

	public void alterar(T entidade) {
		this.gerenciadorDeEntidade.merge(entidade);
	}

	public List<T> obterTodos() {

		CriteriaBuilder criteriaBuilder = this.gerenciadorDeEntidade.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
		Root<T> raiz = criteriaQuery.from(clazz);

		CriteriaQuery<T> registros = criteriaQuery.select(raiz);
		TypedQuery<T> queryDeTodosOsRegistros = this.gerenciadorDeEntidade.createQuery(registros);

		return queryDeTodosOsRegistros.getResultList();
	}

	public T obterPorId(Integer id) {
		return this.gerenciadorDeEntidade.find(clazz, id);
	}
	
	public T obterPorId(String id) {
		return this.gerenciadorDeEntidade.find(clazz, id);
	}

	public List<T> obterTodosComRelacionamentos(String... relacionamentos) {

		CriteriaBuilder construtorDeQuery = this.gerenciadorDeEntidade.getCriteriaBuilder();
		CriteriaQuery<T> query = construtorDeQuery.createQuery(clazz);

		Root<T> entidade = query.from(clazz);

		for (String entidadeRelacionada : relacionamentos) {
			entidade.fetch(entidadeRelacionada);
		}

		return this.gerenciadorDeEntidade.createQuery(query.select(entidade)).getResultList();
	}

	public T obterPorIdComRelacionamentos(TipoId id, String... relacionamentos) {

		CriteriaBuilder construtorDeQuery = this.gerenciadorDeEntidade.getCriteriaBuilder();
		CriteriaQuery<T> query = construtorDeQuery.createQuery(clazz);

		Root<T> entidade = query.from(clazz);

		for (String entidadeRelacionada : relacionamentos) {
			entidade.fetch(entidadeRelacionada);
		}

		Predicate condition = construtorDeQuery.equal(entidade.get(getNomeDaChavePrimaria()), id);
		query.where(condition);

		return this.gerenciadorDeEntidade.createQuery(query.select(entidade)).getSingleResult();
	}

	@SuppressWarnings("unused")
	public List<T> obterComRelacionamentosPor(Map<String, Object> parametros, String... relacionamentos) {

		CriteriaBuilder construtorDeQuery = this.gerenciadorDeEntidade.getCriteriaBuilder();
		CriteriaQuery<T> query = construtorDeQuery.createQuery(clazz);

		Root<T> entidade = query.from(clazz);

		Map<String, Path<Object>> path = new HashMap<String, Path<Object>>();

		Set<String> chaves = parametros.keySet();

		for (String entidadeRelacionada : relacionamentos) {
			for (String chaveDoParametro : chaves) {
				path.put(chaveDoParametro, entidade.join(entidadeRelacionada).get(chaveDoParametro)) ;
			}
			entidade.fetch(entidadeRelacionada);
		}

		List<Predicate> condicoes = new ArrayList<Predicate>(chaves.size());
		for (String entidadeRelacionada : relacionamentos) {
			for (String chaveDoParametro : chaves) {

				condicoes.add(construtorDeQuery.equal(path.get(chaveDoParametro), parametros.get(chaveDoParametro)));
			}
		}

		query.where(condicoes.toArray(new Predicate[]{}));
		return this.gerenciadorDeEntidade.createQuery(query.select(entidade)).getResultList();
	}

	public List<T> obterComRelacionamentoPor(String nomeAtributo, Object parametros, String relacionamento){

		CriteriaBuilder criteriaBuilder = gerenciadorDeEntidade.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
		Root<T> from = criteriaQuery.from(clazz);
		Path<Object> path = from.join(relacionamento).get(nomeAtributo);

		from.fetch(relacionamento); 

		CriteriaQuery<T> select = criteriaQuery.select(from);
		select.where(criteriaBuilder.equal(path, parametros));

		TypedQuery<T> typedQuery = gerenciadorDeEntidade.createQuery(select);
		List<T> resultList = typedQuery.getResultList();

		return resultList;
	}

	public List<T> obterListaComRelacionamento(Map<String, Object> atributos, String relacionamento){

		CriteriaBuilder criteriaBuilder = gerenciadorDeEntidade.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
		Root<T> from = criteriaQuery.from(clazz);
		from.fetch(relacionamento); 

		List<Predicate> condicoes = new ArrayList<Predicate>();

		for(String nome : atributos.keySet()){
			condicoes.add(criteriaBuilder.like(from.get(relacionamento).get(nome), "%"+atributos.get(nome)+"%"));
		}

		criteriaQuery.select(from).where(condicoes.toArray(new Predicate[]{}));
		return obterPorRestricao(criteriaQuery);
	}
	
	public List<T> obterPorCriterios(Map<String, Object> atributos) {

		CriteriaBuilder criteriaBuilder = obterCriadorDeBuscaPorCriterio();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
		Root<T> from = criteriaQuery.from(clazz);

		List<Predicate> condicoes = new ArrayList<Predicate>();

		for(String nome : atributos.keySet()){
			condicoes.add(criteriaBuilder.equal(from.get(nome), atributos.get(nome)));
		}

		criteriaQuery.select(from).where(condicoes.toArray(new Predicate[]{}));
		return obterPorRestricao(criteriaQuery);
	}


	public T obterUnicoPorCriterios(Map<String, Object> atributos) {

		CriteriaBuilder criteriaBuilder = obterCriadorDeBuscaPorCriterio();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
		Root<T> from = criteriaQuery.from(clazz);

		List<Predicate> condicoes = new ArrayList<Predicate>();

		for(String nome : atributos.keySet()){

			if(("null").equals(atributos.get(nome)))
				condicoes.add(criteriaBuilder.isNull(from.get(nome)));
			else if(("!null").equals(atributos.get(nome)))
				condicoes.add(criteriaBuilder.isNotNull(from.get(nome)));
			else 
				condicoes.add(criteriaBuilder.equal(from.get(nome), atributos.get(nome)));
		}

		criteriaQuery.select(from).where(condicoes.toArray(new Predicate[]{}));
		return obterUnicoPorRestricao(criteriaQuery);
	}


	public List<T> obterPorCriteriosLike(Map<String, Object> atributos) {
		CriteriaBuilder criteriaBuilder = obterCriadorDeBuscaPorCriterio();
		CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);

		Root<T> estruturaRaiz = query.from(clazz);

		List<Predicate> condicoes = new ArrayList<Predicate>();

		for(String nome : atributos.keySet()){
			condicoes.add(criteriaBuilder.like(criteriaBuilder.upper(estruturaRaiz.<String>get(nome)), "%"+atributos.get(nome)+"%"));

		}
		query.select(estruturaRaiz).where(condicoes.toArray(new Predicate[]{}));
		return obterPorRestricao(query);
	}

	public List<T> obterPorCriteriosLikeOrEquals(Map<String, Object> atributos) {
		CriteriaBuilder criteriaBuilder = obterCriadorDeBuscaPorCriterio();
		CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);

		Root<T> estruturaRaiz = query.from(clazz);

		List<Predicate> condicoes = new ArrayList<Predicate>();

		for(String nome : atributos.keySet()){
			Object atributo = atributos.get(nome);


			if(atributo.toString().contains("%"))
			{
				condicoes.add(criteriaBuilder.like(criteriaBuilder.upper(estruturaRaiz.<String>get(nome)), atributos.get(nome)+""));
			}

			else
			{
				condicoes.add(criteriaBuilder.equal(estruturaRaiz.get(nome), atributos.get(nome)));
			}
		}

		query.select(estruturaRaiz).where(condicoes.toArray(new Predicate[]{}));
		return obterPorRestricao(query);
	}

	public T obterUnicoPorRestricao(CriteriaQuery<T> consulta) {
		return this.gerenciadorDeEntidade.createQuery(consulta).getSingleResult();
	}

	private CriteriaBuilder obterCriadorDeBuscaPorCriterio() {
		return this.gerenciadorDeEntidade.getCriteriaBuilder();
	}

	public List<T> obterPorRestricao(CriteriaQuery<T> consulta) {
		return this.gerenciadorDeEntidade.createQuery(consulta).getResultList();
	}

	private String getNomeDaChavePrimaria(){
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			if(field.getAnnotation(Id.class) != null || field.getAnnotation(EmbeddedId.class) != null)
				return field.getName();
		}

		return "id";
	}

	public void limparTodoCacheDe() {
		this.gerenciadorDeEntidade.getEntityManagerFactory().getCache().evict(clazz);
	}

	public void limparInstanciaDoCache(Object chave) {
		this.gerenciadorDeEntidade.getEntityManagerFactory().getCache().evict(clazz, chave);
	}

	public EntityManager getGerenciadorDeEntidade() {
		return gerenciadorDeEntidade;
	}
}
