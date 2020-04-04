package com.testthree.v1.demo.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhuoyongkang
 * @version 1.0
 * @date 2020.3.31
 */
public class TestToWin {
    /**
     * @param r 行数
     * @param c 列数
     * @return 返回r,c位置是否能赢棋
     * @Description 判断传入位置落子能否取得胜利
     */
    public static boolean testToWin(int r, int c){
        //格子号
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
            for (int[] tttList : myWinList) {
                int numX = TestWayAndWin.testWay(tttList)[0];
                int numO = TestWayAndWin.testWay(tttList)[1];
                if(numX == 2) {
                    return true;
                }
            }
        }
        return false;

    }
}
