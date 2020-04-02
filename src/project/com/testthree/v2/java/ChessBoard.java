package com.testthree.v2.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.testthree.v2.java.Constants.*;

public class ChessBoard {
    /** 棋盘矩阵，空为0，X为1，O为2 */
    private int[][] mat;
    /** 记录上一步棋 */
    private int row,col;
    /** 获胜序列常量 */
    private static final int[][] WIN_LIST ={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    private int three=3;

    public ChessBoard(){
        this.mat = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        this.row = 0;
        this.col = 0;
    }

    /**对应PrintMat.printMat()*/
    public void printMat(){
        System.out.println("  1 2 3");
        for(int i = 0; i < three; i++){
            for(int j = 0; j < three; j++){
                if(this.mat[i][j]==0){
                    if(j==0){
                        if(i==0){
                            System.out.print("1 . ");
                        }
                        else if(i==1){
                            System.out.print("\n2 . ");
                        }
                        else if(i==2){
                            System.out.print("\n3 . ");
                        }
                    }
                    if(j!=0){
                        System.out.print(". ");
                    }
                }
                if(this.mat[i][j]==1){
                    if(j==0){
                        if(i==0){
                            System.out.print("1 x ");
                        }
                        else if(i==1){
                            System.out.print("\n2 x ");
                        }
                        else if(i==2){
                            System.out.print("\n3 x ");
                        }
                    }
                    if(j!=0){
                        System.out.print("x ");
                    }
                }
                if(this.mat[i][j]==2){
                    if(j==0){
                        if(i==0){
                            System.out.print("1 O ");
                        }
                        else if(i==1){
                            System.out.print("\n2 O ");
                        }
                        else if(i==2){
                            System.out.print("\n3 O ");
                        }
                    }
                    if(j!=0){
                        System.out.print("O ");
                    }
                }
            }
        }
    }

    /**
     * @return 是否获胜
     * @description 计算上次落点后能否获胜
     */
    public boolean testAnyOneWin(){
        /*  格子号，依次为
            1 2 3
            4 5 6
            7 8 9   */
        int cellN = row * 3 + col + 1;
        for (int[] tttList : getMyWinList(cellN)) {
            int numX = testWay(tttList)[CHESSMAN_X];
            int numO = testWay(tttList)[CHESSMAN_O];
            if(numX == 3 || numO == 3) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param cellN 某点的格子号
     * @return 包含该点的获胜序列
     * @description 通过给定某点格子号，求得包含该点的获胜序列
     */
    public List<int[]> getMyWinList(int cellN){
        List <int[]> myWinlist = new ArrayList<>();
        for(int[] list : WIN_LIST){
            if(Arrays
                    .stream(list)
                    .boxed()
                    .collect(Collectors.toList())
                    .contains(cellN)) {
                myWinlist.add(list);
            }
        }
        return myWinlist;
    }

    //对应TestToWin.testToWin()
    public boolean testToWin(int r, int c){
        for (int[] tttList : getMyWinList(r * 3 + c + 1)) {
            if(testWay(tttList)[CHESSMAN_X] == 2) {
                return true;
            }
        }
        return false;
    }

    //对应TestToWin.testToBlock()
    public boolean testToBlock(int r, int c){
        for (int[] tttList : getMyWinList(r * 3 + c + 1)) {
            if(testWay(tttList)[CHESSMAN_O] == 2) {
                return true;
            }
        }
        return false;
    }

    //对TestToWin.testToWin()和TestToBlock.testToBlock()进行重构
    public boolean whoToWin(int r, int c, int chessMan){

        for (int[] tttList : getMyWinList(r * 3 + c + 1)) {
            if(testWay(tttList)[chessMan] == 2) {
                return true;
            }
        }
        return false;
    }

    /**
     * @author zhuquntao
     * @param tttList 待测数组
     * @return 待测数组中各个棋子的个数
     * @Description 计算某数组中各个棋子的个数
     */
    public int[] testWay(int[] tttList){
        List<Integer> lettersList = new ArrayList<Integer>();
        for(int cellN : tttList){
            int r = (cellN - 1) / 3;
            int c = (cellN - 1) % 3;
            lettersList.add(this.mat[r][c]);
        }
        int numX = Collections.frequency(lettersList,CHESSMAN_X);
        int numO = Collections.frequency(lettersList,CHESSMAN_O);
        int numBlank = Collections.frequency(lettersList,CHESSMAN_BLANK);
        int[] numOfChessman = {numBlank,numX,numO};
        return numOfChessman;
    }

    //落子
    public void changeMat(int row, int col, int chessMan) {
        this.row = row;
        this.col = col;
        this.mat[row][col] = chessMan;
    }

    public int[][] getMat(){
        return this.mat;
    }

    public void setMat(int[][] mat){
        this.mat = mat;
    }

    public void setRow(int row){
        this.row = row;
    }

    public void setCol(int col){
        this.col = col;
    }

}
