package es.unileon.prg1.tetris;



public class TetrisTextUI{
    private Tetris juego;
    public TetrisTextUI(Tetris tetris){
        this.juego=tetris;
    }
    public void init() throws TetrisException {
        boolean end=false;
        String entrada="";
        do{
            System.out.println("TETRIS");
            juego.toString();
            System.out.println("W-> GIRAR A LA IZQUIERDA");
            System.out.println("E-> GIRAR A LA DERECHA");
            System.out.println("A-> MOVER A LA IZQUIERDA");
            System.out.println("D-> MOVER A LA IZQUIERDA");
            System.out.println("S-> BAJAR PIEZA");
            System.out.println("Exit->Salir");
            entrada=introduceTeclado();
            switch(entrada){
                case "W":juego.spinLeft();
                    break;
                case "E":juego.spinRigth();
                    break;
                case "A":juego.moveLeft();
                    break;
                case "D":juego.moveRight();
                    break;
                case "S":juego.drop();
                    break;
                case "SALIR":end=true;
                    break;

            }
            if(juego.perder()){
                end=true;
            }
        }while(true&&!end);
    }
    public String introduceTeclado() throws TetrisException{
        String introducido;
        introducido=Keyboard.readString();
        introducido.toUpperCase();
        if(introducido!="W"&&introducido!="E"&&introducido!="A"&&introducido!="S"&&introducido!="D"&&introducido!="EXIT"){
            throw new TetrisException("Error: La entrada introducida es erronea ");
        }

        return introducido;
    }

    
}