package br.com.pimentel.laboratorio2.model;

import javax.persistence.Entity;

@Entity
public class Taxista extends Profissao implements Rodoviario {

	private Double kmPercorrido;
	private Integer numeroPassageiros;

	public Taxista() {
		super();
	}

	public Taxista(String cpf, String nome, Integer numeroPassageiros, Double valorBens, Double kmPercorrido) {
		super(cpf, nome, valorBens);
		this.kmPercorrido = kmPercorrido;
		this.setNumeroPassageiros(numeroPassageiros);
	}
	
	public Double getKmPercorrido() {
		return kmPercorrido;
	}

	public void setKmPercorrido(Double kmPercorrido) {
		this.kmPercorrido = kmPercorrido;
	}

	/**
	 * @return
	 */
	public Integer getNumeroPassageiros() {
		return numeroPassageiros;
	}

	/**
	 * @param numeroPassageiros
	 */
	public void setNumeroPassageiros(Integer numeroPassageiros) {
		this.numeroPassageiros = numeroPassageiros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((kmPercorrido == null) ? 0 : kmPercorrido.hashCode());
		result = prime * result + ((numeroPassageiros == null) ? 0 : numeroPassageiros.hashCode());
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
		Taxista other = (Taxista) obj;
		if (kmPercorrido == null) {
			if (other.kmPercorrido != null)
				return false;
		} else if (!kmPercorrido.equals(other.kmPercorrido))
			return false;
		if (numeroPassageiros == null) {
			if (other.numeroPassageiros != null)
				return false;
		} else if (!numeroPassageiros.equals(other.numeroPassageiros))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Taxista [kmPercorrido=" + kmPercorrido + ", numeroPassageiros=" + numeroPassageiros + "]";
	}
	
	

}
