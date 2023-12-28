package es.unileon.prg1.tetris;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private Board board1, board2, board3;
    private Block blockC;
    private Block blockI;
    private Block blockJ;
    private Block blockL;
    private Block blockS;
    private Block blockT;
    private Block blockZ;
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
    public void testDrop0()throws TetrisException{
        assertTrue(board1.canDrop(blockC));
        assertTrue(board2.canDrop(blockJ));
        assertTrue(board3.canDrop(blockL));
        
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
                     "│  J                 │\n" + //
                     "│  J                 │\n" + //
                     "│J J                 │\n" + //
                     "└────────────────────┘\n"   //
                     
                     , this.board2.toString());

        assertEquals("│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│                │\n" + //
                     "│L               │\n" + //
                     "│L               │\n" + //
                     "│L L             │\n" + //
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
    public void testDrop2()throws TetrisException{
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
    public void testDrop5()throws TetrisException{
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
        blockC.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(blockC));
        assertTrue(board1.canDrop(blockL));
        blockJ.moveRight(board1.getNumberOfColumns());
        blockJ.moveRight(board1.getNumberOfColumns());
        blockJ.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(blockJ));
        
         assertEquals("│L           │\n" + //
                      "│L           │\n" + //
                      "│L L     J   │\n" + //
                      "│  O O   J   │\n" + //
                      "│  O O J J   │\n" + //
                      "└────────────┘\n"   //
                     ,this.board1.toString());
        
        assertFalse(board1.canDrop(new Block()));
        assertFalse(board1.canDrop(blockZ));
        blockI.moveRight(board1.getNumberOfColumns());
        blockI.moveRight(board1.getNumberOfColumns());
        blockI.moveRight(board1.getNumberOfColumns());
        blockI.moveRight(board1.getNumberOfColumns());
        assertFalse(board1.canDrop(blockI));

        

                  
       
    }
    @Test
    public void testDropFallo2()throws TetrisException{
        blockC.moveRight(board1.getNumberOfColumns());
        blockC.rotateRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(blockC));
        blockL.rotateRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(blockL));
        blockJ.moveRight(board1.getNumberOfColumns());
        blockJ.moveRight(board1.getNumberOfColumns());
        blockJ.moveRight(board1.getNumberOfColumns());
        blockJ.rotateLeft(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(blockJ));
        
        assertEquals( "│            │\n" + //
                      "│            │\n" + //
                      "│L L L       │\n" + //
                      "│L O O J J J │\n" + //
                      "│  O O     J │\n" + //
                      "└────────────┘\n"   //
                     ,this.board1.toString());
        assertFalse(board1.canDrop(blockI));         
        blockI.moveRight(board1.getNumberOfColumns());
        blockI.moveRight(board1.getNumberOfColumns());
        blockI.moveRight(board1.getNumberOfColumns());
        blockI.moveRight(board1.getNumberOfColumns());
        assertFalse(board1.canDrop(blockI));
                 
       
    }
    @Test
    public void testFilasFallo1()throws TetrisException{
        Block bloque1=blockC;
        Block bloque2=new Block();
        Block bloque3=new Block();
        bloque1.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque1));
        bloque2.moveRight(board1.getNumberOfColumns());
        bloque2.moveRight(board1.getNumberOfColumns());
        bloque2.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque2));
        bloque3.moveRight(board1.getNumberOfColumns());
        bloque3.moveRight(board1.getNumberOfColumns());
        bloque3.moveRight(board1.getNumberOfColumns());
        bloque3.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque3));
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
        Block bloque1=blockC;
        Block bloque2=new Block();
        Block bloque3=new Block();
        assertTrue(board1.canDrop(bloque1));
        bloque2.moveRight(board1.getNumberOfColumns());
        bloque2.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque2));
        bloque3.moveRight(board1.getNumberOfColumns());
        bloque3.moveRight(board1.getNumberOfColumns());
        bloque3.moveRight(board1.getNumberOfColumns());
        bloque3.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque3));

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
    @Test
    public void testElim3FIlas()throws TetrisException{
        Block bloque1=blockC;
        Block bloque2=new Block();
        Block bloque3=blockI;
        Block bloque4=new BlockI();
        Block bloque5=new BlockI();
        assertTrue(board1.canDrop(bloque1));
        bloque2.moveRight(board1.getNumberOfColumns());
        bloque2.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque2));
        bloque3.rotateRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque3));
        bloque4.moveRight(board1.getNumberOfColumns());
        bloque4.moveRight(board1.getNumberOfColumns());
        bloque4.moveRight(board1.getNumberOfColumns());
        bloque4.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque4));
        bloque5.moveRight(board1.getNumberOfColumns());
        bloque5.moveRight(board1.getNumberOfColumns());
        bloque5.moveRight(board1.getNumberOfColumns());
        bloque5.moveRight(board1.getNumberOfColumns());
        bloque5.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque5));
        


         assertEquals("│            │\n" + //
                      "│        I I │\n" + //
                      "│I I I I I I │\n" + //
                      "│O O O O I I │\n" + //
                      "│O O O O I I │\n" + //
                      "└────────────┘\n"   //
                     ,this.board1.toString());
        assertEquals(board1.checkAndDeleteRows(),30);
        assertEquals("│            │\n" + //
                     "│            │\n" + //
                     "│            │\n" + //
                     "│            │\n" + //
                     "│        I I │\n" + //
                     "└────────────┘\n"   //
                     ,this.board1.toString());
        
    }
    @Test
    public void testElim4FIlas()throws TetrisException{
        Block bloque1=blockC;
        Block bloque2=new Block();
        Block bloque3=new Block();
        Block bloque4=new BlockI();
        Block bloque5=new BlockI();
        Block bloque6=new Block();
        Block bloque7=blockI;

        assertTrue(board1.canDrop(bloque1));
        bloque2.moveRight(board1.getNumberOfColumns());
        bloque2.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque2));
        assertTrue(board1.canDrop(bloque3));
        bloque6.moveRight(board1.getNumberOfColumns());
        bloque6.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque6));
        bloque7.rotateRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque7));
        bloque4.moveRight(board1.getNumberOfColumns());
        bloque4.moveRight(board1.getNumberOfColumns());
        bloque4.moveRight(board1.getNumberOfColumns());
        bloque4.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque4));
        bloque5.moveRight(board1.getNumberOfColumns());
        bloque5.moveRight(board1.getNumberOfColumns());
        bloque5.moveRight(board1.getNumberOfColumns());
        bloque5.moveRight(board1.getNumberOfColumns());
        bloque5.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque5));
        


         assertEquals("│I I I I     │\n" + //
                      "│O O O O I I │\n" + //
                      "│O O O O I I │\n" + //
                      "│O O O O I I │\n" + //
                      "│O O O O I I │\n" + //
                      "└────────────┘\n"   //
                     ,this.board1.toString());
        assertEquals(board1.checkAndDeleteRows(),40);
        assertEquals("│            │\n" + //
                     "│            │\n" + //
                     "│            │\n" + //
                     "│            │\n" + //
                     "│I I I I     │\n" + //
                     "└────────────┘\n"   //
                     ,this.board1.toString());
        
    }
    @Test
    public void testElimFilasAcierto2()throws TetrisException{
        Block bloque1=blockI;
        Block bloque2=blockL;
        Block bloque3=blockJ;
        bloque2.rotateLeft(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque2));
        bloque1.moveRight(board1.getNumberOfColumns());
        bloque1.moveRight(board1.getNumberOfColumns());
        bloque1.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque1));
        bloque3.moveRight(board1.getNumberOfColumns());
        bloque3.moveRight(board1.getNumberOfColumns());
        bloque3.moveRight(board1.getNumberOfColumns());
        bloque3.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque3));

         assertEquals("│            │\n" + //
                      "│      I     │\n" + //
                      "│      I   J │\n" + //
                      "│    L I   J │\n" + //
                      "│L L L I J J │\n" + //
                      "└────────────┘\n"   //
                     ,this.board1.toString());
        assertEquals(board1.checkAndDeleteRows(),10);
         assertEquals("│            │\n" + //
                      "│            │\n" + //
                      "│      I     │\n" + //
                      "│      I   J │\n" + //
                      "│    L I   J │\n" + //
                      "└────────────┘\n"   //
                     ,this.board1.toString());
        
    }

    @Test
    public void testElimFilasAcierto3()throws TetrisException{
        Block bloque1=blockI;
        Block bloque2=blockL;
        Block bloque3=blockJ;
        Block bloque4=blockT;
        bloque2.rotateLeft(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque2));
        bloque1.moveRight(board1.getNumberOfColumns());
        bloque1.moveRight(board1.getNumberOfColumns());
        bloque1.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque1));
        bloque4.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque4));
        bloque3.moveRight(board1.getNumberOfColumns());
        bloque3.moveRight(board1.getNumberOfColumns());
        bloque3.moveRight(board1.getNumberOfColumns());
        bloque3.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque3));

         assertEquals("│  T T T     │\n" + //
                      "│    T I     │\n" + //
                      "│      I   J │\n" + //
                      "│    L I   J │\n" + //
                      "│L L L I J J │\n" + //
                      "└────────────┘\n"   //
                     ,this.board1.toString());
        assertEquals(board1.checkAndDeleteRows(),10);
         assertEquals("│            │\n" + //
                      "│  T T T     │\n" + //
                      "│    T I     │\n" + //
                      "│      I   J │\n" + //
                      "│    L I   J │\n" + //
                      "└────────────┘\n"   //
                     ,this.board1.toString());
        
    }
    @Test
    public void testElimFilasAcierto4()throws TetrisException{
        Block bloque1=blockI;
        Block bloque2=blockL;
        Block bloque3=blockJ;
        Block bloque4=blockS;
        bloque1.rotateLeft(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque1));
        bloque3.rotateLeft(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque3));
        bloque4.moveRight(board1.getNumberOfColumns());
        bloque4.moveRight(board1.getNumberOfColumns());
        bloque4.moveRight(board1.getNumberOfColumns());
        bloque4.rotateLeft(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque4));
        bloque2.rotateRight(board1.getNumberOfColumns());
        bloque2.rotateRight(board1.getNumberOfColumns());
        bloque2.moveRight(board1.getNumberOfColumns());
        bloque2.moveRight(board1.getNumberOfColumns());
        bloque2.moveRight(board1.getNumberOfColumns());
        bloque2.moveRight(board1.getNumberOfColumns());
        assertTrue(board1.canDrop(bloque2));

         assertEquals("│            │\n" + //
                      "│            │\n" + //
                      "│J J J S L L │\n" + //
                      "│    J S S L │\n" + //
                      "│I I I I S L │\n" + //
                      "└────────────┘\n"   //
                     ,this.board1.toString());
        assertEquals(board1.checkAndDeleteRows(),20);
         assertEquals("│            │\n" + //
                      "│            │\n" + //
                      "│            │\n" + //
                      "│            │\n" + //
                      "│    J S S L │\n" + //
                      "└────────────┘\n"   //
                     ,this.board1.toString());
        
    }

}

