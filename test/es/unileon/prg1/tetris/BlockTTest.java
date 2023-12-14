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

    @Test
    public void blockTTest(){
        assertEquals("T T T \n" + "  T   \n", blockT.toString());
    }
}
