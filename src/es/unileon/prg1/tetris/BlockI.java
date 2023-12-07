package es.unileon.prg1.tetris;
//crear private Piece modelo; como este hecho en la clase Block y un método getModelo que devuelva
//this.modelo en todas las clases de los bloques
public class BlockI extends Block{
    private ArrayMxN blockI;
    public BlockI() {
        blockI = new ArrayMxN(4, 1);
        blockI.set(0, 0, 1);
        blockI.set(1, 0, 1);
        blockI.set(2, 0, 1);
        blockI.set(3, 0, 1);
        
    }

}