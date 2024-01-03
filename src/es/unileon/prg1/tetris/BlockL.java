package es.unileon.prg1.tetris;
/**
 * Clase que crea un bloqueL extendiendo de la clase Block
 * 
 * @author Mario Arias
 */
public class BlockL extends Block{
    /**
     * Constructor de la clase que crea el bloqueL y le asigna su modelo de pieza
     */
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

    
}
