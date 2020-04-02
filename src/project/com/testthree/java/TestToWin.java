package com.testthree.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class TestToWin {
    public static boolean testToWin(int r, int c){
        int cellN = r * 3 + c + 1; //格子号
        List <int[]> myWinList = new ArrayList<>();
        for(int[] list : GameDriver.WINLIST){
            if(Arrays
                    .stream(list)
                    .boxed()
                    .collect(Collectors.toList())
                    .contains(cellN))
                myWinList.add(list);
            for (int[] tttList : myWinList) {
                int numX = TestWayAndWin.testWay(tttList)[0];
                int numO = TestWayAndWin.testWay(tttList)[1];
                if(numX == 2)
                    return true;
            }
        }
        return false;

    }
}
