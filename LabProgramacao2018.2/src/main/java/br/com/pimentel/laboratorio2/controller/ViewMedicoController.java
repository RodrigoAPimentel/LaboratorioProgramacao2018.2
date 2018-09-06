package br.com.pimentel.laboratorio2.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.pimentel.laboratorio2.model.MaskFieldUtil;
import br.com.pimentel.laboratorio2.model.Medico;
import br.com.pimentel.laboratorio2.repository.ProfissaoRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ViewMedicoController implements Initializable{



	@FXML TextField textFieldNome;
	@FXML TextField textFieldCPF;
	@FXML TextField textFieldValorBens;
	@FXML Button buttonSalvar;
	@FXML TextField textFieldDespesaCongresso;
	@FXML TextField textFieldPacientesAno;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		MaskFieldUtil.cpfField(textFieldCPF);		
		MaskFieldUtil.monetaryField(textFieldValorBens);
		MaskFieldUtil.monetaryField(textFieldDespesaCongresso);
		MaskFieldUtil.numericField(textFieldPacientesAno);		
	}

	@FXML public void onClickedBtnSalvar(MouseEvent event) throws Exception {	
		System.out.println(textFieldValorBens.getText());
		ProfissaoRepository repository = new ProfissaoRepository();
		Medico medico = new Medico(textFieldCPF.getText(), 
				                   textFieldNome.getText(),
				                   Integer.parseInt(textFieldPacientesAno.getText()), 
				                   Double.parseDouble(textFieldValorBens.getText().replaceAll("[^0-9]", "")), 
				                   Double.parseDouble(textFieldDespesaCongresso.getText().replaceAll("[^0-9]", "")));
		repository.save(medico);
		
		textFieldNome.setText("");
		textFieldCPF.setText("");
		textFieldValorBens.setText("");
		textFieldDespesaCongresso.setText("");
		textFieldPacientesAno.setText("");
	}





}
