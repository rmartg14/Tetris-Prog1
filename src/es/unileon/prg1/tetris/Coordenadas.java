package es.unileon.prg1.tetris;

public class Coordenadas {
    private int x;
    private int y;

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordenadas() {
        this.x = 0;
        this.y = 0;
    }

    public void moverDerecha(){
        x++;
    }

    public void moverIzquierda(){
        x--;
    }

    public void dropOne(){
        y++;
    }
}
