package br.com.fiap.model.service;

import java.util.List;

import javax.inject.Inject;

import br.com.fiap.model.dao.PacienteDAO;
import br.com.fiap.model.entity.Paciente;
import br.com.fiap.model.service.interfaces.IPacienteService;

/**
 * toda lógica de negócio vai aqui.
 * 
 * @author Abimael
 * 
 */
public class PacienteService implements IPacienteService {

	@Inject
	private PacienteDAO pacienteDAO;

	@Override
	public List<Paciente> listaTodos() {
		return pacienteDAO.listaTodos();
	}

	@Override
	public void atualizaOuAdiciona(Paciente paciente) {
		pacienteDAO.atualizaOuAdiciona(paciente);
	}

	@Override
	public void remove(Long id) {
		pacienteDAO.remove(id);
	}

	@Override
	public List<Paciente> autoCompletar(String nome) {
		return pacienteDAO.autoCompletar(nome);
	}

}
