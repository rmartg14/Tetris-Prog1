package es.unileon.prg1.tetris;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Esta clase se encarga de crear los bloques a introducir en el tetris y modificar su 
 * posición y su orentación con métodos de mover y girar los bloques
 * 
 * Se trata de un array de unos y ceros, los cuáles al imprimir el bloque pasan a ser piezas 
 * de distinctos colores y tipos dependiendo el tipo de bloque.
 * 
 * @author Pedro Gavin
 */

public class Block {
    /** Atributo de una matriz de 1s y 0s a la que se delegan muchas operaciones de la clase.*/
    protected ArrayMxN bloque;
    /** Atributo para acceder a las coordenadas actuales del bloque */
    protected Coordenadas cor;
    /** Atributo para acceder al tipo de piezas que va a utilizar el bloque.*/
    protected Piece modelo;
    //Atriuto para poder generar los logs en el fichero log.log
    static final Logger logger = LogManager.getLogger(Block.class.getName());
   

    /**
     * Constructor de la clase que crea el bloque genérico que, en este caso, es un cuadrado de 2x2.
     */
    public Block(){
        bloque = new ArrayMxN(2, 2);
        bloque.set(0, 0, 1);
        bloque.set(0, 1, 1);
        bloque.set(1, 0, 1);
        bloque.set(1, 1, 1);
        
        cor = new Coordenadas();
        this.modelo = new Piece(Color.YELLOW, "O");
    }

    /**
	 * Devuelve el modelo que corresponde a este bloque
	 * 
	 * @return Modelo(color y caracter) de cada pieza de este bloque
	 */
    public Piece getModelo(){
        return this.modelo;
    }
    /**
	 * Devuelve el elemento que se encuentra en la posición 
     * de la fila y columna que se pasa como parámetro
	 * 
	 * @param row Fila de la matriz bloque
     * @param col Columna de la matriz bloque
	 * @return Elemento que se encontraba en la posición (row,col)
	 */
    public int getElem(int row, int col){
        return bloque.get(row, col);
    }
    /**
	 * Devuelve las coordenadas actuales del bloque
	 * 
	 * @return Coordenadas x e y del bloque
	 */
    public Coordenadas getCoordenadas(){
        return cor;
    }
    /**
	 * Devuelve la cordenada x del bloque
	 * 
	 * @return Coordenada x del bloque
	 */
    public int getX(){
        return cor.getX();
    }
    /**
	 * Devuelve la cordenada y del bloque
	 * 
	 * @return Coordenada y del bloque
	 */
    public int getY(){
        return cor.getY();
    }
    /**
	 * Devuelve el número de columnas del bloque
	 * 
	 * @return Número de columnas que tiene la matriz del bloque
	 */
    public int getColumnsBlock(){
        return bloque.columns();
    }
    /**
	 * Devuelve el número de filas del bloque
	 * 
	 * @return Número de filas que tiene la matriz del bloque
	 */
    public int getRowsBlock(){
        return bloque.rows();
    }
    /**
	 * Suma 1 a la coordenada y
	 */
    public void bajarBloque(){
        cor.dropOne();
    }
    /**
     * Rota el bloque hacia la izquierda
     * 
	 * Convierte el bloque actual en un array NxN para poder llamar a spinLeft de 
     * ArrayNxN, tras hacer esta operación vuelve a copiar el resultado en el bloque
     * 
     * @param columnas Número de columnas que tiene el tablero
	 */
    public void rotateLeft(int columnas){
        if (bloque.get(0, 0) == 1 && bloque.get(1, 0) == 1 && bloque.get(0, 1) == 1 && bloque.get(1, 1) == 1) {
            
        } else {
            ArrayNxN array=new ArrayNxN(this.bloque);
            array=array.spinLeft();
            this.bloque=array.getMinArray();
            //Si al rotar el bloque se exceden los límites del tablero se mueve el bloque a la izquierda hasta que vuelva a entrar
            if (cor.getX() + bloque.columns() >= columnas) {
                int cont = cor.getX() + bloque.columns() - columnas ;
                cor.setX(cor.getX()-cont);
            }
        }
    }
    /**
     * Rota el bloque hacia la derecha
     * 
	 * Convierte el bloque actual en un array NxN para poder llamar a spinRight de 
     * ArrayNxN, tras hacer esta operación vuelve a copiar el resultado en el bloque
     * 
     * @param columnas Número de columnas que tiene el tablero
	 */
    public void rotateRight(int columnas){
        if (bloque.get(0, 0) == 1 && bloque.get(1, 0) == 1 && bloque.get(0, 1) == 1 && bloque.get(1, 1) == 1) {
            
        } else {
            ArrayNxN array=new ArrayNxN(this.bloque);
            array=array.spinRight();
            this.bloque=array.getMinArray();
            //Si al rotar el bloque se exceden los límites del tablero se mueve el bloque a la izquierda hasta que vuelva a entrar
            if (cor.getX() + bloque.columns() >= columnas) {
                int cont = cor.getX() + bloque.columns() - columnas ;
                cor.setX(cor.getX()-cont);
            }
        }
        
        
        
    }

    /**
	 * Resta 1 a la coordenada x
     * @throws TetrisException Se lanza cuando no puedo mover el bloque a la izquerda
	 */
    public void moveLeft() throws TetrisException{
        if((cor.getX() - 1 < 0)){
            logger.error("No se puede mover el bloque a la izquierda");
            throw new TetrisException("Error, no puedes mover el bloque a la izquierda");
        }

        cor.moverIzquierda();
    }

    /**
	 * Suma 1 a la coordenada x
     * @throws TetrisException Se lanza cuando no puedo mover el bloque a la derecha
	 */
    public void moveRight(int columnas) throws TetrisException{
        if (cor.getX() + bloque.columns() >= columnas){
            logger.error("No se puede mover el bloque a la derecha");
            throw new TetrisException("Error, no puedes mover el bloque a la derecha");
        }  
        cor.moverDerecha();
    }
    /*
     * Devuelve un String del bloque creado
     * 
     * Desde la coordenada x=0 hasta la x actual del bloque coloca una pieza vacia.
     * Una vez llega a la coordenada x recorre la pieza y dónde encuentra un 1 coloca 
     * una pieza del tipo del modelo que se inicializa en el constructor
     * 
     * @return Representación visual del bloque.
     */
    @Override
    public String toString(){
        StringBuffer output = new StringBuffer();
        Piece p = new Piece();
       
        
        for (int i = 0; i < bloque.rows(); i++) {
            output.append(" ");
            for(int k = 0; k < cor.getX(); k++){
                output.append(p.toString());
            }

            for (int j = 0; j < bloque.columns(); j++) {
                
                if (bloque.get(i, j) == 1) {
                    output.append(this.modelo.toString());
                } else {
                    
                    output.append(p.toString());
                }
                
            }
            if(i!=bloque.rows()-1){
                output.append("\n");
            }
        }
        return output.toString(); 
    }
}
