package br.com.fiap.model.service;

import java.util.List;

import javax.inject.Inject;

import br.com.fiap.model.dao.MedicoDAO;
import br.com.fiap.model.entity.Medico;
import br.com.fiap.model.service.interfaces.IMedicoService;

/**
 * toda lógica de negócio vai aqui.
 * 
 * @author Abimael
 * 
 */
public class MedicoService implements IMedicoService {

	@Inject
	private MedicoDAO medicoDAO;

	@Override
	public List<Medico> listaTodos() {
		return medicoDAO.listaTodos();
	}

	@Override
	public void atualizaOuAdiciona(Medico medico) {
		medicoDAO.atualizaOuAdiciona(medico);
	}

	@Override
	public void remove(Long id) {
		medicoDAO.remove(id);
	}

	@Override
	public List<Medico> autoCompletar(String nome) {
		return medicoDAO.autoCompletar(nome);
	}

}
