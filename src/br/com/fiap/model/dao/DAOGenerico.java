package br.com.fiap.model.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class DAOGenerico<T> implements DAO<T>{

	@Inject
	public EntityManager em;
	private final Class<T> classe;

	@SuppressWarnings("unchecked")
	public DAOGenerico() {
		this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public List<T> listaTodos() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).getResultList();

		return lista;
	}

	public T buscaPorId(Long id) {
		return (T) em.find(classe, id);
	}

	public T buscaPorId(Class<T> classe, Long id) {
		return em.getReference(classe, id);
	}

	public void adiciona(T t) {
		em.persist(t);
	}

	public void remove(Long id) {
		T o = buscaPorId(classe, id);
		em.remove(o);
	}

	public void atualiza(T t) {
		em.merge(t);
	}

	public void atualizaOuAdiciona(T t) {
		em.merge(t);
	}
}
