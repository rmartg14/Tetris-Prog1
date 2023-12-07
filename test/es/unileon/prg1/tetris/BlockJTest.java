package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlockJTest {
    private BlockJ blockJ;

    @Before
    public void setUp(){
        this.blockJ = new BlockJ();
    }

    @Test
    public void blockJTest(){
        assertEquals("01\n" + "01\n" + "11\n", blockJ.toString());
    }
}
