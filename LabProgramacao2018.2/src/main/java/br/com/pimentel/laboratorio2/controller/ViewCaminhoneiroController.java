package br.com.pimentel.laboratorio2.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.pimentel.laboratorio2.model.Caminhoneiro;
import br.com.pimentel.laboratorio2.model.MaskFieldUtil;
import br.com.pimentel.laboratorio2.repository.ProfissaoRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ViewCaminhoneiroController implements Initializable{

	@FXML TextField textFieldNome;
	@FXML TextField textFieldCPF;
	@FXML TextField textFieldValorBens;
	@FXML Button buttonSalvar;
	@FXML TextField textFieldToneladas;
	@FXML TextField textFieldKmPercorrido;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		MaskFieldUtil.cpfField(textFieldCPF);		
		MaskFieldUtil.monetaryField(textFieldValorBens);
		MaskFieldUtil.monetaryField(textFieldKmPercorrido);
		MaskFieldUtil.monetaryField(textFieldToneladas);
	}

	@FXML public void onClickedBtnSalvar(MouseEvent event) throws Exception {	
		System.out.println(textFieldValorBens.getText());
		ProfissaoRepository repository = new ProfissaoRepository();
		Caminhoneiro caminhoneiro = new Caminhoneiro(textFieldCPF.getText(), 
				                   textFieldNome.getText(),
				                   Double.parseDouble(textFieldToneladas.getText().replaceAll("[^0-9]", "")), 
				                   Double.parseDouble(textFieldValorBens.getText().replaceAll("[^0-9]", "")), 
				                   Double.parseDouble(textFieldKmPercorrido.getText().replaceAll("[^0-9]", "")));
		repository.save(caminhoneiro);
		
		textFieldNome.setText("");
		textFieldCPF.setText("");
		textFieldValorBens.setText("");
		textFieldKmPercorrido.setText("");
		textFieldToneladas.setText("");
	}





}
