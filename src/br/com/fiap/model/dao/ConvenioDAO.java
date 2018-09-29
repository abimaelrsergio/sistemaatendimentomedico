package br.com.fiap.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.model.entity.Convenio;

/**
 * Esta classe é utilizada como acesso ao banco de dados, especifícamente a
 * tabela Convenio.<br>
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
public class ConvenioDAO extends DAOGenerico<Convenio> {
	
	// método utilizado para fazer testes, somente isso.
	public void setEntityManager(EntityManager em){
		this.em = em;
	}

	public Convenio buscarConveniosPorNome(String nome) {
		TypedQuery<Convenio> query = em.createQuery(
				"from Convenio c where c.nomeConvenio= :pNome", Convenio.class);
		query.setParameter("pNome", nome);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Convenio> autoCompletar(String nome) {
		TypedQuery<Convenio> query = em.createQuery(
				"from Convenio c where c.nomeConvenio like :pNome", Convenio.class);
		query.setParameter("pNome", nome + "%");
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
}
