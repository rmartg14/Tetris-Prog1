package es.unileon.prg1.tetris;

public class BlockL extends Block{
    private ArrayMxN blockL;
    private Piece modelo;
    public BlockL() {
        blockL = new ArrayMxN(3, 2);
        blockL.set(0, 0, 1);
        blockL.set(0, 1, 0);
        blockL.set(1, 0, 1);
        blockL.set(1, 1, 0);
        blockL.set(2, 0, 1);
        blockL.set(2, 1, 1);
        this.modelo = new Piece(Color.WHITE, "L");   
    }

    public Piece getModelo(){
        return this.modelo;
    }


    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < blockL.rows(); i++) {
                for (int j = 0; j < blockL.columns(); j++) {
                    stringBuffer.append(blockL.get(i, j));
                }
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();  
    }
}
