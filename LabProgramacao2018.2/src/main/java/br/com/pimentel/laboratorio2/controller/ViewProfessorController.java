package br.com.pimentel.laboratorio2.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.pimentel.laboratorio2.model.MaskFieldUtil;
import br.com.pimentel.laboratorio2.model.Professor;
import br.com.pimentel.laboratorio2.repository.ProfissaoRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ViewProfessorController implements Initializable{



	@FXML TextField textFieldNome;
	@FXML TextField textFieldCPF;
	@FXML TextField textFieldValorBens;
	@FXML TextField textFieldMaterialDidatico;
	@FXML TextField textFieldSalarioAnual;
	@FXML Button buttonSalvar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		MaskFieldUtil.cpfField(textFieldCPF);
		MaskFieldUtil.monetaryField(textFieldSalarioAnual);
		MaskFieldUtil.monetaryField(textFieldValorBens);
		MaskFieldUtil.monetaryField(textFieldMaterialDidatico);		
	}

	@FXML public void onClickedBtnSalvar(MouseEvent event) throws Exception {		
		ProfissaoRepository repository = new ProfissaoRepository();
		Professor professor = new Professor(textFieldCPF.getText(), 
											textFieldNome.getText(), 
											Double.parseDouble(textFieldSalarioAnual.getText().replaceAll("[^0-9]", "")), 
											Double.parseDouble(textFieldValorBens.getText().replaceAll("[^0-9]", "")), 
											Double.parseDouble(textFieldMaterialDidatico.getText().replaceAll("[^0-9]", "")));
		repository.save(professor);
		
		textFieldNome.setText("");
		textFieldCPF.setText("");
		textFieldValorBens.setText("");
		textFieldMaterialDidatico.setText("");
		textFieldSalarioAnual.setText("");
	}





}
