package es.unileon.prg1.tetris.strategy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg1.tetris.Color;
import es.unileon.prg1.tetris.Piece;
public class PieceTextTest {
    private Piece none, pieceO, pieceL, pieceZ, pieceI, pieceJ, pieceS, pieceT, pieceR;

    @Before
    public void setUp() throws Exception {
        ColorStrategySingleton.getInstance("color");
        this.none = new Piece(Color.NONE, " ");
        this.pieceO = new Piece(Color.YELLOW, "O");
        this.pieceL = new Piece(Color.WHITE, "L");
        this.pieceZ = new Piece(Color.GREEN, "Z");
        this.pieceI = new Piece(Color.CYAN, "I");
        this.pieceJ = new Piece(Color.BLUE, "J");
        this.pieceS = new Piece(Color.RED, "S");
        this.pieceT = new Piece(Color.MAGENTA, "T");
        this.pieceR = new Piece(Color.BLACK, "R");
    }

    @Test
    public void testPiece() {
        Piece piece = new Piece();
        assertEquals(ANSIColorStrategy.ANSI_DEFAULT, piece.toString());
        
    }

    @Test
    public void testPieceSign() {
        assertEquals(ANSIColorStrategy.ANSI_DEFAULT, none.toString());
        assertEquals(ANSIColorStrategy.ANSI_YELLOW, pieceO.toString());
        assertEquals(ANSIColorStrategy.ANSI_WHITE, pieceL.toString());
        assertEquals(ANSIColorStrategy.ANSI_GREEN, pieceZ.toString());
        assertEquals(ANSIColorStrategy.ANSI_CYAN, pieceI.toString());
        assertEquals(ANSIColorStrategy.ANSI_BLUE, pieceJ.toString());
        assertEquals(ANSIColorStrategy.ANSI_RED, pieceS.toString());
        assertEquals(ANSIColorStrategy.ANSI_MAGENTA, pieceT.toString());
        assertEquals(ANSIColorStrategy.ANSI_BLACK, pieceR.toString());
    }

    @Test
    public void testPiecePiece() {
        Piece piece = new Piece(none);
        assertEquals(ANSIColorStrategy.ANSI_DEFAULT, piece.toString());
    }

    @Test
    public void testGetColor() {
        assertEquals(Color.NONE, none.getColor());
        assertEquals(Color.YELLOW, pieceO.getColor());
        assertEquals(Color.WHITE, pieceL.getColor());
        assertEquals(Color.GREEN, pieceZ.getColor());
        assertEquals(Color.CYAN, pieceI.getColor());
        assertEquals(Color.BLUE, pieceJ.getColor());
        assertEquals(Color.RED, pieceS.getColor());
        assertEquals(Color.MAGENTA, pieceT.getColor());
        assertEquals(Color.BLACK, pieceR.getColor());
    }

    @Test
    public void testGetSign() {
        assertEquals("  ", none.getSign());
        assertEquals("O ", pieceO.getSign());
        assertEquals("L ", pieceL.getSign());
        assertEquals("Z ", pieceZ.getSign());
        assertEquals("I ", pieceI.getSign());
        assertEquals("J ", pieceJ.getSign());
        assertEquals("S ", pieceS.getSign());
        assertEquals("T ", pieceT.getSign());
        assertEquals("R ", pieceR.getSign());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(this.none.isEmpty());
        assertFalse(this.pieceO.isEmpty());
        assertFalse(this.pieceL.isEmpty());
        assertFalse(this.pieceZ.isEmpty());
        assertFalse(this.pieceI.isEmpty());
        assertFalse(this.pieceJ.isEmpty());
        assertFalse(this.pieceS.isEmpty());
        assertFalse(this.pieceT.isEmpty());
        assertFalse(this.pieceR.isEmpty());
    }

    @Test
    public void testToString() {
        assertEquals(ANSIColorStrategy.ANSI_DEFAULT, none.toString());
        assertEquals(ANSIColorStrategy.ANSI_YELLOW, pieceO.toString());
        assertEquals(ANSIColorStrategy.ANSI_WHITE, pieceL.toString());
        assertEquals(ANSIColorStrategy.ANSI_GREEN, pieceZ.toString());
        assertEquals(ANSIColorStrategy.ANSI_CYAN, pieceI.toString());
        assertEquals(ANSIColorStrategy.ANSI_BLUE, pieceJ.toString());
        assertEquals(ANSIColorStrategy.ANSI_RED, pieceS.toString());
        assertEquals(ANSIColorStrategy.ANSI_MAGENTA, pieceT.toString());
        assertEquals(ANSIColorStrategy.ANSI_BLACK, pieceR.toString());
    }
    
}
