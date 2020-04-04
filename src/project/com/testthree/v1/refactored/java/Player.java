package com.testthree.v1.refactored.java;

import java.util.Scanner;
/**
 * @author zhuoyongkang
 * @version 1.1
 * @date 2020.4.2
 */
public class Player {
    /**棋子类型，1为X，2为O*/
    private int chessMan;
    /**记录玩家的上一步*/
    private int row, col;

    public Player(){
        /**玩家棋子默认为O*/
        this.chessMan = 2;
    }

    /**
     * @param cb 玩家所使用的棋盘
     * @return  退出标志
     * @Description 对应GetMove.getMove()
     */
    public boolean move(ChessBoard cb){

        while (true) {
            String input = this.getInput();
            String[] contentList = input.split(",");
            if (contentList.length >= 1 && "exit".equals(contentList[0]))  //输入为exit
            {
                System.out.println("Bye now");
                return true;
            }
            else if (this.checkInput(input) == 0)     //输入位数不对
            {
                System.out.println("Use row,col.Re-enter");
            }
            else {

                if (this.checkInput(input) == 1) {
                    System.out.println("Out of range,Re-enter");
                }
                else if (cb.getMat()[row][col] != 0) {     //已有棋子
                    System.out.println("Occupied,re-enter");
                }
                else {
                    cb.changeMat(row, col, 2);
                    cb.printMat();
                    break;
                }

            }

        }
        return false;
    }

    /**
     * @return 获取输入
     * 对应GetInput.getInput()
     */
    public String getInput(){
        System.out.print("\nEnter move or  \"exit\" :");
        Scanner input = new Scanner(System.in);
        String content = input.next();
        return content;
    }

    /**
     * @param input 需要检查的字符串
     * @return 检查类型
     * 对应CheckInput.checkInput()
     */
    public int checkInput(String input){
        String[] contentList = input.split(",");
        if(contentList.length!=2){
            return 0;      //位数不对
        }
        else {
            row = Integer.parseInt(contentList[0])-1;    //字符串到整形转换
            col = Integer.parseInt(contentList[1])-1;
            if (row<0||row>=3||col<0||col>=3){
                return 1; //越界
            }
        }
        return 3;  //没有以上情况
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }
}
