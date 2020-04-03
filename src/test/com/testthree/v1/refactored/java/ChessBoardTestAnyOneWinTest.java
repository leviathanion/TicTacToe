package com.testthree.v1.refactored.java;


import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * @author zhuquntao
 * @version 1.0
 * @date 2020.4.2
 */

@RunWith(Parameterized.class)
public class ChessBoardTestAnyOneWinTest {
    static ChessBoard cb;
    private boolean expected;

    @BeforeClass
    public static void setUp() throws Exception {
        cb = new ChessBoard();
    }

    public ChessBoardTestAnyOneWinTest(int r, int c, int[][] mat, boolean expected) {
        cb = new ChessBoard();
        cb.setRow(r);
        cb.setCol(c);
        cb.setMat(mat);
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}:testAnyOneWin[{0},{1}]={3}")
    public static Collection testDate(){
        return Arrays.asList(new Object[][]{
                //横向
                {1,0,new int[][]{{0,0,0},{0,0,0},{0,0,0}},false},
                {1,0,new int[][]{{0,0,0},{1,1,1},{0,0,0}},true},
                {1,0,new int[][]{{0,0,0},{2,2,2},{0,0,0}},true},
                //纵向
                {2,1,new int[][]{{0,0,0},{0,0,0},{0,0,0}},false},
                {2,1,new int[][]{{0,1,0},{0,1,0},{0,1,0}},true},
                {2,1,new int[][]{{0,2,0},{0,2,0},{0,2,0}},true},
                //对角线
                {2,2,new int[][]{{0,0,0},{0,0,0},{0,0,0}},false},
                {2,2,new int[][]{{1,0,0},{0,1,0},{0,0,1}},true},
                {2,2,new int[][]{{2,0,0},{0,2,0},{0,0,2}},true},
            }
        );
    }

    @Test
    public void testAnyOneWin() {
        assertEquals(expected, cb.testAnyOneWin());
    }

    @AfterClass
    public static void tearDown() throws Exception {
        cb = null;
    }
}