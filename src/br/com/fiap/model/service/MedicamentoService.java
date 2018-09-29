package br.com.fiap.model.service;

import java.util.List;

import javax.inject.Inject;

import br.com.fiap.model.dao.MedicamentoDAO;
import br.com.fiap.model.entity.Medicamento;
import br.com.fiap.model.service.interfaces.IMedicamentoService;

/**
 * toda lógica de negócio vai aqui.
 * 
 * @author Abimael
 * 
 */
public class MedicamentoService implements IMedicamentoService {

	@Inject
	private MedicamentoDAO medicamentoDAO;

	@Override
	public List<Medicamento> listaTodos() {
		return medicamentoDAO.listaTodos();
	}

	@Override
	public void atualizaOuAdiciona(Medicamento medicamento) {
		medicamentoDAO.atualizaOuAdiciona(medicamento);
	}

	@Override
	public void remove(Long id) {
		medicamentoDAO.remove(id);
	}

	@Override
	public List<Medicamento> autoCompletar(String nome) {
		return medicamentoDAO.autoCompletar(nome);
	}

}
