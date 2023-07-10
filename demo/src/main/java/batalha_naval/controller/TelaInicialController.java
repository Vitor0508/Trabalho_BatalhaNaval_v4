package batalha_naval.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaInicialController implements Initializable {

    @FXML
    private AnchorPane Fundo;

    @FXML
    private Button NovoJogo;

    @FXML
    private Button Sair;

    private Stage stageIniciarJogo;
    //private TelaBatalhaNavalController telaBatalhaNavalController;

    @FXML
    void ButtonNovoJogo(ActionEvent event) {
        if (stageIniciarJogo.getOwner() == null) {
            stageIniciarJogo.initOwner((Stage) Fundo.getScene().getWindow());
            ((Button) event.getSource()).getScene().getWindow().hide();
        }
        stageIniciarJogo.showAndWait();

    }

    @FXML
    void ButtonSair(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Parent parent;
        FXMLLoader fxmlLoader;
        try {
            stageIniciarJogo = new Stage();
            fxmlLoader = new FXMLLoader(getClass().getResource("/resources/poov/telas/TelaBatalhaNaval.fxml"));
            parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            stageIniciarJogo.setScene(scene);
            stageIniciarJogo.setTitle("Batalha Naval");
            stageIniciarJogo.setResizable(false);
            stageIniciarJogo.initModality(Modality.APPLICATION_MODAL);

        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initModality(Modality.WINDOW_MODAL);
            alert.setTitle("ERRO");
            alert.setHeaderText("Erro");
            alert.setContentText("Erro carregando a aplicação!");
            System.out.println(e.getMessage());
            alert.showAndWait();
            // Fecha a aplicação JavaFX
            Platform.exit();
        }
    }

}
