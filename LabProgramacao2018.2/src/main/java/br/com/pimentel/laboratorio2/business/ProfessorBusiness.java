package br.com.pimentel.laboratorio2.business;

import java.util.List;

import br.com.pimentel.laboratorio2.model.Professor;
import br.com.pimentel.laboratorio2.model.Profissao;
import br.com.pimentel.laboratorio2.repository.ProfessorRepository;
import br.com.pimentel.laboratorio2.repository.ProfissaoRepository;

public class ProfessorBusiness extends Professor implements CalculosIR {

	private ProfissaoRepository repository;
	private Double desconto, ir;
	private ProfessorRepository professorRepository;
	private List<Professor> list;
	
	@Override
	public Double calculaRendaAnual(Profissao profissao) {
		Professor professorAux = (Professor) profissao;
		return professorAux.getRendaAnual();
	}

	@Override
	public Double calculaRendaAnual(String cpf) {
		repository = new ProfissaoRepository();

		Professor professorAux = (Professor) repository.findById(cpf);
		return professorAux.getRendaAnual();
	}

	@Override
	public Double calculaDescontoIR(Profissao profissao) {
		repository = new ProfissaoRepository();

		Professor professor = (Professor) repository.findById(profissao.getCpf());
		desconto = professor.getMaterialDidatico()*0.3;

		return desconto;
	}

	@Override
	public Double calculaDescontoIR(String cpf) {
		repository = new ProfissaoRepository();

		Professor professor = (Professor) repository.findById(cpf);
		desconto = professor.getMaterialDidatico()*0.3;

		return desconto;
	}

	@Override
	public Double calculaIR(Profissao profissao) {
		Professor professorAux = (Professor) profissao;
		
		Double salario = calculaRendaAnual(profissao);
		if (salario <= 1908.0) {
			ir = (salario * 0.12) - calculaDescontoIR(professorAux);
			return ir;			
		} else if (salario > 1908.0 && salario <= 3816.0) {
			ir = (salario * 0.2) - calculaDescontoIR(professorAux);
			return ir;
		}else{
			ir = (salario * 0.27) - calculaDescontoIR(professorAux);
			return ir;
		}
	}

	@Override
	public Double calculaIR(String cpf) {
		repository = new ProfissaoRepository();

		Professor professor = (Professor) repository.findById(cpf);
		
		Double salario = calculaRendaAnual(professor);
		if (salario <= 1908.0) {
			ir = (salario * 0.12) - calculaDescontoIR(professor);
			return ir;			
		} else if (salario > 1908.0 && salario <= 3816.0) {
			ir = (salario * 0.2) - calculaDescontoIR(professor);
			return ir;
		}else{
			ir = (salario * 0.27) - calculaDescontoIR(professor);
			return ir;
		}
	}

	@Override
	public Boolean calculaMalhaFina(Profissao profissao) {
		professorRepository = new ProfessorRepository();
		list = professorRepository.findAll();
		Double somaTodosValorBens = 0.0;
		for (Professor professor : list) {
			somaTodosValorBens =+ professor.getValorBens();
		}
		Double mediaValorBens = somaTodosValorBens/list.size();
		if ((profissao.getValorBens() * 1.5) >= mediaValorBens) {
			return true;
		} else {
			return false;
		}
		
	}	

}
