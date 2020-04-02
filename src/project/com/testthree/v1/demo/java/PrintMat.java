package com.testthree.v1.demo.java;

public class PrintMat {
    //private int[][] board_mat;//棋盘矩阵

    public void printMat(){
        //board_mat=com.testthree.java.GameDriver.mat;
        System.out.println("  1 2 3");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
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
