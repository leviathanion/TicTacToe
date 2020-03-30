package com.testthree.java;

public class CheckInput {
    //private static int flag=5;
    private static int r;
    private static int c;

    public  static int checkInput(String input){
        String[] content_list = input.split(",");
        if(content_list.length < 2){
            return 0;      //位数不够
        }
        else {
            r = Integer.parseInt(content_list[0])-1;    //字符串到整形转换
            c = Integer.parseInt(content_list[1])-1;
            if (r<0||r>=3||c<0||c>=3){
                return 1; //越界
            }
        }
     return 3;
    }
}