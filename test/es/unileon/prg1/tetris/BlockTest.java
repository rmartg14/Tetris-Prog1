package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class BlockTest {

    private Block blockO;

    @Before
    public void setUp() throws Exception {
        this.blockO = new Block();
    }

    @Test
    public void bloqueTest(){
        assertEquals("O O \n" + "O O \n", blockO.toString());
    }

    @Test
    public void rotateLeftTest(){
        assertEquals("O O \n" + "O O \n", blockO.toString());

        blockO.rotateLeft();
        assertEquals( "O O \n" + "O O \n", blockO.toString());

        blockO.rotateLeft();
        assertEquals("O O \n" + "O O \n", blockO.toString());

        blockO.rotateLeft();
        assertEquals("O O \n" + "O O \n", blockO.toString());

        blockO.rotateLeft();
        assertEquals( "O O \n" + "O O \n", blockO.toString());
    }


    @Test 
    public void rotateRightTest(){
        assertEquals("O O \n" + "O O \n", blockO.toString());

        blockO.rotateRight(3);
        assertEquals( "O O \n" + "O O \n", blockO.toString());

        blockO.rotateRight(3);
        assertEquals("O O \n" + "O O \n", blockO.toString());

        blockO.rotateRight(3);
        assertEquals("O O \n" + "O O \n", blockO.toString());

        blockO.rotateRight(3);
        assertEquals( "O O \n" + "O O \n", blockO.toString());
    }



    @Test 
    public void moveRightTest() throws TetrisException{
        blockO.getCoordenadas().setX(0);
        blockO.getCoordenadas().setY(0);
        blockO.moveRight(7);
        assertEquals(1, blockO.getCoordenadas().getX());
        assertEquals(0, blockO.getCoordenadas().getY());
        blockO.moveRight(7);
        assertEquals(2, blockO.getCoordenadas().getX());
    }

    @Test
    public void cannotMoveRightTest() throws TetrisException{
        blockO.getCoordenadas().setX(4);
        blockO.getCoordenadas().setY(0);
        blockO.moveRight(6);
        assertEquals(4, blockO.getCoordenadas().getX());
    }


    @Test 
    public void moveLeftTest() throws TetrisException{
        blockO.getCoordenadas().setX(5);
        blockO.getCoordenadas().setY(0);
        blockO.moveLeft();
        assertEquals(4, blockO.getCoordenadas().getX());
        assertEquals(0, blockO.getCoordenadas().getY());
        
    }

    @Test
    public void cannotMoveLeftTest() throws TetrisException{
        blockO.getCoordenadas().setX(0);
        blockO.getCoordenadas().setY(0);
        blockO.moveLeft();
        assertEquals(0, blockO.getCoordenadas().getX());
        assertEquals(0, blockO.getCoordenadas().getY());
    }

    @Test
    public void toStringTest() {
        assertEquals("O O \n" + "O O \n", blockO.toString());
    }
}
