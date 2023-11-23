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
        num=randomNumber.nextInt(7);
        switch(num){
            case
        }
        return null;
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


    public void drop() {
    }


   


    public void spinRigth() {
    }


    public void moveRigth() {
    }


    public void set(Block block2) {
    }




}