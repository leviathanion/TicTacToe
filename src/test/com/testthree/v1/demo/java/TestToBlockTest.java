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
 * @author taoyongxin
 * @version 1.0
 * @date 2020.4.3
 */

@RunWith(Parameterized.class)
public class TestToBlockTest {
	private int row,col;
    private boolean expected;

    public TestToBlockTest(int r, int c, int[][] mat, boolean expected){
        this.row = r;
        this.col = c;
        GameDriver.mat = mat;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}:testToBlock[{0},{1}]={3}")
    public static Collection testDataSet(){
        return Arrays.asList(
                new Object[][]{
                        //边界
                        {1, 2, new int[][]{{1, 0, 2}, {0, 0, 0}, {0, 0, 2}}, true},
                        {1, 2, new int[][]{{1, 0, 2}, {0, 0, 0}, {0, 0, 0}}, false},
                        {1, 2, new int[][]{{1, 0, 0}, {2, 2, 0}, {0, 0, 0}}, true},
                        {1, 2, new int[][]{{1, 0, 0}, {2, 0, 0}, {0, 0, 0}}, false},
                        {1, 0, new int[][]{{1, 0, 0}, {0, 2, 2}, {0, 0, 0}}, true},
                        {1, 0, new int[][]{{1, 0, 0}, {0, 2, 0}, {0, 0, 0}}, false},
                        //中心
                        {1, 1, new int[][]{{1, 0, 2}, {0, 0, 0}, {2, 0, 0}}, true},
                        {1, 1, new int[][]{{1, 0, 2}, {0, 0, 0}, {0, 0, 0}}, false},
                        {1, 1, new int[][]{{1, 2, 0}, {0, 0, 0}, {0, 2, 0}}, true},
                        {1, 1, new int[][]{{1, 2, 0}, {0, 0, 0}, {0, 0, 0}}, false},
                        {1, 1, new int[][]{{1, 0, 0}, {2, 0, 2}, {0, 0, 0}}, true},
                        {1, 1, new int[][]{{1, 0, 0}, {2, 0, 0}, {0, 0, 0}}, false},
                        //对角
                        {2, 2, new int[][]{{1, 0, 0}, {0, 0, 0}, {2, 2, 0}}, true},
                        {2, 2, new int[][]{{1, 0, 0}, {0, 0, 0}, {2, 0, 0}}, false},
                        {2, 2, new int[][]{{1, 0, 2}, {0, 0, 2}, {0, 0, 0}}, true},
                        {2, 2, new int[][]{{1, 0, 2}, {0, 0, 0}, {0, 0, 0}}, false}
                }
        );
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testToBlock() {
        assertTrue(TestToBlock.testToBlock(this.row, this.col) == this.expected);
    }
}
