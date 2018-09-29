package br.com.fiap.model.service.interfaces;

import java.util.List;

import br.com.fiap.model.entity.Medico;

public interface IMedicoService {

	public List<Medico> listaTodos();
	
	public void remove(Long id);
	
	public void atualizaOuAdiciona(Medico medico);
	
	public List<Medico> autoCompletar(String nome);
}
