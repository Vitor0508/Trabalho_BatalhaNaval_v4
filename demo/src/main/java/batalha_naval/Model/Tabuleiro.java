package batalha_naval.Model;

public class Tabuleiro {
    private int[][] tabuleiro;
    private Submarino submarino;
    private Couracado couracado;
    private PortaAviao portaAviao;
    private Posiciona posiciona;
    private int valor;

    public Tabuleiro() {
        this.tabuleiro = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.tabuleiro[i][j] = 0;
            }
        }
    }

    public Posiciona getPosiciona() {
        return posiciona;
    }

    public void setPosiciona(Posiciona posiciona) {
        this.posiciona = posiciona;
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(int[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Submarino getSubmarino() {
        return submarino;
    }

    public void setSubmarino(Submarino submarino) {
        this.submarino = submarino;
    }

    public Couracado getCouracado() {
        return couracado;
    }

    public void setCouracado(Couracado couracado) {
        this.couracado = couracado;
    }

    public PortaAviao getPortaAviao() {
        return portaAviao;
    }

    public void setPortaAviao(PortaAviao portaAviao) {
        this.portaAviao = portaAviao;
    }

    public void setBarco(int x, int y, int tipo) {
        this.tabuleiro[x][y] = tipo;
    }

    public int getBarco(int x, int y) {
        return this.tabuleiro[x][y];
    }

    public void setAgua(int x, int y) {
        this.tabuleiro[x][y] = 0;
    }

    public int getAgua(int x, int y) {
        return this.tabuleiro[x][y];
    }

    public void mostrarTabuleiro() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.tabuleiro[i][j] == 0) {
                    System.out.print(tabuleiro[i][j] + " ");
                } else {
                    System.out.print(tabuleiro[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void setTabuleiroHorizontal(int i, int y, int j) {
        System.out.println("i: " + i + " y: " + y);
        System.out.println("j: " + j);
        for (int k = 0; k < j; k++) {
            this.tabuleiro[i][y + k] = j;

        }
    }

    public void setTabuleiroVertical(int i, int y, int j) {
        System.out.println("i: " + i + " y: " + y);
        for (int k = 0; k < j; k++) {
            this.tabuleiro[i + k][y] = j;

        }
    }

}
