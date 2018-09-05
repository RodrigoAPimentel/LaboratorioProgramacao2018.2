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

}
