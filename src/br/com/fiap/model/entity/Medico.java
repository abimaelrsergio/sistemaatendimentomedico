package br.com.fiap.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_MEDICOS")
public class Medico implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String nomeMedico;

	@Column
	private long crm;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "COD_ESPECIALIDADE")
	private Especialidade especialidade;

	@OneToMany(mappedBy = "medico")
	private Collection<Consulta> consulta = new ArrayList<Consulta>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public long getCrm() {
		return crm;
	}

	public void setCrm(long crm) {
		this.crm = crm;
	}

	public Collection<Consulta> getConsulta() {
		return consulta;
	}

	public void setConsulta(Collection<Consulta> consulta) {
		this.consulta = consulta;
	}
}
