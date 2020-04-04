package com.testthree.v1.demo.java;

import java.util.ArrayList;

/**
 * @author xucheng
 * @version 1.0
 * @date 2020.3.31
 */
public class GetCompMove {
    //**该返回的坐标*/
    private static int[] getComMoveResult=new int[2];
    /**电脑优先落子顺序*/
    private static int[] prefix=new int[] {1,9,3,7,5,2,4,6,8};

    /**
     * @param numMoves 棋的步数
     * @param oppCell   下棋的网格号
     * @return getComMoveResult 电脑最终下棋的坐标
     * @description 棋盘对应网格号依次为：
     *                                  1   2   3
     *                                  4   5   6
     *                                  7   8   9
     *               电脑先检测第三步，若中间网格未被占据，则占据中间网格
     *               再看能让自己获胜的情况，若能获胜则占据
     *               再看能让玩家获胜的情况，若能让玩家获胜则占据对应网格
     *               再按照prefix数组中对应的网格号的优先级下棋
     */
    public static int[] getCompMove(int numMoves,int oppCell) {
        ArrayList<int[]>cellList=new ArrayList<>();
        //如果这是第3步，且对手第2步下在边上，就下在中央
        if(3==numMoves) {
            if(2==oppCell||4==oppCell||6==oppCell||8==oppCell) {
                getComMoveResult[0]=1;
                getComMoveResult[1]=1;
                return getComMoveResult;
            }
        }

        //生成一个包含所有空单元格的数组
        for	(int j=0;j<3;j++) {
            for(int i=0;i<3;i++) {
                if(GameDriver.mat[i][j]==0) {
                    cellList.add(new int[]{i,j});
                }
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
