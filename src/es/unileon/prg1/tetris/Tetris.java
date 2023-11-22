package es.unileon.prg1.tetris;
public class Tetris{
    private Board board;
    private Block block;
    private int points;
    private Color color;
    
    public Tetris(int rows, int columns, String tieneColor){
        this.board= new Board(rows,columns);
        if(noColor(tieneColor)){
            this.color=Color.NONE;
        }
        this.block=new Block();
        this.points=0;

    }
    private boolean noColor(String color){
        boolean noColor=false;
        if(color=="nocolor"){
            noColor=true;
        }
        return noColor;
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




}