package br.com.fiap.controller.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.fiap.controller.interceptor.Transactional;
import br.com.fiap.model.entity.Consulta;
import br.com.fiap.model.service.interfaces.IConsultaService;
import br.com.fiap.util.IndexUtil;

@Transactional
@RequestScoped
@Named
public class ConsultaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Logger logger;
	@Inject
	private IConsultaService consultaService;
	private List<Consulta> consultas;
	private Consulta consulta;

	@PostConstruct
	private void reCarregarDados() {
		consulta = new Consulta();
		consultas = consultaService.listaTodos();
		IndexUtil.novoIndex(5);
	}
	
	public void grava() throws Exception {
	
		consultaService.atualizaOuAdiciona(consulta);
		
		logger.debug("Consulta foi adicionado ou atualizado");
		
		reCarregarDados();
	}

	public void remove() {
		consultaService.remove(consulta.getId());
		
		logger.debug("Consulta: " + consulta.getEspecialidade().getDescricao() + " foi removido.");
		
		reCarregarDados();
	}
	
	public List<Consulta> autoCompletar(String nome) {
        return consultaService.autoCompletar(nome);
    }
	
	public Consulta getConsulta() {
		return consulta;
	}
	
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}	

	public List<Consulta> getConsultas() {
		return consultas;
	}
}
