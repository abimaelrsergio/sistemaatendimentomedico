package br.com.fiap.controller.managedbeans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.fiap.controller.interceptor.Transactional;
import br.com.fiap.util.IndexUtil;

@Transactional
@RequestScoped
@Named
public class IndexAtivoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer index;

	public Integer getIndex() {
		index = IndexUtil.index;
		return index ;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

}
