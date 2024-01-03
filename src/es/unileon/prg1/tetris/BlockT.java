package es.unileon.prg1.tetris;
/**
 * Clase que crea un bloqueT extendiendo de la clase Block
 * 
 * @author Mario Arias
 */
public class BlockT extends Block{
    /**
     * Constructor de la clase que crea el bloqueT y le asigna su modelo de pieza
     */
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
}