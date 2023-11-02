package es.unileon.prg1.tetris;

import es.unileon.prg1.tetris.strategy.ColorStrategySingleton;

public class Piece {

    private Color color;
    private String sign;

    public Piece() {
        this.color = Color.NONE;
        this.sign = "  ";
    }

    public Piece(Color color, String sign) {
        this.color = color;
        this.sign = sign + " ";
    }

    public Piece(Piece another){
        this.color = another.getColor();
        this.sign = another.getSign();
    }

    public Color getColor() {
        return this.color;
    }

    public String getSign() {
        return this.sign;
    }

    public boolean isEmpty() {
        return this.sign.trim().length() == 0;
    }

    public String toString() {
        return ColorStrategySingleton.getInstance().toString(this);
    }

}