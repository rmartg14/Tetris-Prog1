package es.unileon.prg1.tetris;
//crear private Piece modelo; como este hecho en la clase Block y un método getModelo que devuelva
//this.modelo en todas las clases de los bloques
public class BlockL extends Block{
    private ArrayMxN blockL;
    public BlockL() {
        blockL = new ArrayMxN(3, 2);
        blockL.set(0, 0, 1);
        blockL.set(0, 1, 0);
        blockL.set(1, 0, 1);
        blockL.set(1, 1, 0);
        blockL.set(2, 0, 1);
        blockL.set(2, 1, 1);
        
    }
}
