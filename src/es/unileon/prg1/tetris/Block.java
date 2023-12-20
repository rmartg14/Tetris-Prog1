package es.unileon.prg1.tetris;


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
    /*
     * Crear metodo bajarBloque llamando a dropOne de Coordenadas para poder llamar a block.bajarBloque desde board-----Done
     * Crear metodo getX y getY que devuelvan las cooredenadas actuales del bloque llamando a cor.getX u cor.getY-----Done
     * Crear método getModelo() que devuelva this.modelo----------Done
     * Crar un metodo block.getElem(fila,col) para que devuelva el contenido de block[i][j] que es 1 o 0--------Done
     * 
     * 
     */

     /**
     * Creamos el bloque genérico que en este caso es un cuadrado de 2x2.
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
	 * @return modelo
	 */
    public Piece getModelo(){
        return this.modelo;
    }
    /**
	 * Devuelve el elemento que se encuentra en la posición 
     * de la fila y columna que se pasa como parámetro
	 * 
	 * @param row
     * @param col
	 * @return elem
	 */
    public int getElem(int row, int col){
        return bloque.get(row, col);
    }
    /**
	 * Devuelve las coordenadas actuales del bloque
	 * 
	 * @return cor
	 */
    public Coordenadas getCoordenadas(){
        return cor;
    }
    /**
	 * Devuelve la cordenada x del bloque
	 * 
	 * @return cordX
	 */
    public int getX(){
        return cor.getX();
    }
    /**
	 * Devuelve la cordenada y del bloque
	 * 
	 * @return cordY
	 */
    public int getY(){
        return cor.getY();
    }
    /**
	 * Devuelve el número de columnas del bloque
	 * 
	 * @return nCols
	 */
    public int getColumnsBlock(){
        return bloque.columns();
    }
    /**
	 * Devuelve el número de filas del bloque
	 * 
	 * @return nRows
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
	 */
    public void rotateLeft(){
        int mayorL = 0;
        if (bloque.rows() < bloque.columns()) {
            mayorL = bloque.columns();
        } else {
            mayorL = bloque.rows();
        }
        ArrayNxN blockN = new ArrayNxN(mayorL);
        for (int i = 0; i < blockN.rows(); i++) {
            for (int j = 0; j < blockN.columns(); j++) {
                if (bloque.get(i, j) != 0) {
                    blockN.set(i, j, bloque.get(i, j));  
                } else {
                    blockN.set(i, j, 0);
                }
                
            }
        }
        if (cor.getX() - bloque.rows() < 0) {
            int moves = (cor.getX() - bloque.rows())*(-1);
            for (int i = 0; i < moves; i++) {
                cor.setX(cor.getX() + 1);
            }
        }
        blockN.spinLeft();
        blockN.getMinArray();
        for (int i = 0; i < blockN.rows(); i++) {
            for (int j = 0; j < blockN.columns(); j++) {
                bloque.set(i, j, blockN.get(i, j));
            }
        }
        
    }
    /**
     * Rota el bloque hacia la derecha
     * 
	 * Convierte el bloque actual en un array NxN para poder llamar a spinRight de 
     * ArrayNxN, tras hacer esta operación vuelve a copiar el resultado en el bloque
	 */
    public void rotateRight(int columnas){
        int mayorL = 0;
        if (bloque.rows() < bloque.columns()) {
            mayorL = bloque.columns();
        } else {
            mayorL = bloque.rows();
        }
        ArrayNxN blockN = new ArrayNxN(mayorL);
        for (int i = 0; i < blockN.rows(); i++) {
            for (int j = 0; j < blockN.columns(); j++) {
                if (bloque.get(i, j) != 0) {
                    blockN.set(i, j, bloque.get(i, j));  
                } else {
                    blockN.set(i, j, 0);
                }
                
            }
        }
        if (bloque.rows() + cor.getX() >= columnas) {
            int moves = (bloque.rows() + cor.getX()) - columnas + 1;
            for (int i = 0; i < moves; i++) {
                cor.setX(cor.getX() - 1);
            }
        }
        blockN.spinRight();
        blockN.getMinArray();
        for (int i = 0; i < blockN.rows(); i++) {
            for (int j = 0; j < blockN.columns(); j++) {
                bloque.set(i, j, blockN.get(i, j));
            }
        }
    }

    /**
	 * Resta 1 a la coordenada x
	 */
    public void moveLeft(){
        if(!(cor.getX() - 1 < 0)){
            cor.moverIzquierda();
        }
    }
//lanzar excepcion si no se puede mover mas
    /**
	 * Suma 1 a la coordenada x
	 */
    public void moveRight(int columnas){
        if (cor.getX() + bloque.columns() < columnas){
            cor.moverDerecha();
        }  
    }
    /*
     * Devuelve un String del bloque creado
     * 
     * Desde la coordenada x=0 hasta la x actual del bloque coloca un espacio.
     * Una vez llega a la coordenada x recorre la pieza y dónde encuentra un 1 coloca 
     * una pieza del tipo del modelo que se inicializa en el constructor
     */
    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        Piece p = new Piece();
        for(int i=0;i<cor.getX();i++){
            stringBuffer.append(p.toString());
        }
        for (int i = 0; i < bloque.rows(); i++) {
            for (int j = 0; j < bloque.columns(); j++) {
                if (bloque.get(i, j) == 1) {
                    stringBuffer.append(this.modelo.toString());
                } else {
                    
                    stringBuffer.append(p.toString());
                }
                
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString(); 
    }
}
