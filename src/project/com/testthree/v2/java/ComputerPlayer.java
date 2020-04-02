package com.testthree.v2.java;

import com.testthree2.v1.refactored.java.ChessBoard;

import java.util.ArrayList;

public class ComputerPlayer {

    private int chessMan;//棋子类型，1为X，2为O
    private static final int[] PREFIX=new int[] {1,9,3,7,5,2,4,6,8}; //电脑优先落子顺序

    public ComputerPlayer(){
        this.chessMan = 1;//电脑玩家棋子默认为X
    }

    //对应GetCompMove.getCompMove()
    public void move(int numMoves, int oppCell, ChessBoard cb){
        ArrayList<int[]> cellList=new ArrayList<>();

        //如果这是第3步，且对手第2步下在边上，就下在中央
        if(3 == numMoves) {
            if(2 == oppCell || 4 == oppCell || 6 == oppCell || 8 == oppCell) {
                cb.changeMat(1,1,1);
                System.out.println("\nOkay,my move...");
                cb.printMat();
                return;
            }
        }

        //生成一个包含所有空单元格的数组
        for	(int j=0; j<3; j++) {
            for(int i=0;i<3;i++) {
                if(cb.getMat()[i][j]==0) {

                    cellList.add(new int[]{i, j});
                }
            }
        }

        //检查每个单元格，看它能否让我方立即获胜
        for(int i=0; i<cellList.size(); i++) {
            if(cb.testToWin(cellList.get(i)[0],cellList.get(i)[1])) {
                cb.changeMat(cellList.get(i)[0],cellList.get(i)[1],1);
                System.out.println("\nOkay,my move...");
                cb.printMat();
                return ;
            }
        }

        //检查每个单元格，看它能否让敌方立即获胜
        for(int i=0; i<cellList.size(); i++) {
            if(cb.testToBlock(cellList.get(i)[0],cellList.get(i)[1])) {
                cb.changeMat(cellList.get(i)[0],cellList.get(i)[1],1);
                System.out.println("\nOkay,my move...");
                cb.printMat();
                return ;
            }
        }

        //棋子落子的优先队列
        for(int i=0; i<9; i++) {
            int r = (PREFIX[i]-1)/3;
            int c = (PREFIX[i]-1)%3;
            if(cb.getMat()[r][c]==0) {
                cb.changeMat(r, c,1);
                System.out.println("\nOkay,my move...");
                cb.printMat();
                return ;
            }
        }
    }

}
