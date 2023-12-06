package es.unileon.prg1.tetris;

import java.util.Random;

import es.unileon.prg1.tetris.strategy.ColorStrategy;
import es.unileon.prg1.tetris.strategy.ColorStrategySingleton;

public class Tetris{
    private Board board;
    private Block block;
    private int points;
    
    
    public Tetris(int rows, int columns, String tieneColor) throws TetrisException{
            checkArguments(rows,columns);
            this.board= new Board(rows,columns);
            ColorStrategySingleton.getInstance(tieneColor);
            this.set(createRandomBlock());
            this.points=0;
       
        

    }
    

    private void checkArguments(int rows, int columns) throws TetrisException {
    if(rows<5||rows>20){
        throw new TetrisException("Error, el numero de filas debe estar entre 5 y 20");
    }else if(columns<6||columns>20){
        throw new TetrisException("Error, el numero de columnas debe estar entre 6 y 20");
    }
}


    private Block createRandomBlock() {
        int num;
        
        Random randomNumber=new Random();
        randomNumber.setSeed(System.currentTimeMillis());
        num=randomNumber.nextInt(8);
        return create(num);
    }


    public Board getBoard() {
        return  this.board;
    }
    public Block getBlock(){
        return this.block;
    }
    public int getPoints(){
        return this.points;
    }


    public void spinLeft() {
        block.rotateLeft();
    }


    public void moveLeft() {
        block.moveLeft();
    }


    public boolean perder() {
        boolean hePerdido=false;
        if(drop()==false){
            hePerdido=true;
        }
        return hePerdido;
    }


    public boolean drop() {
        boolean puede=false;
        int puntuacionObt=0;
        int x=block.getX();
        int y=block.getY();
        puede=(board.canDrop(block,x));
        if(puede){
           puntuacionObt=board.checkAndDeleteRows();
           points+=puntuacionObt;
        }
        
        return puede;
    }


   


    public void spinRight() {
        block.rotateRight();
    }


    public void moveRigth() {
        block.moveRight();

    }


    public void set(Block block2) {
        this.block=block2;
    }


    public Block create(int i) {
        Block bloque=null;
        switch(i){
            case 0: bloque=new Block();
                break;
            case 1: bloque=new Block();
                break;
            case 2: bloque=new BlockI();
                break;
            case 3: bloque=new BlockJ();
                break;
            case 4: bloque=new BlockL();
                break;
            case 5: bloque=new BlockT();
                break;
            case 6: bloque=new BlockS();
                break;
            case 7: bloque=new BlockZ();
                break;
            
        

        }
        return bloque;
    }
   
   
    public String toString(){
        StringBuffer buffer=new StringBuffer();
        buffer.append(block.toString());
        buffer.append("\n");
        buffer.append(board.toString());
        buffer.append("\n");
        buffer.append("PUNTUACION: "+points);
        buffer.append("\n");

        return buffer.toString();
    }




}