package com.testthree.java;

import java.util.ArrayList;
public class GetCompMove {
    private static int[] getComMoveResult=new int[2];	//该返回的坐标
    private static int[] cell=new int[2];		//用于遍历cellList的数组
    private static ArrayList<int[]>cellList=new ArrayList<>();	//棋盘上可落子的集合
    private static int[] prefix=new int[] {1,9,3,7,5,2,4,6,8}; //电脑优先落子顺序

    /**
     *
     * @param numMoves
     * @param oppCell
     * @return getComMoveResult
     */
    public static int[] getCompMove(int numMoves,int oppCell) {

        //如果这是第3步，且对手第2步下在边上，就下在中央
        if(3==numMoves)
            if(2==oppCell||4==oppCell||6==oppCell||8==oppCell) {
                getComMoveResult[0]=1;
                getComMoveResult[1]=1;
                return getComMoveResult;
            }

        //生成一个包含所有空单元格的数组
        for	(int j=0;j<3;j++)
            for(int i=0;i<3;i++) {
                if(GameDriver.mat[i][j]==0) {
                    cell[0]=i;
                    cell[1]=j;
                    cellList.add(cell);
                }
            }

        //检查每个单元格，看它能否让我方立即获胜
        for(int i=0;i<cellList.size();i++) {
            if(TestToWin.testToWin(cellList.get(i)[0],cellList.get(i)[1])) {
                getComMoveResult[0]=cellList.get(i)[0];
                getComMoveResult[1]=cellList.get(i)[1];
                return getComMoveResult;
            }
        }

        //检查每个单元格，看它能否让敌方立即获胜
        for(int i=0;i<cellList.size();i++) {
            if(TestToBlock.testToBlock(cellList.get(i)[0],cellList.get(i)[1])) {
                getComMoveResult[0]=cellList.get(i)[0];
                getComMoveResult[1]=cellList.get(i)[1];
                return getComMoveResult;
            }
        }

        //棋子落子的优先队列
        for(int i=0;i<9;i++) {
            int r =(prefix[i]-1)/3;
            int c=(prefix[i]-1)%3;
            if(GameDriver.mat[r][c]==0) {
                getComMoveResult[0]=r;
                getComMoveResult[1]=c;
                return getComMoveResult;
            }
        }

        return getComMoveResult;
    }
}
