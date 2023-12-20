package es.unileon.prg1.tetris;

public class TetrisTextUI {
    private Tetris juego;

    public TetrisTextUI(Tetris tetris) {
        this.juego = tetris;
    }

    public void init() {
        boolean end = false;
        String entrada = "";
        do {
            System.out.println("TETRIS");
            System.out.println(juego.toString());
            System.out.println("W-> GIRAR A LA IZQUIERDA");
            System.out.println("E-> GIRAR A LA DERECHA");
            System.out.println("A-> MOVER A LA IZQUIERDA");
            System.out.println("D-> MOVER A LA DERECHA");
            System.out.println("S-> BAJAR PIEZA");
            System.out.println("Exit->Salir");
            try {
                entrada = introduceTeclado();
                switch (entrada) {
                    case "W":
                        juego.spinLeft();
                        break;
                    case "E":
                        juego.spinRight();
                        break;
                    case "A":
                        juego.moveLeft();
                        break;
                    case "D":
                        juego.moveRigth();
                        break;
                    case "S":
                        juego.drop();
                        break;
                    case "EXIT":
                        end = true;
                        break;

                }
                if (juego.perder()) {
                    end = true;
                }
            } catch (TetrisException e) {
                System.out.println(e.getMessage());
            }

        } while (!end);
    }

    public String introduceTeclado() throws TetrisException {
        String in;
        in = Keyboard.readString().trim().toUpperCase();
        if (!in.equals("W") && !in.equals("E") && !in.equals("A") && !in.equals("S") && !in.equals("D") && !in.equals("EXIT")) {
            throw new TetrisException("Error: La entrada introducida es erronea ");
        }

        return in;
    }

}