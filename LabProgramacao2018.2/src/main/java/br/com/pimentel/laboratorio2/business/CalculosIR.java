package br.com.pimentel.laboratorio2.business;

import br.com.pimentel.laboratorio2.model.Profissao;

public interface CalculosIR {

	public Double calculaRendaAnual(Profissao profissao);

	public Double calculaRendaAnual(String cpf);
	
	public Double calculaDescontoIR(Profissao profissao);

	public Double calculaDescontoIR(String cpf);

	public Double calculaIR(Profissao profissao);

	public Double calculaIR(String cpf);
	
	public Boolean calculaMalhaFina(Profissao profissao);

}
