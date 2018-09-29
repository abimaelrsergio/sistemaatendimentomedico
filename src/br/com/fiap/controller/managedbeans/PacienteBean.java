package br.com.fiap.controller.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.fiap.controller.interceptor.Transactional;
import br.com.fiap.model.entity.Paciente;
import br.com.fiap.model.service.interfaces.IPacienteService;
import br.com.fiap.util.IndexUtil;

@Transactional
@RequestScoped
@Named
public class PacienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Logger logger;
	@Inject
	private IPacienteService pacienteService;
	private List<Paciente> pacientes;
	private Paciente paciente;

	@PostConstruct
	private void reCarregarDados() {

		paciente = new Paciente();
		pacientes = pacienteService.listaTodos();
		IndexUtil.novoIndex(2);
	}

	public void grava() throws Exception {

		pacienteService.atualizaOuAdiciona(paciente);

		logger.debug("Paciente foi adicionado ou atualizado");

		reCarregarDados();
	}

	public void remove() {
		pacienteService.remove(paciente.getId());

		logger.debug("Paciente: " + paciente.getNomePaciente() + " foi removido.");

		reCarregarDados();
	}

	public List<Paciente> autoCompletar(String nome) {
		return pacienteService.autoCompletar(nome);
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

}
