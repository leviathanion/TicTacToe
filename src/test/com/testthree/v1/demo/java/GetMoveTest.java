package com.testthree.v1.demo.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GetMoveTest {
    private int[] expected;
    private String input;



    public GetMoveTest( int[] expected,String input){

        this.expected = expected;
        this.input = input;


    }


    @Parameterized.Parameters/**构造测试用例*/
    public static Collection data(){
        return Arrays.asList(new Object[][]{{new int[] {1,0,0},"exit"},{new int[]{0,0,0},"1,1"},
                {new int[]{0,1,0},"2,1"},{new int[]{0,1,1},"2,2"},{new int[]{0,2,2},"3,3"}});
    }


    public void tearDown() throws Exception {
        GameDriver.mat= new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    }

    @Test
    public void getMove() {
        GetMove gm=new GetMove();
        String data = this.input;
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        int[] result=gm.getMove();
        System.setIn(stdin);
        assertArrayEquals(this.expected,result);
        //判断数组相等

    }


}