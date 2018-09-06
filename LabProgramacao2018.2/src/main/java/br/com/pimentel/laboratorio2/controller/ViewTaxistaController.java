package br.com.pimentel.laboratorio2.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.pimentel.laboratorio2.model.MaskFieldUtil;
import br.com.pimentel.laboratorio2.model.Taxista;
import br.com.pimentel.laboratorio2.repository.ProfissaoRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ViewTaxistaController implements Initializable{

	@FXML TextField textFieldNome;
	@FXML TextField textFieldCPF;
	@FXML TextField textFieldValorBens;
	@FXML Button buttonSalvar;
	@FXML TextField textFieldPassageiroAno;
	@FXML TextField textFieldKmPercorrido;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		MaskFieldUtil.cpfField(textFieldCPF);		
		MaskFieldUtil.monetaryField(textFieldValorBens);
		MaskFieldUtil.monetaryField(textFieldKmPercorrido);
		MaskFieldUtil.numericField(textFieldPassageiroAno);
	}

	@FXML public void onClickedBtnSalvar(MouseEvent event) throws Exception {	
		System.out.println(textFieldValorBens.getText());
		ProfissaoRepository repository = new ProfissaoRepository();
		Taxista taxista = new Taxista(textFieldCPF.getText(), 
				                   textFieldNome.getText(),
				                   Integer.parseInt(textFieldPassageiroAno.getText()), 
				                   Double.parseDouble(textFieldValorBens.getText().replaceAll("[^0-9]", "")), 
				                   Double.parseDouble(textFieldKmPercorrido.getText().replaceAll("[^0-9]", "")));
		repository.save(taxista);
		
		textFieldNome.setText("");
		textFieldCPF.setText("");
		textFieldValorBens.setText("");
		textFieldPassageiroAno.setText("");
		textFieldKmPercorrido.setText("");
	}





}
