package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlockLTest {
    private BlockL blockL;

    @Before
    public void setUp(){
        this.blockL = new BlockL();
    }

    @Test
    public void blockLTest(){
        assertEquals(" L   \n" + " L   \n" + " L L ", blockL.toString());
    }

    @Test 
    public void moveRightTest() throws TetrisException{
        blockL.getCoordenadas().setX(0);
        blockL.getCoordenadas().setY(0);
        blockL.moveRight(7);
        assertEquals(1, blockL.getCoordenadas().getX());
        assertEquals(0, blockL.getCoordenadas().getY());
        blockL.moveRight(7);
        assertEquals(2, blockL.getCoordenadas().getX());
    }

    @Test
    public void cannotMoveRightTest() throws TetrisException{
        blockL.getCoordenadas().setX(4);
        blockL.getCoordenadas().setY(0);
        blockL.moveRight(6);
        assertEquals(4, blockL.getCoordenadas().getX());
    }

    @Test
    public void cannotMoveRightRotatedTest() throws TetrisException{
        blockL.rotateRight(6);
        blockL.getCoordenadas().setX(3);
        blockL.getCoordenadas().setY(0);
        blockL.moveRight(6);
        assertEquals(3, blockL.getCoordenadas().getX());
    }

    @Test 
    public void moveLeftTest() throws TetrisException{
        blockL.getCoordenadas().setX(5);
        blockL.getCoordenadas().setY(0);
        blockL.moveLeft();
        assertEquals(4, blockL.getCoordenadas().getX());
        assertEquals(0, blockL.getCoordenadas().getY());
        
    }

    @Test
    public void cannotMoveLeftTest() throws TetrisException{
        blockL.getCoordenadas().setX(0);
        blockL.getCoordenadas().setY(0);
        blockL.moveLeft();
        assertEquals(0, blockL.getCoordenadas().getX());
        assertEquals(0, blockL.getCoordenadas().getY());
    }

    @Test
    public void rotateLeftTest(){
        assertEquals(" L   \n" + " L   \n" + " L L ", blockL.toString());

        blockL.rotateLeft();
        assertEquals("     L \n" + " L L L ", blockL.toString());

        blockL.rotateLeft();
        assertEquals(" L L \n" + "   L \n" + "   L ", blockL.toString());

        blockL.rotateLeft();
        assertEquals(" L L L \n" + " L     ", blockL.toString());

        blockL.rotateLeft();
        assertEquals(" L   \n" + " L   \n" + " L L ", blockL.toString());
    }

    @Test
    public void rotateRightTest(){
        assertEquals(" L   \n" + " L   \n" + " L L ", blockL.toString());

        blockL.rotateRight(6);
        assertEquals(" L L L \n" + " L     ", blockL.toString());

        blockL.rotateRight(6);
        assertEquals(" L L \n" + "   L \n" + "   L ", blockL.toString());

        blockL.rotateRight(6);
        assertEquals("     L \n" + " L L L ", blockL.toString());

        blockL.rotateRight(6);
        assertEquals(" L   \n" + " L   \n" + " L L ", blockL.toString());
    }

    @Test 
    public void cannotRotateRightInBounds(){
        blockL.getCoordenadas().setX(4);
        blockL.getCoordenadas().setY(0);
        blockL.rotateRight(6);
        assertEquals(3, blockL.getCoordenadas().getX());
    }

    @Test
    public void bajarBloqueTest(){
        blockL.getCoordenadas().setX(0);
        blockL.getCoordenadas().setY(0);
        blockL.bajarBloque();
        assertEquals(1, blockL.getCoordenadas().getY());
    }
}
