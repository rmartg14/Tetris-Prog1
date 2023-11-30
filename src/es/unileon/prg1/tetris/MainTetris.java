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
		}else if(Integer.parseInt(args[0])<5||Integer.parseInt(args[0])>20){
			System.out.println("Error, el numero de filas debe estar entre 5 y 20");
		}else if(Integer.parseInt(args[1])<6||Integer.parseInt(args[1])>20){
			System.out.println("Error, el numero de columnas debe estar entre 6 y 20");
		}else{
			try {
				rows = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.out.println("Error: filas no válidas.");
			}
			
	
			try {
				columns = Integer.parseInt(args[1]);
			} catch (NumberFormatException e) {
				System.out.println("Error: columnas no válidas.");
			} 
			try {
				color = args[2];
			} catch (ArrayIndexOutOfBoundsException e) {

				System.out.println("Error: argumento inválido para el color.");
			}
	
			tetris = new Tetris(rows, columns, color);
			ui = new TetrisTextUI(tetris);
			ui.init();

		}
        
    }
}