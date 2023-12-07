package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlockZTest {
    private BlockZ blockZ;

    @Before
    public void setUp(){
        this.blockZ = new BlockZ();
    }

    @Test
    public void blockZTest(){
        assertEquals("110\n" + "011\n", blockZ.toString());
    }
}
