package es.unileon.prg1.tetris;

import java.nio.Buffer;

public class ArrayMxN {
    protected int[][] array;

    public ArrayMxN(int rows, int columns){
        array=new int[rows][columns];
    }

    public int rows(){
        int nRows=0;
        for(int i=0;i<array.length;i++){
            nRows++;
        }
        return nRows;
    }

    public int columns(){
        int nCols=0;
        for(int i=0;i<array[0].length;i++){
            nCols++;
        }
        
        return nCols;
    }

    public int get(int row, int column) {
        if(row<this.rows()&&row>=0){
            if(column<this.columns()&&column>=0){
                return array[row][column];
            }
        }
        return Integer.MIN_VALUE;
    }

    public boolean set(int row, int column, int value) {
        if(row<this.rows()&&row>=0){
            if(column<this.columns()&&column>=0){
                array[row][column]=value;
                return true;
            }
        }

        return false;
    }

    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<this.rows();i++){
            for(int j=0;j<this.columns();j++){
                buffer.append(array[i][j]);
            }
                buffer.append("\n");
        }
        return buffer.toString();
    }
}
