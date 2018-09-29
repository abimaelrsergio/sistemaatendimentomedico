package br.com.fiap.model.service;

import java.util.List;

import javax.inject.Inject;

import br.com.fiap.model.dao.EspecialidadeDAO;
import br.com.fiap.model.entity.Especialidade;
import br.com.fiap.model.service.interfaces.IEspecialidadeService;

/**
 * toda lógica de negócio vai aqui.
 * 
 * @author Abimael
 * 
 */
public class EspecialidadeService implements IEspecialidadeService {

	@Inject
	private EspecialidadeDAO especialidadeDAO;

	@Override
	public List<Especialidade> listaTodos() {
		return especialidadeDAO.listaTodos();
	}

	@Override
	public void atualizaOuAdiciona(Especialidade especialidade) {
		especialidadeDAO.atualizaOuAdiciona(especialidade);
	}

	@Override
	public void remove(Long id) {
		especialidadeDAO.remove(id);
	}

	@Override
	public List<Especialidade> autoCompletar(String nome) {
		return especialidadeDAO.autoCompletar(nome);
	}

}
