package br.com.fiap.model.service.interfaces;

import java.util.List;

import br.com.fiap.model.entity.Medicamento;

public interface IMedicamentoService {

	public List<Medicamento> listaTodos();
	
	public void remove(Long id);
	
	public void atualizaOuAdiciona(Medicamento paciente);
	
	public List<Medicamento> autoCompletar(String nome);
}
