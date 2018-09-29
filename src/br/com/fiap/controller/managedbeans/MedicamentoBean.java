package br.com.fiap.controller.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.fiap.controller.interceptor.Transactional;
import br.com.fiap.model.entity.Medicamento;
import br.com.fiap.model.service.interfaces.IMedicamentoService;
import br.com.fiap.util.IndexUtil;

@Transactional
@RequestScoped
@Named
public class MedicamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Logger logger;
	@Inject
	private IMedicamentoService medicamentoService;
	private List<Medicamento> medicamentos;
	private Medicamento medicamento;

	@PostConstruct
	private void reCarregarDados() {
		medicamento = new Medicamento();
		medicamentos = medicamentoService.listaTodos();
		IndexUtil.novoIndex(3);
	}
	
	public void grava() throws Exception {
	
		medicamentoService.atualizaOuAdiciona(medicamento);
		
		logger.debug("Medicamento foi adicionado ou atualizado");
		
		reCarregarDados();
	}

	public void remove() {
		medicamentoService.remove(medicamento.getId());
		
		logger.debug("Medicamento: " + medicamento.getNomeMedicamento() + " foi removido.");
		
		reCarregarDados();
	}
	
	public List<Medicamento> autoCompletar(String nome) {
        return medicamentoService.autoCompletar(nome);
    }
	
	public Medicamento getMedicamento() {
		return medicamento;
	}
	
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}	

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}
}
