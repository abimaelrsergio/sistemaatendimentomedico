package br.com.fiap.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.model.entity.Especialidade;

public class EspecialidadeDAO extends DAOGenerico<Especialidade> {

	// método utilizado para fazer testes, somente isso.
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public Especialidade buscarEspecialidadesPorNome(String nome) {
		TypedQuery<Especialidade> query = em.createQuery(
				"from Especialidade c where c.nomeEspecialidade= :pNome", Especialidade.class);
		query.setParameter("pNome", nome);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Especialidade> autoCompletar(String nome) {
		TypedQuery<Especialidade> query = em.createQuery(
				"from Especialidade c where c.nomeEspecialidade like :pNome",
				Especialidade.class);
		query.setParameter("pNome", nome + "%");
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
}
