package es.unileon.prg1.tetris;

/**
 * Clase que crea un bloqueI extendiendo de la clase Block
 * 
 * @author Mario Arias
 */
public class BlockI extends Block{
    /**
     * Constructor de la clase que crea el bloqueI y le asigna su modelo de pieza
     */
    public BlockI() {
        this.bloque = new ArrayMxN(4, 1);
        bloque.set(0, 0, 1);
        bloque.set(1, 0, 1);
        bloque.set(2, 0, 1);
        bloque.set(3, 0, 1);
        this.modelo = new Piece(Color.CYAN, "I");
    }



    
}