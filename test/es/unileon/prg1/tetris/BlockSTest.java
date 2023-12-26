package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlockSTest {
    private BlockS blockS;

    @Before
    public void setUp(){
        this.blockS = new BlockS();
    }

    @Test
    public void blockSTest(){
        assertEquals("  S S \n" + "S S   \n", blockS.toString());
    }
    
    @Test 
    public void moveRightTest() throws TetrisException{
        blockS.getCoordenadas().setX(0);
        blockS.getCoordenadas().setY(0);
        blockS.moveRight(7);
        assertEquals(1, blockS.getCoordenadas().getX());
        assertEquals(0, blockS.getCoordenadas().getY());
        blockS.moveRight(7);
        assertEquals(2, blockS.getCoordenadas().getX());
    }

    @Test
    public void cannotMoveRightTest() throws TetrisException{
        blockS.getCoordenadas().setX(3);
        blockS.getCoordenadas().setY(0);
        blockS.moveRight(6);
        assertEquals(3, blockS.getCoordenadas().getX());
    }

    @Test
    public void cannotMoveRightRotatedTest() throws TetrisException{
        blockS.rotateRight(6);
        blockS.getCoordenadas().setX(4);
        blockS.getCoordenadas().setY(0);
        blockS.moveRight(6);
        assertEquals(4, blockS.getCoordenadas().getX());
    }

    @Test 
    public void moveLeftTest() throws TetrisException {
        blockS.getCoordenadas().setX(5);
        blockS.getCoordenadas().setY(0);
        blockS.moveLeft();
        assertEquals(4, blockS.getCoordenadas().getX());
        assertEquals(0, blockS.getCoordenadas().getY());
        
    }

    @Test
    public void cannotMoveLeftTest() throws TetrisException{
        blockS.getCoordenadas().setX(0);
        blockS.getCoordenadas().setY(0);
        blockS.moveLeft();
        assertEquals(0, blockS.getCoordenadas().getX());
        assertEquals(0, blockS.getCoordenadas().getY());
    }

    @Test
    public void rotateLeftTest(){
        assertEquals("   S S \n" + 
                        " S S   ", blockS.toString());

        blockS.rotateLeft();
        assertEquals(" S   \n" + " S S \n" + "   S ", blockS.toString());

        blockS.rotateLeft();
        assertEquals("   S S \n" + " S S   ", blockS.toString());

        blockS.rotateLeft();
        assertEquals(" S   \n" + " S S \n" + "   S ", blockS.toString());

        blockS.rotateLeft();
        assertEquals("   S S \n" + " S S   ", blockS.toString());
    }

    @Test
    public void rotateRightTest(){
        assertEquals("   S S \n" + " S S   \n", blockS.toString());

        blockS.rotateRight(6);
        assertEquals(" S   \n" + " S S \n" + "   S \n", blockS.toString());

        blockS.rotateRight(6);
        assertEquals("   S S \n" + " S S   \n", blockS.toString());

        blockS.rotateRight(6);
        assertEquals(" S   \n" + " S S \n" + "   S \n", blockS.toString());

        blockS.rotateRight(6);
        assertEquals("   S S \n" + " S S   \n", blockS.toString());
    }

    @Test 
    public void cannotRotateRightInBounds() throws TetrisException{
        blockS.getCoordenadas().setX(3);
        blockS.getCoordenadas().setY(0);
        blockS.rotateRight(6);
        blockS.moveRight(6);
        blockS.rotateRight(6);
        assertEquals(3, blockS.getCoordenadas().getX());
    }

    @Test
    public void bajarBloqueTest(){
        blockS.getCoordenadas().setX(0);
        blockS.getCoordenadas().setY(0);
        blockS.bajarBloque();
        assertEquals(1, blockS.getCoordenadas().getY());
    }
}
