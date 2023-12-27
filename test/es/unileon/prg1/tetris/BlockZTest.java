package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlockZTest {
    private BlockZ blockZ;

    @Before
    public void setUp(){
        this.blockZ = new BlockZ();
    }

    @Test
    public void blockZTest(){
        assertEquals(" Z Z   \n" + "   Z Z ", blockZ.toString());
    }

    @Test 
    public void moveRightTest() throws TetrisException{
        blockZ.getCoordenadas().setX(0);
        blockZ.getCoordenadas().setY(0);
        blockZ.moveRight(7);
        assertEquals(1, blockZ.getCoordenadas().getX());
        assertEquals(0, blockZ.getCoordenadas().getY());
        blockZ.moveRight(7);
        assertEquals(2, blockZ.getCoordenadas().getX());
    }

    @Test
    public void cannotMoveRightTest() throws TetrisException{
        blockZ.getCoordenadas().setX(3);
        blockZ.getCoordenadas().setY(0);
        blockZ.moveRight(6);
        assertEquals(3, blockZ.getCoordenadas().getX());
    }

    @Test
    public void cannotMoveRightRotatedTest() throws TetrisException{
        blockZ.rotateRight(6);
        blockZ.getCoordenadas().setX(4);
        blockZ.getCoordenadas().setY(0);
        blockZ.moveRight(6);
        assertEquals(4, blockZ.getCoordenadas().getX());
    }

    @Test 
    public void moveLeftTest() throws TetrisException{
        blockZ.getCoordenadas().setX(5);
        blockZ.getCoordenadas().setY(0);
        blockZ.moveLeft();
        assertEquals(4, blockZ.getCoordenadas().getX());
        assertEquals(0, blockZ.getCoordenadas().getY());
        
    }

    @Test
    public void cannotMoveLeftTest() throws TetrisException{
        blockZ.getCoordenadas().setX(0);
        blockZ.getCoordenadas().setY(0);
        blockZ.moveLeft();
        assertEquals(0, blockZ.getCoordenadas().getX());
        assertEquals(0, blockZ.getCoordenadas().getY());
    }

    @Test
    public void rotateLeftTest(){
        assertEquals(" Z Z   \n" + "   Z Z ", blockZ.toString());

        blockZ.rotateLeft(6);
        assertEquals("   Z \n" + " Z Z \n" + " Z   ", blockZ.toString());

        blockZ.rotateLeft(6);
        assertEquals(" Z Z   \n" + "   Z Z ", blockZ.toString());

        blockZ.rotateLeft(6);
        assertEquals("   Z \n" + " Z Z \n" + " Z   ", blockZ.toString());

        blockZ.rotateLeft(6);
        assertEquals(" Z Z   \n" + "   Z Z ", blockZ.toString());
    }

    @Test
    public void rotateRightTest(){
        assertEquals(" Z Z   \n" + "   Z Z ", blockZ.toString());

        blockZ.rotateRight(6);
        assertEquals("   Z \n" + " Z Z \n" + " Z   ", blockZ.toString());

        blockZ.rotateRight(6);
        assertEquals(" Z Z   \n" + "   Z Z ", blockZ.toString());

        blockZ.rotateRight(6);
        assertEquals("   Z \n" + " Z Z \n" + " Z   ", blockZ.toString());

        blockZ.rotateRight(6);
        assertEquals(" Z Z   \n" + "   Z Z ", blockZ.toString());
    }

    @Test 
    public void cannotRotateRightInBounds() throws TetrisException{
        blockZ.getCoordenadas().setX(3);
        blockZ.getCoordenadas().setY(0);
        blockZ.rotateRight(6);
        blockZ.moveRight(6);
        blockZ.rotateRight(6);
        assertEquals(3, blockZ.getCoordenadas().getX());
    }

    @Test
    public void bajarBloqueTest(){
        blockZ.getCoordenadas().setX(0);
        blockZ.getCoordenadas().setY(0);
        blockZ.bajarBloque();
        assertEquals(1, blockZ.getCoordenadas().getY());
    }
}
