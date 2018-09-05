package br.com.pimentel.laboratorio2;

import br.com.pimentel.laboratorio2.business.ProfessorBusiness;
import br.com.pimentel.laboratorio2.model.Professor;
import br.com.pimentel.laboratorio2.model.Taxista;
import br.com.pimentel.laboratorio2.repository.ProfissaoRepository;

public class A {

	public static void main(String[] args) throws Exception {
	
		

		ProfissaoRepository repository = new ProfissaoRepository();
		
		Professor professor = new Professor("000.000.000-00", "Rodrigo", 100000.0, 500000.0, 5000.0);
		Professor professor2 = new Professor("111.111.111-11", "Calango", 12000.0, 45000.0, 100.0);
//		repository.save(professor);
//		repository.save(professor2);
		
		
		Taxista taxista = new Taxista("222.222.222-22", "Jabuti", 10, 100000.0, 50.0);
//		repository.save(taxista);
		
		
		
ProfessorBusiness professorBusiness = new ProfessorBusiness();
		
		System.out.println("\nDESCONTO ======== " + professorBusiness.calculaDescontoIR(professor2));
		System.out.println("\nIMPOSTO TOTAL ======== " + professorBusiness.calculaIR(professor2));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
