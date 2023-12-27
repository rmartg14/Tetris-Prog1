package es.unileon.prg1.tetris;

/**
* La clase Board representa el tablero del juego Tetris. Contiene métodos para
* manejar la colocación de bloques, la verificación y eliminación de filas
* completas, y la representación visual del tablero.
* 
* @author Mario Fernández
*/

public class Board {

    private Piece[][] tablero;
    private Block block;
    private Piece Piece;

    /**
     * Constructor de la clase Board que inicializa el tablero con el número
     * especificado de filas y columnas, y lo llena con piezas vacías.
     * 
     * @param rows    Número de filas del tablero.
     * @param columns Número de columnas del tablero.
     */

    public Board(int rows, int columns) {
    	this.tablero = new Piece[rows][columns];
        this.iniciarTablero();
    }

    /**
     * creacion de una iniciacion del tablero con todo piezas vacias
     */

    private void iniciarTablero(){
        for(int i=0; i<tablero.length;i++){
            for (int j=0; j<tablero[0].length; j++){
                tablero[i][j]=new Piece();
            }
        }
    }

    /**
     * Devuelve el número de filas del tablero.
     * 
     * @return Número de filas del tablero.
     */

    public int getNumberOfRows(){
        return tablero.length;
    }


    /**
     * Devuelve el número de columnas del tablero.
     * 
     * @return Número de columnas del tablero.
     */

    public int getNumberOfColumns(){
        return tablero[0].length;
    }


     /**
     * Comprueba si es posible colocar el bloque en el tablero en la posición actual
     * del bloque. Devuelve verdadero si es posible, falso de lo contrario.
     * 
     * @param block Bloque a colocar en el tablero.
     * @return True si el bloque puede colocarse, false de lo contrario.
     */

    public boolean canDrop(Block block) {
        boolean canDrop = true;
        
        if (canPlace(block)) {
            int x = block.getX();
            int y = block.getY();
            boolean conflicto=false;
            while(y + block.getRowsBlock() < tablero.length&&!conflicto){
                for (int i = 0; i < block.getRowsBlock(); i++) {
                    for (int j = 0; j < block.getColumnsBlock(); j++) {
                        int elem = block.getElem(i, j);
                        //comprobamos si el elemento es 1 o 0
                        if (elem == 1) {
                            if (!tablero[y+1 + i][x + j].isEmpty()) {
                                conflicto=true;    
                            }
                        }
                    }
                }
                if(!conflicto){
                    block.bajarBloque();
                    y = block.getY();
                }

            }
            placeBlock(block);
            
        
        }else{
            canDrop=false;
        }

        return canDrop;
    }
        
    /**
         * Comprueba si es posible colocar el bloque en el tablero en la posición actual
         * del bloque. Devuelve verdadero si es posible, falso de lo contrario.
         * 
         * @param block Bloque a colocar en el tablero.
         * @return True si el bloque puede colocarse, false de lo contrario.
         */
    private boolean canPlace(Block block) {
        int x = block.getX();
        int y = block.getY();
        boolean canPlace=true;
        if(x+block.getColumnsBlock()>=tablero[0].length+1){
            canPlace=false;
        }
        for (int i = 0; i < block.getRowsBlock(); i++) {
            //for (int j = 0; j < block.columns(i); j++) {
            for (int j = 0; j < block.getColumnsBlock(); j++) {
                int elem = block.getElem(i, j);
                    //comprobamos si el elemento es 1 o 0
                if (elem == 1) {
                    if (!tablero[y + i][x + j].isEmpty()) {
                        canPlace=false; 
                    }
                }
            }
        }
        return canPlace; 
    }

    /**
     * Coloca el bloque en el tablero en la posición actual del bloque.
     * 
     * @param block Bloque a colocar en el tablero.
     */

    private void placeBlock(Block block) {
        int x = block.getX();
        int y = block.getY(); 
        
        for (int i = 0; i < block.getRowsBlock(); i++) {
            for (int j = 0; j < block.getColumnsBlock(); j++) {
                int elem= block.getElem(i, j);
                // Colocar el bloque en el tablero
                if (elem == 1) {
                    tablero[y+i][x+j] = new Piece(block.getModelo());
                }
            }
        }
    }    


    /**
     * Comprueba y elimina las filas completas del tablero, desplazando las filas
     * superiores hacia abajo y devolviendo el puntaje obtenido.
     * 
     * @return Puntaje obtenido por eliminar filas completas.
     */

    public int checkAndDeleteRows(){
        int marcador = 0;
        for (int i = tablero.length - 1; i >= 0; i--) {
            while (isRowEmpty(i)==true) {
                deleteRow(i);
                rowsDrops(i);
                marcador=marcador+10;
            }
        }
        return marcador;
    }

    
    /**
     * Comprueba si una fila está vacía.
     * 
     * @param row Índice de la fila a verificar.
     * @return True si la fila está vacía, false de lo contrario.
     */
    private boolean isRowEmpty(int row) {
        boolean isRowEmpty=true;
        for (int i = 0; i < tablero[0].length; i++) {
            if (tablero[row][i].isEmpty()) {
                isRowEmpty = false; // La fila no está llena
            }
        }
        
        return isRowEmpty; // La fila está llena
    }


    /**
     * Elimina una fila completa y la rellena con piezas vacías.
     * 
     * @param row Índice de la fila a eliminar.
     */
    private void deleteRow(int row) {

        for (int i = 0; i < tablero[row].length; i++) {
            tablero[row][i] = new Piece(); // Reemplazar todas las piezas por Piece("  ")
        }
    }

     /**
     * Desplaza las filas superiores hacia abajo después de eliminar una fila.
     * 
     * @param row Índice de la fila eliminada.
     */
    private void rowsDrops(int row) {
        
        for (int i = row-1; i >= 0; i--) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i + 1][j] = tablero[i][j]; // Desplazar las filas superiores hacia abajo
            }
        }
        for (int j = 0; j < tablero[0].length; j++) {
            tablero[0][j] = new Piece(); // Desplazar las filas superiores hacia abajo
        }
    }

    /**
     * Devuelve una representación visual del tablero en formato de cadena de
     * caracteres.
     * 
     * @return Representación visual del tablero.
     */

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < tablero.length; i++) {
            result.append("\u2502");
            for (int j = 0; j < tablero[i].length; j++) {
                result.append(tablero[i][j]);
            }     
            result.append("\u2502");
            result.append("\n"); 
                    
            
        }
            result.append("\u2514");    
            for (int j=0; j<tablero[0].length*2; j++){
                result.append("\u2500");
            }      
            result.append("\u2518");  
            result.append("\n");
        
        return result.toString();
    }
}


/*
Board se basa en dos  operaciones importantes:
Los metodos necesarios para crear el drop, de forma "temporal" de las piezas donde se va mirando si la el blocke cabe en la siguiente fila,
así hasta que llegue a tocar piezas, donde se pone de forma "real" el bloque en cuestion.

Los metodos necesarios (todo dependiendo de la matriz de piezas) cuando una fila se rellene entera, que desaparezcan las piezas de ella
y (con gravedad) caen las piezas de las filas superiores, además se incrementaria el contador de puntuacion.
 */

