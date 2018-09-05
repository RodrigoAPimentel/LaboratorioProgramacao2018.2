package br.com.pimentel.laboratorio2.model;

import javax.persistence.Entity;

@Entity
public class Medico extends Profissao {
	
	private Double despesaCongresso;
	private Integer nrPaciente;

	public Medico() {
		super();
	}

	public Medico(String cpf, String nome, Integer nrPaciente, Double valorBens, Double despesaCongresso) {
		super(cpf, nome, valorBens);
		this.setNrPaciente(nrPaciente);
		this.despesaCongresso = despesaCongresso;
	}

	public Integer getNrPaciente() {
		return nrPaciente;
	}

	public void setNrPaciente(Integer nrPaciente) {
		this.nrPaciente = nrPaciente;
	}

	public Double getDespesaCongresso() {
		return despesaCongresso;
	}

	public void setDespesaCongresso(Double despesaCongresso) {
		this.despesaCongresso = despesaCongresso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((despesaCongresso == null) ? 0 : despesaCongresso.hashCode());
		result = prime * result + ((nrPaciente == null) ? 0 : nrPaciente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		if (despesaCongresso == null) {
			if (other.despesaCongresso != null)
				return false;
		} else if (!despesaCongresso.equals(other.despesaCongresso))
			return false;
		if (nrPaciente == null) {
			if (other.nrPaciente != null)
				return false;
		} else if (!nrPaciente.equals(other.nrPaciente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Medico [despesaCongresso=" + despesaCongresso + ", nrPaciente=" + nrPaciente + "]";
	}
	
}
