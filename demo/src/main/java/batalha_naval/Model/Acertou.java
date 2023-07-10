package batalha_naval.Model;


import java.util.ArrayList;

public class Acertou {
    private int x;
    private int y;
    private Tabuleiro tabuleiro;
    private ArrayList<Barco> barcos;

    public Acertou() {

    }

    public Acertou(int x, int y, Tabuleiro tabuleiro) {
        this.x = x;
        this.y = y;
        this.tabuleiro = tabuleiro;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    /*
     * public boolean acertou(int x, int y) {
     * if (tabuleiro.getTabuleiro()[x][y] != 0) {
     * System.out.println("Acertou");
     * 
     * switch (tabuleiro.getTabuleiro()[x][y]) {
     * case 2:
     * for (Barco barco : barcos) {
     * for (int i = 0; i < barco.getTamanho(); i++) {
     * if (barco.getPosicaoPartes()[i][0] == x && barco.getPosicaoPartes()[i][1] ==
     * y) {
     * barco.setPartes(barco.getPartes() - 1);
     * System.out.println("Partes: " + barco.getPartes());
     * }
     * }
     * if (barco.getPartes() == 0) {
     * barco.setAfundado(true);
     * System.out.println("Afundou");
     * }
     * }
     * break;
     * case 4:
     * // System.out.println("teste");
     * for (Barco barco : barcos) {
     * for (int i = 0; i < barco.getTamanho(); i++) {
     * if (barco.getPosicaoPartes()[i][0] == x && barco.getPosicaoPartes()[i][1] ==
     * y) {
     * barco.setPartes(barco.getPartes() - 1);
     * System.out.println("Partes: " + barco.getPartes());
     * }
     * }
     * if (barco.getPartes() == 0) {
     * barco.setAfundado(true);
     * System.out.println("Afundou");
     * }
     * }
     * break;
     * case 5:
     * System.out.println("Porta Aviao");
     * for (Barco barco : barcos) {
     * for (int i = 0; i < barco.getTamanho(); i++) {
     * if (barco.getPosicaoPartes()[i][0] == x && barco.getPosicaoPartes()[i][1] ==
     * y) {
     * barco.setPartes(barco.getPartes() - 1);
     * System.out.println("Partes: " + barco.getPartes());
     * }
     * }
     * if (barco.getPartes() == 0) {
     * barco.setAfundado(true);
     * System.out.println("Afundou");
     * }
     * }
     * break;
     * default:
     * System.out.println("Erro");
     * break;
     * }
     * tabuleiro.getTabuleiro()[x][y] = -1;
     * return true;
     * } else {
     * tabuleiro.getTabuleiro()[x][y] = -1;
     * System.out.println("Errou");
     * return false;
     * 
     * }
     * }
     */

    public int acertou(int x, int y) {
        int retorno = -1;
        if (tabuleiro.getTabuleiro()[x][y] != 0) {
            System.out.println("Acertou");
            switch (tabuleiro.getTabuleiro()[x][y]) {
                case 2:
                    for (Barco barco : barcos) {
                        for (int i = 0; i < barco.getTamanho(); i++) {
                            if (barco.getPosicaoPartes()[i][0] == x && barco.getPosicaoPartes()[i][1] == y) {
                                barco.setPartes(barco.getPartes() - 1);
                                System.out.println("Partes: " + barco.getPartes());
                                tabuleiro.getTabuleiro()[x][y] = -1;
                                retorno = 2;
                            }
                        }
                        if (barco.getPartes() == 0 && barco.isAfundado() == false) {
                            barco.setAfundado(true);
                            System.out.println("Afundou");
                            tabuleiro.getTabuleiro()[x][y] = -1;
                            retorno = 3;
                        }
                    }
                    return retorno;

                case 4:
                    System.out.println("Couraçado");
                    for (Barco barco : barcos) {
                        for (int i = 0; i < barco.getTamanho(); i++) {
                            if (barco.getPosicaoPartes()[i][0] == x && barco.getPosicaoPartes()[i][1] == y) {
                                barco.setPartes(barco.getPartes() - 1);
                                System.out.println("Partes: " + barco.getPartes());
                                tabuleiro.getTabuleiro()[x][y] = -1;
                                retorno = 4;
                            }
                        }
                        if (barco.getPartes() == 0 && barco.isAfundado() == false) {
                            barco.setAfundado(true);
                            System.out.println("Afundou");
                            tabuleiro.getTabuleiro()[x][y] = -1;
                            retorno = 5;
                        }
                    }
                    return retorno;

                case 5:
                    System.out.println("Porta Aviao");
                    for (Barco barco : barcos) {
                        for (int i = 0; i < barco.getTamanho(); i++) {
                            if (barco.getPosicaoPartes()[i][0] == x && barco.getPosicaoPartes()[i][1] == y) {
                                barco.setPartes(barco.getPartes() - 1);
                                System.out.println("Partes: " + barco.getPartes());
                                tabuleiro.getTabuleiro()[x][y] = -1;
                                retorno = 6;
                            }
                        }
                        if (barco.getPartes() == 0 && barco.isAfundado() == false) {
                            barco.setAfundado(true);
                            System.out.println("Afundou");
                            tabuleiro.getTabuleiro()[x][y] = -1;
                            retorno = 7;
                        }
                    }
                    return retorno;
            }
            tabuleiro.getTabuleiro()[x][y] = -1;
        }
        else{
            tabuleiro.getTabuleiro()[x][y] = -1;
        }

        return retorno;

    }

    public ArrayList<Barco> getBarcos() {
        return barcos;
    }

    public void setBarcos(ArrayList<Barco> barcos) {
        this.barcos = barcos;
    }

}