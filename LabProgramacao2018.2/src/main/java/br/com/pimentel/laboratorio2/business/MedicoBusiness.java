package br.com.pimentel.laboratorio2.business;

import java.util.List;

import br.com.pimentel.laboratorio2.model.Medico;
import br.com.pimentel.laboratorio2.model.Profissao;
import br.com.pimentel.laboratorio2.repository.MedicoRepository;
import br.com.pimentel.laboratorio2.repository.ProfissaoRepository;

public class MedicoBusiness extends Medico implements CalculosIR {

	private ProfissaoRepository repository;
	private Double desconto, ir, rendaAnual;
	private MedicoRepository medicoRepository;
	private List<Medico> list;

	@Override
	public Double calculaRendaAnual(Profissao profissao) {
		repository = new ProfissaoRepository();
		Medico medico = (Medico) repository.findById(profissao.getCpf());
		rendaAnual = medico.getNrPaciente() * 5.0;
		return rendaAnual;
	}

	@Override
	public Double calculaRendaAnual(String cpf) {
		repository = new ProfissaoRepository();
		Medico medico = (Medico) repository.findById(cpf);
		rendaAnual = medico.getNrPaciente() * 5.0;
		return rendaAnual;
	}
	
	@Override
	public Double calculaDescontoIR(Profissao profissao) {
		repository = new ProfissaoRepository();
		Medico medico = (Medico) repository.findById(profissao.getCpf());
		desconto = medico.getDespesaCongresso();
		return desconto;
	}

	@Override
	public Double calculaDescontoIR(String cpf) {
		repository = new ProfissaoRepository();
		Medico medico = (Medico) repository.findById(cpf);
		desconto = medico.getDespesaCongresso();
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
		Medico medico = (Medico) repository.findById(cpf);
		ir = (calculaRendaAnual(cpf) + (0.005 * medico.getValorBens())) - calculaDescontoIR(medico);
		return ir;
	}
	
	@Override
	public Boolean calculaMalhaFina(Profissao profissao) {
		medicoRepository = new MedicoRepository();
		list = medicoRepository.findAll();
		Double somaTodosValorBens = 0.0;
		for (Medico medico : list) {
			somaTodosValorBens =+ medico.getValorBens();
		}
		Double mediaValorBens = somaTodosValorBens/list.size();
		if ((profissao.getValorBens() * 1.5) >= mediaValorBens) {
			return true;
		} else {
			return false;
		}
		
	}	
	

}
