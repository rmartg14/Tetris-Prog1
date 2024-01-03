package es.unileon.prg1.tetris;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import es.unileon.prg1.tetris.strategy.ColorStrategy;
import es.unileon.prg1.tetris.strategy.ColorStrategySingleton;

public class Tetris{
    // Atributo que permite cambiar el board
    private Board board;
    // Atributo que permite mover los bloques
    private Block block;
    // Atributo que es un contador para contar cuantos puntos lleva el jugador
    private int points;
    static final Logger logger = LogManager.getLogger(Tetris.class.getName());
    private Random randomNumber;

    
    // Se crea el juego tetris, este contructor crea un board con la longitud que le pasa el  usuario, el primer bloque e inicializa el contador de puntos a 0
    public Tetris(int rows, int columns, String tieneColor) throws TetrisException{
            checkArguments(rows,columns);
            this.board= new Board(rows,columns);
            ColorStrategySingleton.getInstance(tieneColor);
            this.randomNumber=new Random();
            randomNumber.setSeed(System.currentTimeMillis());
            this.set(createRandomBlock());
            this.points=0;
    }
    
    // Comprueba que las filas y columnas estan bien en el rango  
    private void checkArguments(int rows, int columns) throws TetrisException {
    if(rows<5||rows>20){
        logger.error("El número de filas pasado por linea de comando es erróneo");
        throw new TetrisException("Error, el numero de filas debe estar entre 5 y 20");
    }else if(columns<6||columns>20){
        logger.error("El número de columnas pasado por linea de comando es erróneo");
        throw new TetrisException("Error, el numero de columnas debe estar entre 6 y 20");
    }

    }

    // Crea un bloque aleatorio
    private Block createRandomBlock() {
        int num;
        num=randomNumber.nextInt(8);
        return create(num);
    }

    /** 
    * Este método devuelve el board
    * @return board
    */ 
    public Board getBoard() {
        return  this.board;
    }

    /** 
     * Este método devuelve el bloque actual
     * @return block
     */
    public Block getBlock(){
        return this.block;
    }

    /**
     * Este método devuelve los puntos actuales
     * @return points
     */
    public int getPoints(){
        return this.points;
    }

    /**
     * Este método rota el bloque a la izquierda
     */
    public void spinLeft() {
        int colBloque=board.getNumberOfColumns();
        block.rotateLeft(colBloque);
    }

    /**
     * Este método mueve el bloque a la izquierda
     * @throws TetrisException
     */
    public void moveLeft() throws TetrisException {
            block.moveLeft();
        
        
    }

  

    /**
     * Este método comprueba si puedes bajar el bloque actual, si puedes devuelve true, si no devuelve false. 
     * Este método también es el metodo que suma la puntuación
     * @return puede
     */
    public boolean drop() {
        boolean puede=false;
        int puntuacionObt=0;
        
        puede=(board.canDrop(this.block));
        if(puede){
            logger.info("La pieza se puede colocar con éxito en la posición x= "+block.getX());
            this.set(createRandomBlock());
           puntuacionObt=board.checkAndDeleteRows();
           if(puntuacionObt>0){
            logger.info("Se eliminan "+puntuacionObt/10+" filas y se suman "+puntuacionObt+" puntos");
           } 
           points+=puntuacionObt;
        }
        
        return puede;
    }


   

    /**
     * Este método rota el bloque a la derecha
     */
    public void spinRight() {
        int colBloque=board.getNumberOfColumns();
        block.rotateRight(colBloque);
    }

    /**
     * Este método mueve el bloque a la derecha
     * @throws TetrisException
     */
    public void moveRigth() throws TetrisException {
        
            int colBloque=board.getNumberOfColumns();
            block.moveRight(colBloque);
        
        

    }

    /**
     * Este método actualiza el bloque
     */
    public void set(Block block2) {
        this.block=block2;
    }

    /**
     * Este método crea un bloque aleatorio
     * @return bloque
     */
    public Block create(int i) {
        Block bloque=null;
        switch(i){
            case 0: bloque=new Block();
                    logger.info("Cuadrado creado");
                break;
            case 1: bloque=new Block();
                    logger.info("Cuadrado creado");
                break;
            case 2: bloque=new BlockI();
                    logger.info("Bloque I creado");
                break;
            case 3: bloque=new BlockJ();
                    logger.info("Bloque J creado");
                break;
            case 4: bloque=new BlockL();
                    logger.info("Bloque L creado");
                break;
            case 5: bloque=new BlockT();
                    logger.info("Bloque T creado");
                break;
            case 6: bloque=new BlockS();
                    logger.info("Bloque S creado");
                break;
            default: bloque=new BlockZ();
                    logger.info("Bloque Z creado");
                
            
        

        }
        return bloque;
    }
   
    /**
     * Este método devuelve un string del juego, incluyendo el bloque y el board
     * Cada vez que pones un bloque se vuelve a llamar a este método
     */
    public String toString(){
        StringBuffer buffer=new StringBuffer();
        buffer.append(block.toString());
        buffer.append("\n");
        buffer.append("\n");
        buffer.append(board.toString());
        buffer.append("POINTS: "+points);
      

        return buffer.toString();
    }




}