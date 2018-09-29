package br.com.fiap.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.model.entity.Paciente;

public class PacienteDAO extends DAOGenerico<Paciente> {

	// método utilizado para fazer testes, somente isso.
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public Paciente buscarPacientesPorNome(String nome) {
		TypedQuery<Paciente> query = em.createQuery(
				"from Paciente c where c.nome= :pNome", Paciente.class);
		query.setParameter("pNome", nome);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Paciente> autoCompletar(String nome) {
		TypedQuery<Paciente> query = em.createQuery(
				"from Paciente p where p.nome like :pNome",
				Paciente.class);
		query.setParameter("pNome", nome + "%");
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
}
