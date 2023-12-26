package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlockJTest {
    private BlockJ blockJ;

    @Before
    public void setUp(){
        this.blockJ = new BlockJ();
    }

    @Test
    public void blockJTest(){
        assertEquals("  J \n" + "  J \n" + "J J \n", blockJ.toString());
    }

    @Test 
    public void moveRightTest() throws TetrisException{
        blockJ.getCoordenadas().setX(0);
        blockJ.getCoordenadas().setY(0);
        blockJ.moveRight(7);
        assertEquals(1, blockJ.getCoordenadas().getX());
        assertEquals(0, blockJ.getCoordenadas().getY());
        blockJ.moveRight(7);
        assertEquals(2, blockJ.getCoordenadas().getX());
    }

    @Test
    public void cannotMoveRightTest() throws TetrisException{
        blockJ.getCoordenadas().setX(4);
        blockJ.getCoordenadas().setY(0);
        blockJ.moveRight(6);
        assertEquals(4, blockJ.getCoordenadas().getX());
    }

    @Test
    public void cannotMoveRightRotatedTest() throws TetrisException{
        blockJ.rotateRight(6);
        blockJ.getCoordenadas().setX(3);
        blockJ.getCoordenadas().setY(0);
        blockJ.moveRight(6);
        assertEquals(3, blockJ.getCoordenadas().getX());
    }

    @Test 
    public void moveLeftTest() throws TetrisException{
        blockJ.getCoordenadas().setX(5);
        blockJ.getCoordenadas().setY(0);
        blockJ.moveLeft();
        assertEquals(4, blockJ.getCoordenadas().getX());
        assertEquals(0, blockJ.getCoordenadas().getY());
        
    }

    @Test
    public void cannotMoveLeftTest() throws TetrisException{
        blockJ.getCoordenadas().setX(0);
        blockJ.getCoordenadas().setY(0);
        blockJ.moveLeft();
        assertEquals(0, blockJ.getCoordenadas().getX());
        assertEquals(0, blockJ.getCoordenadas().getY());
    }

    @Test
    public void rotateLeftTest(){
        assertEquals("  J \n" + "  J \n" + "J J \n", blockJ.toString());

        blockJ.rotateLeft();
        assertEquals("J J J \n" + "    J \n", blockJ.toString());

        blockJ.rotateLeft();
        assertEquals("J J \n" + "J   \n" + "J   \n", blockJ.toString());

        blockJ.rotateLeft();
        assertEquals("J     \n" + "J J J \n", blockJ.toString());

        blockJ.rotateLeft();
        assertEquals("  J \n" + "  J \n" + "J J \n", blockJ.toString());
    }

    @Test
    public void rotateRightTest(){
        assertEquals("  J \n" + "  J \n" + "J J \n", blockJ.toString());

        blockJ.rotateRight(6);
        assertEquals("J     \n" + "J J J \n", blockJ.toString());

        blockJ.rotateRight(6);
        assertEquals("J J \n" + "J   \n" + "J   \n", blockJ.toString());

        blockJ.rotateRight(6);
        assertEquals("J J J \n" + "    J \n", blockJ.toString());

        blockJ.rotateRight(6);
        assertEquals("  J \n" + "  J \n" + "J J \n", blockJ.toString());
    }

    @Test 
    public void cannotRotateRightInBounds(){
        blockJ.getCoordenadas().setX(4);
        blockJ.getCoordenadas().setY(0);
        blockJ.rotateRight(6);
        assertEquals(3, blockJ.getCoordenadas().getX());
    }

    @Test
    public void bajarBloqueTest(){
        blockJ.getCoordenadas().setX(0);
        blockJ.getCoordenadas().setY(0);
        blockJ.bajarBloque();
        assertEquals(1, blockJ.getCoordenadas().getY());
    }
}
