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

/**
 * @author caoxiuyuan
 * @version 2.0
 */
@RunWith(Parameterized.class)
public class GameSystemChooseModeTest {
    /**定义参数*/
    private int expected;
    private String input;
    private GameSystem gs;

    /**引入参数*/
    public GameSystemChooseModeTest(int expected, String input){
        this.gs=new GameSystem();
        this.expected = expected;
        this.input = input;
    }

    @Parameterized.Parameters
    // 构建测试数据集
    public static Collection data(){
        return Arrays.asList(new Object[][]{{1,"1"},{2,"2"},{3,"3"},{4,"exit"},{4,"123456"}});
    }


    @Test
    public void chooseMode() {
        String data = this.input;
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        int result= gs.chooseMode();
        System.setIn(stdin);
        assertEquals(this.expected,result);
    }
}