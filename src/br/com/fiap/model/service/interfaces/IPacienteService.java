package br.com.fiap.model.service.interfaces;

import java.util.List;

import br.com.fiap.model.entity.Paciente;

public interface IPacienteService {

	public List<Paciente> listaTodos();
	
	public void remove(Long id);
	
	public void atualizaOuAdiciona(Paciente paciente);
	
	public List<Paciente> autoCompletar(String nome);
}
