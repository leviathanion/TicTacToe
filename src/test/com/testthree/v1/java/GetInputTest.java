package com.testthree.v1.java;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GetInputTest {
    private String expected;
    private String input;



    public GetInputTest(String expected,String input){

        this.expected = expected;
        this.input = input;

    }


    @Parameters// 构造测试用例
    public static Collection data(){
        return Arrays.asList(new Object[][]{{"exit","exit"},{"1,2","1,2"},{"1,3","1,3"},{"2,3","2,3"},{"3,3","3,3"}});   //返回值应和键盘输入一致
    }

    @Test
    public void getInput() {
        //GetMove gm=new GetMove();
        String data = this.input;
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        String result=GetInput.getInput();
        System.setIn(stdin);
        assertEquals(this.expected,result);
    }



}