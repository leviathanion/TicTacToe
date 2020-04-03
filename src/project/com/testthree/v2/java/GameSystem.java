package com.testthree.v2.java;

import com.testthree.v2.java.ChessBoard;
import com.testthree.v2.java.ComputerPlayer;
import com.testthree.v2.java.Player;

import java.util.Scanner;

import static com.testthree.v2.java.Constants.CHESSMAN_X;

/**
 * @author 123
 */
public class GameSystem {
    /**退出标志*/
    private boolean exitFlag;
    /**棋盘*/
    private ChessBoard cb;
    /**电脑玩家*/
    private ComputerPlayer cp;
    private Player defaultPlayer;
    private Player extraPlayer;

    /**回合*/
    private int numMoves;

    private int modeFlag;
    private static final int PVE_FLAG = 1;
    private static final int PVP_FLAG = 2;
    private static final int QUIT_FLAG=3;
    private static final int EXCEPTION_FLAG=4;
    String pveOption="1";
    String pvpOption="2";
    String exitOption="3";

    public GameSystem(){
        this.exitFlag = false;
        this.cb = new ChessBoard();
        this.defaultPlayer = new Player();
        this.numMoves = 0;
    }

    /**对应GameDriver.gameDriver()*/
    public void start(){
        System.out.println("Welcome!");
        while(true){
            System.out.println("Please choose mode!");
            System.out.println("1:PVE  2:PVP  3:EXIT");
            modeFlag=chooseMode();
            if(modeFlag==PVE_FLAG){
                this.cp = new ComputerPlayer();
                pVe();
                this.exitFlag = false;
                this.cb = new ChessBoard();
                this.defaultPlayer = new Player();
                this.numMoves = 0;
            }
            else if (modeFlag==PVP_FLAG){
                this.extraPlayer = new Player(CHESSMAN_X);
                pVp();
                this.exitFlag = false;
                this.cb = new ChessBoard();
                this.defaultPlayer = new Player();
                this.numMoves = 0;

            }
            else if (modeFlag==QUIT_FLAG){
                break;
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
                cp.move(numMoves, defaultPlayer.getRow() * 3 + defaultPlayer.getCol() + 1, cb);

                if (cb.testAnyOneWin()) {
                    System.out.println("\n X WIN THE GAME!");
                    break;
                }
            }
            else if (numMoves % 2 == 0){
                //玩家移动
                exitFlag = defaultPlayer.move(cb);

                if(!exitFlag&&cb.testAnyOneWin()){
                    System.out.println("\n O WIN THE GAME!");
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
                    System.out.println("\nO WIN THE GAME!");
                    break;
                }

            }
        }
    }

    public int chooseMode(){
        while(true){
            Scanner input = new Scanner(System.in);
            String content = input.next();
            if (pveOption.equals(content)){
                return PVE_FLAG;
            }
            else if (pvpOption.equals(content)){
                return PVP_FLAG;
            }
            else if (exitOption.equals(content)){
                return QUIT_FLAG;
            }
            else{
                System.out.println("Input error!\nPlease re-enter\n");
                return EXCEPTION_FLAG;
            }

        }

    }


}
