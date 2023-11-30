package es.unileon.prg1.tetris;

public class BlockT extends Block{
    public BlockT() {
        ArrayMxN blockT = new ArrayMxN(2, 3);
        blockT.set(0, 0, 1);
        blockT.set(0, 1, 1);
        blockT.set(0, 2, 1);
        blockT.set(1, 0, 0);
        blockT.set(1, 1, 1);
        blockT.set(1, 3, 0);
        
    }
}