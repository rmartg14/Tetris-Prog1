package es.unileon.prg1.tetris;

public class BlockJ extends Block{

    public BlockJ() {
        this.bloque = new ArrayMxN(3, 2);
        bloque.set(0, 0, 0);
        bloque.set(0, 1, 1);
        bloque.set(1, 0, 0);
        bloque.set(1, 1, 1);
        bloque.set(2, 0, 1);
        bloque.set(2, 1, 1);
        this.modelo = new Piece(Color.BLUE, "J");
    }
    
    public Piece getModelo(){
        return this.modelo;
    }
}
