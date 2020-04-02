package com.testthree.v2.java;

import com.testthree.v2.java.ChessBoard;
import com.testthree.v2.java.ComputerPlayer;
import com.testthree.v2.java.Player;

import java.util.Scanner;

import static com.testthree.v2.java.Constants.CHESSMAN_X;

public class GameSystem {

    private boolean exitFlag;
    //退出标志
    private ChessBoard cb;
    //棋盘
    private ComputerPlayer cp;
    //电脑玩家
    private Player defaultPlayer;
    private Player extraPlayer;
    //玩家
    private int numMoves;
    //回合
    private int modeFlag;
    private static final int pveFlag = 1;
    private static final int pvpFlag = 2;
    String pveOption="1";
    String pvpOption="2";

    public GameSystem(){
        this.exitFlag = false;
        this.cb = new ChessBoard();
        this.defaultPlayer = new Player();
        this.numMoves = 0;
    }

    /**对应GameDriver.gameDriver()*/
    public void start(){
        System.out.println("Welcome!");
        modeFlag=chooseMode();
        if(modeFlag==pveFlag){
            this.cp = new ComputerPlayer();
            pVe();
        }
        else if (modeFlag==pvpFlag){
            this.extraPlayer = new Player(CHESSMAN_X);
            pVp();
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
                cp.move(numMoves, defaultPlayer.getRow() * 3 + defaultPlayer.getCol() + 1, cb);

                if (cb.testAnyOneWin()) {
                    System.out.println("\nX WIN THE GAME!");
                    break;
                }
            }
            else if (numMoves % 2 == 0){
                //玩家移动
                exitFlag = defaultPlayer.move(cb);

                if(!exitFlag&&cb.testAnyOneWin()){
                    System.out.println("\\nO WIN THE GAME!");
                    break;
                }

            }
        }
    }

    public void pVp(){
        System.out.println("This is PvP mode now.");
        cb.printMat();
        System.out.println("\nEnter position like \"r,c\" to move,or \"exit\" to exit");

        while(!exitFlag){
            numMoves++;
            if(numMoves > 9){
                System.out.println("\nNo more space left.");
                break;
            }
            if (numMoves % 2 > 0){
                System.out.println("\n It's turn to X!");
                //玩家一移动
                exitFlag = extraPlayer.move(cb);

                if (!exitFlag&&cb.testAnyOneWin()) {
                    System.out.println("\nX WIN THE GAME!");
                    break;
                }
            }
            else if (numMoves % 2 == 0){
                System.out.println("\n It's turn to O!");
                //玩家一移动
                exitFlag = defaultPlayer.move(cb);

                if(!exitFlag&&cb.testAnyOneWin()){
                    System.out.println("\\nO WIN THE GAME!");
                    break;
                }

            }
        }
    }

    public int chooseMode(){
        while(true){
            System.out.println("Please choose moode!");
            System.out.println("1:PVE  2:PVP");
            Scanner input = new Scanner(System.in);
            String content = input.next();
            if (pveOption.equals(content)){
                return pveFlag;
            }
            else if (pvpOption.equals(content)){
                return pvpFlag;
            }
            System.out.println("Input error!\nPlease re-enter\n");
        }

    }


}
