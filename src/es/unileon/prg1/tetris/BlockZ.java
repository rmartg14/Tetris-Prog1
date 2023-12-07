package es.unileon.prg1.tetris;

public class BlockZ extends Block{
    private ArrayMxN blockZ;
    private Piece modelo;
    public BlockZ() {
        blockZ = new ArrayMxN(2, 3);
        blockZ.set(0, 0, 1);
        blockZ.set(0, 1, 1);
        blockZ.set(0, 2, 0);
        blockZ.set(1, 0, 0);
        blockZ.set(1, 1, 1);
        blockZ.set(1, 3, 1);
        this.modelo = new Piece(Color.GREEN, "Z");
    }
    
    public Piece getModelo(){
        return this.modelo;
    }


    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < blockZ.rows(); i++) {
                for (int j = 0; j < blockZ.columns(); j++) {
                    stringBuffer.append(blockZ.get(i, j));
                }
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();  
    }
}
