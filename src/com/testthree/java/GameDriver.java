package com.testthree.java;


public class GameDriver {

         private PrintMat pt; //实例化绘制棋盘类对象
         private GetCompMove gcm;
         private GetMove gm;
         private int exitFlag;
         public int n=3;
         public static int [][] mat;
         private int numMoves;
         private int r,c;
         private int cellNum;
         private int []gmResult;
         private int []gcmResult;
         public static int[][] WINLIST ={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};

    public GameDriver(){
         this.pt=new PrintMat();
         this.exitFlag=0;
         mat= new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        }

    public  void gameDriver (){
         this.gm=new GetMove();
         this.gcm=new GetCompMove();
         r=c=0;
         numMoves=0;
         pt.print_chessboard();
         System.out.println("\nEnter position like \"r,c\" to move,or \"exit\" to exit");
         System.out.print(mat);
         while(exitFlag!=1){
             numMoves=numMoves+1;
             if(numMoves>9){
                 System.out.println("\nNo more space left.");
                 break;
             }
             if (numMoves%2>0){
                 cellNum=r*3+c+1;
                 gcmResult=GetCompMove.getCompMove(numMoves,cellNum);
                 r=gcmResult[0];
                 c=gcmResult[1];
                 mat[r][c]=1;  //x是1
                 System.out.println("\nOkay,my move...");
                 pt.print_chessboard();
                 if (TestWayAndWin.testWin(r,c)==true) {
                    System.out.println("\nX WIN THE GAME!");
                    break;
                }
             }
             else if (numMoves%2==0){
                 gmResult=gm.getMove();
                 exitFlag=gmResult[0];
                 r=gmResult[1];
                 c=gmResult[2];
                 if(exitFlag==0&&TestWayAndWin.testWin(r,c)==true){
                     System.out.println("\\nO WIN THE GAME!");
                     break;
                 }

             }

        }





}



}





