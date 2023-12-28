package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlockTTest {
    private BlockT blockT;

    @Before
    public void setUp(){
        this.blockT = new BlockT();
    }

    @Test(expected = TetrisException.class)
    public void cannotMoveRightTest() throws TetrisException{
        blockT.getCoordenadas().setX(3);
        blockT.getCoordenadas().setY(0);
        blockT.moveRight(6);
        assertEquals(3, blockT.getCoordenadas().getX());
    }

    @Test(expected = TetrisException.class)
    public void cannotMoveRightRotatedTest() throws TetrisException{
        blockT.rotateRight(6);
        blockT.getCoordenadas().setX(4);
        blockT.getCoordenadas().setY(0);
        blockT.moveRight(6);
        assertEquals(4, blockT.getCoordenadas().getX());
    }

    @Test(expected = TetrisException.class)
    public void cannotMoveLeftTest() throws TetrisException{
        blockT.getCoordenadas().setX(0);
        blockT.getCoordenadas().setY(0);
        blockT.moveLeft();
        assertEquals(0, blockT.getCoordenadas().getX());
        assertEquals(0, blockT.getCoordenadas().getY());
    }

    @Test
    public void blockTTest(){
        assertEquals(" T T T \n" + "   T   ", blockT.toString());
    }

    @Test 
    public void moveRightTest() throws TetrisException{
        blockT.getCoordenadas().setX(0);
        blockT.getCoordenadas().setY(0);
        blockT.moveRight(7);
        assertEquals(1, blockT.getCoordenadas().getX());
        assertEquals(0, blockT.getCoordenadas().getY());
        blockT.moveRight(7);
        assertEquals(2, blockT.getCoordenadas().getX());
    }

    

    @Test 
    public void moveLeftTest() throws TetrisException{
        blockT.getCoordenadas().setX(5);
        blockT.getCoordenadas().setY(0);
        blockT.moveLeft();
        assertEquals(4, blockT.getCoordenadas().getX());
        assertEquals(0, blockT.getCoordenadas().getY());
        
    }


    @Test
    public void rotateLeftTest(){
        assertEquals(" T T T \n" + "   T   ", blockT.toString());

        blockT.rotateLeft(6);
        assertEquals(" T   \n" + " T T \n" + " T   ", blockT.toString());

        blockT.rotateLeft(6);
        assertEquals("   T   \n" + " T T T ", blockT.toString());

        blockT.rotateLeft(6);
        assertEquals("   T \n" + " T T \n" + "   T ", blockT.toString());

        blockT.rotateLeft(6);
        assertEquals(" T T T \n" + "   T   ", blockT.toString());
    }

    @Test
    public void rotateRightTest(){
        assertEquals(" T T T \n" + "   T   ", blockT.toString());

        blockT.rotateRight(6);
        assertEquals("   T \n" + " T T \n" + "   T ", blockT.toString());

        blockT.rotateRight(6);
        assertEquals("   T   \n" + " T T T ", blockT.toString());

        blockT.rotateRight(6);
        assertEquals(" T   \n" + " T T \n" + " T   ", blockT.toString());

        blockT.rotateRight(6);
        assertEquals(" T T T \n" + "   T   ", blockT.toString());
    }

    @Test 
    public void cannotRotateRightInBounds() throws TetrisException{
        blockT.getCoordenadas().setX(3);
        blockT.getCoordenadas().setY(0);
        blockT.rotateRight(6);
        blockT.moveRight(6);
        blockT.rotateRight(6);
        assertEquals(3, blockT.getCoordenadas().getX());
    }

    @Test
    public void bajarBloqueTest(){
        blockT.getCoordenadas().setX(0);
        blockT.getCoordenadas().setY(0);
        blockT.bajarBloque();
        assertEquals(1, blockT.getCoordenadas().getY());
    }
}
