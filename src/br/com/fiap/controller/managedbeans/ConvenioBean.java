package br.com.fiap.controller.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.fiap.controller.interceptor.Transactional;
import br.com.fiap.model.entity.Convenio;
import br.com.fiap.model.service.interfaces.IConvenioService;
import br.com.fiap.util.IndexUtil;

@Transactional
@RequestScoped
@Named
public class ConvenioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Logger logger;
	@Inject
	private IConvenioService convenioService;
	private List<Convenio> convenios;
	private Convenio convenio;

	@PostConstruct
	private void reCarregarDados() {
		convenio = new Convenio();
		convenios = convenioService.listaTodos();
		IndexUtil.novoIndex(0);
	}
	
	public void grava() throws Exception {
	
		convenioService.atualizaOuAdiciona(convenio);
		
		logger.debug("Convenio foi adicionado ou atualizado");
		
		reCarregarDados();
	}

	public void remove() {
		convenioService.remove(convenio.getId());
		
		logger.debug("Convenio: " + convenio.getNomeConvenio() + " foi removido.");
		
		reCarregarDados();
	}
	
	public List<Convenio> autoCompletar(String nome) {
        return convenioService.autoCompletar(nome);
    }
	
	public Convenio getConvenio() {
		return convenio;
	}
	
	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}	

	public List<Convenio> getConvenios() {
		return convenios;
	}
}
