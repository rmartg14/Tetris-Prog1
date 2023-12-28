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
    @Test(expected = TetrisException.class)
    public void cannotMoveRightTest() throws TetrisException{
        blockI.getCoordenadas().setX(5);
        blockI.getCoordenadas().setY(0);
        blockI.moveRight(6);
        assertEquals(5, blockI.getCoordenadas().getX());
    }
    @Test(expected = TetrisException.class)
    public void cannotMoveRightRotatedTest() throws TetrisException{
        blockI.rotateRight(6);
        blockI.getCoordenadas().setX(2);
        blockI.getCoordenadas().setY(0);
        blockI.moveRight(6);
        assertEquals(2, blockI.getCoordenadas().getX());
    }
    @Test(expected = TetrisException.class)
    public void cannotMoveLeftTest() throws TetrisException{
        blockI.getCoordenadas().setX(0);
        blockI.getCoordenadas().setY(0);
        blockI.moveLeft();
        assertEquals(0, blockI.getCoordenadas().getX());
        assertEquals(0, blockI.getCoordenadas().getY());
    }
    @Test
    public void blockITest(){
        assertEquals(" I \n" + " I \n" + " I \n" + " I ", blockI.toString());
    }

    @Test 
    public void moveRightTest() throws TetrisException{
        blockI.getCoordenadas().setX(0);
        blockI.getCoordenadas().setY(0);
        blockI.moveRight(7);
        assertEquals(1, blockI.getCoordenadas().getX());
        assertEquals(0, blockI.getCoordenadas().getY());
        blockI.moveRight(7);
        assertEquals(2, blockI.getCoordenadas().getX());
    }

   

   

    @Test 
    public void moveLeftTest() throws TetrisException{
        blockI.getCoordenadas().setX(5);
        blockI.getCoordenadas().setY(0);
        blockI.moveLeft();
        assertEquals(4, blockI.getCoordenadas().getX());
        assertEquals(0, blockI.getCoordenadas().getY());
        
    }

    

    @Test
    public void rotateLeftTest(){
        assertEquals(" I \n" + " I \n" + " I \n" + " I ", blockI.toString());

        blockI.rotateLeft(6);
        assertEquals(" I I I I ", blockI.toString());

        blockI.rotateLeft(6);
        assertEquals(" I \n" + " I \n" + " I \n" + " I ", blockI.toString());

        blockI.rotateLeft(6);
        assertEquals(" I I I I ", blockI.toString());

        blockI.rotateLeft(6);
        assertEquals(" I \n" + " I \n" + " I \n" + " I ", blockI.toString());
    }

    @Test
    public void rotateRightTest(){
        assertEquals(" I \n" + " I \n" + " I \n" + " I ", blockI.toString());

        blockI.rotateRight(6);
        assertEquals(" I I I I ", blockI.toString());

        blockI.rotateRight(6);
        assertEquals(" I \n" + " I \n" + " I \n" + " I ", blockI.toString());

        blockI.rotateRight(6);
        assertEquals(" I I I I ", blockI.toString());

        blockI.rotateRight(6);
        assertEquals(" I \n" + " I \n" + " I \n" + " I ", blockI.toString());
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