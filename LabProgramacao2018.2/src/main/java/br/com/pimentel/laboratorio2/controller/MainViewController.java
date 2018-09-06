package br.com.pimentel.laboratorio2.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.pimentel.laboratorio2.business.CaminhoneiroBusiness;
import br.com.pimentel.laboratorio2.business.MedicoBusiness;
import br.com.pimentel.laboratorio2.business.ProfessorBusiness;
import br.com.pimentel.laboratorio2.business.TaxistaBusiness;
import br.com.pimentel.laboratorio2.model.MaskFieldUtil;
import br.com.pimentel.laboratorio2.model.Profissao;
import br.com.pimentel.laboratorio2.repository.ProfissaoRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class MainViewController implements Initializable{

	@FXML Tab tabCadastrarContribuintes;
	@FXML ComboBox<String> comboBoxProfissao;
	@FXML Tab tabCalcularImpostos;
	@FXML Pane paneProfissao;
	@FXML Button btnPesquisar;
	@FXML TextField textfieldCalcularImpostosRendaAnual;
	@FXML TextField textfieldCalcularImpostosDescontos;
	@FXML TextField textfieldCalcularImpostosImpostoDevido;
	@FXML Label labelMalhaFina;
	@FXML TextField textfieldPesquisar;
	@FXML TextField textfieldCalcularImpostosNome;
	@FXML TextField textfieldCalcularImpostosCPF;
	@FXML Tab tabListaMalhaFina;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comboBoxProfissao.getItems().addAll("Professor","Caminhoneiro","Medico","Taxista");
		MaskFieldUtil.cpfField(textfieldPesquisar);
		
	}

	@FXML public void onActionComboboxProfissao(ActionEvent event) throws IOException {			
		paneProfissao.getChildren().clear();
		Parent node = FXMLLoader.load(getClass().getResource("/FXML/View" + 
				comboBoxProfissao.getSelectionModel().getSelectedItem()+".fxml"));
		paneProfissao.getChildren().add(node);
	}

	@FXML public void onClikedBtnPesquisar(MouseEvent event) {		
		ProfissaoRepository repository = new ProfissaoRepository();
		Profissao profissao;
		Double impostoDevido;
		
		profissao = repository.findById(textfieldPesquisar.getText());
		String profissaoTipo = profissao.getClass().toString().substring(41);
		
		switch (profissaoTipo) {
		case "Medico":
			MedicoBusiness medicoBusiness = new MedicoBusiness();
			textfieldCalcularImpostosRendaAnual.setText("R$ " + medicoBusiness.calculaRendaAnual(profissao).toString() + "0");
			textfieldCalcularImpostosCPF.setText(textfieldPesquisar.getText());
			textfieldCalcularImpostosDescontos.setText("R$ " + medicoBusiness.calculaDescontoIR(profissao).toString() + "0");
			textfieldCalcularImpostosNome.setText(profissao.getNome());
			impostoDevido = medicoBusiness.calculaIR(profissao);
			if (impostoDevido <= 0) {
				textfieldCalcularImpostosImpostoDevido.setText("R$ 0,00");
			}else {
				textfieldCalcularImpostosImpostoDevido.setText("R$ " + impostoDevido + "0");
			}
			if (medicoBusiness.calculaMalhaFina(profissao)) {
				labelMalhaFina.setText("============= MALHA FINA =============");
			}else {
				labelMalhaFina.setText("############# SITUAÇÃO OK #############");
			}
			break;
		case "Taxista":
			TaxistaBusiness taxistaBusiness = new TaxistaBusiness();
			textfieldCalcularImpostosRendaAnual.setText("R$ " + taxistaBusiness.calculaRendaAnual(profissao).toString() + "0");
			textfieldCalcularImpostosCPF.setText(textfieldPesquisar.getText());
			textfieldCalcularImpostosDescontos.setText("R$ " + taxistaBusiness.calculaDescontoIR(profissao).toString() + "0");
			textfieldCalcularImpostosNome.setText(profissao.getNome());
			impostoDevido = taxistaBusiness.calculaIR(profissao);
			if (impostoDevido <= 0) {
				textfieldCalcularImpostosImpostoDevido.setText("R$ 0,00");
			}else {
				textfieldCalcularImpostosImpostoDevido.setText("R$ " + impostoDevido + "0");
			}
			if (taxistaBusiness.calculaMalhaFina(profissao)) {
				labelMalhaFina.setText("============= MALHA FINA =============");
			}else {
				labelMalhaFina.setText("############# SITUAÇÃO OK #############");
			}
			break;
		case "Professor":
			ProfessorBusiness professorBusiness = new ProfessorBusiness();
			textfieldCalcularImpostosRendaAnual.setText("R$ " + professorBusiness.calculaRendaAnual(profissao).toString() + "0");
			textfieldCalcularImpostosCPF.setText(textfieldPesquisar.getText());
			textfieldCalcularImpostosDescontos.setText("R$ " + professorBusiness.calculaDescontoIR(profissao).toString() + "0");
			textfieldCalcularImpostosNome.setText(profissao.getNome());
			impostoDevido = professorBusiness.calculaIR(profissao);
			if (impostoDevido <= 0) {
				textfieldCalcularImpostosImpostoDevido.setText("R$ 0,00");
			}else {
				textfieldCalcularImpostosImpostoDevido.setText("R$ " + impostoDevido + "0");
			}
			if (professorBusiness.calculaMalhaFina(profissao)) {
				labelMalhaFina.setText("============= MALHA FINA =============");
			}else {
				labelMalhaFina.setText("############# SITUAÇÃO OK #############");
			}
		case "Caminhoneiro":
			CaminhoneiroBusiness caminhoneiroBusiness = new CaminhoneiroBusiness();
			textfieldCalcularImpostosRendaAnual.setText("R$ " + caminhoneiroBusiness.calculaRendaAnual(profissao).toString() + "0");
			textfieldCalcularImpostosCPF.setText(textfieldPesquisar.getText());
			textfieldCalcularImpostosDescontos.setText("R$ " + caminhoneiroBusiness.calculaDescontoIR(profissao).toString() + "0");
			textfieldCalcularImpostosNome.setText(profissao.getNome());
			impostoDevido = caminhoneiroBusiness.calculaIR(profissao);
			if (impostoDevido <= 0) {
				textfieldCalcularImpostosImpostoDevido.setText("R$ 0,00");
			}else {
				textfieldCalcularImpostosImpostoDevido.setText("R$ " + impostoDevido + "0");
			}
			if (caminhoneiroBusiness.calculaMalhaFina(profissao)) {
				labelMalhaFina.setText("============= MALHA FINA =============");
			}else {
				labelMalhaFina.setText("############# SITUAÇÃO OK #############");
			}
			break;
		default:
			break;
		}
		
	}

}
