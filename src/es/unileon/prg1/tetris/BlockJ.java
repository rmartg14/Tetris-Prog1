package es.unileon.prg1.tetris;

public class BlockJ extends Block{
    private ArrayMxN blockJ;
    private Piece modelo;
    public BlockJ() {
        blockJ = new ArrayMxN(3, 2);
        blockJ.set(0, 0, 0);
        blockJ.set(0, 1, 1);
        blockJ.set(1, 0, 0);
        blockJ.set(1, 1, 1);
        blockJ.set(2, 0, 1);
        blockJ.set(2, 1, 1);
        this.modelo = new Piece(Color.BLUE, "J");
    }
    
    public Piece getModelo(){
        return this.modelo;
    }


    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < blockJ.rows(); i++) {
                for (int j = 0; j < blockJ.columns(); j++) {
                    stringBuffer.append(blockJ.get(i, j));
                }
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();  
    }
}
