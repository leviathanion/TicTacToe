package com.testthree.v1.demo.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author zhuquntao
 * @version 1.0
 * @date 2020.3.31
 */
public class TestWayAndWin {


    /**
     * @param tttList 待测数组
     * @return 待测数组中各个棋子的个数
     * @Description 计算某数组中各个棋子的个数
     */
    public static int[] testWay(int[] tttList) {
        List<Integer> lettersList = new ArrayList<Integer>();
        for(int cellN : tttList){
            int r = (cellN - 1) / 3;
            int c = (cellN - 1) % 3;
            lettersList.add(GameDriver.mat[r][c]);
        }
        int numX = Collections.frequency(lettersList,1);
        int numO = Collections.frequency(lettersList,2);
        int numBlank = Collections.frequency(lettersList,0);
        int[] numOfChessman = {numX,numO,numBlank};
        return numOfChessman;
    }

    /**
     * @param r 待测点的横坐标
     * @param c 待测点的纵坐标
     * @return 能否获胜
     * @Description 判断某点落子后能否获胜
     */
    public static Boolean testWin(int r,int c) {
        /*  格子号，依次为
            1 2 3
            4 5 6
            7 8 9   */
        int cellN = r * 3 + c + 1;
        List <int[]> myWinList = new ArrayList<>();
        for(int[] list : GameDriver.WINLIST){
            if(Arrays
                    .stream(list)
                    .boxed()
                    .collect(Collectors.toList())
                    .contains(cellN)) {
                myWinList.add(list);
            }
        }
        for (int[] tttList : myWinList) {
            int numX = testWay(tttList)[0];
            int numO = testWay(tttList)[1];
            if(numX == 3 || numO == 3) {
                return true;
            }
        }
        return false;
    }
}
