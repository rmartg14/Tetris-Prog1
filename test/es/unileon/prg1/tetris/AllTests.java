package es.unileon.prg1.tetris;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.unileon.prg1.tetris.strategy.PieceColorTest;

@RunWith(Suite.class)
@SuiteClasses({ TetrisTest.class, ArrayMxNTest.class,ArrayNxNTest.class, BlockITest.class, BlockJTest.class, BlockLTest.class, BlockSTest.class, BlockTest.class,
    BlockTTest.class, BlockZTest.class, BoardTest.class, PieceColorTest.class})
public class AllTests {

}
//añadir los tests a suiteclasses