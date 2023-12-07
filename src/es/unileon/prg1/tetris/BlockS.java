package es.unileon.prg1.tetris;
//crear private Piece modelo; como este hecho en la clase Block y un método getModelo que devuelva
//this.modelo en todas las clases de los bloques
public class BlockS extends Block{
    ArrayMxN blockS;
    public BlockS() {
        blockS = new ArrayMxN(2, 3);
        blockS.set(0, 0, 0);
        blockS.set(0, 1, 1);
        blockS.set(0, 2, 1);
        blockS.set(1, 0, 1);
        blockS.set(1, 1, 1);
        blockS.set(1, 2, 0);
        
    }
    
}
