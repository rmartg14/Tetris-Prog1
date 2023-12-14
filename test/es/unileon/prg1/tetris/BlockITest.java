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
}