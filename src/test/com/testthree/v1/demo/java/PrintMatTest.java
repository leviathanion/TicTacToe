package com.testthree.v1.demo.java;

import org.junit.Test;
import java.io.ByteArrayOutputStream; // 输出缓冲区
import java.io.PrintStream; // 打印输出流
import static org.junit.Assert.*;


public class PrintMatTest {
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;
    PrintMat printMat;
    public static  int [][] mat={{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

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
    public void printMatTest() throws Exception {
        GameDriver.mat = mat;
        printMat.printMat();
        String s =new String("  1 2 3"+"\n1 . . . "+"\n2 . . . "+"\n3 . . . ");
        assertEquals(s, bytes.toString());

    }
}