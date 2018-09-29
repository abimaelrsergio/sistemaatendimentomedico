package br.com.fiap.controller.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.fiap.controller.interceptor.Transactional;
import br.com.fiap.model.entity.Especialidade;
import br.com.fiap.model.entity.Paciente;
import br.com.fiap.model.service.interfaces.IEspecialidadeService;
import br.com.fiap.model.service.interfaces.IPacienteService;
import br.com.fiap.util.IndexUtil;

@Transactional
@RequestScoped
@Named
public class AgendamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Logger logger;
	@Inject
	private IPacienteService pacienteService;
	@Inject
	private IEspecialidadeService especialidadeService;
	private List<Especialidade> especialidades;
	private List<Paciente> pacientes;
	private Paciente paciente;
	private Especialidade especialidade;

	@PostConstruct
	private void reCarregarDados() {
		paciente = new Paciente();
		pacientes = pacienteService.listaTodos();
		especialidades = especialidadeService.listaTodos();
		IndexUtil.novoIndex(5);
	}

	public void grava() throws Exception {

		pacienteService.atualizaOuAdiciona(paciente);

		logger.debug("Paciente foi adicionado ou atualizado");

		reCarregarDados();
	}

	public void remove() {
		pacienteService.remove(paciente.getId());

		logger.debug("Paciente: " + paciente.getNomePaciente()
				+ " foi removido.");

		reCarregarDados();
	}

	public List<Paciente> autoCompletar(String nome) {
		return pacienteService.autoCompletar(nome);
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente convenio) {
		this.paciente = convenio;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
}
