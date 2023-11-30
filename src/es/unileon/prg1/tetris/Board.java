package es.unileon.prg1.tetris;

public class Board {

    private Piece[][] tablero;
//es cambiar para que se mueve en coordenadas el drop, poniendo coordenadas.y
//es cambiar 
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
//drop
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
    public int placeAndDropBlock(int[] block) {

        int lengthBlock = block[0].length;
        int heightbBlock = block.length;
    
        int placeBlockDrops = -1;
    
        for (int i = 0; i < rows - lengthBlock + 1 && placeBlockDrops == -1; i++) {
            boolean canDrop = true;
    
            for (int a = 0; a < lengthBlock && canDrop; a++) { //va ir dropeando hasta que llegue la ultima fila que no choca
                for (int j = 0; j < columns && canDrop; j++) {
                    if (tablero[a + i][j] == 1 && block[a] == 1) {
                        canDrop = false;
                    }
                }
            }
    
            if (canDrop) {
                placeBlockDrops = i;
            }
        }
    
        if (placeBlockDrops != -1) {
            for (int a = 0; a < lengthBlock; a++) {
                for (int j = 0; j < columns; j++) {
                    if (block[a] == 1) {
                        tablero[a + placeBlockDrops][j] = 1;
                    }
                }
            }
        }
    
        return placeBlockDrops; //devuelve la ultima fila donde se puede  colocar el bloque, sin chocar
    }

    //con este metodo compruebo si la matriz esta llena de 1's
public boolean existFullRows(int[][] ) {
    for (int[] row : matriz) {
        boolean rowFull = true;
        for (int valor : row) {
            if (valor != 1) {
                rowFull = false;
            }
        }
        if (rowFull) {
            return true;
        }
    }
    return false;
}


//en caso de haber se cambian por 0's y luego se baja todas las filas superiores
//además se añade una fila de 0's a la matriz en su parte superior 
//ya que despues de moverse unas filas pa bajo, la de arriba se quedaria sin nada
public void deleteFullRows() {
    int row = tablero.length - 1;
    while (row >= 0) {
        boolean rowFull = true;
        for (int valor : tablero.row) {
            if (valor != 1) {
                rowFull = false;
            }
        }

        if (rowFull) {
            // Si es una fila de 1's, eliminarla y ponerla en 0's
            for (int i = 0; i < tablero[0].length; i++) {
                tablero[row][i] = 0;
            }

            // Ajustar las filas superiores
            for (int i = row - 1; i >= 0; i--) {
                for (int j = 0; j < tablero[0].length; j++) {
                    tablero[i + 1][j] = tablero[i][j];
                }
            }
        }

        row--;
    }
}
}

/*

dos siguientes operaciones importantes:
Los metodos necesarios para crear el drop, de forma "temporarl" de las piezas donde se va mirando si la el blocke cabe en la siguiente fila,
 así hasta que llegue a tocar piezas, donde se pone de forma "real" el bloque en cuestion.

Los metodos necesarios (todo dependiendo de la matriz de piezas) cuando una fila se rellene entera, que desaparezcan las piezas de ella
y (con gravedad) caen las piezas de las filas superiores, además se incrementaria el contador de puntuacion.

arreglame el codigo antes para los siguientes caso:

que se haga todo lo menciado en el metodo eliminarfilasdeunos, en caso de haber mas de una fila entera llena de 1's para todas las filas, no solo una






 */