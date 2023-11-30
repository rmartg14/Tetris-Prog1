package es.unileon.prg1.tetris;

public class Board {
    private int rows;

    public Board(int rows, int columns) {
    	this.rows=rows;
    	this.columns=columns;
    	
    	
    }

    public static int placeAndDropBlock(int[][] matriz, int[] block) {
        int rows = matriz.length;
        int columns = matriz[0].length;
        int lengthBlock = block.length;
    
        int placeBlockDrops = -1;
    
        for (int i = 0; i < rows - lengthBlock + 1 && placeBlockDrops == -1; i++) {
            boolean canDrop = true;
    
            for (int a = 0; a < lengthBlock && canDrop; a++) { //va ir dropeando hasta que llegue la ultima fila que no choca
                for (int j = 0; j < columns && canDrop; j++) {
                    if (matriz[a + i][j] == 1 && block[a] == 1) {
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
                        matriz[a + placeBlockDrops][j] = 1;
                    }
                }
            }
        }
    
        return placeBlockDrops; //devuelve la ultima fila donde se puede  colocar el bloque, sin chocar
    }
    









    //con este metodo compruebo si la matriz esta llena de 1's
public static boolean existOnesRows(int[][] matriz) {
    for (int[] row : matriz) {
        boolean rowFullOfOnes = true;
        for (int valor : row) {
            if (valor != 1) {
                rowFullOfOnes = false;
            }
        }
        if (rowFullOfOnes) {
            return true;
        }
    }
    return false;
}


//en caso de haber se cambian por 0's y luego se baja todas las filas superiores
//además se añade una fila de 0's a la matriz en su parte superior 
//ya que despues de moverse unas filas pa bajo, la de arriba se quedaria sin nada
public static void deleteOnesRows(int[][] matriz) {
    int row = matriz.length - 1;
    while (row >= 0) {
        boolean rowFullOfOnes = true;
        for (int valor : matriz[row]) {
            if (valor != 1) {
                rowFullOfOnes = false;
            }
        }

        if (rowFullOfOnes) {
            // Si es una fila de 1's, eliminarla y ponerla en 0's
            for (int i = 0; i < matriz[0].length; i++) {
                matriz[row][i] = 0;
            }

            // Ajustar las filas superiores
            for (int i = row - 1; i >= 0; i--) {
                for (int j = 0; j < matriz[0].length; j++) {
                    matriz[i + 1][j] = matriz[i][j];
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