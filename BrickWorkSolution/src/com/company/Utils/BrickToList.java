package com.company.Utils;

import java.util.ArrayList;
import java.util.List;

public class BrickToList {

    public static List<Integer> getEvenBricks(int[][] brickWall) {
        List<Integer> evenBricks = new ArrayList<>();

        for (int[] ints : brickWall) {
            for (int current : ints) {
                if (current % 2 == 0) {
                    evenBricks.add(current);
                }
            }
        }
        return evenBricks;
    }

    public static List<Integer> getOddBricks(int[][] brickWall) {
        List<Integer> evenBricks = new ArrayList<>();

        for (int[] ints : brickWall) {
            for (int current : ints) {
                if (current % 2 != 0) {
                    evenBricks.add(current);
                }
            }
        }
        return evenBricks;
    }
}
