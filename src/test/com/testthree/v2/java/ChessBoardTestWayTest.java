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
public class ChessBoardTestWayTest {
    private int[] tttList;
    static ChessBoard cb;
    private int[] numOfChessman;

    @BeforeClass
    public static void setUp() throws Exception {
        cb = new ChessBoard();
    }

    public ChessBoardTestWayTest(int[] tttList, int[][] mat, int[] numOfChessman) {
        this.tttList = tttList;
        cb.setMat(mat);
        this.numOfChessman = numOfChessman;
    }

    @Parameterized.Parameters(name = "{index}:testWay[{0}]={2}")
    public static Collection testDate(){
        return Arrays.asList(new Object[][]{
                //横向
                {new int[]{4,5,6},new int[][]{{0,0,0},{0,0,0},{0,0,0}},new int[]{3,0,0}},
                {new int[]{4,5,6},new int[][]{{0,0,0},{1,0,0},{0,0,0}},new int[]{2,1,0}},
                {new int[]{4,5,6},new int[][]{{0,0,0},{1,1,0},{0,0,0}},new int[]{1,2,0}},
                {new int[]{4,5,6},new int[][]{{0,0,0},{1,1,1},{0,0,0}},new int[]{0,3,0}},
                {new int[]{4,5,6},new int[][]{{0,0,0},{2,0,0},{0,0,0}},new int[]{2,0,1}},
                {new int[]{4,5,6},new int[][]{{0,0,0},{2,2,0},{0,0,0}},new int[]{1,0,2}},
                {new int[]{4,5,6},new int[][]{{0,0,0},{2,2,2},{0,0,0}},new int[]{0,0,3}},
                //纵向
                {new int[]{2,5,8},new int[][]{{0,0,0},{0,0,0},{0,0,0}},new int[]{3,0,0}},
                {new int[]{2,5,8},new int[][]{{0,1,0},{0,0,0},{0,0,0}},new int[]{2,1,0}},
                {new int[]{2,5,8},new int[][]{{0,1,0},{0,1,0},{0,0,0}},new int[]{1,2,0}},
                {new int[]{2,5,8},new int[][]{{0,1,0},{0,1,0},{0,1,0}},new int[]{0,3,0}},
                {new int[]{2,5,8},new int[][]{{0,2,0},{0,0,0},{0,0,0}},new int[]{2,0,1}},
                {new int[]{2,5,8},new int[][]{{0,2,0},{0,2,0},{0,0,0}},new int[]{1,0,2}},
                {new int[]{2,5,8},new int[][]{{0,2,0},{0,2,0},{0,2,0}},new int[]{0,0,3}},
                //对角
                {new int[]{1,5,9},new int[][]{{0,0,0},{0,0,0},{0,0,0}},new int[]{3,0,0}},
                {new int[]{1,5,9},new int[][]{{1,0,0},{0,0,0},{0,0,0}},new int[]{2,1,0}},
                {new int[]{1,5,9},new int[][]{{1,0,0},{0,1,0},{0,0,0}},new int[]{1,2,0}},
                {new int[]{1,5,9},new int[][]{{1,0,0},{0,1,0},{0,0,1}},new int[]{0,3,0}},
                {new int[]{1,5,9},new int[][]{{2,0,0},{0,0,0},{0,0,0}},new int[]{2,0,1}},
                {new int[]{1,5,9},new int[][]{{2,0,0},{0,2,0},{0,0,0}},new int[]{1,0,2}},
                {new int[]{1,5,9},new int[][]{{2,0,0},{0,2,0},{0,0,2}},new int[]{0,0,3}},
        });
    }


    @Test
    public void testWay() {
        assertArrayEquals(this.numOfChessman, cb.testWay(this.tttList));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        cb = null;
    }
}