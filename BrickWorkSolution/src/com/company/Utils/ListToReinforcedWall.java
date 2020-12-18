package com.company.Utils;

import java.util.List;

public class ListToReinforcedWall {

    public static int[][] putEvenBricks(List<Integer> evenBricks, int[][] brickWall) {
        for (int i = 0; i < brickWall.length; i++) {
            for (int j = 0; j < brickWall[i].length; j += 3) {
                int squareBrick = evenBricks.get(j);
                brickWall[i][j] = squareBrick;
            }
        }
        return brickWall;
    }

    public static int[][] putOddBricks(List<Integer> oddBricks, int[][] brickWall) {
        int index = 0;

        for (int i = 0; i < brickWall.length; i++) {
            for (int j = 1; j < brickWall[i].length; j++) {
                int squareBrick = oddBricks.get(index);
                index++;
                brickWall[i][j] = squareBrick;

                //TODO
                if (j % 2 == 0) {
                    j += 1;
                }
            }
        }
        return brickWall;
    }
}
