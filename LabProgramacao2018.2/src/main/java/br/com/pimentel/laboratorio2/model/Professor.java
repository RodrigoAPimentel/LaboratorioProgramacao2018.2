package br.com.pimentel.laboratorio2.model;

import javax.persistence.Entity;

@Entity
public class Professor extends Profissao {
	
	private Double materialDidatico;
	private Double rendaAnual;

	public Professor() {
		super();
	}

	public Professor(String cpf, String nome, Double rendaAnual, Double valorBens, Double materialDidatico) {
		super(cpf, nome, valorBens);
		this.setRendaAnual(rendaAnual);
		this.materialDidatico = materialDidatico;
	}

	public Double getRendaAnual() {
		return rendaAnual;
	}

	public void setRendaAnual(Double rendaAnual) {
		this.rendaAnual = rendaAnual;
	}

	public Double getMaterialDidatico() {
		return materialDidatico;
	}

	public void setMaterialDidatico(Double materialDidatico) {
		this.materialDidatico = materialDidatico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((materialDidatico == null) ? 0 : materialDidatico.hashCode());
		result = prime * result + ((rendaAnual == null) ? 0 : rendaAnual.hashCode());
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
		Professor other = (Professor) obj;
		if (materialDidatico == null) {
			if (other.materialDidatico != null)
				return false;
		} else if (!materialDidatico.equals(other.materialDidatico))
			return false;
		if (rendaAnual == null) {
			if (other.rendaAnual != null)
				return false;
		} else if (!rendaAnual.equals(other.rendaAnual))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Professor [materialDidatico=" + materialDidatico + ", rendaAnual=" + rendaAnual + "]";
	}
	
}
