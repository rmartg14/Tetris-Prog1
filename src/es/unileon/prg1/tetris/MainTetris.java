package es.unileon.prg1.tetris;

public class MainTetris {
// faltan comprobaciones de argumentos recibidos por la linea de comandos!!!
// faltan conversiones de los argumentos recibidos!!!
    public static void main(String args[]) {
        Tetris tetris;
        TetrisTextUI ui;

        tetris = new Tetris(rows, columns, color);
        ui = new TetrisTextUI(tetris);
        ui.init();
    }
}