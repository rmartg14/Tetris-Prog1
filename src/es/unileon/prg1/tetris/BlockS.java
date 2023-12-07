package es.unileon.prg1.tetris;

public class BlockS extends Block{
    private ArrayMxN blockS;
    private Piece modelo;
    public BlockS() {
        blockS = new ArrayMxN(2, 3);
        blockS.set(0, 0, 0);
        blockS.set(0, 1, 1);
        blockS.set(0, 2, 1);
        blockS.set(1, 0, 1);
        blockS.set(1, 1, 1);
        blockS.set(1, 2, 0);
        this.modelo = new Piece(Color.RED, "S");
    }
    
    public Piece getModelo(){
        return this.modelo;
    }


    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < blockS.rows(); i++) {
                for (int j = 0; j < blockS.columns(); j++) {
                    stringBuffer.append(blockS.get(i, j));
                }
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();  
    }
}
