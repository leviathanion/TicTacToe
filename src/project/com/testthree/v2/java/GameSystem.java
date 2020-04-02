package com.testthree.v2.java;

import com.testthree2.v1.refactored.java.ChessBoard;
import com.testthree2.v1.refactored.java.ComputerPlayer;
import com.testthree2.v1.refactored.java.Player;

import java.util.Scanner;

public class GameSystem {

    private boolean exitFlag;
    //退出标志
    private ChessBoard cb;
    //棋盘
    private ComputerPlayer cp;
    //电脑玩家
    private Player player;
    //玩家
    private int numMoves;
    //回合
    private int modeFlag;
    private int pveFlag=1;
    private int pvpFlag=2;
    String pveOption="1";
    String pvpOption="2";

    public GameSystem(){
        this.exitFlag = false;
        this.cb = new ChessBoard();
        this.cp = new ComputerPlayer();
        this.player = new Player();
        this.numMoves = 0;
    }

    /**对应GameDriver.gameDriver()*/
    public void start(){
        System.out.println("Welcome!");
        while(true){
            modeFlag=chooseMode();
            if(modeFlag==pveFlag){
                pVe();
            }
            else if (modeFlag==pvpFlag){
                //pVp()
            }
            else{
                System.out.println("Please re-enter");
            }
        }


    }

    public void pVe(){
        System.out.println("This is PvE mode now.");
        cb.printMat();
        System.out.println("\nEnter position like \"r,c\" to move,or \"exit\" to exit");

        while(!exitFlag){
            numMoves++;
            if(numMoves > 9){
                System.out.println("\nNo more space left.");
                break;
            }
            if (numMoves % 2 > 0){
                //电脑移动
                cp.move(numMoves,player.getRow() * 3 + player.getCol() + 1, cb);

                if (cb.testAnyOneWin()) {
                    System.out.println("\nX WIN THE GAME!");
                    break;
                }
            }
            else if (numMoves % 2 == 0){
                //玩家移动
                exitFlag = player.move(cb);

                if(!exitFlag&&cb.testAnyOneWin()){
                    System.out.println("\\nO WIN THE GAME!");
                    break;
                }

            }
        }
    }

    public int chooseMode(){
        System.out.println("Please choose moode!");
        System.out.println("1:PVE  2:PVP");
        Scanner input = new Scanner(System.in);
        String content = input.next();
        if (pveOption.equals(content)){
            return 1;
        }
        else if (pvpOption.equals(content)){
            return 2;
        }
        return 3;
    }


}