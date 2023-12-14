package es.unileon.prg1.tetris;

public class BlockZ extends Block{
    public BlockZ() {
        this.bloque = new ArrayMxN(2, 3);
        bloque.set(0, 0, 1);
        bloque.set(0, 1, 1);
        bloque.set(0, 2, 0);
        bloque.set(1, 0, 0);
        bloque.set(1, 1, 1);
        bloque.set(1, 2, 1);
        this.modelo = new Piece(Color.GREEN, "Z");
    }
    
    public Piece getModelo(){
        return this.modelo;
    }
}
