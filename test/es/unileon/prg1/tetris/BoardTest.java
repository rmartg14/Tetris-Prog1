package es.unileon.prg1.tetris;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private Board board1, board2, board3;
    @Before
    public void setUp()throws Exception{
        this.board1=new Board(5,6);
        this.board2=new Board(10, 10);
        this.board3=new Board(8, 8);
        this.board1.iniciarTablero();
        this.board2.iniciarTablero();
        this.board3.iniciarTablero();

    }

    @Test
    public void testInic() throws TetrisException{}{
        assertEquals("│            │\n" + //
                     "│            │\n" + //
                     "│            │\n" + //
                     "│            │\n" + //
                     "│            │\n" + //
                     "└────────────┘\n"    //
                     ,this.board1.toString());

        assertEquals("│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "└────────────────────┘\n"   //
                     
                     , this.board2.toString());

        assertEquals("│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "└────────────────┘\n"   //
                     
                     , this.board3.toString());

    
    }
    @Test
    public void testNRows()throws TetrisException{
        assertEquals(board1.getNumberOfRows(), 5);
        assertEquals(board2.getNumberOfRows(), 10);
        assertEquals(board3.getNumberOfRows(), 8);
    }
    @Test
    public void testNCols()throws TetrisException{
        assertEquals(board1.getNumberOfColumns(), 6);
        assertEquals(board2.getNumberOfColumns(), 10);
        assertEquals(board3.getNumberOfColumns(), 8);
    }
    @Test
    public void testDropCuadradoNeg()throws TetrisException{
        assertFalse(board1.canDrop(new Block(), -1));
        assertFalse(board2.canDrop(new Block(), -2));
        assertFalse(board3.canDrop(new Block(), -3));
    }
    @Test
    public void testDropCuadrado0()throws TetrisException{
        assertTrue(board1.canDrop(new Block(), 0));
        assertTrue(board2.canDrop(new Block(), 0));
        assertTrue(board3.canDrop(new Block(), 0));
        
        assertEquals("│            │\n" + //
                     "│            │\n" + //
                     "│            │\n" + //
                     "│O O         │\n" + //
                     "│O O         │\n" + //
                     "└────────────┘\n"    //
                     ,this.board1.toString());
                     
        assertEquals("│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│O O                 │\n" + //
                     "│O O                 │\n" + //
                     "└────────────────────┘\n"   //
                     
                     , this.board2.toString());

        assertEquals("│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│O O             │\n" + //
                     "│O O             │\n" + //
                     "└────────────────┘\n"   //
                     
                     , this.board3.toString());
        

    }

    @Test
    public void testDropCuadrado1()throws TetrisException{
        assertTrue(board1.canDrop(new Block(), 1));
        assertTrue(board2.canDrop(new Block(), 1));
        assertTrue(board3.canDrop(new Block(), 1));
        
        assertEquals("│            │\n" + //
                     "│            │\n" + //
                     "│            │\n" + //
                     "│  O O       │\n" + //
                     "│  O O       │\n" + //
                     "└────────────┘\n"    //
                     ,this.board1.toString());
                     
        assertEquals("│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│  O O               │\n" + //
                     "│  O O               │\n" + //
                     "└────────────────────┘\n"   //
                     
                     , this.board2.toString());

        assertEquals("│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│  O O           │\n" + //
                     "│  O O           │\n" + //
                     "└────────────────┘\n"   //
                     
                     , this.board3.toString());
        

    }
    @Test
    public void testDropCuadrado2()throws TetrisException{
        assertTrue(board1.canDrop(new Block(), 2));
        assertTrue(board2.canDrop(new Block(), 2));
        assertTrue(board3.canDrop(new Block(), 2));
        
        assertEquals("│            │\n" + //
                     "│            │\n" + //
                     "│            │\n" + //
                     "│    O O     │\n" + //
                     "│    O O     │\n" + //
                     "└────────────┘\n"    //
                     ,this.board1.toString());
                     
        assertEquals("│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│    O O             │\n" + //
                     "│    O O             │\n" + //
                     "└────────────────────┘\n"   //
                     
                     , this.board2.toString());

        assertEquals("│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│    O O         │\n" + //
                     "│    O O         │\n" + //
                     "└────────────────┘\n"   //
                     
                     , this.board3.toString());
        

    }
    @Test
    public void testDropCuadrado5()throws TetrisException{
        assertFalse(board1.canDrop(new Block(), 5));
        assertTrue(board2.canDrop(new Block(), 5));
        assertTrue(board3.canDrop(new Block(), 5));             
        assertEquals("│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│          O O       │\n" + //
                     "│          O O       │\n" + //
                     "└────────────────────┘\n"   //
                     
                     , this.board2.toString());

        assertEquals("│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│          O O   │\n" + //
                     "│          O O   │\n" + //
                     "└────────────────┘\n"   //
                     
                     , this.board3.toString());
        

    }
    @Test
    public void testDropCuadrado7()throws TetrisException{
        assertFalse(board1.canDrop(new Block(), 7));
        assertTrue(board2.canDrop(new Block(), 7));
        assertFalse(board3.canDrop(new Block(), 7));             
        assertEquals("│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│              O O   │\n" + //
                     "│              O O   │\n" + //
                     "└────────────────────┘\n"   //
                     
                     , this.board2.toString());

        

    }
    @Test
    public void testDropFallo1()throws TetrisException{
        assertTrue(board1.canDrop(new Block(), 1));
        assertTrue(board1.canDrop(new Block(), 3));
        assertTrue(board1.canDrop(new Block(), 0));
        
         assertEquals("│            │\n" + //
                      "│O O         │\n" + //
                      "│O O         │\n" + //
                      "│  O O O O   │\n" + //
                      "│  O O O O   │\n" + //
                      "└────────────┘\n"   //
                     ,this.board1.toString());
        
        assertFalse(board1.canDrop(new Block(), 1));
        assertFalse(board1.canDrop(new Block(), 0));

                  
       
    }
    @Test
    public void testDropFallo2()throws TetrisException{
                 
       
    }
    @Test
    public void testFilasFallo1()throws TetrisException{
        assertTrue(board1.canDrop(new Block(), 1));
        assertTrue(board1.canDrop(new Block(), 3));
        assertTrue(board1.canDrop(new Block(), 4));
        assertEquals(board1.checkAndDeleteRows(),0);

         assertEquals("│            │\n" + //
                      "│        O O │\n" + //
                      "│        O O │\n" + //
                      "│  O O O O   │\n" + //
                      "│  O O O O   │\n" + //
                      "└────────────┘\n"   //
                     ,this.board1.toString());
                  
       
    }
    @Test
    public void testElimFilasAcierto()throws TetrisException{
        assertTrue(board1.canDrop(new Block(), 0));
        assertTrue(board1.canDrop(new Block(), 2));
        assertTrue(board1.canDrop(new Block(), 4));

         assertEquals("│            │\n" + //
                      "│            │\n" + //
                      "│            │\n" + //
                      "│O O O O O O │\n" + //
                      "│O O O O O O │\n" + //
                      "└────────────┘\n"   //
                     ,this.board1.toString());
        assertEquals(board1.checkAndDeleteRows(),20);
        assertEquals("│            │\n" + //
                     "│            │\n" + //
                     "│            │\n" + //
                     "│            │\n" + //
                     "│            │\n" + //
                     "└────────────┘\n"   //
                     ,this.board1.toString());
        
    }



}

//DUDAS: COMO SABER SI VIENE GIRADO EL BLOQUE O NO
//DECIRLE A MARIO QUE COMPRUEBE QUE LA X ES POSITIVA Y NO SE SALE DEL TABLERO