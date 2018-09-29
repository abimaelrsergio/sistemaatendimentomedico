package br.com.fiap.model.service.interfaces;

import java.util.List;

import br.com.fiap.model.entity.Consulta;

public interface IConsultaService {

	public List<Consulta> listaTodos();
	
	public void remove(Long id);
	
	public void atualizaOuAdiciona(Consulta consulta);
	
	public List<Consulta> autoCompletar(String nome);
}
