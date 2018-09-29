package br.com.fiap.model.service;

import java.util.List;

import javax.inject.Inject;

import br.com.fiap.model.dao.ConvenioDAO;
import br.com.fiap.model.entity.Convenio;
import br.com.fiap.model.service.interfaces.IConvenioService;

/**
 * toda lógica de negócio vai aqui.
 * 
 * @author Abimael
 * 
 */
public class ConvenioService implements IConvenioService {

	@Inject
	private ConvenioDAO convenioDAO;

	@Override
	public List<Convenio> listaTodos() {
		return convenioDAO.listaTodos();
	}

	@Override
	public void atualizaOuAdiciona(Convenio convenio) {
		convenioDAO.atualizaOuAdiciona(convenio);
	}

	@Override
	public void remove(Long id) {
		convenioDAO.remove(id);
	}

	@Override
	public List<Convenio> autoCompletar(String nome) {
		return convenioDAO.autoCompletar(nome);
	}

}
