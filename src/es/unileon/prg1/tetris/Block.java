package es.unileon.prg1.tetris;

public class Block {

    private ArrayMxN bloque = new ArrayMxN(2, 2);
    private Coordenadas cor = new Coordenadas();
    
    public Block(){
        for (int i = 0; i < bloque.rows(); i++) {
            for (int j = 0; j < bloque.columns(); j++) {
                bloque.set(i, j, 1);
            }
        }
    }
    
    public void rotateLeft(){
        int mayorL = 0;
        if (bloque.rows() < bloque.columns()) {
            mayorL = bloque.columns();
        } else {
            mayorL = bloque.rows();
        }
        ArrayNxN blockN = new ArrayNxN(mayorL);
        for (int i = 0; i < blockN.rows(); i++) {
            for (int j = 0; j < blockN.columns(); j++) {
                if (bloque.get(i, j) == 0) {
                    blockN.set(i, j, bloque.get(i, j));  
                } else {
                    blockN.set(i, j, 0);
                }
                
            }
        }
        blockN.spinLeft();
        blockN.getMinArray();
        bloque = blockN;
    }

    public void rotateRight(){
        int mayorL = 0;
        if (bloque.rows() < bloque.columns()) {
            mayorL = bloque.columns();
        } else {
            mayorL = bloque.rows();
        }
        ArrayNxN blockN = new ArrayNxN(mayorL);
        for (int i = 0; i < blockN.rows(); i++) {
            for (int j = 0; j < blockN.columns(); j++) {
                if (bloque.get(i, j) == 0) {
                    blockN.set(i, j, bloque.get(i, j));  
                } else {
                    blockN.set(i, j, 0);
                }
                
            }
        }
        blockN.spinRight();
        blockN.getMinArray();
        bloque = blockN;
    }

    public void moveLeft(){
        if(!(cor.getX() + 1 < 0)){
            cor.moverIzquierda();
        }
    }

    public void moveRight(){
        
    }
}
