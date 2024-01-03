package es.unileon.prg1.tetris;

public class MainTetris {
// faltan comprobaciones de argumentos recibidos por la linea de comandos!!!
// faltan conversiones de los argumentos recibidos!!!
    public static void main(String args[]){
        Tetris tetris;
        TetrisTextUI ui;

        int rows=0;
        int columns=0;
        String color="";
		if(args.length!=3){
			System.out.println("Debes meter 3 argumentos");
		}else{
			try {System.err.println();
				rows = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.out.println("Error: filas no válidas.");
			
			
			}
			
	
			try {
				columns = Integer.parseInt(args[1]);
			} catch (NumberFormatException e) {
				System.out.println("Error: columnas no válidas.");
			} 
			
				color = args[2];
			
	
			try {
				tetris = new Tetris(rows, columns, color);
				ui = new TetrisTextUI(tetris);
				ui.init();
			} catch (TetrisException e) {
				System.out.println(e.getMessage());
				System.out.println("Sintaxis del programa:");
				System.out.println("MainTetris Filas Columnas Color");
			}
			

		}
        
    }
}