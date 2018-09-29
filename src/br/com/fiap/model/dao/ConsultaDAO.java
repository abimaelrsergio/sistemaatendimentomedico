package br.com.fiap.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.model.entity.Consulta;

public class ConsultaDAO extends DAOGenerico<Consulta> {

	// método utilizado para fazer testes, somente isso.
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public Consulta buscarConsultasPorNome(String nome) {
		TypedQuery<Consulta> query = em.createQuery(
				"from Consulta c where c.nomeConsulta= :pNome", Consulta.class);
		query.setParameter("pNome", nome);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Consulta> autoCompletar(String nome) {
		TypedQuery<Consulta> query = em.createQuery(
				"from Consulta c where c.nomeConsulta like :pNome",
				Consulta.class);
		query.setParameter("pNome", nome + "%");
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
}
