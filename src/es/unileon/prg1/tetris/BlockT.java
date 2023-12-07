package es.unileon.prg1.tetris;
//crear private Piece modelo; como este hecho en la clase Block y un método getModelo que devuelva
//this.modelo en todas las clases de los bloques

public class BlockT extends Block{
    ArrayMxN blockT;
    public BlockT() {
        blockT = new ArrayMxN(2, 3);
        blockT.set(0, 0, 1);
        blockT.set(0, 1, 1);
        blockT.set(0, 2, 1);
        blockT.set(1, 0, 0);
        blockT.set(1, 1, 1);
        blockT.set(1, 3, 0);
        
    }
}