package es.unileon.prg1.tetris;

public class BlockS extends Block{
    public BlockS() {
        ArrayMxN blockS = new ArrayMxN(2, 3);
        blockS.set(0, 0, 0);
        blockS.set(0, 1, 1);
        blockS.set(0, 2, 1);
        blockS.set(1, 0, 1);
        blockS.set(1, 1, 1);
        blockS.set(1, 2, 0);
        
    }
    
}
