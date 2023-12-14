package es.unileon.prg1.tetris;

public class BlockL extends Block{
    public BlockL() {
        this.bloque = new ArrayMxN(3, 2);
        bloque.set(0, 0, 1);
        bloque.set(0, 1, 0);
        bloque.set(1, 0, 1);
        bloque.set(1, 1, 0);
        bloque.set(2, 0, 1);
        bloque.set(2, 1, 1);
        this.modelo = new Piece(Color.WHITE, "L");   
    }

    public Piece getModelo(){
        return this.modelo;
    }
}
