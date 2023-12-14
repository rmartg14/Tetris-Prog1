package es.unileon.prg1.tetris;

public class BlockT extends Block{
    public BlockT() {
        this. bloque= new ArrayMxN(2, 3);
        bloque.set(0, 0, 1);
        bloque.set(0, 1, 1);
        bloque.set(0, 2, 1);
        bloque.set(1, 0, 0);
        bloque.set(1, 1, 1);
        bloque.set(1, 3, 0);
        this.modelo = new Piece(Color.MAGENTA, "T");
    }


    public Piece getModelo(){
        return this.modelo;
    }
}