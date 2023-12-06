package test.es.unileon.prg1.tetris;

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
        assertEquals("11\n" + "11\n", blockO.toString());
    }

    @Test
public void rotateLeftTest(){
    assertEquals("11\n" + "11\n", blockO.toString());

    blockO.rotateLeft();
    assertEquals( "11\n" + "11\n", blockO.toString());

    blockO.rotateLeft();
    assertEquals("11\n" + "11\n", blockO.toString());

    blockO.rotateLeft();
    assertEquals("11\n" + "11\n", blockO.toString());

    blockO.rotateLeft();
    assertEquals( "11\n" + "11\n", blockO.toString());
}


    @Test 
    public void rotateRightTest(){
        assertEquals("11\n" + "11\n", blockO.toString());

        blockO.rotateRight();
        assertEquals( "11\n" + "11\n", blockO.toString());

        blockO.rotateRight();
        assertEquals("11\n" + "11\n", blockO.toString());

        blockO.rotateRight();
        assertEquals("11\n" + "11\n", blockO.toString());

        blockO.rotateRight();
        assertEquals( "11\n" + "11\n", blockO.toString());
    }



    @Test 
    public void moveRightTest(){
        blockO.getCoordenadas().setX(0);
        blockO.getCoordenadas().setY(0);
        blockO.moveRight();
        assertEquals(1, blockO.getCoordenadas().getX());
        assertEquals(0, blockO.getCoordenadas().getY());
    }

    @Test 
    public void moveLeftTest(){
        blockO.getCoordenadas().setX(5);
        blockO.getCoordenadas().setY(0);
        blockO.moveLeft();
        assertEquals(4, blockO.getCoordenadas().getX());
        assertEquals(0, blockO.getCoordenadas().getY());
        
    }

    @Test
    public void toStringTest() {
        assertEquals("11\n" + "11\n", blockO.toString());
    }
}
