package es.unileon.prg1.tetris;

public class Board {

    private Piece[][] tablero;
    private Block block;
    private Piece Piece;

    public Board(int rows, int columns) {
    	this.tablero = new Piece[rows][columns];
        
    }
    //creacion de una iniciacion del tablero con todo 0's
    public void iniciarTablero(){
        Piece emptyPiece= new Piece();
        for(int i=0; i<tablero.length;i++){
            for (int j=0; j<tablero[0].length; j++){
                tablero[i][j]=emptyPiece;
            }
        }
    }
    public int getNumberOfRows(){
        return tablero.length;
    }
    public int getNumberOfColumns(){
        return tablero[0].length;
    }

/* sabiendo que lo que mide cada objeto, de ancho y largo hacer
sabiendo dsde que x1 empieza y x2 acaba, ir bajando y's
cuando y=0, entra la pieza?
si
cuando y=1, entra la pieza?
si
...
cuando y=3, entra la pieza?
no
colocar bloque en y=3-1.
cuando se sabe donde esta el bloque, se genera 
si introduzo el bloque en empezando si en cordenada y+1 no entra, ya pierdes
*/

 
/* DUDAS
 * como poner las piezas que se corresponden al block que tenemos
 * como poner para que termine el juego (se lo pregunto antes a los compañeros)
 */
public boolean canDrop(Block block, int x) {
    //llamar a bolque.getX
    int lengthBlock = block.getColumnsBlock();
    int maxY = tablero.length - block.getRowsBlock();
    boolean canDrop;

    if (canPlace(block, x, 0)) {
        int y = 0;
        //llamar a bloque.getY

        // Mover hacia abajo hasta encontrar una posición válida
        while (y < maxY && canPlace(block, x, y + 1)) {
            //cada vex que puede bajar llamar a block.bajarBloque y hacet y=getY()
            y++;
            //
        }

        placeBlock(block, x, y - 1);
        canDrop=true;
    } else {
        canDrop=false;
        //No cabria en la possicion de y =0, por lo que pierdo.
    }
    return canDrop;
}


//este metodo comprueba si se puede poner o no poner el bloque en ese sitio
private boolean canPlace(Block block, int x, int y) {
    //int x=block.getX()
    //int y=block.getY()-1;
    boolean canPlace=true;
    for (int i = 0; i < block.getRowsBlock(); i++) {
        for (int j = 0; j < block.getColumnsBlock(); j++) {
            //llamar a bloque.getElem(i,j)que devuelva el elemento en block[i][j]
            //Comprobar si este elemento que devuelve getElem es ==1 y si lo es comprobar que la posicion donde lo quieres 
            //colocar tiene una pieza vacia, si no la tiene devolver false
            //if(board[x][y]!=vacia
            //
            //x++:
        }
        //x=block.getX();
        //y++;
    }
    return canPlace; 
}

private void placeBlock(Block block, int x, int y) {
    for (int i = 0; i < block.getRowsBlock(); i++) {
        for (int j = 0; j < block.getColumnsBlock(); j++) {
            // Colocar el bloque en el tablero
            tablero[y + i][x + j] = new Piece(block.getModelo());
        }
    }
}    

//acontinuacion los metodos para la eliminacion de las filas enteras de =! piece("  ")
 
    //general
    public int checkAndDeleteRows() {
        int marcador = 0;
        for (int i = tablero.length - 1; i >= 0; i--) {
            if (isRowEmpty(i)) {
                deleteRow(i);
                rowsDrops(i);
                marcador=marcador+10;
            }
        }
        return marcador;
    }

    //comprueba SI esta o NO esta llena alguna fila
    private boolean isRowEmpty(int row) {
        boolean isRowEmpty=true;
        for (Piece Piece : tablero[row]) {
            if (Piece == null || Piece.equals(new Piece())) {
                isRowEmpty = false; // La fila no está llena
            }
        }
        return isRowEmpty; // La fila está llena
    }

    //elimina una fila y las cambia por piezas vacias
    private void deleteRow(int row) {
        for (int i = 0; i < tablero[row].length; i++) {
            tablero[row][i] = new Piece(); // Reemplazar todas las piezas por Piece("  ")
        }
    }

    //drop de las filas superiores a la fila eliminada
    private void rowsDrops(int row) {
        for (int i = row-1; i >= 0; i--) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i + 1][j] = tablero[i][j]; // Desplazar las filas superiores hacia abajo
            }
        }
    }
}



/*

Board se basa en dos  operaciones importantes:
Los metodos necesarios para crear el drop, de forma "temporal" de las piezas donde se va mirando si la el blocke cabe en la siguiente fila,
así hasta que llegue a tocar piezas, donde se pone de forma "real" el bloque en cuestion.

Los metodos necesarios (todo dependiendo de la matriz de piezas) cuando una fila se rellene entera, que desaparezcan las piezas de ella
y (con gravedad) caen las piezas de las filas superiores, además se incrementaria el contador de puntuacion.
 */

