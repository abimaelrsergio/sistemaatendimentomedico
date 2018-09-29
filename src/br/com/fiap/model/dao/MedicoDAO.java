package br.com.fiap.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.model.entity.Medico;

public class MedicoDAO extends DAOGenerico<Medico> {

	// método utilizado para fazer testes, somente isso.
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public Medico buscarMedicosPorNome(String nome) {
		TypedQuery<Medico> query = em.createQuery(
				"from Medico c where c.nomeMedico= :pNome", Medico.class);
		query.setParameter("pNome", nome);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Medico> autoCompletar(String nome) {
		TypedQuery<Medico> query = em.createQuery(
				"from Medico c where c.nomeMedico like :pNome",
				Medico.class);
		query.setParameter("pNome", nome + "%");
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

}
