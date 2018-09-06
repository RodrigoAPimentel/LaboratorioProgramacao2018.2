package br.com.pimentel.laboratorio2.view;

import java.io.IOException;

import br.com.pimentel.laboratorio2.MeuSistemaSimplesDeTributacao;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageController {
	
	private static StageController stageController = null;
    private Stage stage;

    private StageController(Stage stage) {
        this.stage = stage;
    }

    public static StageController instance(Stage stage) {
        if (stageController == null) {
        	stageController = new StageController(stage);
        }
        return stageController;
    }

    public Stage getStage() {
        return this.stage;
    }

    public void loadNewStage(String fxml) throws IOException {
    	FXMLLoader fxmlLoad = new FXMLLoader();
    	fxmlLoad.setLocation(MeuSistemaSimplesDeTributacao.class.getResource("/FXML/"+fxml+".fxml"));
        if (stage != null) {
            Parent root = fxmlLoad.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
//            Util.janelaMaximizada(stage);
            stage.show();
        }
    }

}
