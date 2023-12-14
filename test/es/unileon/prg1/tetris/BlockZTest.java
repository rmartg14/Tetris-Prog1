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
        assertEquals("Z Z   \n" + "  Z Z \n", blockZ.toString());
    }
}
