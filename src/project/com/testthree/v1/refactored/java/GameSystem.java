package com.testthree.v1.refactored.java;
/**
 * @author zhuoyongkang
 * @version 1.1
 * @date 2020.4.2
 */
public class GameSystem {
    /**退出标志*/
    private boolean exitFlag;
    /**棋盘*/
    private ChessBoard cb;
    /**电脑玩家*/
    private ComputerPlayer cp;
    /**玩家*/
    private Player player;
    /**回合数*/
    private int numMoves;

    public GameSystem(){
        this.exitFlag = false;
        this.cb = new ChessBoard();
        this.cp = new ComputerPlayer();
        this.player = new Player();
        this.numMoves = 0;
    }

    /**
     * 对应GameDriver.gameDriver()
     */
    public void start(){

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


}
