package br.com.fiap.model.service;

import java.util.List;

import javax.inject.Inject;

import br.com.fiap.model.dao.ConsultaDAO;
import br.com.fiap.model.entity.Consulta;
import br.com.fiap.model.service.interfaces.IConsultaService;

/**
 * toda lógica de negócio vai aqui.
 * 
 * @author Abimael
 * 
 */
public class ConsultaService implements IConsultaService {

	@Inject
	private ConsultaDAO consultaDAO;

	@Override
	public List<Consulta> listaTodos() {
		return consultaDAO.listaTodos();
	}

	@Override
	public void atualizaOuAdiciona(Consulta consulta) {
		consultaDAO.atualizaOuAdiciona(consulta);
	}

	@Override
	public void remove(Long id) {
		consultaDAO.remove(id);
	}

	@Override
	public List<Consulta> autoCompletar(String nome) {
		return consultaDAO.autoCompletar(nome);
	}

}
