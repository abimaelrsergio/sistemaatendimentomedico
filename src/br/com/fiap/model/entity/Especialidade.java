package br.com.fiap.model.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TAB_ESPECIALIDADE")
public class Especialidade  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "COD_ESPECIALIDADE")
	private long id;
	
	@Column
	private String descricao;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="especialidade")
	private Collection<Medico> medicos;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Collection<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(Collection<Medico> medicos) {
		this.medicos = medicos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return descricao;
	}

}
