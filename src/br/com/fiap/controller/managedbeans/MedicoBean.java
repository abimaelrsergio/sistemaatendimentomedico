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
import br.com.fiap.model.entity.Medico;
import br.com.fiap.model.service.interfaces.IMedicoService;
import br.com.fiap.util.IndexUtil;

@Transactional
@RequestScoped
@Named
public class MedicoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Logger logger;
	@Inject
	private IMedicoService medicoService;
	private List<Medico> medicos;
	private Medico medico;
	private Especialidade especialidade;

	@PostConstruct
	private void reCarregarDados() {

		medico = new Medico();
		especialidade = new Especialidade();
		medicos = medicoService.listaTodos();
		IndexUtil.novoIndex(1);
	}

	public void grava() throws Exception {

		medico.setEspecialidade(especialidade);
		medicoService.atualizaOuAdiciona(medico);

		logger.debug("Medico foi adicionado ou atualizado");

		reCarregarDados();
	}

	public void remove() {
		medicoService.remove(medico.getId());

		logger.debug("Medico: " + medico.getNomeMedico() + " foi removido.");

		reCarregarDados();
	}

	public List<Medico> autoCompletar(String nome) {
		return medicoService.autoCompletar(nome);
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
}
