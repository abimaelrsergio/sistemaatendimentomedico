package br.com.fiap.controller.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.fiap.controller.interceptor.Transactional;
import br.com.fiap.model.entity.Tratamento;
import br.com.fiap.model.service.interfaces.ITratamentoService;
import br.com.fiap.util.IndexUtil;

@Transactional
@RequestScoped
@Named
public class TratamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Logger logger;
	@Inject
	private ITratamentoService tratamentoService;
	private List<Tratamento> tratamentos;
	private Tratamento tratamento;

	@PostConstruct
	private void reCarregarDados() {
		tratamento = new Tratamento();
		tratamentos = tratamentoService.listaTodos();
		IndexUtil.novoIndex(4);
	}
	
	public void grava() throws Exception {
	
		tratamentoService.atualizaOuAdiciona(tratamento);
		
		logger.debug("Tratamento foi adicionado ou atualizado");
		
		reCarregarDados();
	}

	public void remove() {
		tratamentoService.remove(tratamento.getId());
		
		logger.debug("Tratamento: " + tratamento.getNomeTratamento() + " foi removido.");
		
		reCarregarDados();
	}
	
	public List<Tratamento> autoCompletar(String nome) {
        return tratamentoService.autoCompletar(nome);
    }
	
	public Tratamento getTratamento() {
		return tratamento;
	}
	
	public void setTratamento(Tratamento tratamento) {
		this.tratamento = tratamento;
	}	

	public List<Tratamento> getTratamentos() {
		return tratamentos;
	}
}
