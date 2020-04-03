package com.testthree.v2.java;

import com.testthree.v1.demo.java.GetInput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class GameSystemTest {
    private int expected;
    private String input;


    public GameSystemTest(int expected, String input){
        this.expected = expected;
        this.input = input;
    }

    @Parameterized.Parameters
    // 构造测试用例
    public static Collection data(){
        return Arrays.asList(new Object[][]{{1,"1"},{2,"2"},{3,"3"},{4,"exit"},{4,"123456"}});
    }


    @Test
    public void chooseMode() {
        GameSystem gs=new GameSystem();
        String data = this.input;
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        int result= gs.chooseMode();
        System.setIn(stdin);
        assertEquals(this.expected,result);
    }
}