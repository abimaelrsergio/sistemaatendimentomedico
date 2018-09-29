package br.com.fiap.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.model.entity.Tratamento;

/**
 * Esta classe é utilizada como acesso ao banco de dados, especifícamente a
 * tabela Tratamento.<br>
 * <br>
 * <b>Características desta classe:</b>
 * <p>
 * - Recebe um EntityManager por injeção de dependência. - O entity manager é
 * aberto e fechado pelo CDI. - As transações são gerenciadas pelo CDI.
 * 
 * @see {@linkplain} br.com.fiap.util.JPAUtil
 * 
 *      </p>
 * @author Abimael
 * 
 */
public class TratamentoDAO extends DAOGenerico<Tratamento> {
	
	// método utilizado para fazer testes, somente isso.
	public void setEntityManager(EntityManager em){
		this.em = em;
	}

	public Tratamento buscarTratamentosPorNome(String nome) {
		TypedQuery<Tratamento> query = em.createQuery(
				"from Tratamento c where c.nomeTratamento= :pNome", Tratamento.class);
		query.setParameter("pNome", nome);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Tratamento> autoCompletar(String nome) {
		TypedQuery<Tratamento> query = em.createQuery(
				"from Tratamento c where c.nomeTratamento like :pNome", Tratamento.class);
		query.setParameter("pNome", nome + "%");
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
}
