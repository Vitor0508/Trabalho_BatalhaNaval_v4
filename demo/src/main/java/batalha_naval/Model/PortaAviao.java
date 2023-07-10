package batalha_naval.Model;

public class PortaAviao extends Barco {
    static final int tamanho = 5;
    private int partes = 5;
    private boolean vertical = false;

    private int posicaoPartes[][] = new int[5][2];

    // posicao inicial
    private int x;
    private int y;

    // static final int quantidade = 1;
    static final String nome = "PortaAviao";

    public int getTamanho() {
        return tamanho;
    }

    public String getNome() {
        return nome;
    }

    public PortaAviao() {
        super();
    }

    public int getPartes() {
        return partes;
    }

    public void setPartes(int partes) {
        this.partes = partes;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
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

    public int[][] getPosicaoPartes() {
        return posicaoPartes;
    }

    public void setPosicaoPartes() {
        if (!this.vertical) {
            for (int i = 0; i < this.tamanho; i++) {
                this.posicaoPartes[i][0] = this.x;
                this.posicaoPartes[i][1] = this.y + i;
            }
        } else {
            for (int i = 0; i < this.tamanho; i++) {
                this.posicaoPartes[i][0] = this.x + i;
                this.posicaoPartes[i][1] = this.y;
            }
        }
    }

    
    
}