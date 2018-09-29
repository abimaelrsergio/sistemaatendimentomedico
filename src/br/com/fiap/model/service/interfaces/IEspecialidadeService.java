package br.com.fiap.model.service.interfaces;

import java.util.List;

import br.com.fiap.model.entity.Especialidade;

public interface IEspecialidadeService {

	public List<Especialidade> listaTodos();
	
	public void remove(Long id);
	
	public void atualizaOuAdiciona(Especialidade especialidade);
	
	public List<Especialidade> autoCompletar(String nome);
}
