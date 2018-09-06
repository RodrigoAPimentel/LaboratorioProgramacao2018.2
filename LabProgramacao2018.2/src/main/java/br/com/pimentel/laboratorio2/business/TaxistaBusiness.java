package br.com.pimentel.laboratorio2.business;

import java.util.List;

import br.com.pimentel.laboratorio2.model.Medico;
import br.com.pimentel.laboratorio2.model.Profissao;
import br.com.pimentel.laboratorio2.model.Taxista;
import br.com.pimentel.laboratorio2.repository.ProfissaoRepository;
import br.com.pimentel.laboratorio2.repository.TaxistaRepository;

public class TaxistaBusiness extends Medico implements CalculosIR {

	private ProfissaoRepository repository;
	private Double desconto, ir, rendaAnual;
	private TaxistaRepository taxistaRepository;
	private List<Taxista> list;

	@Override
	public Double calculaRendaAnual(Profissao profissao) {
		repository = new ProfissaoRepository();
		Taxista taxista = (Taxista) repository.findById(profissao.getCpf());
		rendaAnual = taxista.getNumeroPassageiros() * 0.5;
		return rendaAnual;
	}

	@Override
	public Double calculaRendaAnual(String cpf) {
		repository = new ProfissaoRepository();
		Taxista taxista = (Taxista) repository.findById(cpf);
		rendaAnual = taxista.getNumeroPassageiros() * 0.5;
		return rendaAnual;
	}
	
	@Override
	public Double calculaDescontoIR(Profissao profissao) {
		repository = new ProfissaoRepository();
		Taxista taxista = (Taxista) repository.findById(profissao.getCpf());
		desconto = taxista.getKmPercorrido() * 0.01;
		return desconto;
	}

	@Override
	public Double calculaDescontoIR(String cpf) {
		repository = new ProfissaoRepository();
		Taxista taxista = (Taxista) repository.findById(cpf);
		desconto = taxista.getKmPercorrido() * 0.01;
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
		Taxista taxista = (Taxista) repository.findById(cpf);
		ir = (calculaRendaAnual(cpf) + (0.005 * taxista.getValorBens())) - calculaDescontoIR(taxista);
		return ir;
	}
	
	@Override
	public Boolean calculaMalhaFina(Profissao profissao) {
		taxistaRepository = new TaxistaRepository();
		list = taxistaRepository.findAll();
		Double somaTodosValorBens = 0.0;
		for (Taxista taxista : list) {
			somaTodosValorBens =+ taxista.getValorBens();
		}
		Double mediaValorBens = somaTodosValorBens/list.size();
		if ((profissao.getValorBens() * 1.5) >= mediaValorBens) {
			return true;
		} else {
			return false;
		}
		
	}	

	

}
