package es.unileon.prg1.tetris;
public class BlockL extends Block{
    
    public BlockL() {
        ArrayMxN blockL = new ArrayMxN(3, 2);
        blockL.set(0, 0, 1);
        blockL.set(0, 1, 0);
        blockL.set(1, 0, 1);
        blockL.set(1, 1, 0);
        blockL.set(2, 0, 1);
        blockL.set(2, 1, 1);
        
    }
}
