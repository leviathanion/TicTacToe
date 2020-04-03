package com.testthree.v1.demo.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream; // 输出缓冲区
import java.io.PrintStream; // 打印输出流
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PrintMatTest {
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;
    PrintMat printMat;
    private String expected;

    public  PrintMatTest(int [][] mat,String expected){
        this.expected = expected;
        GameDriver.mat = mat;
    }

    @Parameterized.Parameters/**构造测试用例*/
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {new int[][]{{0,0,0},{0,0,0},{0,0,0}},"  1 2 3"+"\n1 . . . "+"\n2 . . . "+"\n3 . . . "},
                {new int[][]{{1,0,0},{0,0,0},{0,0,0}},"  1 2 3"+"\n1 x . . "+"\n2 . . . "+"\n3 . . . "},
                {new int[][]{{1,2,0},{0,0,0},{0,0,0}},"  1 2 3"+"\n1 x O . "+"\n2 . . . "+"\n3 . . . "},
                {new int[][]{{1,2,1},{0,0,0},{0,0,0}},"  1 2 3"+"\n1 x O x "+"\n2 . . . "+"\n3 . . . "},
                {new int[][]{{1,2,1},{2,0,0},{0,0,0}},"  1 2 3"+"\n1 x O x "+"\n2 O . . "+"\n3 . . . "},
                {new int[][]{{1,2,1},{2,1,0},{0,0,0}},"  1 2 3"+"\n1 x O x "+"\n2 O x . "+"\n3 . . . "},
                {new int[][]{{1,2,1},{2,1,2},{0,0,0}},"  1 2 3"+"\n1 x O x "+"\n2 O x O "+"\n3 . . . "},
                {new int[][]{{1,2,1},{2,1,2},{1,0,0}},"  1 2 3"+"\n1 x O x "+"\n2 O x O "+"\n3 x . . "},
                {new int[][]{{1,2,1},{2,1,2},{1,2,0}},"  1 2 3"+"\n1 x O x "+"\n2 O x O "+"\n3 x O . "},
                {new int[][]{{1,2,1},{2,1,2},{1,2,1}},"  1 2 3"+"\n1 x O x "+"\n2 O x O "+"\n3 x O x "},
                });
    }

    @org.junit.Before              // 预处理
    public void setUp() throws Exception {

        printMat = new PrintMat();;

        bytes = new ByteArrayOutputStream();
        console = System.out;

        System.setOut(new PrintStream(bytes));

    }

    @org.junit.After              // 后处理
    public void tearDown() throws Exception {

        System.setOut(console);
    }


    @Test
    public void printMat() throws Exception {
        printMat.printMat();
        //String s =new String("  1 2 3"+"\n1 . . . "+"\n2 . . . "+"\n3 . . . ");
        assertEquals(this.expected, bytes.toString());

    }
}