package test.java;

import com.testthree.java.CheckInput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CheckInputTest {
    private int expected;
    private String input;

    public CheckInputTest(int expected, String input){

        this.expected = expected;
        this.input = input;

    }

    @Parameterized.Parameters// 构造测试用例
    public static Collection data(){
        return Arrays.asList(new Object[][]{{0,"2"},{3,"2,2"},{0,"assda"},{0,"1，3"},{1,"3,6"}});
    }

    @Test
    public void checkInput() {
        int result= CheckInput.checkInput(this.input);
        assertEquals(this.expected,result);
    }
}