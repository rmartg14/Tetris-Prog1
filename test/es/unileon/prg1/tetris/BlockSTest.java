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
}
