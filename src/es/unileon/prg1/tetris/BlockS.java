package es.unileon.prg1.tetris;

public class BlockS extends Block{

    public BlockS() {
        this.bloque = new ArrayMxN(2, 3);
        bloque.set(0, 0, 0);
        bloque.set(0, 1, 1);
        bloque.set(0, 2, 1);
        bloque.set(1, 0, 1);
        bloque.set(1, 1, 1);
        bloque.set(1, 2, 0);
        this.modelo = new Piece(Color.RED, "S");
    }
    
    public Piece getModelo(){
        return this.modelo;
    }
}
