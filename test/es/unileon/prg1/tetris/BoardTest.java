package es.unileon.prg1.tetris;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private Board board1, board2, board3;
    private Block blockC;
    private BlockI blockI;
    private BlockJ blockJ;
    private BlockL blockL;
    private BlockS blockS;
    private BlockT blockT;
    private BlockZ blockZ;
    @Before
    public void setUp()throws Exception{
        this.board1=new Board(5,6);
        this.board2=new Board(10, 10);
        this.board3=new Board(8, 8);
        this.blockC=new Block();
        this.blockI=new BlockI();
        this.blockJ=new BlockJ();
        this.blockL=new BlockL();
        this.blockS=new BlockS();
        this.blockT=new BlockT();
        this.blockZ=new BlockZ();

       

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
        blockC.moveLeft();
        assertFalse(board1.canDrop(blockC));
        blockC.moveLeft();
        blockC.moveLeft();
        assertFalse(board2.canDrop(blockC));
        blockC.moveLeft();
        blockC.moveLeft();
        blockC.moveLeft();
        assertFalse(board3.canDrop(blockC));
    }
    @Test
    public void testDropCuadrado0()throws TetrisException{
        assertTrue(board1.canDrop(blockC));
        assertTrue(board2.canDrop(blockC));
        assertTrue(board3.canDrop(blockC));
        
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
    public void testDrop1()throws TetrisException{
        blockC.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(blockC));
        blockS.moveRight(board2.getNumberOfColumns());
        assertTrue(board2.canDrop(blockS));
        blockT.moveRight(board3.getNumberOfColumns());
        assertTrue(board3.canDrop(blockT));
        
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
                     "│    S S             │\n" + //
                     "│  S S               │\n" + //
                     "└────────────────────┘\n"   //
                     
                     , this.board2.toString());

        assertEquals("│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│  T T T         │\n" + //
                     "│    T           │\n" + //
                     "└────────────────┘\n"   //
                     
                     , this.board3.toString());
        

    }
    @Test
    public void testDropCuadrado2()throws TetrisException{
        blockZ.moveRight(board1.getNumberOfColumns());
        blockZ.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(blockZ));
        blockJ.moveRight(board2.getNumberOfColumns());
        blockJ.moveRight(board2.getNumberOfColumns());
        assertTrue(board2.canDrop(blockJ));
        blockL.moveRight(board3.getNumberOfColumns());
        blockL.moveRight(board3.getNumberOfColumns());
        assertTrue(board3.canDrop(blockL));
        
        assertEquals("│            │\n" + //
                     "│            │\n" + //
                     "│            │\n" + //
                     "│    Z Z     │\n" + //
                     "│      Z Z   │\n" + //
                     "└────────────┘\n"    //
                     ,this.board1.toString());
                     
        assertEquals("│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│      J             │\n" + //
                     "│      J             │\n" + //
                     "│    J J             │\n" + //
                     "└────────────────────┘\n"   //
                     
                     , this.board2.toString());

        assertEquals("│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│    L           │\n" + //
                     "│    L           │\n" + //
                     "│    L L         │\n" + //
                     "└────────────────┘\n"   //
                     
                     , this.board3.toString());
        

    }
    @Test
    public void testDropCuadrado5()throws TetrisException{
        blockI.moveRight(board2.getNumberOfColumns());
        blockI.moveRight(board2.getNumberOfColumns());
        blockI.moveRight(board2.getNumberOfColumns());
        blockI.moveRight(board2.getNumberOfColumns());
        blockI.moveRight(board2.getNumberOfColumns());
        assertTrue(board2.canDrop(blockI));
        blockC.moveRight(board3.getNumberOfColumns());
        blockC.moveRight(board3.getNumberOfColumns());
        blockC.moveRight(board3.getNumberOfColumns());
        blockC.moveRight(board3.getNumberOfColumns());
        blockC.moveRight(board3.getNumberOfColumns());
        assertTrue(board3.canDrop(blockC));             
        assertEquals("│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│                    │\n" + //
                     "│          I         │\n" + //
                     "│          I         │\n" + //
                     "│          I         │\n" + //
                     "│          I         │\n" + //
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
    public void testDropFallo1()throws TetrisException{
        assertTrue(board1.canDrop(new Block()));
        assertTrue(board1.canDrop(new Block()));
        assertTrue(board1.canDrop(new Block()));
        
         assertEquals("│            │\n" + //
                      "│O O         │\n" + //
                      "│O O         │\n" + //
                      "│  O O O O   │\n" + //
                      "│  O O O O   │\n" + //
                      "└────────────┘\n"   //
                     ,this.board1.toString());
        
        assertFalse(board1.canDrop(new Block()));
        assertFalse(board1.canDrop(new Block()));

                  
       
    }
    @Test
    public void testDropFallo2()throws TetrisException{
                 
       
    }
    @Test
    public void testFilasFallo1()throws TetrisException{
        assertTrue(board1.canDrop(new Block()));
        assertTrue(board1.canDrop(new Block()));
        assertTrue(board1.canDrop(new Block()));
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
        assertTrue(board1.canDrop(new Block()));
        assertTrue(board1.canDrop(new Block()));
        assertTrue(board1.canDrop(new Block()));

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

