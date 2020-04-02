package com.testthree.v1.demo.java;

public class CheckInput {
    //private static int flag=5;
    private static int r;
    private static int c;

    public  static int checkInput(String input){
        String[] contentList = input.split(",");
        if(contentList.length!=2){
            return 0;      //位数不对
        }
        else {
            r = Integer.parseInt(contentList[0])-1;    //字符串到整形转换
            c = Integer.parseInt(contentList[1])-1;
            if (r<0||r>=3||c<0||c>=3){
                return 1; //越界
            }
        }
     return 3;  //没有以上情况
    }
}
