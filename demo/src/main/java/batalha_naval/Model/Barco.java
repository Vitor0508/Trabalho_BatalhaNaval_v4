package batalha_naval.Model;

public abstract class Barco {
    private boolean afundado;

    public boolean isAfundado() {
        return afundado;
    }

    public void setAfundado(boolean afundado) {
        this.afundado = afundado;
    }

    public abstract int getTamanho();

    public abstract String getNome();

    public abstract int[] getPartes();

    public abstract void setPartes(int[] partes);

    public abstract boolean isVertical();

    public abstract void setVertical(boolean vertical);

    public abstract int getX();

    public abstract void setX(int x);

    public abstract int getY();

    public abstract void setY(int y);

}
