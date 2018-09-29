package br.com.fiap.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TAB_PACIENTE_CONVENIO")
public class PacienteConvenio  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private int cod_paciente;
	
	@Id
	@Column
	private int cod_convenio;

	public int getCod_paciente() {
		return cod_paciente;
	}

	public void setCod_paciente(int cod_paciente) {
		this.cod_paciente = cod_paciente;
	}

	public int getCod_convenio() {
		return cod_convenio;
	}

	public void setCod_convenio(int cod_convenio) {
		this.cod_convenio = cod_convenio;
	}
	
	

}
