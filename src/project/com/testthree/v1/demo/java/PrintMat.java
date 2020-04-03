package com.testthree.v1.demo.java;

/**
 * @author JiangXianQiang
 * @version 1.0
 * @date 2020.3.31
 */
public class PrintMat {
    private static int MAXM=3;

    public void printMat(){
        /**打印棋盘*/
        System.out.print("  1 2 3\n");
        for(int i = 0; i < MAXM; i++){
            for(int j = 0; j < MAXM; j++){
                if(GameDriver.mat[i][j]==0){
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
                if(GameDriver.mat[i][j]==1){
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
                if(GameDriver.mat[i][j]==2){
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

}
