package br.com.fiap.model.dao;

import java.util.List;

public interface DAO<T> {
	
	List<T> listaTodos();
	
	T buscaPorId(Long id);

	T buscaPorId(Class<T> classe, Long id);

	void adiciona(T t);

	void remove(Long id);

	void atualiza(T t);

	void atualizaOuAdiciona(T t);


}
