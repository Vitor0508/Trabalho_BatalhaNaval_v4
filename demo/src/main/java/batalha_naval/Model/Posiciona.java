package batalha_naval.Model;

public class Posiciona {
    private int x;
    private int y;
    private Tabuleiro tabuleiro;
    private Submarino submarino;
    private Couracado couracado;
    private PortaAviao portaAviao;

    public Posiciona() {

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

    public Boolean ehValido(int x, int y) {
        if (x < 0 || x > 9 || y < 0 || y > 9) {
            return false;
        }
        if(tabuleiro.getTabuleiro()[x][y] != 0) {
            System.out.println("entrou");
            return false;
        }
        return true;
    }

   public void posicionaBarco(Barco barco, int x, int y) {
    boolean valido = true;
    if (barco instanceof Submarino) {
        for (int i = 0; i < 2; i++) {
            if (!ehValido(x, y + i)) {
               System.out.print("Posição inválida");
               valido = false;
               break;
            }
        }
        if (valido) {
            tabuleiro.setTabuleiroHorizontal(x, y, 2);
            barco.setX(x);
            barco.setY(y);
            barco.setVertical(false);
            barco.setPosicaoPartes();
        }
    } else if (barco instanceof Couracado) {
        for (int i = 0; i < 4; i++) {
            if (!ehValido(x, y+i)) {
                System.out.print("Posição inválida");
                valido = false;
                break;
            }
        }
        if (valido) {
            tabuleiro.setTabuleiroHorizontal(x, y, 4);
            barco.setX(x);
            barco.setY(y);
            barco.setVertical(false);
            barco.setPosicaoPartes();
        }
    } else if (barco instanceof PortaAviao)  {
        for (int i = 0; i < 5; i++) {
            if (!ehValido(x, y+i)) {
                System.out.print("Posição inválida");
                valido = false;
                break;
            }
        }
        if (valido) {
            tabuleiro.setTabuleiroHorizontal(x, y, 5);
            barco.setX(x);
            barco.setY(y);
            barco.setVertical(false);
            barco.setPosicaoPartes();
        }
    }
}

  public void posicionaBarcovertical(Barco barco, int x, int y) {
    boolean valido = true;
    if (barco instanceof Submarino) {
        for (int i = 0; i < 2; i++) {
            if (!ehValido(x+i, y)) {
               System.out.print("Posição inválida");
               valido = false;
               break;
            }
        }
        if (valido) {
            tabuleiro.setTabuleiroVertical(x, y, 2);
            barco.setX(x);
            barco.setY(y);
            barco.setVertical(true);
            barco.setPosicaoPartes();

        }
    } else if (barco instanceof Couracado) {
        for (int i = 0; i < 4; i++) {
            if (!ehValido(x+i, y)) {
                System.out.print("Posição inválida");
                valido = false;
                break;
            }
        }
        if (valido) {
            tabuleiro.setTabuleiroVertical(x, y, 4);
            barco.setX(x);
            barco.setY(y);
            barco.setVertical(true);
            barco.setPosicaoPartes();
        }
    } else if (barco instanceof PortaAviao) {
        for (int i = 0; i < 5; i++) {
            if (!ehValido(x+i, y)) {
                System.out.print("Posição inválida");
                valido = false;
                break;
            }
        }
        if (valido) {
            tabuleiro.setTabuleiroVertical(x, y, 5);
            barco.setX(x);
            barco.setY(y);
            barco.setVertical(true);
            barco.setPosicaoPartes();
        }
    }
}



    // public Posiciona(int x, int y, Tabuleiro tabuleiro, Submarino submarino,
    // Couracado couracado, PortaAviao portaAviao) {
    // this.x = x;
    // this.y = y;
    // this.tabuleiro = tabuleiro;
    // this.submarino = submarino;
    // this.couracado = couracado;
    // this.portaAviao = portaAviao;
    // }

}