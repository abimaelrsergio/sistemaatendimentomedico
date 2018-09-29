package br.com.fiap.model.service;

import java.util.List;

import javax.inject.Inject;

import br.com.fiap.model.dao.TratamentoDAO;
import br.com.fiap.model.entity.Tratamento;
import br.com.fiap.model.service.interfaces.ITratamentoService;

/**
 * toda lógica de negócio vai aqui.
 * 
 * @author Abimael
 * 
 */
public class TratamentoService implements ITratamentoService {

	@Inject
	private TratamentoDAO tratamentoDAO;

	@Override
	public List<Tratamento> listaTodos() {
		return tratamentoDAO.listaTodos();
	}

	@Override
	public void atualizaOuAdiciona(Tratamento tratamento) {
		tratamentoDAO.atualizaOuAdiciona(tratamento);
	}

	@Override
	public void remove(Long id) {
		tratamentoDAO.remove(id);
	}

	@Override
	public List<Tratamento> autoCompletar(String nome) {
		return tratamentoDAO.autoCompletar(nome);
	}

}
