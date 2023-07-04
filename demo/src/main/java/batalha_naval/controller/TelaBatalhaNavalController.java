package batalha_naval.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class TelaBatalhaNavalController implements Initializable {

    @FXML
    private Button ButtonCoura1;

    @FXML
    private Button ButtonCoura2;

    @FXML
    private Button ButtonPorta1;

    @FXML
    private Button ButtonPorta2;

    @FXML
    private Button ButtonPosicionar1;

    @FXML
    private Button ButtonPosicionar2;

    @FXML
    private Button ButtonSub1;

    @FXML
    private Button ButtonSub2;

    @FXML
    private GridPane GridPane1;

    @FXML
    private GridPane GridPane2;

    @FXML
    private Text LabelNomeJogador1;

    @FXML
    private Text LabelTempo;

    @FXML
    private Text NomeJogador1;

    @FXML
    private Text NomeJogador11;

    @FXML
    private Text TituloLabel;

    @FXML
    private Text labelNomeJogador2;

    private Button[][] buttons1;
    private Button[][] buttons2;

    @FXML
    void ButtonCoura1Clicado(ActionEvent event) {

    }

    @FXML
    void ButtonCoura2Clicado(ActionEvent event) {

    }

    @FXML
    void ButtonPorta1Clicado(ActionEvent event) {

    }

    @FXML
    void ButtonPorta2Clicado(ActionEvent event) {

    }

    @FXML
    void ButtonPosicionar2Clicado(ActionEvent event) {

    }

    @FXML
    void ButtonPosicionarClicado1(ActionEvent event) {

    }

    @FXML
    void ButtonSub1Clicado(ActionEvent event) {

    }

    @FXML
    void ButtonSub2Clicado(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttons1 = new Button[10][10];
        buttons2 = new Button[10][10];
        for (int i = 0; i < buttons1.length; i++) {
            for (int j = 0; j < buttons1.length; j++) {
                buttons1[i][j] = new Button();
                buttons1[i][j].setPrefSize(50, 50);
                buttons1[i][j].setOnAction(new ButtonClickHandler());
                buttons1[i][j].setOnMouseEntered(new Mouseacima());
                GridPane1.add(buttons1[i][j], i, j);
            }
        }
        for (int i = 0; i < buttons2.length; i++) {
            for (int j = 0; j < buttons2.length; j++) {
                buttons2[i][j] = new Button();
                buttons2[i][j].setPrefSize(50, 50);
                buttons2[i][j].setOnAction(new ButtonClickHandler());
                buttons2[i][j].setOnMouseEntered(new Mouseacima());
                GridPane2.add(buttons2[i][j], i, j);
            }
        }
    }

    private class ButtonClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Button clickedButton = (Button) event.getSource();
            int row = GridPane.getRowIndex(clickedButton);
            int col = GridPane.getColumnIndex(clickedButton);

        }
    }

   private class Mouseacima implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        Button hoveredButton = (Button) event.getSource();
        int row = GridPane.getRowIndex(hoveredButton);
        int col = GridPane.getColumnIndex(hoveredButton);

        // Realize as ações desejadas quando o mouse é movido sobre o botão
        // Por exemplo, alterar a cor do botão, exibir informações adicionais, etc.
    }
}
}