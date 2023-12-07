package es.unileon.prg1.tetris;

public class Block {

    private ArrayMxN bloque;
    private Coordenadas cor;

    private Piece modelo;
    /*
     * Crear metodo bajarBloque llamando a dropOne de Coordenadas para poder llamar a block.bajarBloque desde board
     * Crear metodo getX y getY que devuelvan las cooredenadas actuales del bloque llamando a cor.getX u cor.getY
     * Crear método getModelo() que devuelva this.modelo
     * Crar un metodo block.getElem(fila,col) para que devuelva el contenido de block[i][j] que es 1 o 0
     * 
     * 
     */
    public Block(){
        bloque.set(0, 0, 1);
        bloque.set(0, 1, 1);
        bloque.set(1, 0, 1);
        bloque.set(1, 1, 1);
        bloque = new ArrayMxN(2, 2);
        cor = new Coordenadas();
        this.modelo = new Piece(Color.YELLOW, "0");
    }

    public Coordenadas getCoordenadas(){
        return cor;
    }
    public int getColumnsBlock(){
        return bloque.columns();
    }

    public int getRowsBlock(){
        return bloque.rows();
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
                if (bloque.get(i, j) != 0) {
                    blockN.set(i, j, bloque.get(i, j));  
                } else {
                    blockN.set(i, j, 0);
                }
                
            }
        }
        blockN.spinLeft();
        blockN.getMinArray();
        for (int i = 0; i < blockN.rows(); i++) {
            for (int j = 0; j < blockN.columns(); j++) {
                bloque.set(i, j, blockN.get(i, j));
            }
        }
        
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
                if (bloque.get(i, j) != 0) {
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
        if(!(cor.getX() - 1 < 0)){
            cor.moverIzquierda();
        }
    }

    public void moveRight(){
        Board t = new Board(0, 0);
        
        if (cor.getX() + bloque.columns() < t.getNumberOfColumns()) {
            cor.moverDerecha();
        }
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bloque.rows(); i++) {
            for (int j = 0; j < bloque.columns(); j++) {
                stringBuffer.append(bloque.get(i, j));
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString(); 
    }
}
