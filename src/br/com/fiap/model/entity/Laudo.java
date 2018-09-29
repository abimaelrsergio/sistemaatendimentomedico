package br.com.fiap.model.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;

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
@Table(name="TAB_LAUDO")
public class Laudo  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long cod_laudo;
	
	@ManyToOne
	@JoinColumn(name="COD_PACIENTE")
	private Paciente paciente;
	
	@Column(name="COD_MEDICO")
	private long cod_medico;
	
	@Column
	private String descricao;
	
	@Column
	private Date data;
	
	@Column
	private Time horario;
	

	@OneToMany
	@JoinColumn(name="COD_LAUDO")
	private Collection<Medicamento> medicamento = new ArrayList<Medicamento>();
	
	public long getCod_laudo() {
		return cod_laudo;
	}

	public void setCod_laudo(long cod_laudo) {
		this.cod_laudo = cod_laudo;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setCod_medico(long cod_medico) {
		this.cod_medico = cod_medico;
	}

	public long getCod_medico() {
		return cod_medico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHorario() {
		return horario;
	}

	public void setHorario(Time horario) {
		this.horario = horario;
	}

	public Collection<Medicamento> getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Collection<Medicamento> medicamento) {
		this.medicamento = medicamento;
	}
}
