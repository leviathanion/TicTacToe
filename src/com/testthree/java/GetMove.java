package com.testthree.java;

import java.util.Scanner;

public class GetMove {

       private int r,c;
       private int[] result=new int[3];
       private PrintMat pm;

       public GetMove(){
           this.pm=new PrintMat();
       }
       public int[] getMove(){
           while(true){
               System.out.print("\nEnter move or  \"exit\" :");
               Scanner input = new Scanner(System.in);
               String content = input.next();
               String[] content_list = content.split(",");
               if(content_list.length >= 1&&content_list[0].equals("exit"))  //输入为exit
               {
                   System.out.println("Bye now");
                   result[0]=1;  //result[0]表示退出标志
                   result[1]=0;  //r
                   result[2]=0;  //c
                   return result;
               }
               else if(content_list.length < 2)     //输入位数不够
               {
                   System.out.println("Use row,col.Re-enter");
               }
               else {
                   r = Integer.parseInt(content_list[0])-1;    //字符串到整形转换
                   c = Integer.parseInt(content_list[1])-1;
                   if (r<0||r>=3||c<0||c>=3){        //越界
                       System.out.println("Out of range,Re-enter");
                   }
                   else if (GameDriver.mat[r][c]!=0){     //已有棋子
                       System.out.println("Occupied,re-enter");
                   }
                   else{
                       GameDriver.mat[r][c]=2;
                       pm.print_chessboard();
                       break;
                   }

               }
           }
           result[0]=0;
           result[1]=r;
           result[2]=c;
           return result;
       }


}
