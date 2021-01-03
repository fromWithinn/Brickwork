package com.company.Utils;

import java.util.List;

public class ListToReinforcedWall {

    //TODO
    public static int[][] putEvenBricks(List<Integer> evenBricks, int[][] brickWall) {
        int index = 0;
        for (int i = 0; i < brickWall.length; i++) {
            int resetIndex = index;
            index = 0;
            if (i > 1) {
                index += 2;
            }
            for (int j = 0; j < brickWall[i].length; j += 3) {
                int squareBrick = evenBricks.get(index);
                brickWall[i][j] = squareBrick;
                index++;
                if (j >= brickWall[i].length - 1) {
                    index = resetIndex;
                }
            }
        }
        return brickWall;
    }

    //TODO
    public static int[][] putOddBricks(List<Integer> oddBricks, int[][] brickWall) {
        int index = 0;
        int squareCount = 0;

        for (int i = 0; i < brickWall.length; i++) {
            for (int j = 1; j < brickWall[i].length; j++) {
                if (index >= oddBricks.size()) {
                    break;
                }
                int squareBrick = oddBricks.get(index);
                brickWall[i][j] = squareBrick;

                if (squareCount >= 1) {
                    index++;
                    squareCount = 0;
                    j += 1;
                    continue;
                }

                squareCount++;
            }
        }
        return brickWall;
    }
}