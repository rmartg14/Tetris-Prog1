package test.es.unileon.prg1.tetris;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TetrisTextUITest {

    private Tetris tetris;
    private TetrisTextUI tetrisTextUI;

    @Before
    public void setUp() {
        tetris = new Tetris(); 
        tetrisTextUI = new TetrisTextUI(tetris);
    }

    @Test
    public void testIntroduceTeclado() {
        try {
            assertEquals("W", tetrisTextUI.introduceTeclado("W"));
        } catch (TetrisException e) {
            fail("No debería haber lanzado una excepción para una entrada válida");
        }
        try{
        
        }
    }
    
}
   