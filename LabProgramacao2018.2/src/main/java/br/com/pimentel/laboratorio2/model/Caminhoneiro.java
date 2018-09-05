package br.com.pimentel.laboratorio2.model;

import javax.persistence.Entity;

@Entity
public class Caminhoneiro extends Profissao implements Rodoviario {

	private Double kmPercorrido;
	private Double toneladaTransportada;
	
	public Caminhoneiro() {
	}

	public Caminhoneiro(String cpf, String nome, Double toneladaTransportada, Double valorBens, Double kmPercorrido) {
		super(cpf, nome, valorBens);
		this.setToneladaTransportada(toneladaTransportada);
		this.kmPercorrido = kmPercorrido;
	}

	public Double getToneladaTransportada() {
		return toneladaTransportada;
	}

	public void setToneladaTransportada(Double toneladaTransportada) {
		this.toneladaTransportada = toneladaTransportada;
	}

	public Double getKmPercorrido() {
		return kmPercorrido;
	}

	public void setKmPercorrido(Double kmPercorrido) {
		this.kmPercorrido = kmPercorrido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((kmPercorrido == null) ? 0 : kmPercorrido.hashCode());
		result = prime * result + ((toneladaTransportada == null) ? 0 : toneladaTransportada.hashCode());
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
		Caminhoneiro other = (Caminhoneiro) obj;
		if (kmPercorrido == null) {
			if (other.kmPercorrido != null)
				return false;
		} else if (!kmPercorrido.equals(other.kmPercorrido))
			return false;
		if (toneladaTransportada == null) {
			if (other.toneladaTransportada != null)
				return false;
		} else if (!toneladaTransportada.equals(other.toneladaTransportada))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Caminhoneiro [kmPercorrido=" + kmPercorrido + ", toneladaTransportada=" + toneladaTransportada + "]";
	}

}
