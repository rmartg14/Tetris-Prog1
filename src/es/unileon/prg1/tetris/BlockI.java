package es.unileon.prg1.tetris;


public class BlockI extends Block{
    private Piece modelo;
    private ArrayMxN blockI;
    public BlockI() {
        blockI = new ArrayMxN(4, 1);
        blockI.set(0, 0, 1);
        blockI.set(1, 0, 1);
        blockI.set(2, 0, 1);
        blockI.set(3, 0, 1);
        this.modelo = new Piece(Color.CYAN, "I");
    }



    public Piece getModelo(){
        return this.modelo;
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < blockI.rows(); i++) {
                for (int j = 0; j < blockI.columns(); j++) {
                    stringBuffer.append(blockI.get(i, j));
                }
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();  
    }


}