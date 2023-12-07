package es.unileon.prg1.tetris;
//crear private Piece modelo; como este hecho en la clase Block y un método getModelo que devuelva
//this.modelo en todas las clases de los bloques

public class BlockZ extends Block{
    private ArrayMxN blockZ;
    public BlockZ() {
        blockZ = new ArrayMxN(2, 3);
        blockZ.set(0, 0, 1);
        blockZ.set(0, 1, 1);
        blockZ.set(0, 2, 0);
        blockZ.set(1, 0, 0);
        blockZ.set(1, 1, 1);
        blockZ.set(1, 3, 1);
        
    }
}
