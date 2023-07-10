package batalha_naval.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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

    private Button[][] buttons1;
    private Button[][] buttons2;
    private String nomeBarco;
    private boolean isvertical = false;
    private Tabuleiro tabuleiro1;
    private Tabuleiro tabuleiro2;
    private boolean isPosicionando = false;
    private ArrayList<Barco> barcos = new ArrayList<Barco>();
    private Posiciona posiciona;
    private int qtdSubmarino = 0;
    private int qtdCouracado = 0;
    private int qtdPortaAviao = 0;
    private boolean isPosInvalida = false;

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

    }

    @FXML
    void ButtonPorta1Clicado(ActionEvent event) {
        nomeBarco = "Portaviao";
        isPosicionando = false;

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
        nomeBarco = "Submarino";
        isPosicionando = false;

    }

    @FXML
    void ButtonSub2Clicado(ActionEvent event) {
        nomeBarco = "Submarino";

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
                // buttons2[i][j].setOnAction(new ButtonClickHandler());
                buttons2[i][j].setOnMouseEntered(new Mouseacima());
                buttons2[i][j].setOnMouseExited(new MouseFora());
                buttons2[i][j].setText("A");
                buttons2[i][j].setTextFill(Color.BLUE);
                buttons2[i][j].setStyle("-fx-background-color: blue;");
                GridPane2.add(buttons2[i][j], j, i); // Inverter a ordem das coordenadas i e j para corresponder à
                                                     // matriz
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
                    if (ehValido(row, col, tabuleiro1) && ehValido(row, col + 1, tabuleiro1)) {
                        System.out.println("Botão clicado: " + row + " " + col);
                        if (buttons1[row][col].isDisable() == false && buttons1[row][col + 1].isDisable() == false) {
                            buttons1[row][col].setText("S");
                            buttons1[row][col + 1].setText("S");
                            buttons1[row][col].setDisable(true);
                            buttons1[row][col + 1].setDisable(true);
                            isPosicionando = true;
                            nomeBarco = "";
                            if (qtdSubmarino < 3) {
                                Submarino sub = new Submarino();
                                barcos.add(sub);
                                posiciona.setTabuleiro(tabuleiro1);
                                posiciona.setSubmarino(sub);
                                posiciona.posicionaBarco(sub, row, col);
                                tabuleiro1.mostrarTabuleiro();
                                qtdSubmarino++;
                            } else {
                                System.out.println("Você já posicionou todos os submarinos");
                            }
                        } else {
                            System.out.println("Posição inválida");
                            isPosInvalida = true;
                        }

                    }

                } else {
                    if (ehValido(row + 1, col, tabuleiro1) && ehValido(row, col, tabuleiro1)) {
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
                    alert.setHeaderText("Você já posicionou todos os porta-aviões");
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
                            if (qtdCouracado < 2) {
                                Couracado cour = new Couracado();
                                barcos.add(cour);
                                posiciona.setTabuleiro(tabuleiro1);
                                posiciona.setCouracado(cour);
                                posiciona.posicionaBarco(cour, row, col);
                                tabuleiro1.mostrarTabuleiro();
                                qtdCouracado++;
                            } else {
                                System.out.println("Você já posicionou todos os couraçados");
                            }
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

    public boolean ehValido(int x, int y, Tabuleiro tabuleiro) {
        if (x < 0 || x > 9 || y < 0 || y > 9 || tabuleiro.getTabuleiro()[x][y] != 0) {
            return false;
        }
        return true;
    }

}