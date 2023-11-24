package es.unileon.prg1.tetris;

import java.util.Random;

import es.unileon.prg1.tetris.strategy.ColorStrategy;
import es.unileon.prg1.tetris.strategy.ColorStrategySingleton;

public class Tetris{
    private Board board;
    private Block block;
    private int points;
    
    
    public Tetris(int rows, int columns, String tieneColor){
        this.board= new Board(rows,columns);
        ColorStrategySingleton.getInstance(tieneColor);
        this.block=createRandomBlock();
        this.points=0;

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
    }


    public void moveLeft() {
    }


    public boolean perder() {
        return false;
    }


    public boolean drop() {
        return false;
    }


   


    public void spinRight() {
    }


    public void moveRigth() {
    }


    public void set(Block block2) {
    }


    public Block create(int i) {
        Block bloque;
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
        return null;
    }
   
   
    public String toString(){
        return "";
    }




}