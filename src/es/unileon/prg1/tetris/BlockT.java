package es.unileon.prg1.tetris;

public class BlockT extends Block{
    private ArrayMxN blockT;
    private Piece modelo;
    public BlockT() {
        blockT = new ArrayMxN(2, 3);
        blockT.set(0, 0, 1);
        blockT.set(0, 1, 1);
        blockT.set(0, 2, 1);
        blockT.set(1, 0, 0);
        blockT.set(1, 1, 1);
        blockT.set(1, 3, 0);
        this.modelo = new Piece(Color.MAGENTA, "T");
    }


    public Piece getModelo(){
        return this.modelo;
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < blockT.rows(); i++) {
                for (int j = 0; j < blockT.columns(); j++) {
                    stringBuffer.append(blockT.get(i, j));
                }
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();  
    }
}