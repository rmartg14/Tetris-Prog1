package es.unileon.prg1.tetris;

public class Board {


    public Board(int rows, int columns) {
    	this.rows=rows;
    	this.columns=columns;
    	this.points=0;
    	
    }

    public boolean canDrop(Block block) { //con este metodo secomprueba si hay o no hay cabida para el bloque debajo

        boolean result = true;

        for (int i = 0; i < 4; i++) {
            int row = block.getrows() + block.getBlocks()[i].getrows();
            int column = block.getcolumns() + block.getBlocks()[i].getcolumns() + 1;
            if (column >= height || getBlock(row, column) != null) {
                result = false;
                break;
            }
        }
        return result;
    }

    public void drop1Row() {  //con CanDropRow en true, se movería el bloque una abajo

        if (canDropRow(Block)) {
    
            Block.setcolumn(Block.getcolumns() + 1);
    
        }
    
    }

    public boolean isRowFull(int row) {
    	
    }
    public void removeRow(int row) {
	if (isRowFull=true){
		
    }
    public int increasePoints(int Points){
    	if (isRowFull(row)){
    		Points=Points+1;
        }
        return Points;
    }
    
    		
    	


}
}
/*

dos siguientes operaciones importantes:
Los metodos necesarios para crear el drop, de forma "temporarl" de las piezas donde se va mirando si la el blocke cabe en la siguiente fila,
 así hasta que llegue a tocar piezas, donde se pone de forma "real" el bloque en cuestion.

Los metodos necesarios (todo dependiendo de la matriz de piezas) cuando una fila se rellene entera, que desaparezcan las piezas de ella
y (con gravedad) caen las piezas de las filas superiores, además se incrementaria el contador de puntuacion.

 */