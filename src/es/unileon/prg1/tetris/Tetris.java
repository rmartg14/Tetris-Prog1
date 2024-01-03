package es.unileon.prg1.tetris;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import es.unileon.prg1.tetris.strategy.ColorStrategy;
import es.unileon.prg1.tetris.strategy.ColorStrategySingleton;

/**
 * Clase principal del proyecto encargada de comunicarse con todas las demás y delegarle las tareas
 * envidas desde el textUI
 * @author Rubén Martínez
 */
public class Tetris{
    // Atributo que permite comunicarse con el board
    private Board board;
    // Atributo que permite crear y utilizar los bloques
    private Block block;
    // Contador de puntos del jugador
    private int points;
    //Atriuto para poder generar los logs en el fichero log.log
    static final Logger logger = LogManager.getLogger(Tetris.class.getName());
    //Atributo para generar un número random
    private Random randomNumber;

    
    /**
	 * Constructor del juego que se encarga de inicializar todos sus componentes
	 * 
	 * @param rows Número de filas que tiene el board
     * @param columns Número de columnas que tiene el board
     * @param tieneColor String para crear el tetris en modo color o sin color
	 */
    public Tetris(int rows, int columns, String tieneColor) throws TetrisException{
            checkArguments(rows,columns);
            this.board= new Board(rows,columns);
            ColorStrategySingleton.getInstance(tieneColor);
            this.randomNumber=new Random();
            randomNumber.setSeed(System.currentTimeMillis());
            this.set(createRandomBlock());
            this.points=0;
    }
    
    /**
	 * Método que comprueba el valor de los argumentos para que sea correcto
	 * 
	 * @param rows Número de filas del board
     * @param columns Número de columnas del board
     * @throws TetrisException Lanza excepción si el número de filas y columnas no estan entre los valores indicados
	 */ 
    private void checkArguments(int rows, int columns) throws TetrisException {
    if(rows<5||rows>20){
        logger.error("El número de filas pasado por linea de comando es erróneo, debe estar entr 5 y 20");
        throw new TetrisException("Error, el numero de filas debe estar entre 5 y 20");
    }else if(columns<6||columns>20){
        logger.error("El número de columnas pasado por linea de comando es erróneo, debe estar entre 6 y 20");
        throw new TetrisException("Error, el numero de columnas debe estar entre 6 y 20");
    }

    }

    /**
	 * Llama al método create que crea un bloque distinto dependiendo del número que le pases,
     * pasándole un número generado de forma random entre el 0 y el 7
	 * 
	 * @return bloque rándom generado
	 */
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
     * @throws TetrisException Propaga la excepción que lanza block.moveLeft()
     */
    public void moveLeft() throws TetrisException {
            block.moveLeft();
        
        
    }

  

    /**
     * Este método comprueba si puedes bajar el bloque actual
     * Tras colocarse el bloque comprueba si hay filas llenas y si las hay suma su puntuación a la total
     * Tras colocar el bloque llama a createRandomBlock() para crear el siguiente bloque a colocar de forma random
     * 
     * @return True si se puede realizar el drop, false si no se puede
     */
    public boolean drop() {
        boolean puede=false;
        int puntuacionObt=0;
        
        puede=(board.canDrop(this.block));
        if(puede){
            logger.info("La pieza se coloca con éxito en la posición x= "+block.getX());
            this.set(createRandomBlock());
           puntuacionObt=board.checkAndDeleteRows();
           if(puntuacionObt>0){
            if(puntuacionObt==10){
                logger.info("Se elimina "+puntuacionObt/10+" fila y se suman "+puntuacionObt+" puntos");
            }else{
                logger.info("Se eliminan "+puntuacionObt/10+" filas y se suman "+puntuacionObt+" puntos");
            }
            
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
     * @throws TetrisException Propaga la excepción que lanza block.moveRight(colBoard)
     */
    public void moveRigth() throws TetrisException {
        
            int colBoard=board.getNumberOfColumns();
            block.moveRight(colBoard);
        
        

    }

    /**
     * Este método establece el siguiente bloque a colocar
     * @param block2 Siguiente bloque a colocar
     */
    public void set(Block block2) {
        this.block=block2;
    }

    /**
     * Este método crea un bloque distinto dependiendo del número que recibe como parámetro
     * 
     * @param i Número random del 1 al 7
     * @return bloque creado
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
     * Este método devuelve un string del juego, incluyendo el bloque el board y la puntuación
     * 
     * @return Representación visual del juego.
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