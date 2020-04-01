package test.java;

import com.testthree.java.GameDriver;
import com.testthree.java.TestWayAndWin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TestWinTest {
    private int r,c;
    private int[][] mat;
    private boolean expected;

    public TestWinTest(int r, int c, int[][] mat, boolean expected) {
        this.r = r;
        this.c = c;
        GameDriver.mat = mat;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}:testWin[{0},{1}]={3}")
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
        });
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testWin() {
        assertEquals(expected,TestWayAndWin.testWin(this.r,this.c));
    }
}