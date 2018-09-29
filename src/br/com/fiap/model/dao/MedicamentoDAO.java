package br.com.fiap.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.model.entity.Medicamento;

public class MedicamentoDAO extends DAOGenerico<Medicamento> {

	// método utilizado para fazer testes, somente isso.
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public Medicamento buscarMedicamentosPorNome(String nome) {
		TypedQuery<Medicamento> query = em.createQuery(
				"from Medicamento c where c.nomeMedicamento= :pNome", Medicamento.class);
		query.setParameter("pNome", nome);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Medicamento> autoCompletar(String nome) {
		TypedQuery<Medicamento> query = em.createQuery(
				"from Medicamento c where c.nomeMedicamento like :pNome",
				Medicamento.class);
		query.setParameter("pNome", nome + "%");
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
}
