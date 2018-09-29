package br.com.fiap.model.service.interfaces;

import java.util.List;

import br.com.fiap.model.entity.Tratamento;

public interface ITratamentoService {

	public List<Tratamento> listaTodos();
	
	public void remove(Long id);
	
	public void atualizaOuAdiciona(Tratamento tratamento);
	
	public List<Tratamento> autoCompletar(String nome);
}
