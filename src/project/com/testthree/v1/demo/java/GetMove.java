package com.testthree.v1.demo.java;

public class GetMove {

    private int r, c;
    private int[] result = new int[3];
    private PrintMat pm;

    public GetMove() {
        this.pm = new PrintMat();
    }

    public int[] getMove() {
        while (true) {
            String input = GetInput.getInput();
            String[] contentList = input.split(",");
            if (contentList.length >= 1 && "exit".equals(contentList[0]))  //输入为exit
            {
                System.out.println("Bye now");
                result[0] = 1;  //result[0]表示退出标志
                result[1] = 0;  //r
                result[2] = 0;  //c
                return result;
            }
            else if (CheckInput.checkInput(input)==0)     //输入位数不对
            {
                System.out.println("Use row,col.Re-enter");
            }
            else {
                r = Integer.parseInt(contentList[0]) - 1;    //字符串到整形转换
                c = Integer.parseInt(contentList[1]) - 1;
                if (CheckInput.checkInput(input) == 1) {
                    System.out.println("Out of range,Re-enter");
                }
                else if (GameDriver.mat[r][c] != 0) {     //已有棋子
                    System.out.println("Occupied,re-enter");
                }
                else {
                    GameDriver.mat[r][c] = 2;
                    pm.printMat();
                    break;
                }

            }

        }
        result[0] = 0;
        result[1] = r;
        result[2] = c;
        return result;
    }
}







