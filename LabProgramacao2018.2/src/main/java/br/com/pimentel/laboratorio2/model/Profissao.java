package br.com.pimentel.laboratorio2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author Rodrigo Pimentel
 * @LabProgramacao2018.2 @2018
 *
 *
 */
@Entity @Inheritance(strategy=InheritanceType.JOINED)
public abstract class Profissao {
	
	@Id private String cpf;
	private String nome;
	private Double valorBens;

	public Profissao() {
		super();
	}

	public Profissao(String cpf, String nome, Double valorBens) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.valorBens = valorBens;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	
	public void SetNome(String nome) {
		this.nome = nome;
	}
	
	public Double getValorBens() {
		return valorBens;
	}
	
	public void setValorBens(Double valorBens) {
		this.valorBens = valorBens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((valorBens == null) ? 0 : valorBens.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissao other = (Profissao) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (valorBens == null) {
			if (other.valorBens != null)
				return false;
		} else if (!valorBens.equals(other.valorBens))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profissao [cpf=" + cpf + ", nome=" + nome + ", valorBens=" + valorBens + "]";
	}

}
