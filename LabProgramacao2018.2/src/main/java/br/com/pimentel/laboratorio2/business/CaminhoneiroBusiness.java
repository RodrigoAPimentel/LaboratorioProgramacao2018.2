package br.com.pimentel.laboratorio2.business;

import br.com.pimentel.laboratorio2.model.Caminhoneiro;
import br.com.pimentel.laboratorio2.model.Medico;
import br.com.pimentel.laboratorio2.model.Profissao;
import br.com.pimentel.laboratorio2.repository.ProfissaoRepository;

public class CaminhoneiroBusiness extends Medico implements CalculosIR {

	private ProfissaoRepository repository;
	private Double desconto, ir, rendaAnual;

	@Override
	public Double calculaRendaAnual(Profissao profissao) {
		repository = new ProfissaoRepository();
		Caminhoneiro caminhoneiro = (Caminhoneiro) repository.findById(profissao.getCpf());
		
		Double toneladas = caminhoneiro.getToneladaTransportada();
		if (toneladas <= 100) {
			rendaAnual = 500.0;
			return rendaAnual;
		} else{
			rendaAnual = 500.0 + ((toneladas-100) * 50.0);
			return rendaAnual;
		}
	}

	@Override
	public Double calculaRendaAnual(String cpf) {
		repository = new ProfissaoRepository();
		Caminhoneiro caminhoneiro = (Caminhoneiro) repository.findById(cpf);
		
		Double toneladas = caminhoneiro.getToneladaTransportada();
		if (toneladas <= 100) {
			rendaAnual = 500.0;
			return rendaAnual;
		} else{
			rendaAnual = 500.0 + ((toneladas-100) * 50.0);
			return rendaAnual;
		}
	}
	
	@Override
	public Double calculaDescontoIR(Profissao profissao) {
		repository = new ProfissaoRepository();
		Caminhoneiro caminhoneiro = (Caminhoneiro) repository.findById(profissao.getCpf());
		desconto = caminhoneiro.getKmPercorrido() * 0.01;
		return desconto;
	}

	@Override
	public Double calculaDescontoIR(String cpf) {
		repository = new ProfissaoRepository();
		Caminhoneiro caminhoneiro = (Caminhoneiro) repository.findById(cpf);
		desconto = caminhoneiro.getKmPercorrido() * 0.01;
		return desconto;
	}

	@Override
	public Double calculaIR(Profissao profissao) {
		ir = (calculaRendaAnual(profissao) + (0.005 * profissao.getValorBens())) - calculaDescontoIR(profissao);
		return ir;
	}

	@Override
	public Double calculaIR(String cpf) {
		repository = new ProfissaoRepository();
		Caminhoneiro caminhoneiro = (Caminhoneiro) repository.findById(cpf);
		ir = (calculaRendaAnual(cpf) + (0.005 * caminhoneiro.getValorBens())) - calculaDescontoIR(caminhoneiro);
		return ir;
	}
	

}
