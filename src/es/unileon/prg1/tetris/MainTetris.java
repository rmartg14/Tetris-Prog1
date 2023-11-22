package es.unileon.prg1.tetris;

public class MainTetris {
// faltan comprobaciones de argumentos recibidos por la linea de comandos!!!
// faltan conversiones de los argumentos recibidos!!!
    public static void main(String args[]) throws TetrisException {
        Tetris tetris;
        TetrisTextUI ui;

        int rows;
        int columns;
        String color;
        try {
			rows = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			throw new TetrisException("Error: filas no válidas.");
		}
		

		try {
			columns = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			throw new TetrisException("Error: columnas no válidas.");
		} 
		try {
			color = args[2];
		} catch (ArrayIndexOutOfBoundsException e) {
			
			throw new TetrisException("Error: argumento inválido para el color.");
		}

        tetris = new Tetris(rows, columns, color);
        ui = new TetrisTextUI(tetris);
        ui.init();
    }
}