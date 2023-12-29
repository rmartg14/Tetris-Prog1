package es.unileon.prg1.tetris;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrisTextUI {
    private Tetris juego;
    static final Logger logger = LogManager.getLogger(TetrisTextUI.class.getName());

    public TetrisTextUI(Tetris tetris) {
        this.juego = tetris;
    }

    public void init() {
        logger.info("Tetris iniciado con éxito.");
        boolean end = true;
        String entrada = "";
        do {
            System.out.println("\n\u001b[43;1m T \u001b[42;1m E \u001b[46m T \u001b[44m R \u001b[41;1m I \u001b[45;1m S \u001B[0m\n");
            System.out.println(juego.toString());
            System.out.println();
            System.out.print("       'W'-> spin left ");
            System.out.print("'E'-> spin right\n");
            System.out.print("'A'-> move left ");
            System.out.print("'S'-> drop ");
            System.out.print("'D'-> move right\n");
            System.out.print("”Exit” or ”Salir” to leave tetris)\n");
            try {
                entrada = introduceTeclado();
                logger.info("El usuario ha introducido por teclado: "+entrada);
                switch (entrada) {
                    case "W":
                        juego.spinLeft();
                        logger.info("La pieza gira hacia la izquierda");
                        break;
                    case "E":
                        juego.spinRight();
                        logger.info("La pieza gira hacia la derecha");
                        break;
                    case "A":
                        juego.moveLeft();
                        break;
                    case "D":
                        juego.moveRigth();
                        break;
                    case "S":
                        end=juego.drop();
                        if(!end){
                            System.out.println("Bye!");
                            logger.info("El usuario pierde con una puntuación de "+juego.getPoints()+" puntos");
                        }
                        break;
                    default:
                        System.out.println("Bye!");
                        end = false;
                        logger.info("El usuario abandona la partida");
                        

                }
                
            } catch (TetrisException e) {
                System.out.println(e.getMessage());
            }

        } while (end);
    }

    public String introduceTeclado() throws TetrisException {
        String in;
        in = Keyboard.readString().trim().toUpperCase();
        if (!in.equals("W") && !in.equals("E") && !in.equals("A") && !in.equals("S") && !in.equals("D") && !in.equals("EXIT")&&!in.equals("SALIR")) {
            logger.error("La entrada intoducida es errónea");
            throw new TetrisException("Error: La entrada introducida es erronea ");
            
        }

        return in;
    }

}