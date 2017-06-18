/**
	 * Furnas Centrais Elétricas S.A
	 * Divisão de Suporte ao Desenvolvimento de Sistemas de Informação
	 * Copyright (c) 2014 Todos os direitos reservados à Eletrobras Furnas S.A.
	 * 
	 * @author Wilson Fernandes 
	 * @since 12/01/2017
	 * @version 1.0
	 */

package com.nutrisoft.repository.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 * IRepositorioGenericoDados.java
 * 
 * Furnas Centrais Elétricas S.A
 * Divisão de Suporte ao Desenvolvimento de Sistemas de Informação
 * Copyright (c) 2014 Todos os direitos reservados à Eletrobras Furnas S.A.
 * 
 * Representa o repositório genérico.
 * 
 * @param <T> Tipo da classe.
 * @param <TipoId> Tipo do id da classe.
 * 
 * @author PrimeUp
 * 
 * 25/11/2014
 */
public interface RepositorioGenericoDadosImpl<T, TipoId> {
	
	/**
	 * Persiste uma entidade no banco de dados.
	 * 
	 * @param entidade a ser persistida.
	 * @return 
	 */
	void salvar(T entidade);

	/**
	 * Exclui uma entidade do banco de dados.
	 * 
	 * @param entidade a ser excluida.
	 */
	void excluir(T entidade);

	/**
	 * Altera uma entidade já existente do banco de dados.
	 * 
	 * @param entidade a ser alterada.
	 */
	void alterar(T entidade);

	/**
	 * Obtém todas as entidades persistidas no banco de dados, e ao mesmo tempo, carrega os relacionamentos 
	 * para evitar o problema de lazy load.
	 * 
	 * @param relacionamentos - nomes dos atributos da classe dos quais desejam-se carregas os relacionamentos de 
	 * modo EAGER.
	 * @return
	 */
	List<T> obterTodosComRelacionamentos(String... relacionamentos);

	/**
	 * Obtém uma instância da entidade, buscada do banco de dados a partir de
	 * sua chave primária, e ao mesmo tempo, carrega os relacionamentos para evitar o problema de lazy load.
	 * 
	 * @param id - valor da chave da tabela
	 * @param relacionamentos - nomes dos atributos da classe dos quais desejam-se carregas os relacionamentos de 
	 * modo EAGER.
	 * @return instância da entidade 
	 */
	T obterPorIdComRelacionamentos(TipoId id, String... relacionamentos);
	
	/**
	 * Obtém uma lista com as instâncias da entidade que tem relacionamento com uma entidade
	 * que tem um atributo com o mesmo valor.
	 * @param nomeAtributo - nome do atributo da entidade relacionada
	 * @param parametros - valor do atributo da entidade relacionada
	 * @param relacionamento - nome do atributo na entidade T que referencia a entidade relacionada
	 * @return Uma lista com instâncias de T
	 */
	List<T> obterComRelacionamentoPor(String nomeAtributo, Object parametros, String relacionamento);
	
	/**
	 * Obtém uma lista com as instâncias da entidade que tem relacionamento com uma entidade
	 * que tem um ou mais atributos com o mesmo valor.
	 * @param parametros - mapeamento do nome do atributo da entidade relacionada e do seu valor
	 * @param relacionamentos - nome do atributo na entidade T que referencia a entidade relacionada
	 * @return Uma lista com instâncias de T
	 */
	List<T> obterComRelacionamentosPor(Map<String, Object> parametros, String... relacionamentos);
	
	/***
	 * Busca um objeto do tipo T usando os criterios recebidos como parâmetro. <br>
	 * Critérios são compostos por: 
	 * <ol> 
	 * 	<li>Nome do atributo da entidade a ser utilizado como critério</li>
	 *  <li>Valor do atributo da entidade a ser utilizado como filtro na busca</li>
	 * </ol>
	 * @param atributos - mapeamento do nome do atributo da entidade a ser utilizado como critério e o seu valor. 
	 * @return conjunto de objetos que satisfazem a busca com o filtro utilizado.
	 */
	List<T> obterPorCriterios(Map<String, Object> atributos);
	
	/**
	 * Obtém uma entidade segundo um critério de consulta.
	 * 
	 * @param consulta Critério de consulta.
	 * @return Entidade que obedece o critério de consulta.
	 */
	T obterUnicoPorRestricao(CriteriaQuery<T> consulta);
	
	/**
	 * Limpa todas as instâncias de uma determinada classe do cache de segundo
	 * nível.
	 * 
	 * @param type - classe mapeada no cache.
	 */
	void limparTodoCacheDe();

	/**
	 * Limpa a instância de uma determinada classe do cache de segundo nível a
	 * partir de sua chave de identificação.
	 * 
	 * @param type - classe mapeada no cache.
	 * @param chace - chave da instância a ser excluída do cache.
	 */
	void limparInstanciaDoCache(Object chave);
	
	/**
	 * Obtem o gerenciador de entidades, caso seja necessário a um repositório
	 * utilizar funções não existentes no repositório genérico.
	 * 
	 * @return EntityManager.
	 */
	EntityManager getGerenciadorDeEntidade();

	

	
}
