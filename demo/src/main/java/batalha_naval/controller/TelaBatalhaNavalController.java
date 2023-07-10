package batalha_naval.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import batalha_naval.Model.Acertou;
import batalha_naval.Model.Barco;
import batalha_naval.Model.Couracado;
import batalha_naval.Model.PortaAviao;
import batalha_naval.Model.Posiciona;
import batalha_naval.Model.Submarino;
import batalha_naval.Model.Tabuleiro;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
    private Button ButtonIsVertical;

    @FXML
    private Text labelNomeJogador2;

    @FXML
    private Button ButtonReiniciar;

    private Button[][] buttons1;
    private Button[][] buttons2;
    private String nomeBarco;
    private boolean isvertical = false;
    private Tabuleiro tabuleiro1;
    private Tabuleiro tabuleiro2;
    private boolean isPosicionando = false;
    private ArrayList<Barco> barcos = new ArrayList<Barco>();
    private ArrayList<Barco> barcos2 = new ArrayList<Barco>();
    private Posiciona posiciona;
    private int qtdSubmarino = 0;
    private int qtdCouracado = 0;
    private int qtdPortaAviao = 0;
    private boolean isPosInvalida = false;
    private Acertou acertou1;
    private Acertou acertou2;
    private int barcosAfundados1 = 0;
    private int barcosAfundados2 = 0;
    private int vez = 0;

    @FXML
    void ButtonIsVerticalClicado(ActionEvent event) {
        if (isvertical) {
            isvertical = false;
        } else {
            isvertical = true;
        }

    }

    @FXML
    void ButtonCoura1Clicado(ActionEvent event) {
        nomeBarco = "Couracado";
        isPosicionando = false;

    }

    @FXML
    void ButtonCoura2Clicado(ActionEvent event) {
        nomeBarco = "Couracado";
        isPosicionando = false;

    }

    @FXML
    void ButtonPorta1Clicado(ActionEvent event) {
        nomeBarco = "Portaviao";
        isPosicionando = false;

    }

    @FXML
    void ButtonPorta2Clicado(ActionEvent event) {
        nomeBarco = "Portaviao";
        isPosicionando = false;

    }

    @FXML
    void ButtonReiniciarClicado(ActionEvent event) {
        nomeBarco = "";
        isvertical = false;
        isPosicionando = false;
        qtdSubmarino = 0;
        qtdCouracado = 0;
        qtdPortaAviao = 0;
        isPosInvalida = false;
        barcosAfundados1 = 0;
        barcosAfundados2 = 0;
        vez = 0;
        barcos.clear();
        barcos2.clear();
        
        

        buttons1 = new Button[10][10];
        buttons2 = new Button[10][10];
        tabuleiro1 = new Tabuleiro();
        tabuleiro2 = new Tabuleiro();
        posiciona = new Posiciona();
        for (int i = 0; i < buttons1.length; i++) {
            for (int j = 0; j < buttons1[i].length; j++) { // Corrigir a condição de parada do loop interno
                buttons1[i][j] = new Button();
                buttons1[i][j].setPrefSize(50, 50);
                buttons1[i][j].setOnAction(new ButtonClickHandler1());
                buttons1[i][j].setOnMouseEntered(new Mouseacima());
                buttons1[i][j].setOnMouseExited(new MouseFora());
                buttons1[i][j].setText("A");
                buttons1[i][j].setTextFill(Color.BLUE);
                buttons1[i][j].setStyle("-fx-background-color: blue;");
                GridPane1.add(buttons1[i][j], j, i); // Inverter a ordem das coordenadas i e j para corresponder à
                                                     // matriz
            }
        }
        for (int i = 0; i < buttons2.length; i++) {
            for (int j = 0; j < buttons2[i].length; j++) { // Corrigir a condição de parada do loop interno
                buttons2[i][j] = new Button();
                buttons2[i][j].setPrefSize(50, 50);
                buttons2[i][j].setOnAction(new ButtonClickHandler2());
                buttons2[i][j].setDisable(true);
                buttons2[i][j].setOnMouseEntered(new Mouseacima2());
                buttons2[i][j].setOnMouseExited(new MouseFora2());
                buttons2[i][j].setText("A");
                buttons2[i][j].setTextFill(Color.BLUE);
                buttons2[i][j].setStyle("-fx-background-color: blue;");
                GridPane2.add(buttons2[i][j], j, i); // Inverter a ordem das coordenadas i e j para corresponder à
                                                     // matriz
            }
        }

        // Show or hide buttons as needed
        ButtonReiniciar.setVisible(false);
        GridPane1.setVisible(true);
        GridPane1.setDisable(false);
        ButtonPosicionar1.setVisible(false);
        ButtonPosicionar2.setVisible(false);
        ButtonPosicionar1.setDisable(true);
        ButtonPosicionar2.setDisable(true);
        ButtonCoura1.setVisible(true);
        ButtonCoura2.setVisible(true);
        ButtonPorta1.setVisible(true);
        ButtonPorta2.setVisible(true);
        ButtonSub1.setVisible(true);
        ButtonSub2.setVisible(true);
        ButtonCoura1.setDisable(false);
        ButtonCoura2.setDisable(false);
        ButtonPorta1.setDisable(false);
        ButtonPorta2.setDisable(false);
        ButtonSub1.setDisable(false);
        ButtonSub2.setDisable(false);
        ButtonIsVertical.setDisable(false);
        ButtonIsVertical.setVisible(true);
    
        acertou1 = new Acertou();
        acertou2 = new Acertou();
        


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Batalha Naval");
        alert.setHeaderText("Jogo reiniciado");
        alert.setContentText("O jogo foi reiniciado com sucesso!");
        alert.showAndWait();
    }

    @FXML
    void ButtonPosicionar2Clicado(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Batalha Naval");
        alert.setHeaderText("Jogo Irá começar");
        alert.setContentText("O jogo irá começar, boa sorte!");
        alert.showAndWait();
        for (int i = 0; i < buttons1.length; i++) {
            for (int j = 0; j < buttons1[i].length; j++) {
                buttons1[i][j].setStyle("-fx-background-color: blue;");
                buttons1[i][j].setTextFill(Color.BLUE);
                buttons1[i][j].setDisable(false);
                buttons2[i][j].setStyle("-fx-background-color: blue;");
                buttons2[i][j].setTextFill(Color.BLUE);
                buttons2[i][j].setDisable(false);
                buttons1[i][j].setOnAction(new ButtonAtirarClick());
                buttons2[i][j].setOnAction(new ButtonAtirarClick());
            }
        }
        ButtonPosicionar1.setVisible(false);
        ButtonPosicionar2.setVisible(false);
        ButtonPosicionar1.setDisable(true);
        ButtonPosicionar2.setDisable(true);
        ButtonCoura1.setVisible(false);
        ButtonCoura2.setVisible(false);
        ButtonPorta1.setVisible(false);
        ButtonPorta2.setVisible(false);
        ButtonSub1.setVisible(false);
        ButtonSub2.setVisible(false);
        ButtonIsVertical.setVisible(false);
        acertou1 = new Acertou();
        acertou2 = new Acertou();
        acertou1.setTabuleiro(tabuleiro1);
        acertou2.setTabuleiro(tabuleiro2);
        acertou1.setBarcos(barcos);
        acertou2.setBarcos(barcos2);

    }

    @FXML
    void ButtonPosicionarClicado1(ActionEvent event) {
        for (int i = 0; i < buttons1.length; i++) {
            for (int j = 0; j < buttons1[i].length; j++) {
                buttons1[i][j].setStyle("-fx-background-color: blue;");
                buttons1[i][j].setTextFill(Color.BLUE);
                buttons1[i][j].setDisable(true);
                buttons2[i][j].setDisable(false);
            }
        }
        qtdCouracado = 0;
        qtdPortaAviao = 0;
        qtdSubmarino = 0;
        ButtonPosicionar1.setDisable(true);
        ButtonPosicionar1.setVisible(true);

    }

    @FXML
    void ButtonSub1Clicado(ActionEvent event) {
        nomeBarco = "Submarino";
        isPosicionando = false;

    }

    @FXML
    void ButtonSub2Clicado(ActionEvent event) {
        nomeBarco = "Submarino";
        isPosicionando = false;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttons1 = new Button[10][10];
        buttons2 = new Button[10][10];
        tabuleiro1 = new Tabuleiro();
        tabuleiro2 = new Tabuleiro();
        posiciona = new Posiciona();
        for (int i = 0; i < buttons1.length; i++) {
            for (int j = 0; j < buttons1[i].length; j++) { // Corrigir a condição de parada do loop interno
                buttons1[i][j] = new Button();
                buttons1[i][j].setPrefSize(50, 50);
                buttons1[i][j].setOnAction(new ButtonClickHandler1());
                buttons1[i][j].setOnMouseEntered(new Mouseacima());
                buttons1[i][j].setOnMouseExited(new MouseFora());
                buttons1[i][j].setText("A");
                buttons1[i][j].setTextFill(Color.BLUE);
                buttons1[i][j].setStyle("-fx-background-color: blue;");
                GridPane1.add(buttons1[i][j], j, i); // Inverter a ordem das coordenadas i e j para corresponder à
                                                     // matriz
            }
        }
        for (int i = 0; i < buttons2.length; i++) {
            for (int j = 0; j < buttons2[i].length; j++) { // Corrigir a condição de parada do loop interno
                buttons2[i][j] = new Button();
                buttons2[i][j].setPrefSize(50, 50);
                buttons2[i][j].setOnAction(new ButtonClickHandler2());
                buttons2[i][j].setDisable(true);
                buttons2[i][j].setOnMouseEntered(new Mouseacima2());
                buttons2[i][j].setOnMouseExited(new MouseFora2());
                buttons2[i][j].setText("A");
                buttons2[i][j].setTextFill(Color.BLUE);
                buttons2[i][j].setStyle("-fx-background-color: blue;");
                GridPane2.add(buttons2[i][j], j, i); // Inverter a ordem das coordenadas i e j para corresponder à
                                                     // matriz
            }
        }
    }

    private class ButtonAtirarClick implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Button clickedButton = (Button) event.getSource();
            int row = GridPane.getRowIndex(clickedButton);
            int col = GridPane.getColumnIndex(clickedButton);
            if (barcosAfundados1 != 6 || barcosAfundados2 != 6) {
                if (vez % 2 == 0) {
                    GridPane1.setDisable(true);
                    GridPane2.setDisable(false);
                    int val = acertou1.acertou(row, col);
                    if (val == 2) {
                        clickedButton.setStyle("-fx-background-color: red;");
                        clickedButton.setTextFill(Color.BLACK);
                        clickedButton.setDisable(true);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Acertou submarino");
                        alert.setHeaderText("Acertou submarino");
                        alert.setContentText("Acertou submarino");
                        alert.showAndWait();

                    }
                    if (val == 3) {
                        System.out.println("Afundou sub");
                        clickedButton.setStyle("-fx-background-color: red;");
                        clickedButton.setTextFill(Color.BLACK);
                        clickedButton.setDisable(true);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Afundou submarino");
                        alert.setHeaderText("Afundou submarino");
                        alert.setContentText("Afundou submarino");
                        barcosAfundados1++;
                        alert.showAndWait();
                    }
                    if (val == 4) {
                        System.out.println("Acertou coura");
                        clickedButton.setStyle("-fx-background-color: red;");
                        clickedButton.setTextFill(Color.BLACK);
                        clickedButton.setDisable(true);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Acertou Couracado");
                        alert.setHeaderText("Acertou Couracado");
                        alert.setContentText("Acertou Couracado");
                        alert.showAndWait();
                    }
                    if (val == 5) {
                        System.out.println("Afundou coura");
                        clickedButton.setStyle("-fx-background-color: red;");
                        clickedButton.setTextFill(Color.BLACK);
                        clickedButton.setDisable(true);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Afundou Couracado");
                        alert.setHeaderText("Afundou Couracado");
                        alert.setContentText("Afundou Couracado");
                        barcosAfundados1++;
                        alert.showAndWait();
                    }
                    if (val == 6) {
                        System.out.println("Acertou Porta avião");
                        clickedButton.setStyle("-fx-background-color: red;");
                        clickedButton.setTextFill(Color.BLACK);
                        clickedButton.setDisable(true);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Acertou Porta aviao");
                        alert.setHeaderText("Acertou Porta aviao");
                        alert.setContentText("Acertou Porta aviao");
                        alert.showAndWait();
                    }

                    if (val == 7) {
                        System.out.println("Afundou porta");
                        clickedButton.setStyle("-fx-background-color: red;");
                        clickedButton.setTextFill(Color.BLACK);
                        clickedButton.setDisable(true);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Afundou Porta aviao");
                        alert.setHeaderText("Afundou Porta aviao");
                        alert.setContentText("Afundou Porta aviao");
                        barcosAfundados1++;
                        alert.showAndWait();
                    }

                    if (val == -1) {
                        clickedButton.setStyle("-fx-background-color: white;");
                        clickedButton.setTextFill(Color.BLACK);
                        clickedButton.setDisable(true);
                    }
                    tabuleiro1.mostrarTabuleiro();
                }
                if (vez % 2 != 0) {
                    int val = acertou2.acertou(row, col);
                    GridPane1.setDisable(false);
                    GridPane2.setDisable(true);
                    if (val == 2) {
                        clickedButton.setStyle("-fx-background-color: red;");
                        clickedButton.setTextFill(Color.BLACK);
                        clickedButton.setDisable(true);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Acertou submarino");
                        alert.setHeaderText("Acertou submarino");
                        alert.setContentText("Acertou submarino");
                        alert.showAndWait();

                    }
                    if (val == 3) {
                        System.out.println("Afundou sub");
                        clickedButton.setStyle("-fx-background-color: red;");
                        clickedButton.setTextFill(Color.BLACK);
                        clickedButton.setDisable(true);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Afundou submarino");
                        alert.setHeaderText("Afundou submarino");
                        alert.setContentText("Afundou submarino");
                        barcosAfundados2++;
                        alert.showAndWait();
                    }
                    if (val == 4) {
                        System.out.println("Acertou coura");
                        clickedButton.setStyle("-fx-background-color: red;");
                        clickedButton.setTextFill(Color.BLACK);
                        clickedButton.setDisable(true);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Acertou Couracado");
                        alert.setHeaderText("Acertou Couracado");
                        alert.setContentText("Acertou Couracado");
                        alert.showAndWait();
                    }
                    if (val == 5) {
                        System.out.println("Afundou coura");
                        clickedButton.setStyle("-fx-background-color: red;");
                        clickedButton.setTextFill(Color.BLACK);
                        clickedButton.setDisable(true);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Afundou Couracado");
                        alert.setHeaderText("Afundou Couracado");
                        alert.setContentText("Afundou Couracado");
                        barcosAfundados2++;
                        alert.showAndWait();
                    }
                    if (val == 6) {
                        System.out.println("Acertou Porta avião");
                        clickedButton.setStyle("-fx-background-color: red;");
                        clickedButton.setTextFill(Color.BLACK);
                        clickedButton.setDisable(true);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Acertou Porta aviao");
                        alert.setHeaderText("Acertou Porta aviao");
                        alert.setContentText("Acertou Porta aviao");
                        alert.showAndWait();
                    }

                    if (val == 7) {
                        System.out.println("Afundou porta");
                        clickedButton.setStyle("-fx-background-color: red;");
                        clickedButton.setTextFill(Color.BLACK);
                        clickedButton.setDisable(true);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Afundou Porta aviao");
                        alert.setHeaderText("Afundou Porta aviao");
                        alert.setContentText("Afundou Porta aviao");
                        barcosAfundados2++;
                        alert.showAndWait();
                    }

                    if (val == -1) {
                        clickedButton.setStyle("-fx-background-color: white;");
                        clickedButton.setTextFill(Color.BLACK);
                        clickedButton.setDisable(true);
                    }
                    tabuleiro1.mostrarTabuleiro();
                }
                vez++;
            }
            if (barcosAfundados1 == 6) {
                GridPane1.setDisable(true);
                GridPane2.setDisable(true);
                ButtonReiniciar.setVisible(true);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Fim de jogo");
                alert.setHeaderText("Fim de jogo");
                alert.setContentText("Jogador 2 venceu");
                alert.showAndWait();
            }
            if (barcosAfundados2 == 6) {
                GridPane1.setDisable(true);
                GridPane2.setDisable(true);
                ButtonReiniciar.setVisible(true);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Fim de jogo");
                alert.setHeaderText("Fim de jogo");
                alert.setContentText("Jogador 1 venceu");
                alert.showAndWait();
            }

        }

    }

    private class ButtonClickHandler1 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Button clickedButton = (Button) event.getSource();
            int row = GridPane.getRowIndex(clickedButton);
            int col = GridPane.getColumnIndex(clickedButton);
            if (nomeBarco == "Submarino") {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro1) && ehValido(row, col + 1, tabuleiro1) && qtdSubmarino < 3) {
                        System.out.println("Botão clicado: " + row + " " + col);
                        if (buttons1[row][col].isDisable() == false && buttons1[row][col + 1].isDisable() == false) {
                            buttons1[row][col].setText("S");
                            buttons1[row][col + 1].setText("S");
                            buttons1[row][col].setDisable(true);
                            buttons1[row][col + 1].setDisable(true);
                            isPosicionando = true;
                            nomeBarco = "";
                            Submarino sub = new Submarino();
                            barcos.add(sub);
                            posiciona.setTabuleiro(tabuleiro1);
                            posiciona.setSubmarino(sub);
                            posiciona.posicionaBarco(sub, row, col);
                            tabuleiro1.mostrarTabuleiro();
                            qtdSubmarino++;

                        } else {
                            System.out.println("Posição inválida");
                            isPosInvalida = true;
                        }

                    }

                } else {
                    if (ehValido(row + 1, col, tabuleiro1) && ehValido(row, col, tabuleiro1) && qtdSubmarino < 3) {
                        if (buttons1[row][col].isDisable() == false && buttons1[row + 1][col].isDisable() == false) {
                            buttons1[row][col].setText("S");
                            buttons1[row + 1][col].setText("S");
                            buttons1[row][col].setDisable(true);
                            buttons1[row + 1][col].setDisable(true);
                            isPosicionando = true;
                            nomeBarco = "";
                            Submarino sub = new Submarino();
                            barcos.add(sub);
                            posiciona.setTabuleiro(tabuleiro1);
                            posiciona.setSubmarino(sub);
                            posiciona.posicionaBarcovertical(sub, row, col);
                            tabuleiro1.mostrarTabuleiro();
                            qtdSubmarino++;

                        }
                    } else {
                        System.out.println("Posição inválida");
                        isPosInvalida = true;
                    }

                }
                if (qtdSubmarino == 3) {
                    ButtonSub1.setDisable(true);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Aviso");
                    alert.setHeaderText("Você já posicionou todos os Submarinos");
                    alert.showAndWait();

                }
            }
            if (nomeBarco == "Couracado") {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro1) && ehValido(row, col + 1, tabuleiro1)
                            && ehValido(row, col + 2, tabuleiro1) && ehValido(row, col + 3, tabuleiro1)
                            && qtdCouracado < 2) {
                        System.out.println("Botão clicado: " + row + " " + col);
                        if (buttons1[row][col].isDisable() == false && buttons1[row][col + 1].isDisable() == false
                                && buttons1[row][col + 2].isDisable() == false
                                && buttons1[row][col + 3].isDisable() == false) {
                            buttons1[row][col].setText("C");
                            buttons1[row][col + 1].setText("C");
                            buttons1[row][col + 2].setText("C");
                            buttons1[row][col + 3].setText("C");
                            buttons1[row][col].setDisable(true);
                            buttons1[row][col + 1].setDisable(true);
                            buttons1[row][col + 2].setDisable(true);
                            buttons1[row][col + 3].setDisable(true);
                            isPosicionando = true;
                            nomeBarco = "";
                            Couracado cour = new Couracado();
                            barcos.add(cour);
                            posiciona.setTabuleiro(tabuleiro1);
                            posiciona.setCouracado(cour);
                            posiciona.posicionaBarco(cour, row, col);
                            tabuleiro1.mostrarTabuleiro();
                            qtdCouracado++;
                        } else {
                            System.out.println("Posição inválida");
                            isPosInvalida = true;
                        }

                    }

                } else {
                    if (ehValido(row + 1, col, tabuleiro1) && ehValido(row, col, tabuleiro1)
                            && ehValido(row + 2, col, tabuleiro1) && ehValido(row + 3, col, tabuleiro1)
                            && qtdCouracado < 2) {
                        if (buttons1[row][col].isDisable() == false && buttons1[row + 1][col].isDisable() == false
                                && buttons1[row + 2][col].isDisable() == false
                                && buttons1[row + 3][col].isDisable() == false) {
                            buttons1[row][col].setText("C");
                            buttons1[row + 1][col].setText("C");
                            buttons1[row + 2][col].setText("C");
                            buttons1[row + 3][col].setText("C");
                            buttons1[row][col].setDisable(true);
                            buttons1[row + 1][col].setDisable(true);
                            buttons1[row + 2][col].setDisable(true);
                            buttons1[row + 3][col].setDisable(true);
                            isPosicionando = true;
                            nomeBarco = "";
                            Couracado cour = new Couracado();
                            barcos.add(cour);
                            posiciona.setTabuleiro(tabuleiro1);
                            posiciona.setCouracado(cour);
                            posiciona.posicionaBarcovertical(cour, row, col);
                            tabuleiro1.mostrarTabuleiro();
                            qtdCouracado++;

                        } else {
                            System.out.println("Posição inválida");
                            isPosInvalida = true;
                        }
                    }
                }
                if (qtdCouracado == 2) {
                    ButtonCoura1.setDisable(true);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Aviso");
                    alert.setHeaderText("Você já posicionou todos os Couraçados");
                    alert.showAndWait();

                }
            }
            if (nomeBarco == "Portaviao") {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro1) && ehValido(row, col + 1, tabuleiro1)
                            && ehValido(row, col + 2, tabuleiro1) && ehValido(row, col + 3, tabuleiro1)
                            && ehValido(row, col + 4, tabuleiro1) && qtdPortaAviao < 1) {
                        System.out.println("Botão clicado: " + row + " " + col);
                        if (buttons1[row][col].isDisable() == false && buttons1[row][col + 1].isDisable() == false
                                && buttons1[row][col + 2].isDisable() == false
                                && buttons1[row][col + 3].isDisable() == false
                                && buttons1[row][col + 4].isDisable() == false) {
                            buttons1[row][col].setText("P");
                            buttons1[row][col + 1].setText("P");
                            buttons1[row][col + 2].setText("P");
                            buttons1[row][col + 3].setText("P");
                            buttons1[row][col + 4].setText("P");
                            buttons1[row][col].setDisable(true);
                            buttons1[row][col + 1].setDisable(true);
                            buttons1[row][col + 2].setDisable(true);
                            buttons1[row][col + 3].setDisable(true);
                            buttons1[row][col + 4].setDisable(true);
                            isPosicionando = true;
                            nomeBarco = "";
                            PortaAviao porta = new PortaAviao();
                            barcos.add(porta);
                            posiciona.setTabuleiro(tabuleiro1);
                            posiciona.setPortaAviao(porta);
                            posiciona.posicionaBarco(porta, row, col);
                            tabuleiro1.mostrarTabuleiro();
                            qtdPortaAviao++;
                        } else {
                            System.out.println("Posição inválida");
                            isPosInvalida = true;
                        }
                    }
                } else {
                    if (ehValido(row + 1, col, tabuleiro1) && ehValido(row, col, tabuleiro1)
                            && ehValido(row + 2, col, tabuleiro1) && ehValido(row + 3, col, tabuleiro1)
                            && ehValido(row + 4, col, tabuleiro1) && qtdPortaAviao < 1) {
                        if (buttons1[row][col].isDisable() == false && buttons1[row + 1][col].isDisable() == false
                                && buttons1[row + 2][col].isDisable() == false
                                && buttons1[row + 3][col].isDisable() == false
                                && buttons1[row + 4][col].isDisable() == false) {
                            buttons1[row][col].setText("P");
                            buttons1[row + 1][col].setText("P");
                            buttons1[row + 2][col].setText("P");
                            buttons1[row + 3][col].setText("P");
                            buttons1[row + 4][col].setText("P");
                            buttons1[row][col].setDisable(true);
                            buttons1[row + 1][col].setDisable(true);
                            buttons1[row + 2][col].setDisable(true);
                            buttons1[row + 3][col].setDisable(true);
                            buttons1[row + 4][col].setDisable(true);
                            isPosicionando = true;
                            nomeBarco = "";
                            PortaAviao porta = new PortaAviao();
                            barcos.add(porta);
                            posiciona.setTabuleiro(tabuleiro1);
                            posiciona.setPortaAviao(porta);
                            posiciona.posicionaBarcovertical(porta, row, col);
                            tabuleiro1.mostrarTabuleiro();
                            qtdPortaAviao++;
                        } else {
                            System.out.println("Posição inválida");
                            isPosInvalida = true;
                        }
                    }
                }
                if (qtdPortaAviao == 1) {
                    ButtonPorta1.setDisable(true);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Aviso");
                    alert.setHeaderText("Você já posicionou todos os porta-aviões");
                    alert.showAndWait();

                }
            }
            if (qtdSubmarino == 3 && qtdCouracado == 2 && qtdPortaAviao == 1) {
                ButtonPosicionar1.setVisible(true);

            }
        }

    }

    private class ButtonClickHandler2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Button clickedButton = (Button) event.getSource();
            int row = GridPane.getRowIndex(clickedButton);
            int col = GridPane.getColumnIndex(clickedButton);
            if (nomeBarco == "Submarino") {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro2) && ehValido(row, col + 1, tabuleiro2) && qtdSubmarino < 3) {
                        System.out.println("Botão clicado: " + row + " " + col);
                        if (buttons2[row][col].isDisable() == false && buttons2[row][col + 1].isDisable() == false) {
                            buttons2[row][col].setText("S");
                            buttons2[row][col + 1].setText("S");
                            buttons2[row][col].setDisable(true);
                            buttons2[row][col + 1].setDisable(true);
                            isPosicionando = true;
                            nomeBarco = "";
                            Submarino sub = new Submarino();
                            barcos2.add(sub);
                            posiciona.setTabuleiro(tabuleiro2);
                            posiciona.setSubmarino(sub);
                            posiciona.posicionaBarco(sub, row, col);
                            tabuleiro2.mostrarTabuleiro();
                            qtdSubmarino++;

                        } else {
                            System.out.println("Posição inválida");
                            isPosInvalida = true;
                        }

                    }

                } else {
                    if (ehValido(row + 1, col, tabuleiro2) && ehValido(row, col, tabuleiro2) && qtdSubmarino < 3) {
                        if (buttons2[row][col].isDisable() == false && buttons2[row + 1][col].isDisable() == false) {
                            buttons2[row][col].setText("S");
                            buttons2[row + 1][col].setText("S");
                            buttons2[row][col].setDisable(true);
                            buttons2[row + 1][col].setDisable(true);
                            isPosicionando = true;
                            nomeBarco = "";
                            Submarino sub = new Submarino();
                            barcos2.add(sub);
                            posiciona.setTabuleiro(tabuleiro2);
                            posiciona.setSubmarino(sub);
                            posiciona.posicionaBarcovertical(sub, row, col);
                            tabuleiro2.mostrarTabuleiro();
                            qtdSubmarino++;

                        }
                    } else {
                        System.out.println("Posição inválida");
                        isPosInvalida = true;
                    }

                }
                if (qtdSubmarino == 3) {
                    ButtonSub2.setDisable(true);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Aviso");
                    alert.setHeaderText("Você já posicionou todos os Submarinos");
                    alert.showAndWait();

                }
            }
            if (nomeBarco == "Couracado") {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro2) && ehValido(row, col + 1, tabuleiro2)
                            && ehValido(row, col + 2, tabuleiro2) && ehValido(row, col + 3, tabuleiro2)
                            && qtdCouracado < 2) {
                        System.out.println("Botão clicado: " + row + " " + col);
                        if (buttons2[row][col].isDisable() == false && buttons2[row][col + 1].isDisable() == false
                                && buttons2[row][col + 2].isDisable() == false
                                && buttons2[row][col + 3].isDisable() == false) {
                            buttons2[row][col].setText("C");
                            buttons2[row][col + 1].setText("C");
                            buttons2[row][col + 2].setText("C");
                            buttons2[row][col + 3].setText("C");
                            buttons2[row][col].setDisable(true);
                            buttons2[row][col + 1].setDisable(true);
                            buttons2[row][col + 2].setDisable(true);
                            buttons2[row][col + 3].setDisable(true);
                            isPosicionando = true;
                            nomeBarco = "";
                            Couracado cour = new Couracado();
                            barcos2.add(cour);
                            posiciona.setTabuleiro(tabuleiro2);
                            posiciona.setCouracado(cour);
                            posiciona.posicionaBarco(cour, row, col);
                            tabuleiro2.mostrarTabuleiro();
                            qtdCouracado++;

                        } else {
                            System.out.println("Posição inválida");
                            isPosInvalida = true;
                        }

                    }

                } else {
                    if (ehValido(row + 1, col, tabuleiro2) && ehValido(row, col, tabuleiro2)
                            && ehValido(row + 2, col, tabuleiro2) && ehValido(row + 3, col, tabuleiro2)
                            && qtdCouracado < 2) {
                        if (buttons2[row][col].isDisable() == false && buttons2[row + 1][col].isDisable() == false
                                && buttons2[row + 2][col].isDisable() == false
                                && buttons2[row + 3][col].isDisable() == false) {
                            buttons2[row][col].setText("C");
                            buttons2[row + 1][col].setText("C");
                            buttons2[row + 2][col].setText("C");
                            buttons2[row + 3][col].setText("C");
                            buttons2[row][col].setDisable(true);
                            buttons2[row + 1][col].setDisable(true);
                            buttons2[row + 2][col].setDisable(true);
                            buttons2[row + 3][col].setDisable(true);
                            isPosicionando = true;
                            nomeBarco = "";
                            Couracado cour = new Couracado();
                            barcos2.add(cour);
                            posiciona.setTabuleiro(tabuleiro2);
                            posiciona.setCouracado(cour);
                            posiciona.posicionaBarcovertical(cour, row, col);
                            tabuleiro2.mostrarTabuleiro();
                            qtdCouracado++;

                        } else {
                            System.out.println("Posição inválida");
                            isPosInvalida = true;
                        }
                    }
                }
                if (qtdCouracado == 2) {
                    ButtonCoura2.setDisable(true);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Aviso");
                    alert.setHeaderText("Você já posicionou todos os Couraçados");
                    alert.showAndWait();

                }
            }
            if (nomeBarco == "Portaviao") {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro2) && ehValido(row, col + 1, tabuleiro2)
                            && ehValido(row, col + 2, tabuleiro2) && ehValido(row, col + 3, tabuleiro2)
                            && ehValido(row, col + 4, tabuleiro2) && qtdPortaAviao < 1) {
                        System.out.println("Botão clicado: " + row + " " + col);
                        if (buttons2[row][col].isDisable() == false && buttons2[row][col + 1].isDisable() == false
                                && buttons2[row][col + 2].isDisable() == false
                                && buttons2[row][col + 3].isDisable() == false
                                && buttons2[row][col + 4].isDisable() == false) {
                            buttons2[row][col].setText("P");
                            buttons2[row][col + 1].setText("P");
                            buttons2[row][col + 2].setText("P");
                            buttons2[row][col + 3].setText("P");
                            buttons2[row][col + 4].setText("P");
                            buttons2[row][col].setDisable(true);
                            buttons2[row][col + 1].setDisable(true);
                            buttons2[row][col + 2].setDisable(true);
                            buttons2[row][col + 3].setDisable(true);
                            buttons2[row][col + 4].setDisable(true);
                            isPosicionando = true;
                            nomeBarco = "";
                            PortaAviao porta = new PortaAviao();
                            barcos2.add(porta);
                            posiciona.setTabuleiro(tabuleiro2);
                            posiciona.setPortaAviao(porta);
                            posiciona.posicionaBarco(porta, row, col);
                            tabuleiro2.mostrarTabuleiro();
                            qtdPortaAviao++;
                        } else {
                            System.out.println("Posição inválida");
                            isPosInvalida = true;
                        }
                    }
                } else {
                    if (ehValido(row + 1, col, tabuleiro2) && ehValido(row, col, tabuleiro2)
                            && ehValido(row + 2, col, tabuleiro2) && ehValido(row + 3, col, tabuleiro2)
                            && ehValido(row + 4, col, tabuleiro2) && qtdPortaAviao < 1) {
                        if (buttons2[row][col].isDisable() == false && buttons2[row + 1][col].isDisable() == false
                                && buttons2[row + 2][col].isDisable() == false
                                && buttons2[row + 3][col].isDisable() == false
                                && buttons2[row + 4][col].isDisable() == false) {
                            buttons2[row][col].setText("P");
                            buttons2[row + 1][col].setText("P");
                            buttons2[row + 2][col].setText("P");
                            buttons2[row + 3][col].setText("P");
                            buttons2[row + 4][col].setText("P");
                            buttons2[row][col].setDisable(true);
                            buttons2[row + 1][col].setDisable(true);
                            buttons2[row + 2][col].setDisable(true);
                            buttons2[row + 3][col].setDisable(true);
                            buttons2[row + 4][col].setDisable(true);
                            isPosicionando = true;
                            nomeBarco = "";
                            PortaAviao porta = new PortaAviao();
                            barcos2.add(porta);
                            posiciona.setTabuleiro(tabuleiro2);
                            posiciona.setPortaAviao(porta);
                            posiciona.posicionaBarcovertical(porta, row, col);
                            tabuleiro2.mostrarTabuleiro();
                            qtdPortaAviao++;
                        } else {
                            System.out.println("Posição inválida");
                            isPosInvalida = true;
                        }
                    }
                }
                if (qtdPortaAviao == 1) {
                    ButtonPorta2.setDisable(true);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Aviso");
                    alert.setHeaderText("Você já posicionou todos os porta-aviões");
                    alert.showAndWait();

                }
            }
            if (qtdSubmarino == 3 && qtdCouracado == 2 && qtdPortaAviao == 1) {
                ButtonPosicionar2.setVisible(true);
            }
        }
    }

    private class Mouseacima implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            Button hoveredButton = (Button) event.getSource();
            int row = GridPane.getRowIndex(hoveredButton);
            int col = GridPane.getColumnIndex(hoveredButton);
            if (nomeBarco == "Submarino" && !isPosicionando) {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro1) && ehValido(row, col + 1, tabuleiro1)) {
                        if (buttons1[row][col].isDisable() == false && buttons1[row][col + 1].isDisable() == false) {
                            buttons1[row][col].setStyle("-fx-background-color: red;");
                            buttons1[row][col + 1].setStyle("-fx-background-color: red;");
                        }
                    } else {
                        System.out.println("Posição inválida");
                    }
                } else {
                    if (ehValido(row, col, tabuleiro1) && ehValido(row + 1, col, tabuleiro1)) {
                        if (buttons1[row][col].isDisable() == false && buttons1[row + 1][col].isDisable() == false) {
                            buttons1[row][col].setStyle("-fx-background-color: red;");
                            buttons1[row + 1][col].setStyle("-fx-background-color: red;");
                        }
                    } else {
                        System.out.println("Posição inválida");
                    }
                }
            }
            if (nomeBarco == "Couracado" && !isPosicionando) {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro1) && ehValido(row, col + 1, tabuleiro1)
                            && ehValido(row, col + 2, tabuleiro1) && ehValido(row, col + 3, tabuleiro1)) {
                        buttons1[row][col].setStyle("-fx-background-color: red;");
                        buttons1[row][col + 1].setStyle("-fx-background-color: red;");
                        buttons1[row][col + 2].setStyle("-fx-background-color: red;");
                        buttons1[row][col + 3].setStyle("-fx-background-color: red;");
                    }
                } else {
                    if (ehValido(row + 1, col, tabuleiro1) && ehValido(row, col, tabuleiro1)
                            && ehValido(row + 2, col, tabuleiro1) && ehValido(row + 3, col, tabuleiro1)) {
                        buttons1[row][col].setStyle("-fx-background-color: red;");
                        buttons1[row + 1][col].setStyle("-fx-background-color: red;");
                        buttons1[row + 2][col].setStyle("-fx-background-color: red;");
                        buttons1[row + 3][col].setStyle("-fx-background-color: red;");
                    }

                }
            }
            if (nomeBarco == "Portaviao" && !isPosicionando) {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro1) && ehValido(row, col + 1, tabuleiro1)
                            && ehValido(row, col + 2, tabuleiro1) && ehValido(row, col + 3, tabuleiro1)
                            && ehValido(row, col + 4, tabuleiro1)) {
                        buttons1[row][col].setStyle("-fx-background-color: red;");
                        buttons1[row][col + 1].setStyle("-fx-background-color: red;");
                        buttons1[row][col + 2].setStyle("-fx-background-color: red;");
                        buttons1[row][col + 3].setStyle("-fx-background-color: red;");
                        buttons1[row][col + 4].setStyle("-fx-background-color: red;");
                    }
                } else {
                    if (ehValido(row + 1, col, tabuleiro1) && ehValido(row, col, tabuleiro1)
                            && ehValido(row + 2, col, tabuleiro1) && ehValido(row + 3, col, tabuleiro1)
                            && ehValido(row + 4, col, tabuleiro1)) {
                        buttons1[row][col].setStyle("-fx-background-color: red;");
                        buttons1[row + 1][col].setStyle("-fx-background-color: red;");
                        buttons1[row + 2][col].setStyle("-fx-background-color: red;");
                        buttons1[row + 3][col].setStyle("-fx-background-color: red;");
                        buttons1[row + 4][col].setStyle("-fx-background-color: red;");
                    }

                }
            }

        }

    }

    private class Mouseacima2 implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            Button hoveredButton = (Button) event.getSource();
            int row = GridPane.getRowIndex(hoveredButton);
            int col = GridPane.getColumnIndex(hoveredButton);
            if (nomeBarco == "Submarino" && !isPosicionando) {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro2) && ehValido(row, col + 1, tabuleiro2)) {
                        if (buttons2[row][col].isDisable() == false && buttons2[row][col + 1].isDisable() == false) {
                            buttons2[row][col].setStyle("-fx-background-color: red;");
                            buttons2[row][col + 1].setStyle("-fx-background-color: red;");
                        }
                    } else {
                        System.out.println("Posição inválida");
                    }
                } else {
                    if (ehValido(row, col, tabuleiro2) && ehValido(row + 1, col, tabuleiro2)) {
                        if (buttons2[row][col].isDisable() == false && buttons2[row + 1][col].isDisable() == false) {
                            buttons2[row][col].setStyle("-fx-background-color: red;");
                            buttons2[row + 1][col].setStyle("-fx-background-color: red;");
                        }
                    } else {
                        System.out.println("Posição inválida");
                    }
                }
            }
            if (nomeBarco == "Couracado" && !isPosicionando) {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro2) && ehValido(row, col + 1, tabuleiro2)
                            && ehValido(row, col + 2, tabuleiro2) && ehValido(row, col + 3, tabuleiro2)) {
                        buttons2[row][col].setStyle("-fx-background-color: red;");
                        buttons2[row][col + 1].setStyle("-fx-background-color: red;");
                        buttons2[row][col + 2].setStyle("-fx-background-color: red;");
                        buttons2[row][col + 3].setStyle("-fx-background-color: red;");
                    }
                } else {
                    if (ehValido(row + 1, col, tabuleiro2) && ehValido(row, col, tabuleiro2)
                            && ehValido(row + 2, col, tabuleiro2) && ehValido(row + 3, col, tabuleiro2)) {
                        buttons2[row][col].setStyle("-fx-background-color: red;");
                        buttons2[row + 1][col].setStyle("-fx-background-color: red;");
                        buttons2[row + 2][col].setStyle("-fx-background-color: red;");
                        buttons2[row + 3][col].setStyle("-fx-background-color: red;");
                    }

                }
            }
            if (nomeBarco == "Portaviao" && !isPosicionando) {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro2) && ehValido(row, col + 1, tabuleiro2)
                            && ehValido(row, col + 2, tabuleiro2) && ehValido(row, col + 3, tabuleiro2)
                            && ehValido(row, col + 4, tabuleiro2)) {
                        buttons2[row][col].setStyle("-fx-background-color: red;");
                        buttons2[row][col + 1].setStyle("-fx-background-color: red;");
                        buttons2[row][col + 2].setStyle("-fx-background-color: red;");
                        buttons2[row][col + 3].setStyle("-fx-background-color: red;");
                        buttons2[row][col + 4].setStyle("-fx-background-color: red;");
                    }
                } else {
                    if (ehValido(row + 1, col, tabuleiro2) && ehValido(row, col, tabuleiro2)
                            && ehValido(row + 2, col, tabuleiro2) && ehValido(row + 3, col, tabuleiro2)
                            && ehValido(row + 4, col, tabuleiro2)) {
                        buttons2[row][col].setStyle("-fx-background-color: red;");
                        buttons2[row + 1][col].setStyle("-fx-background-color: red;");
                        buttons2[row + 2][col].setStyle("-fx-background-color: red;");
                        buttons2[row + 3][col].setStyle("-fx-background-color: red;");
                        buttons2[row + 4][col].setStyle("-fx-background-color: red;");
                    }
                }
            }
        }
    }

    private class MouseFora implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            Button hoveredButton = (Button) event.getSource();
            int row = GridPane.getRowIndex(hoveredButton);
            int col = GridPane.getColumnIndex(hoveredButton);
            if (nomeBarco == "Submarino" && !isPosicionando) {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro1) && ehValido(row, col + 1, tabuleiro1)) {
                        if (!buttons1[row][col].isDisable() && !buttons1[row][col + 1].isDisable()) {
                            buttons1[row][col].setStyle("-fx-background-color: blue;");
                            buttons1[row][col + 1].setStyle("-fx-background-color: blue;");
                        }
                    } else {
                        System.out.println("Posição inválida");
                    }
                } else {
                    if (ehValido(row, col, tabuleiro1) && ehValido(row + 1, col, tabuleiro1)) {
                        if (!buttons1[row][col].isDisable() && !buttons1[row + 1][col].isDisable()) {
                            buttons1[row][col].setStyle("-fx-background-color: blue;");
                            buttons1[row + 1][col].setStyle("-fx-background-color: blue;");
                        }
                    } else {
                        System.out.println("Posição inválida");
                    }
                }
            }
            if (nomeBarco == "Couracado" && !isPosicionando) {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro1) && ehValido(row, col + 1, tabuleiro1)
                            && ehValido(row, col + 2, tabuleiro1) && ehValido(row, col + 3, tabuleiro1)) {
                        buttons1[row][col].setStyle("-fx-background-color: blue;");
                        buttons1[row][col + 1].setStyle("-fx-background-color: blue;");
                        buttons1[row][col + 2].setStyle("-fx-background-color: blue;");
                        buttons1[row][col + 3].setStyle("-fx-background-color: blue;");
                    }
                } else {
                    if (ehValido(row + 1, col, tabuleiro1) && ehValido(row, col, tabuleiro1)
                            && ehValido(row + 2, col, tabuleiro1) && ehValido(row + 3, col, tabuleiro1)) {
                        buttons1[row][col].setStyle("-fx-background-color: blue;");
                        buttons1[row + 1][col].setStyle("-fx-background-color: blue;");
                        buttons1[row + 2][col].setStyle("-fx-background-color: blue;");
                        buttons1[row + 3][col].setStyle("-fx-background-color: blue;");
                    }
                }
            }
            if (nomeBarco == "Portaviao" && !isPosicionando) {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro1) && ehValido(row, col + 1, tabuleiro1)
                            && ehValido(row, col + 2, tabuleiro1) && ehValido(row, col + 3, tabuleiro1)
                            && ehValido(row, col + 4, tabuleiro1)) {
                        buttons1[row][col].setStyle("-fx-background-color: blue;");
                        buttons1[row][col + 1].setStyle("-fx-background-color: blue;");
                        buttons1[row][col + 2].setStyle("-fx-background-color: blue;");
                        buttons1[row][col + 3].setStyle("-fx-background-color: blue;");
                        buttons1[row][col + 4].setStyle("-fx-background-color: blue;");
                    }
                } else {
                    if (ehValido(row + 1, col, tabuleiro1) && ehValido(row, col, tabuleiro1)
                            && ehValido(row + 2, col, tabuleiro1) && ehValido(row + 3, col, tabuleiro1)
                            && ehValido(row + 4, col, tabuleiro1)) {
                        buttons1[row][col].setStyle("-fx-background-color: blue;");
                        buttons1[row + 1][col].setStyle("-fx-background-color: blue;");
                        buttons1[row + 2][col].setStyle("-fx-background-color: blue;");
                        buttons1[row + 3][col].setStyle("-fx-background-color: blue;");
                        buttons1[row + 4][col].setStyle("-fx-background-color: blue;");
                    }
                }
            }

            // Realize as ações desejadas quando o mouse é movido sobre o botão
            // Por exemplo, alterar a cor do botão, exibir informações adicionais, etc.
        }
    }

    private class MouseFora2 implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            Button hoveredButton = (Button) event.getSource();
            int row = GridPane.getRowIndex(hoveredButton);
            int col = GridPane.getColumnIndex(hoveredButton);
            if (nomeBarco == "Submarino" && !isPosicionando) {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro2) && ehValido(row, col + 1, tabuleiro2)) {
                        if (!buttons2[row][col].isDisable() && !buttons2[row][col + 1].isDisable()) {
                            buttons2[row][col].setStyle("-fx-background-color: blue;");
                            buttons2[row][col + 1].setStyle("-fx-background-color: blue;");
                        }
                    } else {
                        System.out.println("Posição inválida");
                    }
                } else {
                    if (ehValido(row, col, tabuleiro2) && ehValido(row + 1, col, tabuleiro2)) {
                        if (!buttons2[row][col].isDisable() && !buttons2[row + 1][col].isDisable()) {
                            buttons2[row][col].setStyle("-fx-background-color: blue;");
                            buttons2[row + 1][col].setStyle("-fx-background-color: blue;");
                        }
                    } else {
                        System.out.println("Posição inválida");
                    }
                }
            }
            if (nomeBarco == "Couracado" && !isPosicionando) {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro2) && ehValido(row, col + 1, tabuleiro2)
                            && ehValido(row, col + 2, tabuleiro2) && ehValido(row, col + 3, tabuleiro2)) {
                        buttons2[row][col].setStyle("-fx-background-color: blue;");
                        buttons2[row][col + 1].setStyle("-fx-background-color: blue;");
                        buttons2[row][col + 2].setStyle("-fx-background-color: blue;");
                        buttons2[row][col + 3].setStyle("-fx-background-color: blue;");
                    }
                } else {
                    if (ehValido(row + 1, col, tabuleiro2) && ehValido(row, col, tabuleiro2)
                            && ehValido(row + 2, col, tabuleiro2) && ehValido(row + 3, col, tabuleiro2)) {
                        buttons2[row][col].setStyle("-fx-background-color: blue;");
                        buttons2[row + 1][col].setStyle("-fx-background-color: blue;");
                        buttons2[row + 2][col].setStyle("-fx-background-color: blue;");
                        buttons2[row + 3][col].setStyle("-fx-background-color: blue;");
                    }
                }
            }
            if (nomeBarco == "Portaviao" && !isPosicionando) {
                if (isvertical) {
                    if (ehValido(row, col, tabuleiro2) && ehValido(row, col + 1, tabuleiro2)
                            && ehValido(row, col + 2, tabuleiro2) && ehValido(row, col + 3, tabuleiro2)
                            && ehValido(row, col + 4, tabuleiro2)) {
                        buttons2[row][col].setStyle("-fx-background-color: blue;");
                        buttons2[row][col + 1].setStyle("-fx-background-color: blue;");
                        buttons2[row][col + 2].setStyle("-fx-background-color: blue;");
                        buttons2[row][col + 3].setStyle("-fx-background-color: blue;");
                        buttons2[row][col + 4].setStyle("-fx-background-color: blue;");
                    }
                } else {
                    if (ehValido(row + 1, col, tabuleiro2) && ehValido(row, col, tabuleiro2)
                            && ehValido(row + 2, col, tabuleiro2) && ehValido(row + 3, col, tabuleiro2)
                            && ehValido(row + 4, col, tabuleiro2)) {
                        buttons2[row][col].setStyle("-fx-background-color: blue;");
                        buttons2[row + 1][col].setStyle("-fx-background-color: blue;");
                        buttons2[row + 2][col].setStyle("-fx-background-color: blue;");
                        buttons2[row + 3][col].setStyle("-fx-background-color: blue;");
                        buttons2[row + 4][col].setStyle("-fx-background-color: blue;");
                    }
                }
            }

            // Realize as ações desejadas quando o mouse sai do botão
            // Por exemplo, alterar a cor do botão de volta ao estado original, etc.
        }
    }

    public boolean ehValido(int x, int y, Tabuleiro tabuleiro) {
        if (x < 0 || x > 9 || y < 0 || y > 9 || tabuleiro.getTabuleiro()[x][y] != 0) {
            return false;
        }
        return true;
    }

}