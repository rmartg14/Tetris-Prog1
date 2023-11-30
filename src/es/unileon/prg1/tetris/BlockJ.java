package es.unileon.prg1.tetris;

public class BlockJ extends Block{
    
    public BlockJ() {
        ArrayMxN blockJ = new ArrayMxN(3, 2);
        blockJ.set(0, 0, 0);
        blockJ.set(0, 1, 1);
        blockJ.set(1, 0, 0);
        blockJ.set(1, 1, 1);
        blockJ.set(2, 0, 1);
        blockJ.set(2, 1, 1);
        
    }
}
