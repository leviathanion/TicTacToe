package com.testthree.v2.java;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author zhuquntao
 * @version 1.0
 * @date 2020.4.2
 */

@RunWith(Parameterized.class)
public class ChessBoardGetMyWinListTest {
    private int cellN;
    static ChessBoard cb;
    int[][] myWinList;

    @BeforeClass
    public static void setUp() throws Exception {
        cb = new ChessBoard();
    }

    public ChessBoardGetMyWinListTest(int cellN, int[][]myWinList){
        this.cellN = cellN;
        this.myWinList = myWinList;
    }

    @Parameterized.Parameters(name = "{index}:getMyWinList[{0}]")
    public static Collection testDate(){
        return Arrays.asList(new Object[][]{
                {1,new int[][]{{1,2,3},{1,4,7},{1,5,9}}},
                {2,new int[][]{{1,2,3},{2,5,8}}},
                {3,new int[][]{{1,2,3},{3,6,9},{3,5,7}}},
                {4,new int[][]{{4,5,6},{1,4,7}}},
                {5,new int[][]{{4,5,6},{2,5,8},{1,5,9},{3,5,7}}},
                {6,new int[][]{{4,5,6},{3,6,9}}},
                {7,new int[][]{{7,8,9},{1,4,7},{3,5,7}}},
                {8,new int[][]{{7,8,9},{2,5,8}}},
                {9,new int[][]{{7,8,9},{3,6,9},{1,5,9}}}

            }
        );
    }

    @Test
    public void getMyWinList() {
        assertArrayEquals(this.myWinList,cb.getMyWinList(this.cellN).toArray());
    }

    @AfterClass
    public static void tearDown() throws Exception {
        cb = null;
    }
}