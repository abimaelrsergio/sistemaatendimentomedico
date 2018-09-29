package br.com.fiap.controller.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;


import br.com.fiap.model.entity.Usuario;
import br.com.fiap.model.service.UsuarioService;
import br.com.fiap.model.service.interfaces.IUsuarioService;

@SessionScoped
@ManagedBean
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(LoginBean.class);
	private IUsuarioService usuarioService;
	private Usuario usuario = new Usuario();

	public String efetuaLogin() {
		usuarioService = new UsuarioService();
		boolean loginValido = usuarioService.existe(usuario);

		if (loginValido) {
			logger.debug("Usuário conectado: " + usuario);
			return "index";
		} else {
			logger.debug("Usuário não existe: " + usuario);
			return "login";
		}
	}

	public boolean isLogado() {
		return usuario != null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
