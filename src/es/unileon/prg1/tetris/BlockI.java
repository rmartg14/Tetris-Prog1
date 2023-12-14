package es.unileon.prg1.tetris;


public class BlockI extends Block{

    public BlockI() {
        this.bloque = new ArrayMxN(4, 1);
        bloque.set(0, 0, 1);
        bloque.set(1, 0, 1);
        bloque.set(2, 0, 1);
        bloque.set(3, 0, 1);
        this.modelo = new Piece(Color.CYAN, "I");
    }



    public Piece getModelo(){
        return this.modelo;
    }
}