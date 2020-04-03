package com.testthree.v1.demo.java;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * @author zhuquntao
 * @version 1.0
 * @date 2020.4.1
 */

@RunWith(Parameterized.class)
public class TestWayTest {
    private int[] tttList;
    private int[][] mat;
    private int[] numOfChessman;



    public TestWayTest(int[] tttList, int[][] mat, int[] numOfChessman) {
        this.tttList = tttList;
        GameDriver.mat = mat;
        this.numOfChessman = numOfChessman;
    }

    @Parameterized.Parameters(name = "{index}:testWay[{0}]={2}")
    public static Collection testDate(){
        return Arrays.asList(new Object[][]{
                //横向
                {new int[]{4,5,6},new int[][]{{0,0,0},{0,0,0},{0,0,0}},new int[]{0,0,3}},
                {new int[]{4,5,6},new int[][]{{0,0,0},{1,0,0},{0,0,0}},new int[]{1,0,2}},
                {new int[]{4,5,6},new int[][]{{0,0,0},{1,1,0},{0,0,0}},new int[]{2,0,1}},
                {new int[]{4,5,6},new int[][]{{0,0,0},{1,1,1},{0,0,0}},new int[]{3,0,0}},
                {new int[]{4,5,6},new int[][]{{0,0,0},{2,0,0},{0,0,0}},new int[]{0,1,2}},
                {new int[]{4,5,6},new int[][]{{0,0,0},{2,2,0},{0,0,0}},new int[]{0,2,1}},
                {new int[]{4,5,6},new int[][]{{0,0,0},{2,2,2},{0,0,0}},new int[]{0,3,0}},
                //纵向
                {new int[]{2,5,8},new int[][]{{0,0,0},{0,0,0},{0,0,0}},new int[]{0,0,3}},
                {new int[]{2,5,8},new int[][]{{0,1,0},{0,0,0},{0,0,0}},new int[]{1,0,2}},
                {new int[]{2,5,8},new int[][]{{0,1,0},{0,1,0},{0,0,0}},new int[]{2,0,1}},
                {new int[]{2,5,8},new int[][]{{0,1,0},{0,1,0},{0,1,0}},new int[]{3,0,0}},
                {new int[]{2,5,8},new int[][]{{0,2,0},{0,0,0},{0,0,0}},new int[]{0,1,2}},
                {new int[]{2,5,8},new int[][]{{0,2,0},{0,2,0},{0,0,0}},new int[]{0,2,1}},
                {new int[]{2,5,8},new int[][]{{0,2,0},{0,2,0},{0,2,0}},new int[]{0,3,0}},
                //对角
                {new int[]{1,5,9},new int[][]{{0,0,0},{0,0,0},{0,0,0}},new int[]{0,0,3}},
                {new int[]{1,5,9},new int[][]{{1,0,0},{0,0,0},{0,0,0}},new int[]{1,0,2}},
                {new int[]{1,5,9},new int[][]{{1,0,0},{0,1,0},{0,0,0}},new int[]{2,0,1}},
                {new int[]{1,5,9},new int[][]{{1,0,0},{0,1,0},{0,0,1}},new int[]{3,0,0}},
                {new int[]{1,5,9},new int[][]{{2,0,0},{0,0,0},{0,0,0}},new int[]{0,1,2}},
                {new int[]{1,5,9},new int[][]{{2,0,0},{0,2,0},{0,0,0}},new int[]{0,2,1}},
                {new int[]{1,5,9},new int[][]{{2,0,0},{0,2,0},{0,0,2}},new int[]{0,3,0}},
        });
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testWay() {
        assertArrayEquals(this.numOfChessman,TestWayAndWin.testWay(this.tttList));
    }


}