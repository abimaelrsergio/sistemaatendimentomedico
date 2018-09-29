package br.com.fiap.model.service;

import br.com.fiap.model.dao.UsuarioDAO;
import br.com.fiap.model.entity.Usuario;
import br.com.fiap.model.service.interfaces.IUsuarioService;

/**
 * toda lógica de negócio vai aqui.
 * 
 * @author Abimael
 * 
 */
public class UsuarioService implements IUsuarioService {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	@Override
	public boolean existe(Usuario usuario) {
		return usuarioDAO.existe(usuario);
	}

}
