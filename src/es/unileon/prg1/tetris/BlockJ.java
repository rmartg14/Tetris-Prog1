package es.unileon.prg1.tetris;
//crear private Piece modelo; como este hecho en la clase Block y un método getModelo que devuelva
//this.modelo en todas las clases de los bloques
public class BlockJ extends Block{
    private ArrayMxN blockJ;
    public BlockJ() {
        blockJ = new ArrayMxN(3, 2);
        blockJ.set(0, 0, 0);
        blockJ.set(0, 1, 1);
        blockJ.set(1, 0, 0);
        blockJ.set(1, 1, 1);
        blockJ.set(2, 0, 1);
        blockJ.set(2, 1, 1);
        
    }
}
