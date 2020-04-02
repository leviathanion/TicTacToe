package com.testthree.v1.demo.java;
import java.util.Scanner;

public class GetInput {
    public static String getInput(){
        System.out.print("\nEnter move or  \"exit\" :");
        Scanner input = new Scanner(System.in);
        String content = input.next();
        return content;

    }
}
