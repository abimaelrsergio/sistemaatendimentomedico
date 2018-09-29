package br.com.fiap.model.service.interfaces;

import java.util.List;

import br.com.fiap.model.entity.Convenio;

public interface IConvenioService {

	public List<Convenio> listaTodos();
	
	public void remove(Long id);
	
	public void atualizaOuAdiciona(Convenio convenio);
	
	public List<Convenio> autoCompletar(String nome);
}
