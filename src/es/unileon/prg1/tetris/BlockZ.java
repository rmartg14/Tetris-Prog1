package es.unileon.prg1.tetris;

public class BlockZ extends Block{
    public BlockZ() {
        ArrayMxN blockZ = new ArrayMxN(2, 3);
        blockZ.set(0, 0, 1);
        blockZ.set(0, 1, 1);
        blockZ.set(0, 2, 0);
        blockZ.set(1, 0, 0);
        blockZ.set(1, 1, 1);
        blockZ.set(1, 3, 1);
        
    }
}
