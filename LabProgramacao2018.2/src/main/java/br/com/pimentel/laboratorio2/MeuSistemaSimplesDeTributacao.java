package br.com.pimentel.laboratorio2;

import br.com.pimentel.laboratorio2.view.StageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MeuSistemaSimplesDeTributacao extends Application {

	private StageController stageController;

	@Override
	public void start(Stage stage) throws Exception {
		this.stageController = StageController.instance(stage);
		Parent root = null;
		Scene scene;
		
		stage.centerOnScreen();	
		root = FXMLLoader.load(getClass().getResource("/FXML/MainView.fxml"));
		
		scene = new Scene(root);
		scene.setFill(null);

		stageController.getStage().setScene(scene);
		stageController.getStage().show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
