package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class BlockLTest {
    private BlockL blockL;

    @Before
    public void setUp(){
        this.blockL = new BlockL();
    }

    @Test
    public void blockLTest(){
        assertEquals("10\n" + "10\n" + "11\n", blockL.toString());
    }
}
