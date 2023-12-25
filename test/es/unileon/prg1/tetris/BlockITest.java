package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BlockITest {
    private BlockI blockI;

    @Before
    public void setUp(){
        this.blockI = new BlockI();
    }

    @Test
    public void blockITest(){
        assertEquals("I \n" + "I \n" + "I \n" + "I \n", blockI.toString());
    }

    @Test 
    public void moveRightTest(){
        blockI.getCoordenadas().setX(0);
        blockI.getCoordenadas().setY(0);
        blockI.moveRight(7);
        assertEquals(1, blockI.getCoordenadas().getX());
        assertEquals(0, blockI.getCoordenadas().getY());
        blockI.moveRight(7);
        assertEquals(2, blockI.getCoordenadas().getX());
    }

    @Test
    public void cannotMoveRightTest(){
        blockI.getCoordenadas().setX(5);
        blockI.getCoordenadas().setY(0);
        blockI.moveRight(6);
        assertEquals(5, blockI.getCoordenadas().getX());
    }

    @Test
    public void cannotMoveRightRotatedTest(){
        blockI.rotateRight(6);
        blockI.getCoordenadas().setX(2);
        blockI.getCoordenadas().setY(0);
        blockI.moveRight(6);
        assertEquals(2, blockI.getCoordenadas().getX());
    }

    @Test 
    public void moveLeftTest(){
        blockI.getCoordenadas().setX(5);
        blockI.getCoordenadas().setY(0);
        blockI.moveLeft();
        assertEquals(4, blockI.getCoordenadas().getX());
        assertEquals(0, blockI.getCoordenadas().getY());
        
    }

    @Test
    public void cannotMoveLeftTest(){
        blockI.getCoordenadas().setX(0);
        blockI.getCoordenadas().setY(0);
        blockI.moveLeft();
        assertEquals(0, blockI.getCoordenadas().getX());
        assertEquals(0, blockI.getCoordenadas().getY());
    }

    @Test
    public void rotateLeftTest(){
        assertEquals("I \n" + "I \n" + "I \n" + "I \n", blockI.toString());

        blockI.rotateLeft();
        assertEquals("I I I I \n", blockI.toString());

        blockI.rotateLeft();
        assertEquals("I \n" + "I \n" + "I \n" + "I \n", blockI.toString());

        blockI.rotateLeft();
        assertEquals("I I I I \n", blockI.toString());

        blockI.rotateLeft();
        assertEquals("I \n" + "I \n" + "I \n" + "I \n", blockI.toString());
    }

    @Test
    public void rotateRightTest(){
        assertEquals("I \n" + "I \n" + "I \n" + "I \n", blockI.toString());

        blockI.rotateRight(6);
        assertEquals("I I I I \n", blockI.toString());

        blockI.rotateRight(6);
        assertEquals("I \n" + "I \n" + "I \n" + "I \n", blockI.toString());

        blockI.rotateRight(6);
        assertEquals("I I I I \n", blockI.toString());

        blockI.rotateRight(6);
        assertEquals("I \n" + "I \n" + "I \n" + "I \n", blockI.toString());
    }

    @Test 
    public void cannotRotateRightInBounds(){
        blockI.getCoordenadas().setX(5);
        blockI.getCoordenadas().setY(0);
        blockI.rotateRight(6);
        assertEquals(2, blockI.getCoordenadas().getX());
    }

    @Test
    public void bajarBloqueTest(){
        blockI.getCoordenadas().setX(0);
        blockI.getCoordenadas().setY(0);
        blockI.bajarBloque();
        assertEquals(1, blockI.getCoordenadas().getY());
    }
}